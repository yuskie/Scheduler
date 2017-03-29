package com.yuskie.schedule.model;

import java.util.ArrayList;
import java.util.List;

public class Slot {
	private List<Appointment> appointments = new ArrayList<>();
	private int id;
	
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void addAppointment(Appointment appt){
		appointments.add(appt);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
