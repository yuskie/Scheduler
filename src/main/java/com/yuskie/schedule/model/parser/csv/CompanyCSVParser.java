package com.yuskie.schedule.model.parser.csv;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.yuskie.schedule.model.Company;
import com.yuskie.schedule.model.Schedule;
import com.yuskie.schedule.model.Slot;
import com.yuskie.schedule.model.parser.CompanyParser;

public class CompanyCSVParser implements CompanyParser {

	private File companyFile;
	private Schedule schedule;

	public CompanyCSVParser(Schedule schedule, String fileName) {
		this.schedule = schedule;
		companyFile = new File(fileName);
		if (!companyFile.exists()) {
			System.out.println("File not found: " + companyFile.getAbsolutePath());
			System.exit(1);
		} else if (!companyFile.isFile()) {
			System.out.println("That is not a file!" + companyFile.getAbsolutePath());
			System.exit(1);
		}
	}

	@Override
	public List<Company> parse() {
		List<Company> companies = new ArrayList<>();
		try (Scanner fileScanner = new Scanner(companyFile)) {
			while (fileScanner.hasNextLine()) {
				String companySchedule = fileScanner.nextLine();
				String[] companyScheduleArray = companySchedule.split("[|]+");
				String companyName = companyScheduleArray[0];
				Map<Integer, List<Slot>> companyTimes = new HashMap<>();
				for(int i = 1; i< companyScheduleArray.length; i++){
					String[] time = companyScheduleArray[i].split("[,]");
					int day = Integer.valueOf(time[0]);
					int slot = Integer.valueOf(time[1]);
					if(companyTimes.get(day) == null){
						companyTimes.put(day, new ArrayList<Slot>());
					}
					Slot timeOfDay = schedule.getDays().get(day).get(slot);
					companyTimes.get(day).add(timeOfDay);
				}
				Company newCompany = new Company();
				newCompany.setName(companyName);
				newCompany.setTimes(companyTimes);
				companies.add(newCompany);
			}
		} catch (Exception e) {
			System.out.println("ERRROR PARSING");
			System.exit(-1);
		}
		return companies;
	}
}
