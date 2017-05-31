package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DotaHeroDaoImpl;

@Service("dotaService")
public class DotaService {
	private DotaHeroDaoImpl dotaDao;
	
	@Autowired
	public void setDao(DotaHeroDaoImpl dotaDao){
		this.dotaDao=dotaDao;
	}
	public List getHero(){
		return dotaDao.getAllDotaHero();
	}
}
