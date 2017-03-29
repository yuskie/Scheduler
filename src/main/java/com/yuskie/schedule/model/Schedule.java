package com.yuskie.schedule.model;

import java.util.List;
import java.util.Map;

public class Schedule {
	private Map<Integer, List<Slot>> days;

	public Map<Integer, List<Slot>> getDays() {
		return days;
	}

	public void setDays(Map<Integer, List<Slot>> days) {
		this.days = days;
	}
	
}
