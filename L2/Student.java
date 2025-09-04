/**
 * Student class is a class for students with class variables of verying academic information (student id, last name, first name, email, major, gpa, credit hours, house) it has getter and setter methods for each variable and method overrides for the toString() and equals() methods
 * @author Frannt Kehoe
 * @github FPKEHOE
 * @version 9/3/2025
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



	/**
	 * constructor of a Student object with all required class variables
	 * @param inputStudentID the student id
	 * @param inputFirstName the first name
	 * @param inputLastName the last name
	 * @param inputEmail the email address
	 * @param inputMajor the major
	 * @param inputGpa the non-negative gpa
	 * @param inputCreditHours the credit house
	 * @param inputHouse the house
	 * @throws IllegalArgumentException if gpa is a negative number
	 */
	public Student(int inputStudentID, String inputFirstName, String inputLastName, String inputEmail, String inputMajor, double inputGpa, int inputCreditHours, String inputHouse){
		this.studentID=inputStudentID;
		this.lastName=inputLastName;
		this.firstName=inputFirstName;
		this.email=inputEmail;
		this.major=inputMajor;
		if (inputGpa<0){
			throw new IllegalArgumentException("Error: Invalid GPA");
		}
		else{
			this.gpa=inputGpa;
		}
		this.creditHours=inputCreditHours;
		this.house=inputHouse;

	}

	/**
	 * gets the student id
	 * @return the student id
	 */
	public int getStudentID(){
		return this.studentID;
	}

	/**
	 * gets the last name
	 * @return the last name
	 */
	public String getLastName(){
		return this.lastName;	
	}

	/**
	 * gets the first name
	 * @return the first name
	 */
	public String getFirstName(){
		return this.firstName;	
	}

	/**
	 * gets the email
	 * @return the email
	 */	
	public String getEmail(){
		return this.email;	
	}

	/**
	 * gets the major
	 * @return the major
	 */
	public String getMajor(){
		return this.major;	
	}

	/**
	 * gets the gpa
	 * @return the gpa
	 */
	public double getGpa(){
		return this.gpa;
	}

	/**
	 * gets the credit hours
	 * @return the credit hours
	 */
	public int getCreditHours(){
		return this.creditHours;
	}

	/**
	 * gets the house
	 * @return the house
	 */
	public String getHouse(){
		return this.house;
	}

	/**
	 * sets the student id
	 * @param newStudentID the new student id
	 */
	public void setStudentID(int newStudentID){
		this.studentID=newStudentID;
	}


	/**
	 * sets the last name
	 * @param newLastName the new last name
	 */


	public void setLastName(String newLastName){
		this.lastName=newLastName;
	}

	/**
	 * sets the first name
	 * @param newFirstName the new last name
	 */	
	public void setFirstName(String newFirstName){
		this.firstName=newFirstName;
	}

	/**
	 * sets the email
	 * @param newEmail the new email
	 */	
	public void setEmail(String newEmail){
		this.email=newEmail;
	}

	/**
	 * sets the major
	 * @param newMajor the new major
	 */	
	public void setMajor(String newMajor){
		this.major=newMajor;
	}

	/**
	 * sets the gpa and verifies it is not negative
	 * @param newGpa the new gpa
	 *  @throws IllegalArgumentException if gpa is negative
	 */	
	public void setGpa(double newGpa){
		if (newGpa<0){
			throw new IllegalArgumentException("Error: Invalid GPA");
		}
		else{
		this.gpa=newGpa;
	}
	}

	/**
	 * sets the credit hours
	 * @param newCreditHours the new credit hours
	 */	
	public void setCreditHours(int newCreditHours){
		this.creditHours=newCreditHours;
	}

	/**
	 * sets the house
	 * @param newHouse the new house
	 */	
	public void setHouse(String newHouse){
		this.house=newHouse;
	}



	/**
	 * displays a formatted string representation of the student object
	 * @return formatted string representation of the student object
	 */
	@Override
	public String toString(){
		return ("\nStudent ID: "+this.studentID+"\nLast Name: "+this.lastName+"\nFirst Name: "+this.firstName+"\nEmail: "+this.email+"\nMajor: "+this.major+"\nGPA: "+this.gpa+"\nCredit Hours: "+this.creditHours+"\nHouse: "+this.house);
	}


	/**
	 * Compares student with another student on whether they have the same student id
	 * @param student1 the Student object being compared with
	 * @return a boolean true if two students have the same student id
	 */
	@Override
	public boolean equals(Object student1){
		Student student2=(Student) student1;
		boolean returnBoolean;
		returnBoolean=this.studentID==student2.studentID;
		return returnBoolean;
	}


}



















