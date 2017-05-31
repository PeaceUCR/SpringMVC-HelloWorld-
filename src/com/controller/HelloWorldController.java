package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.DotaHero;
import com.service.DotaService;

@Controller
public class HelloWorldController {
	
	BindingResult br;
	private DotaService ds;
	
	@Autowired
	public void setService(DotaService ds){
		this.ds=ds;
		
	}
	
	@RequestMapping("/")
	public ModelAndView show(){
		//return "home";
		System.out.println("helloworld");
		System.out.println(ds.getHero().size());
		
		List<DotaHero> dlist = ds.getHero();
		ModelAndView mv = new ModelAndView("home");
		Map<String,Object> model = mv.getModel();
		model.put("app_name","<p>hello world</p>");
		model.put("dlist", dlist);
		
		return mv;
	}
}
