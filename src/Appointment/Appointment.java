package Appointment;

import java.util.Scanner;

public class Appointment implements Bookable, Cloneable {
	private String appointmentID;
	private String doctorName;
	private double startTime;
	private double endTime;
	
	/**
	 * @param appointmentID
	 * @param doctorName
	 * @param startTime
	 * @param endTime
	 */
	public Appointment(String appointmentID, String doctorName, double startTime, double endTime) {
		this.appointmentID = appointmentID;
		this.doctorName = doctorName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/**
	 * 
	 * @param appointment
	 * @param appointmentID
	 */
	public Appointment(Appointment appointment, String appointmentID) {
		this.appointmentID = appointmentID;
		this.doctorName = appointment.doctorName;
		this.startTime = appointment.startTime;
		this.endTime = appointment.endTime;
	}
	
	/**
	 * @return the appointmentID
	 */
	public String getAppointmentID() {
		return appointmentID;
	}
	
	/**
	 * @param appointmentID the appointmentID to set
	 */
	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}
	
	/**
	 * @return the doctorName
	 */
	public String getDoctorName() {
		return doctorName;
	}
	
	/**
	 * @param doctorName the doctorName to set
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	/**
	 * @return the startTime
	 */
	public double getStartTime() {
		return startTime;
	}
	
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * @return the endTime
	 */
	public double getEndTime() {
		return endTime;
	}
	
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}

	@Override
	public String isOnSameTime(Appointment a) {
		if(a == null) {
			return "Different time";
		}
		if(this.startTime == a.startTime && this.endTime == a.endTime) {
			return "Same time";
		}
		if(this.startTime == a.startTime || this.endTime == a.endTime) {
			return "Some Overlap";
		}
		return "Different time";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Scanner keyIn = new Scanner(System.in);
		System.out.print("Enter the Appointment ID : for the clone method: ");
		String appointmentID = keyIn.next();
		keyIn.close();
		Appointment appointment = new Appointment(appointmentID, this.doctorName, this.startTime, this.endTime);
		return appointment;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentID=" + appointmentID + ", doctorName=" + doctorName + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (doctorName == null) {
			if (other.doctorName != null)
				return false;
		} else if (!doctorName.equals(other.doctorName))
			return false;
		if (Double.doubleToLongBits(endTime) != Double.doubleToLongBits(other.endTime))
			return false;
		if (Double.doubleToLongBits(startTime) != Double.doubleToLongBits(other.startTime))
			return false;
		return true;
	}
	
	
}
