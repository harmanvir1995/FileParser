package Appointment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessRequests {
	private static Schedule one_scheduleList = new Schedule();
	private static Schedule two_scheduleList = new Schedule();
	
	public static void main(String[] args) {
		ArrayList<Appointment> appointments = new ArrayList<Appointment>();
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream("Schedule.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found so terminating the program...");
			System.exit(0);
		}
		double startTime = 0.00;
		double endTime = 0.00 ;
		while(input.hasNextLine()) {
			String line = input.nextLine();
			String appointmentID = null;
			String doctorName = null;
			if(!line.trim().equals("") && !line.substring(0, 3).equals("Dr.")){
				String[] lineArray = line.split(" ");
				appointmentID = lineArray[0];
				doctorName = lineArray[1];
				line = input.nextLine();
				lineArray = line.split(" ");
				System.out.println(lineArray[1]);
				startTime = Double.parseDouble(lineArray[1]);
				line = input.nextLine();
				lineArray = line.split(" ");
				endTime = Double.parseDouble(lineArray[1]);
			}
			if(appointmentID != null && doctorName != null) {
				Appointment appObject = new Appointment(appointmentID, doctorName, startTime, endTime);
				appointments.add(appObject);
			}
		}
		boolean isEqual = false;
		for(int i = 0; i<appointments.size(); i++) {
			isEqual = false;
			for(int j=0; j<appointments.size()-1; j++) {
				if(appointments.get(i).equals(appointments.get(j))) {
					isEqual = true;
					if(isEqual) {
						System.out.println("*************"+appointments.get(i));
						System.out.println("*************"+appointments.get(j));
					}
					break;
				}
			}
			if(!isEqual) {
				one_scheduleList.addToStart(appointments.get(i));
			}
		}
		input.close();
		one_scheduleList.display();
		System.out.println(one_scheduleList.size());
	}
}
