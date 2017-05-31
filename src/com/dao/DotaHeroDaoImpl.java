package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.entity.DotaHero;

@Component("dotaHeroDao")
public class DotaHeroDaoImpl implements DotaHeroDao {

	NamedParameterJdbcTemplate jdbc;
	public DotaHeroDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("Successfully load DAO IMPL");
	}
	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc= new NamedParameterJdbcTemplate(jdbc);
	}

	@Override
	public List<DotaHero> getAllDotaHero() {
		// TODO Auto-generated method stub
		return jdbc.query("select * from DOTAHERO", new RowMapper<DotaHero>() {

			public DotaHero mapRow(ResultSet rs, int rowNum) throws SQLException {
				DotaHero offer = new DotaHero(rs.getInt("ID"),rs.getString("NAME"),rs.getString("CATAGORY"));



				return offer;
			}

		});

	}

	@Override
	public DotaHero getDotaHero(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDotaHero(DotaHero d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDotaHero(DotaHero d) {
		// TODO Auto-generated method stub
		
	}

}
