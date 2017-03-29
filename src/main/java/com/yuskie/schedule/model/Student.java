package com.yuskie.schedule.model;

import java.util.List;

public class Student {
	private String name;
	
	private List<Company> preferences;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Company> getPreferences() {
		return preferences;
	}
	public void setPreferences(List<Company> preferences) {
		this.preferences = preferences;
	}


}
