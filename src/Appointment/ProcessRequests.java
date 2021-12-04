package Appointment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessRequests {
	private static Schedule one_scheduleList = new Schedule();
	private static Schedule two_scheduleList = new Schedule();
	private static ArrayList<Appointment> appointments = null;
	private static ArrayList<Appointment> requestsArrayList = null;
	
	public static void main(String[] args) {
		//Reading from the Schedule file.
		appointments = new ArrayList<Appointment>();
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
			for(int j=0; j<appointments.size(); j++) {
				if(i==j) {
					break;
				}
				if(appointments.get(i).equals(appointments.get(j))) {
					isEqual = true;
					break;
				}
			}
			if(!isEqual) {
				one_scheduleList.addToStart(appointments.get(i));
			}
		}
		input.close();
		
		//Reading from the Requests file.
		Scanner inputRequests = null;
		requestsArrayList = new ArrayList<Appointment>();
		try {
			inputRequests = new Scanner(new FileInputStream("Requests.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println("Requests File not found, So terminating the program...!!");
			System.exit(0);
		}
		while(inputRequests.hasNext()) {
			String line = inputRequests.nextLine();
			String[] lineArray = line.split(" ",-1);
			requestsArrayList.add(new Appointment(lineArray[0], null,  Double.parseDouble(lineArray[1]), 
										Double.parseDouble(lineArray[2])));
		}
		inputRequests.close();
		processingRequests();
	}
	
	/**
	 * This method processes all the requests and displays the output.
	 */
	private static void processingRequests() {
		int counter = 0;
		String doctorName = null;
		for(int i=0; i<requestsArrayList.size(); i++) {
			counter = 0;
			for(int j=0; j<appointments.size(); j++) {
				String result = requestsArrayList.get(i).isOnSameTime(appointments.get(j));
				if(result.equalsIgnoreCase("Same time")) {
					doctorName = appointments.get(j).getDoctorName();
					counter++;
				}
				else if(result.equalsIgnoreCase("Some Overlap")) {
					doctorName = appointments.get(j).getDoctorName();
					counter++;
				}
			}
			if(counter==0) {
				System.out.println("Patient can't book appointment " + requestsArrayList.get(i).getAppointmentID() 
						+" from " + requestsArrayList.get(i).getStartTime() + " to " 
						+ requestsArrayList.get(i).getEndTime() + " as no doctor is available at this time.");
			}
			if(counter == 1) {
				System.out.println("Patient can book appointment " + requestsArrayList.get(i).getAppointmentID() 
						+" from " + requestsArrayList.get(i).getStartTime() + " to " 
						+ requestsArrayList.get(i).getEndTime() + " with " + doctorName + " as other doctors are "
						+ "not available at this time.");
			}
			if(counter > 1) {
				System.out.println("Patient can book appointment   " + requestsArrayList.get(i).getAppointmentID() 
						+" from " + requestsArrayList.get(i).getStartTime() + " to " 
						+ requestsArrayList.get(i).getEndTime() + " as nothing is schedule during that time for "
						+ "multiple doctors " );
			}
		}
	}
	
	/**
	 * This method prompt the user to enter few appointment Ids in order to check in the given file.
	 */
	public static void promptUserForAppointmentIDs() {
		
	}
}
