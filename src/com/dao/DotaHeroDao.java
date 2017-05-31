package com.dao;

import java.util.List;

import com.entity.DotaHero;
//http://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm
public interface DotaHeroDao {
	
	public List<DotaHero> getAllDotaHero();
	public DotaHero getDotaHero(int id);
	public void updateDotaHero(DotaHero d);
	public void deleteDotaHero(DotaHero d);
}
