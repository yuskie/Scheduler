package com.yuskie.schedule.model.parser.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.yuskie.schedule.model.Schedule;
import com.yuskie.schedule.model.Slot;
import com.yuskie.schedule.model.parser.ScheduleParser;

public class ScheduleCSVParser implements ScheduleParser {

	private File scheduleFile;

	public ScheduleCSVParser() {
		scheduleFile = new File("spring_2017_schedule.csv");
		if (!scheduleFile.exists()) {
			System.out.println("File not found: " + scheduleFile.getAbsolutePath());
			System.exit(1);
		} else if (!scheduleFile.isFile()) {
			System.out.println("That is not a file!" + scheduleFile.getAbsolutePath());
			System.exit(1);
		}
	}

	public Schedule parseSchedule() {
		Schedule theSchedule = new Schedule();
		Map<Integer, List<Slot>> days = new HashMap<>();

		List<Slot> day1 = new ArrayList<>();
		List<Slot> day2 = new ArrayList<>();

		try (Scanner fileScanner = new Scanner(scheduleFile)) {

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] lineCells = line.split("[|]+");
				int lineDay = Integer.parseInt(lineCells[0]);

				Slot theSlot = new Slot();
				if (lineDay == 1) {
					day1.add(theSlot);
				}
				if (lineDay == 2) {
					day2.add(theSlot);
				}

			}

		} catch (FileNotFoundException e) {

		}
		days.put(1, day1);
		days.put(2, day2);
		theSchedule.setDays(days);
		return theSchedule;

	}
	
}
