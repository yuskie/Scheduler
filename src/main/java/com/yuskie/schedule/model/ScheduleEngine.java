package com.yuskie.schedule.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ScheduleEngine {
	private List<Student> students;
	private List<Company> companies;
	private Schedule schedule;
	
	public ScheduleEngine(List<Student> students, List<Company> companies, Schedule schedule){
		this.students = students;
		this.companies = companies;
		this.schedule = schedule;
	}
	
	public Schedule generateSchedule(){
		Map<Integer, List<Slot>> days = schedule.getDays();
		Set<Integer> keys = days.keySet();
		//this for each sets the columns for the schedule
		for(Integer key:  keys){
			List<Slot> day = days.get(key);
			for(int i = 0; i < companies.size(); i++){
				Map<Integer, List<Slot>> companyTimes = companies.get(i).getTimes();
				if(companyTimes.containsKey(key)){
					List<Slot> companySlots = companyTimes.get(key);
					for(Slot s: companySlots){
						Appointment appt = new Appointment();
						appt.setCompany(companies.get(i));
						s.addAppointment(appt);
					}
				}
			}
		}
		
		for(Student s: students){
			List<Company> studentPref = s.getPreferences();
			for(Company c: studentPref){
				Set<Integer> cKeys = c.getTimes().keySet();
				for(Integer key: cKeys){
					List<Slot> companySlots = c.getTimes().get(key);
					for(Slot cS: companySlots){
						List<Appointment> appts = cS.getAppointments();
						for(Appointment appt: appts){
							if(appt.getCompany().equals(c)){
								if(appt.getStudent() == null){
									appt.setStudent(s);
								}
							}
						}
					}
				}
			}
		}
		
		return schedule;
	}

/*	private Map<Company, List<Student>> generateInterestCounter(){
		Map<Company, List<Student>> interestCounter = new HashMap<Company, List<Student>>();
		for(Company company: companies){
			interestCounter.put(company, new ArrayList<Student>());
		}
		for(Student student: students){
			for(Company company: companies){
				if(containsString(student.getPreferences(), company.getName())){
					interestCounter.get(company).add(student);
				}
			}
		}
		
		return interestCounter;
	}*/
	
	public List<Student> getStudents() {
		return students;
	}

	public List<Company> getCompanies() {
		return companies;
	}
	
	private boolean containsString(String[] array, String string){
		for(String stringArg: array){
			if(stringArg.equals(string)){
				return true;
			}
		}
		return false;
	}
}
