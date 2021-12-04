package Appointment;

public class Testing {

	public static void main(String[] args) {
		Schedule list = new Schedule();
		Appointment a1 = new Appointment("M1", "Smith", 10.00, 11.00);
		Appointment a2 = new Appointment("M2", "Harry", 11.00, 11.30);
		Appointment a3 = new Appointment("M3", "Harman", 11.30, 12.00);
		Appointment a4 = new Appointment("M4", "Sarab", 12.00, 12.30);
		list.addToStart(a1);
		list.addToStart(a2);
		list.addToStart(a3);
		list.addToStart(a4);
		list.display();
		System.out.println("-------------------------------");
		list.insertAtIndex(a3, 2);
		list.display();
		System.out.println("-------------------------------");
		list.replaceAtIndex(a2, -1);
		list.display();
		System.out.println(list.find("M4"));
		System.out.println(list.contains("M1"));
	}

}
