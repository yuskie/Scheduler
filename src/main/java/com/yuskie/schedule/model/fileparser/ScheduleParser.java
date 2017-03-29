package com.yuskie.schedule.model.fileparser;

import java.io.File;

public class ScheduleParser {
	
	private File scheduleFile;
	
	public ScheduleParser() {
		scheduleFile = new File("companies10Slots.csv");
		if (!scheduleFile.exists()) {
			System.out.println("File not found: " + scheduleFile.getAbsolutePath());
			System.exit(1);
		} else if (!scheduleFile.isFile()) {
			System.out.println("That is not a file!" + scheduleFile.getAbsolutePath());
			System.exit(1);
		}
	}


}
