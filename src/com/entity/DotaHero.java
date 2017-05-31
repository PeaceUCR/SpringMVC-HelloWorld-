package com.entity;

public class DotaHero {
	private int id;
	private String name;
	private String catagory;
	
	public DotaHero() {
		super();
	}

	public DotaHero(int id,String name,String catagory){
		this.id=id;
		this.name=name;
		this.catagory=catagory;
	}

	@Override
	public String toString() {
		return "DotaHero [id=" + id + ", name=" + name + ", catagory="
				+ catagory + "]";
	}

}
