package com.yuskie.schedule.model.parser.csv;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.yuskie.schedule.model.Company;
import com.yuskie.schedule.model.Schedule;
import com.yuskie.schedule.model.Student;

public class CSVStudentParserTest {

	@Test
	public void fall_match_making_schedule_parser_test(){
		ScheduleCSVParser newScheduleCSVParser = new ScheduleCSVParser("csv_parsed/fall_match_making_schedule_object.csv");
		Schedule schedule = newScheduleCSVParser.parseSchedule();
		CompanyCSVParser newCompanyCSVParser = new CompanyCSVParser(schedule, "csv_parsed/fall_match_making_company_object.csv");
		List<Company> companies = newCompanyCSVParser.parse();
		StudentCSVParser newStudentCSVParser = new StudentCSVParser(companies, "csv_parsed/fall_match_making_student_object.csv");
		List<Student> students = newStudentCSVParser.parse();
		assertEquals(students.size(), 31);
		assertTrue(companies.contains(students.get(0).getPreferences().get(0)));
	}
	
	
	@Test
	public void spring_cleveland_cohort_4_schedule_parser_test(){
		ScheduleCSVParser newScheduleCSVParser = new ScheduleCSVParser("csv_parsed/spring_cleveland_cohort_4_schedule_object.csv");
		Schedule schedule = newScheduleCSVParser.parseSchedule();
		CompanyCSVParser newCompanyCSVParser = new CompanyCSVParser(schedule, "csv_parsed/spring_cleveland_cohort_4_company_object.csv");
		List<Company> companies = newCompanyCSVParser.parse();
		StudentCSVParser newStudentCSVParser = new StudentCSVParser(companies, "csv_parsed/spring_cleveland_cohort_4_student_object.csv");
		List<Student> students = newStudentCSVParser.parse();
		assertEquals(students.size(), 27);
		assertTrue(companies.contains(students.get(0).getPreferences().get(0)));
	}
	
	
	@Test
	public void spring_columbus_cohort_4_schedule_parser_test(){
		ScheduleCSVParser newScheduleCSVParser = new ScheduleCSVParser("csv_parsed/spring_columbus_cohort_4_schedule_object.csv");
		Schedule schedule = newScheduleCSVParser.parseSchedule();
		CompanyCSVParser newCompanyCSVParser = new CompanyCSVParser(schedule, "csv_parsed/spring_columbus_cohort_4_company_object.csv");
		List<Company> companies = newCompanyCSVParser.parse();
		StudentCSVParser newStudentCSVParser = new StudentCSVParser(companies, "csv_parsed/spring_columbus_cohort_4_student_object.csv");
		List<Student> students = newStudentCSVParser.parse();
		assertEquals(students.size(), 26);
		assertTrue(companies.contains(students.get(0).getPreferences().get(0)));
	}
}
