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

	public ScheduleCSVParser(String fileName) {
		scheduleFile = new File(fileName);
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
		try (Scanner fileScanner = new Scanner(scheduleFile)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] lineArray = line.split("[|]+");
				int key = Integer.parseInt(lineArray[0]);
				int slotAmount = Integer.parseInt(lineArray[1]);
				List<Slot> slots = new ArrayList<>();
				for(int i = 0; i<slotAmount; i++){
					Slot newSlot = new Slot();
					slots.add(newSlot);
				}
				days.put(key, slots);
			}

		} catch (FileNotFoundException e) {
			System.out.println("ERRROR PARSING");
			System.exit(-1);
		}
		theSchedule.setDays(days);
		return theSchedule;

	}
	
}
