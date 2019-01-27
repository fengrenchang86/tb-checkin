package com.turtlebone.checkin.entity;


public class GroupConfig{
	
	private Integer id;
	private Integer parentid;
	private String name;
	private String type;
	private Integer app;
		
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return this.id;
	}
		
	public void setParentid(Integer parentid){
		this.parentid = parentid;
	}
	
	public Integer getParentid(){
		return this.parentid;
	}
		
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
		
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
		
	public void setApp(Integer app){
		this.app = app;
	}
	
	public Integer getApp(){
		return this.app;
	}
		
		
}
















