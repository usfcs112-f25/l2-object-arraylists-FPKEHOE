/*
javac Student.java
java Student
*/

public class Student{
	private int studentID;
	private String lastName;
	private String firstName;
	private String email;
	private String major;
	private double gpa;
	private int creditHours;
	private String house;

	public Student(int inputStudentID, String inputFirstName, String inputLastName, String imputEmail, String inputMajor, double inputGpa, int inputCreditHours, String inputHouse){
		this.studentID=inputStudentID;
		this.lastName=inputFirstName;
		this.firstName=inputFirstName;
		this.email=inputEmail;
		this.major=inputMajor;
		this.gpa=inputGpa;
		this.creditHours=inputCreditHours;
		this.house=inputHouse;
	}

	public getStudentID(){
		return this.studentID
	}
	public getLastName(){
		return this.lastName	
	}
	public getFirstName(){
		return this.firstName	
	}
	public getEmail(){
		return this.email	
	}
	public getMajor(){
		return this.major	
	}
	public getGpa(){
		return this.gpa	
	}
	public getCreditHours(){
		return this.creditHours
	}
	public getHouse(){
		return this.house
	}

	public Strung toString(){
		return ""
	}
}

class CSVProcessor{}


class StudentManager{}




















