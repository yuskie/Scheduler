package com.yuskie.schedule.csvparser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yuskie.schedule.model.Student;

public class StudentParser {
	private File studentFile;
	
	public StudentParser(String fileName){
		studentFile = new File(fileName);
	}
	
	public List<Student> generateStudents(){
		List<Student> result = new ArrayList<Student>();
		try(Scanner fileScanner = new Scanner(studentFile)){
			List<String> lines = new ArrayList<>();
			while(fileScanner.hasNextLine()){
				String line = fileScanner.nextLine();
				if (!(line.startsWith(",") || line.startsWith(" ,"))){
					lines.add(line);
					System.out.println(line);
				}
			}
			
		}catch(Exception e){
			
		}
		return result;
	}
	
	public static void main(String[] args){
		StudentParser newParser = new StudentParser("individual_schedule.csv");
		List<Student> result = newParser.generateStudents();
	}
}
