1. web.xml
	Using JNDI to Access the jdbc-resource Within a Web Application,
	https://docs.oracle.com/cd/E19146-01/819-2634/gcxij/index.html
	JNDI configuration:
	
	https://www.mkyong.com/tomcat/how-to-configure-mysql-datasource-in-tomcat-6/
	
	in /META-INF/context.xml
	in web.xml
  {description}Spring Database{/description}
  {resource-ref}
      {description}DB Connection{/description}
      {res-ref-name}jdbc/spring{/res-ref-name}
      {res-type}javax.sql.DataSource{/res-type}
      {res-auth}Container{/res-auth}
  {/resource-ref}
  
	in the DotaHeroDaoImpl.java
	@Autowired
	method annotated with @Autowired is considered to be a config method
	A config method's (annotated with @Autowired) arguments will be autowired with a matching bean in the Spring container.
	
	https://stackoverflow.com/questions/19414734/understanding-spring-autowired-usage
	https://stackoverflow.com/questions/24771702/spring-autowired-method-when-execute?rq=1
	http://docs.spring.io/spring/docs/4.0.5.RELEASE/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html
	
	dao-context.xml
	jndi-name must be correct,jee:jndi-lookup means  to search the JNDI resource name in the web container, (normally, the JNDI resource config in the server server.xml or context.xml,
	when the server start, this resource config will put in web container), then transform to dataSource bean
	{jee:jndi-lookup jndi-name="jdbc/spring" id="dataSource"
		expected-type="javax.sql.DataSource"}
	{/jee:jndi-lookup}
	
	
  ContextLoaderListener
  
  will create a web application context based on the "contextClass" and "contextConfigLocation" servlet context-params.
  The ApplicationContext is where your Spring beans live. The purpose of the ContextLoaderListener is two-fold:
	to tie the lifecycle of the ApplicationContext to the lifecycle of the ServletContext and
	to automate the creation of the ApplicationContext, so you don't have to write explicit code to do create it - it's a convenience function.
	Another convenient thing about the ContextLoaderListener is that it creates a WebApplicationContext and WebApplicationContext provides access to the ServletContext via ServletContextAware beans and the getServletContext method.
	
   ContextLoaderListener has its own context which is shared by all servlets and filters. By default it will search /WEB-INF/applicationContext.xml
   you can customize by
   
  {context-param}
  {param-name}contextConfigLocation{/param-name}
  {param-value}
  classpath:com/config/dao-context.xml
  {/param-value}
  {/context-param}
  
  param-name should be correct "contextConfigLocation", otherwise can't be found!!!!

 2.in dao-context.xml
  
  {context:annotation-config} declares support for general annotations such as @Required, @Autowired, @PostConstruct, and so on.
