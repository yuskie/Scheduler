package com.yuskie.schedule.model.fileparser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.yuskie.schedule.model.Company;
import com.yuskie.schedule.model.Slot;

public class CompanyParser10Slots implements CompanyParser {

	private File companyFile;

	public CompanyParser10Slots() {
		companyFile = new File("companies10Slots.csv");
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

				String company = fileScanner.nextLine();
				Company theCompany = new Company();
				String companyName = company.split("[|]+")[1];
				theCompany.setName(companyName);

				boolean contains = false;
				for (Company c : companies) {
					if (theCompany.getName().equals(c.getName())) {
						int day = Integer.parseInt(company.split("[|]+")[0]);
						List<Slot> slotList = create10Slots();
						c.getTimes().put(day, slotList);
						contains = true;
						break;
					}
				}

				if (contains == false) {
					List<Slot> slotList = create10Slots();
					Map<Integer, List<Slot>> times = new HashMap<>();
					int day = Integer.parseInt(company.split("[|]+")[0]);
					times.put(day, slotList);
					companies.add(theCompany);
					theCompany.setTimes(times);
				}
			}
		} catch (Exception e) {

		}
		return companies;
	}

	private List<Slot> create10Slots() {
		List<Slot> slotList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Slot theSlot = new Slot();
			slotList.add(theSlot);
		}
		return slotList;
	}
}
