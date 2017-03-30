package com.yuskie.schedule.model.fileparser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yuskie.schedule.model.Company;
import com.yuskie.schedule.model.Schedule;
import com.yuskie.schedule.model.ScheduleEngine;
import com.yuskie.schedule.model.Student;

public class StudentCSVParser implements StudentInputParser{
	
	private File studentFile;
	private List<Company> companies;

	public StudentCSVParser(List<Company> companies) {
		this.companies = companies;
		studentFile = new File("spring2017_student.csv");
		if (!studentFile.exists()) {
			System.out.println("File not found: " + studentFile.getAbsolutePath());
			System.exit(1);
		} else if (!studentFile.isFile()) {
			System.out.println("That is not a file!" + studentFile.getAbsolutePath());
			System.exit(1);
		}
	}
	
	@Override
	public List<Student> parse() {
		List<Student> students = new ArrayList<>();
		try (Scanner fileScanner = new Scanner(studentFile)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				Student student = new Student();
				String[] lineArray = line.split("[|]+");
				String studentName = lineArray[0];
				student.setName(studentName);
				List<Company> studentPref = new ArrayList<>();
				for(Company comp : companies){
					for(int i = 1; i < lineArray.length; i++){
						if(comp.getName().toUpperCase().equals(lineArray[i].toUpperCase())){
							studentPref.add(comp);
						}
					}
				}
				student.setPreferences(studentPref);
				students.add(student);
			}
		} catch (Exception e) {

		}
		return students;
	}
	
	public static void main(String[] args){
		ScheduleParser sp = new ScheduleParser();
		Schedule schedule = sp.parseSchedule();
		CompanyParser10Slots companies = new CompanyParser10Slots(schedule);
		List<Company> comps = companies.parse();
		StudentCSVParser students = new StudentCSVParser(comps);
		List<Student> studentList = students.parse();
		ScheduleEngine engine = new ScheduleEngine(studentList, comps, schedule);
		Schedule genSched = engine.generateSchedule();
		System.out.println(genSched);
	}

}
