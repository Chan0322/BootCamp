package com.silsub1;

public class Trader {
	private String name;
	private String city;
	
	public Trader() {
		super();
	}

	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Trader [name=" + name + ", city=" + city + "]";
	}
	
	
	
}
