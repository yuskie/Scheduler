package com.yuskie.schedule.model.parser.csv;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.yuskie.schedule.model.Company;
import com.yuskie.schedule.model.Schedule;

public class CSVCompanyParserTest {

	@Test
	public void fall_match_making_schedule_parser_test(){
		ScheduleCSVParser newScheduleCSVParser = new ScheduleCSVParser("csv_parsed/fall_match_making_schedule_object.csv");
		Schedule schedule = newScheduleCSVParser.parseSchedule();
		CompanyCSVParser newCompanyCSVParser = new CompanyCSVParser(schedule, "csv_parsed/fall_match_making_company_object.csv");
		List<Company> companies = newCompanyCSVParser.parse();
		assertEquals(companies.size(), 23);
		assertEquals(companies.get(9).getTimes().get(1).get(0), schedule.getDays().get(1).get(0)); //Single reference point checker
	}
	
	
	@Test
	public void spring_cleveland_cohort_4_schedule_parser_test(){
		ScheduleCSVParser newScheduleCSVParser = new ScheduleCSVParser("csv_parsed/spring_cleveland_cohort_4_schedule_object.csv");
		Schedule schedule = newScheduleCSVParser.parseSchedule();
		CompanyCSVParser newCompanyCSVParser = new CompanyCSVParser(schedule, "csv_parsed/spring_cleveland_cohort_4_company_object.csv");
		List<Company> companies = newCompanyCSVParser.parse();
		assertEquals(companies.size(), 22);
		assertEquals(companies.get(9).getTimes().get(1).get(0), schedule.getDays().get(1).get(0)); // Single reference point checker
	}
	
	
	@Test
	public void spring_columbus_cohort_4_schedule_parser_test(){
		ScheduleCSVParser newScheduleCSVParser = new ScheduleCSVParser("csv_parsed/spring_columbus_cohort_4_schedule_object.csv");
		Schedule schedule = newScheduleCSVParser.parseSchedule();
		CompanyCSVParser newCompanyCSVParser = new CompanyCSVParser(schedule, "csv_parsed/spring_columbus_cohort_4_company_object.csv");
		List<Company> companies = newCompanyCSVParser.parse();
		assertEquals(companies.size(), 22);
		assertEquals(companies.get(1).getTimes().get(1).get(0), schedule.getDays().get(1).get(0));

	}
}
