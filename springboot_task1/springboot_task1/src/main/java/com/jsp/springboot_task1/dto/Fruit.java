package com.jsp.springboot_task1.dto;

public class Fruit {
	private String name;
	private Double cost;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "Fruit [name=" + name + ", cost=" + cost + "]";
	}
	
	
}
