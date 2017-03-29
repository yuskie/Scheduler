package com.yuskie.schedule.model;

import java.util.List;
import java.util.Map;

public class Company {
	private String name;
	private Map<Integer, List<Slot>> times;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Integer, List<Slot>> getTimes() {
		return times;
	}
	public void setTimes(Map<Integer, List<Slot>> times) {
		this.times = times;
	}

}
