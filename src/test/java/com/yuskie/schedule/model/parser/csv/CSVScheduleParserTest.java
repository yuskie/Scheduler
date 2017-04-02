package com.yuskie.schedule.model.parser.csv;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yuskie.schedule.model.Schedule;

public class CSVScheduleParserTest {

	@Test
	public void fall_match_making_schedule_parser_test(){
		ScheduleCSVParser newScheduleCSVParser = new ScheduleCSVParser("csv_parsed/fall_match_making_schedule_object.csv");
		Schedule schedule = newScheduleCSVParser.parseSchedule();
		assertEquals(schedule.getDays().keySet().size(), 2);
		assertEquals(schedule.getDays().get(1).size(),12);
		assertEquals(schedule.getDays().get(2).size(),11);
	}
	
	
	@Test
	public void spring_cleveland_cohort_4_schedule_parser_test(){
		ScheduleCSVParser newScheduleCSVParser = new ScheduleCSVParser("csv_parsed/spring_cleveland_cohort_4_schedule_object.csv");
		Schedule schedule = newScheduleCSVParser.parseSchedule();
		assertEquals(schedule.getDays().keySet().size(), 2);
		assertEquals(schedule.getDays().get(1).size(),10);
		assertEquals(schedule.getDays().get(2).size(),10);
	}
	
	
	@Test
	public void spring_columbus_cohort_4_schedule_parser_test(){
		ScheduleCSVParser newScheduleCSVParser = new ScheduleCSVParser("csv_parsed/spring_columbus_cohort_4_schedule_object.csv");
		Schedule schedule = newScheduleCSVParser.parseSchedule();
		assertEquals(schedule.getDays().keySet().size(), 4);
		assertEquals(schedule.getDays().get(1).size(),10);
		assertEquals(schedule.getDays().get(2).size(),6);
		assertEquals(schedule.getDays().get(3).size(),10);
		assertEquals(schedule.getDays().get(4).size(),19);
	}
}
