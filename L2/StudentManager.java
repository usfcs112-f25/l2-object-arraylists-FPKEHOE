/**
 * StudentManager.java reads and validates a csv file, calculates and displays statistics, and displays menu for user
 * Asks user for what action to perform( view all students, view all students based on house, display student count for all houses, calculate average GPA for all students and then write file with average, calculate average GPA based on house, exit program) 
 * @author Franny Kehoe
 * @github FPKEHOE
 * @version 9/3/2025
*/

import java.util.ArrayList; 
import java.io.File;
import java.util.Scanner;
import java.io.*;
import java.io.FileWriter;

/**
 * CSVProcessor reads and validates a csv file from command line and creates ArrayList of Student objects
 */
class CSVProcessor{

    /**
     *  Reads CSV file and creates 2D array of rows and columns
     * @param inputFile is the file name of the CSV file
     * @return returnArray A 2D String array of the rows and columns of the CSV file
    */
    public String[][] readCSV(String inputFile) {
        try {
            File file = new File(inputFile);
            Scanner scannerPass1 = new Scanner(file);

            int numOfRows = 0;
            while(scannerPass1.hasNextLine()) {
                numOfRows++;
                scannerPass1.nextLine();
            }
            scannerPass1.close();

            Scanner scannerPass2 = new Scanner(file);

            String[] rowArray = new String[numOfRows];
            for(int x = 0; x < rowArray.length; x++) {
                if(scannerPass2.hasNextLine()){
                    rowArray[x] = scannerPass2.nextLine();
                }
            }
            scannerPass2.close();

            int numOfColumns = 1;
            for(int x = 0; x < rowArray[0].length(); x++){
                if(rowArray[0].charAt(x) == ','){
                    numOfColumns++;
                }
            }

            String[][] returnArray = new String[numOfRows][numOfColumns];
            String[]tempArray;

            // Assign rowArray elements
            for(int x = 0; x < rowArray.length; x++) {
                tempArray = rowArray[x].split(",");
                for(int y = 0; y < numOfColumns; y++){
                    returnArray[x][y] = tempArray[y];
                }
            }
            return returnArray;
        }

        catch (FileNotFoundException Exception) {
            System.out.println("Error: file " + "\"" + inputFile + "\"" + " cannot be found");
            return null;
        }
    }




    /**
     * Iterates through the 2D array to verify that there are all the required fields in the header row
     * @param input2DArray is the 2D array of the CSV data
     * @return true if all the fields exist and only occur once
    */
    public boolean hasAllFieldsMethod(String[][] input2DArray){
        int hasStudentID=0;
        int hasLastName=0;
        int hasFirstName=0;
        int hasEmail=0;
        int hasMajor=0;
        int hasGpa=0;
        int hasCreditHours=0;
        int hasHouse=0;

        boolean returnhasAllFields=false;

        

        for(int y = 0; y < input2DArray[0].length; y++) {

            if (input2DArray[0][y].equalsIgnoreCase("student id")) {
                hasStudentID++;
            }

            else if (input2DArray[0][y].equalsIgnoreCase("credit hours")){
                hasCreditHours++;
            }

            else if (input2DArray[0][y].equalsIgnoreCase("gpa")){
                hasGpa++;
            }

            else if (input2DArray[0][y].equalsIgnoreCase("last name")){
                hasLastName++;
            }

            else if (input2DArray[0][y].equalsIgnoreCase("first name")){
                hasFirstName++;
            }

            else if (input2DArray[0][y].equalsIgnoreCase("email")){
                hasEmail++;
            }

            else if (input2DArray[0][y].equalsIgnoreCase("major")){
                hasMajor++;
            }

            else if (input2DArray[0][y].equalsIgnoreCase("house")){
                hasHouse++;
            }
        }


        if (hasStudentID>1){
            System.out.println("Error: More than 1 'Student ID' field found");
        }

        if (hasLastName>1){
            System.out.println("Error: More than 1 'Last Name' field found");
        }

        if (hasFirstName>1){
            System.out.println("Error: More than 1 'First Name' field found");
        }

        if (hasEmail>1){
            System.out.println("Error: More than 1 'Email' field found");
        }

        if (hasMajor>1){
            System.out.println("Error: More than 1 'Major' field found");
        }

        if (hasGpa>1){
            System.out.println("Error: More than 1 'GPA' field found");
        }

        if (hasCreditHours>1){
            System.out.println("Error: More than 1 'Credit Hours' field found");
        }

        if (hasHouse>1){
            System.out.println("Error: More than 1 'House' field found");
        }




        if (hasStudentID==0){
            System.out.println("Error: Missing or misspelled 'Student ID' field");
        }

        if (hasLastName==0){
            System.out.println("Error: Missing or misspelled 'Last Name' field");
        }

        if (hasFirstName==0){
            System.out.println("Error: Missing or misspelled 'First Name' field");
        }

        if (hasEmail==0){
            System.out.println("Error: Missing or misspelled 'Email' field");
        }

        if (hasMajor==0){
            System.out.println("Error: Missing or misspelled 'Major' field");
        }
        
        if (hasGpa==0){
            System.out.println("Error: Missing or misspelled 'GPA' field");
        } 

        if (hasCreditHours==0){
            System.out.println("Error: Missing or misspelled 'Credit Hours' field");
        }

        if (hasHouse==0){
            System.out.println("Error: Missing or misspelled 'House' field");
        }


        if((hasStudentID==1)&&(hasCreditHours==1)&&(hasGpa==1)&&(hasLastName==1)&&(hasFirstName==1)&&(hasEmail==1)&&(hasMajor==1)&&(hasHouse==1)){
            returnhasAllFields=true;
        }

        return returnhasAllFields;
    }







        




     /**
     * Iterates through the 2D array to verify that the rows contain the right data types based on the field and creates new 2D array with verified data
     * @param input2DArray is the 2D array of the CSV data
     * @return valid2DArray a new 2D array with the verified data
    */  
    public String[][] validateData(String[][] input2DArray){

        int validRowCounter=0;
        int validColumnAmount=input2DArray[0].length;

        int validIndex = 0;
        for(int x = 1; x < input2DArray.length; x++) {
            boolean isRowValid = true;
            for(int y = 0; y < input2DArray[x].length; y++) {

                if ((input2DArray[0][y].equalsIgnoreCase("student id")) || (input2DArray[0][y].equalsIgnoreCase("credit hours"))) {
                    try {
                        Integer.parseInt(input2DArray[x][y]);
                    }
                    catch(NumberFormatException excpt) {
                        isRowValid = false;
                    }
                }

                else if ((input2DArray[0][y].equalsIgnoreCase("gpa"))) {
                    try {
                        Double.parseDouble(input2DArray[x][y]);          
                    }
                    catch(NumberFormatException excpt) {
                        isRowValid = false;
                    }
                }

 

            }
            if(isRowValid==true){
                validRowCounter++;
            }
        }


        String[][] valid2DArray =new String[validRowCounter][validColumnAmount];

       
        for(int x = 1; x < input2DArray.length; x++) {
            boolean isRowLength = true;
            boolean isRowValid=true;

            for(int y = 0; y < input2DArray[x].length; y++) {

                if ((input2DArray[0][y].equalsIgnoreCase("student id")) || (input2DArray[0][y].equalsIgnoreCase("credit hours"))) {
                    try {
                        Integer.parseInt(input2DArray[x][y]);
                    }
                    catch(NumberFormatException excpt) {
                        isRowValid=false;
                    }
                }

                else if ((input2DArray[0][y].equalsIgnoreCase("gpa"))) {
                    try {
                        Double.parseDouble(input2DArray[x][y]);      
                    }
                    catch(NumberFormatException excpt) {
                         isRowValid=false;
                    }
                }
                
                if (input2DArray[x].length!=validColumnAmount){
                    isRowLength=false;
                }

            }

            if (isRowValid==true&&isRowLength==true){
                for(int y = 0; y < input2DArray[x].length; y++) {
                    valid2DArray[validIndex][y]=input2DArray[x][y];
                }
                validIndex++;
            }

        }

        return valid2DArray;
    }














     /**
     * Iterates through the 2D array and creates Student objects then creates ArrayList of the objects
     * @param input2DArray is the 2D array of the CSV data
     * @return studentsArrayList the ArrayList of the student objects
    */ 
    public ArrayList<Student> createArrayList(String[][] input2DArray) {
        ArrayList<Student> studentsArrayList = new ArrayList<Student>();

        for(int x = 1; x < input2DArray.length; x++) {
            for(int y = 0; y < 1; y++){

                    int tempStudentID=(Integer.parseInt(input2DArray[x][y]));
                    String[] tempLastName={(input2DArray[x][y+1])};
                    String[] tempFirstName={(input2DArray[x][y+2])};
                    String[] tempEmail={(input2DArray[x][y+3])};
                    String[] tempMajor={(input2DArray[x][y+4])};
                    double tempGpa=(Double.parseDouble(input2DArray[x][y+5]));
                    int tempCreditHours=(Integer.parseInt(input2DArray[x][y+6]));
                    String[] tempHouse={(input2DArray[x][y+7])};
                    Student tempStudent=new Student(tempStudentID, tempLastName[0], tempFirstName[0], tempEmail[0], tempMajor[0], tempGpa, tempCreditHours, tempHouse[0]);
                    studentsArrayList.add(tempStudent);
                
            }
        }

        return studentsArrayList;
    }


}










/**
 * StudentManager contains the main method, and analyzes and displays statistics and data from the ArrayList of Student objects
 */
public class StudentManager{

     /**
     * displays a menu of options that the user can choose from and validates the user input
     * @return menuOption[0] string of the validated user input
    */ 
    public static String displayMenu(){
        Scanner menuScanner = new Scanner(System.in);
        String[] menuOption= new String[1];
        boolean validMenuInput = false;

        while (validMenuInput == false){
            System.out.println("\nPlease enter option from below:\n * View all students\n * View all Gryffindor students\n * View all Slytherin students\n * View all Hufflepuff students\n * View all Ravenclaw students\n * Display student count for all houses \n * Calculate GPA for all students\n * Calculate GPA for all Gryffindor students\n* Calculate GPA for all Slytherin students\n* Calculate GPA for all Hufflepuff students\n* Calculate GPA for all Ravenclaw students\n * Exit program");
            menuOption[0]=menuScanner.nextLine();

            if (menuOption[0].toLowerCase().contains("view all students")){
                menuOption[0]="View all students";
                validMenuInput = true;
            }
            
            else if (menuOption[0].toLowerCase().contains("view allgryffindor")){
                menuOption[0]="View all Gryffindor students";
                validMenuInput = true;
            }
            
            else if (menuOption[0].toLowerCase().contains("view all slytherin")){
                menuOption[0]="View all Slytherin students";
                validMenuInput = true;
            }
            
            else if (menuOption[0].toLowerCase().contains("view allhufflepuff")){
                menuOption[0]="View all Hufflepuff students";
                validMenuInput = true;
            }
           
            else if (menuOption[0].toLowerCase().contains("view all ravenclaw")){
                menuOption[0]="View all Ravenclaw students";
                validMenuInput = true;
            }
            
            else if (menuOption[0].toLowerCase().contains("count")){
                menuOption[0]="Display student count for all houses";
                validMenuInput = true;
            }

            else if (menuOption[0].toLowerCase().contains("gpa for all students")){
                menuOption[0]="Calculate GPA for all students";
                validMenuInput = true;
            }

            else if (menuOption[0].toLowerCase().contains("gpa for all gryffindor")){
                menuOption[0]="Calculate GPA for all Gryffindor students";
                validMenuInput = true;
            }


            else if (menuOption[0].toLowerCase().contains("gpa for all slytherin")){
                menuOption[0]="Calculate GPA for all Slytherin students";
                validMenuInput = true;
            }


            else if (menuOption[0].toLowerCase().contains("gpa for all hufflepuff")){
                menuOption[0]="Calculate GPA for all Hufflepuff students";
                validMenuInput = true;
            }


            else if (menuOption[0].toLowerCase().contains("gpa for all ravenclaw")){
                menuOption[0]="Calculate GPA for all Ravenclaw students";
                validMenuInput = true;
            }



            
            else if (menuOption[0].equalsIgnoreCase("exit")){
                menuOption[0]="Exit program";
                validMenuInput = true;
            }
            
            else{
                System.out.println("\nError: please re-enter option (you might have to copy option exactly)");
            }
        }
        return menuOption[0];
    }








     /**
     * displays information for each student object based on the selected student population that the user chose (all or by house)
     * @param inputMenuOption is the user inputted menu option
     * @param inputArrayList the ArrayList of the student objects
    */  
    public static void viewStudents(String inputMenuOption, ArrayList<Student> inputArrayList){
        if (inputMenuOption.equalsIgnoreCase("View all Gryffindor students")){
            for (Student s : inputArrayList){
                if (s.getHouse().equalsIgnoreCase("Gryffindor")){
                    System.out.println(s);
                }
            }
        }

        if (inputMenuOption.equalsIgnoreCase("View all Ravenclaw students")){
            for (Student s : inputArrayList){
                if (s.getHouse().equalsIgnoreCase("Ravenclaw")){
                    System.out.println(s);
                }
            }
        } 

        if (inputMenuOption.equalsIgnoreCase("View all Hufflepuff students")){
            for (Student s : inputArrayList){
                if (s.getHouse().equalsIgnoreCase("Hufflepuff")){
                    System.out.println(s);
                }
            }
        }  

        if (inputMenuOption.equalsIgnoreCase("View all Slytherin students")){
            for (Student s : inputArrayList){
                if (s.getHouse().equalsIgnoreCase("Slytherin")){
                    System.out.println(s);
                }
            }
        }

        if (inputMenuOption.equalsIgnoreCase("View all students")){
            for (Student s : inputArrayList){
                    System.out.println(s);
            }
        }
                      
    }









     /**
     * counts and displays the number of students in specified house chosen by user
     * @param inputMenuOption is the user inputted menu option
     * @param inputArrayList the ArrayList of the student objects
    */  
    public static void displayHouseCount(String inputMenuOption, ArrayList<Student> inputArrayList){
        int slytherinCount=0;
        int hufflepuffCount=0;
        int gryffindorCount=0;
        int ravenclawCount=0;

        for (Student s : inputArrayList){
            if (s.getHouse().equalsIgnoreCase("Ravenclaw")){
                ravenclawCount++;
            }
            if (s.getHouse().equalsIgnoreCase("Slytherin")){
                slytherinCount++;
            }
            if (s.getHouse().equalsIgnoreCase("Hufflepuff")){
                hufflepuffCount++;
            }
            if (s.getHouse().equalsIgnoreCase("Gryffindor")){
                gryffindorCount++;
            }
        }

        System.out.println("Number of Gryffindor students: "+gryffindorCount+"\nNumber of Slytherin students: "+slytherinCount+"\nNumber of Hufflepuff students: "+hufflepuffCount+"\nNumber of Ravenclaw students: "+ravenclawCount);
    }







    /**
     * calculates and displays average gpa of all students and gives user option to save result to file "gpa.txt"
     * @param inputMenuOption is the user inputted menu option
     * @param inputArrayList the ArrayList of the student objects
    */  
    public static void displayAverageGPA(String inputMenuOption, ArrayList<Student> inputArrayList){
        double average=0;
        int count=0;

        for (Student s : inputArrayList){
            average=average+s.getGpa();
            count++;
        }
        average=average/count;
        System.out.println("\nGPA of all students: "+average);



        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAdd average GPA to file 'gpa.txt'? (y/n): ");
        String userWriteFileInput;
        try{
            userWriteFileInput=scanner.nextLine();
            FileWriter outputStream=new FileWriter("gpa.txt");
            if (userWriteFileInput.equalsIgnoreCase("y")){
                
                outputStream.write("\nGPA of all students: "+average);
                System.out.println("\nAverage GPA added to file 'gpa.txt");
            }
            outputStream.close();
        }
        catch (IOException excpt){
            System.out.println("\nError: Cannot write file");
        }
    }


     /**
     * calculates and displays average gpa of all gryffindor students
     * @param inputMenuOption is the user inputted menu option
     * @param inputArrayList the ArrayList of the student objects
    */     
    public static void displayGryffindorAverageGPA(String inputMenuOption, ArrayList<Student> inputArrayList){
        double average=0;
        int count=0;

        for (Student s : inputArrayList){
            if (s.getHouse().equals("Gryffindor")){
                average=average+s.getGpa();
                count++;
            }
        }
        average=average/count;
        System.out.println("\nGPA of all Gryffindor students: "+average);
    }

     /**
     * calculates and displays average gpa of all slytherin students
     * @param inputMenuOption is the user inputted menu option
     * @param inputArrayList the ArrayList of the student objects
    */     
    public static void displaySlytherinAverageGPA(String inputMenuOption, ArrayList<Student> inputArrayList){
        double average=0;
        int count=0;

        for (Student s : inputArrayList){
            if (s.getHouse().equals("Slytherin")){
                average=average+s.getGpa();
                count++;
            }
        }
        average=average/count;
        System.out.println("\nGPA of all Slytherin students: "+average);
    }



     /**
     * calculates and displays average gpa of all hufflepuff students
     * @param inputMenuOption is the user inputted menu option
     * @param inputArrayList the ArrayList of the student objects
    */     
    public static void displayHufflepuffAverageGPA(String inputMenuOption, ArrayList<Student> inputArrayList){
        double average=0;
        int count=0;

        for (Student s : inputArrayList){
            if (s.getHouse().equals("Hufflepuff")){
                average=average+s.getGpa();
                count++;
            }
        }
        average=average/count;
        System.out.println("\nGPA of all Hufflepuff students: "+average);
    }



     /**
     * calculates and displays average gpa of all ravenclaw students
     * @param inputMenuOption is the user inputted menu option
     * @param inputArrayList the ArrayList of the student objects
    */     
    public static void displayRavenclawAverageGPA(String inputMenuOption, ArrayList<Student> inputArrayList){
        double average=0;
        int count=0;

        for (Student s : inputArrayList){
            if (s.getHouse().equals("Ravenclaw")){
                average=average+s.getGpa();
                count++;
            }
        }
        average=average/count;
        System.out.println("\nGPA of all Ravenclaw students: "+average);
    }






        











    /**
     *  Main method that reads the CSV file from the command line and validates user used the command line, creates Student objects, and calls the menu and to asks for user input
     * @param command line argument args[0] should have the CSV file name
    */
    public static void main (String [] args){


        CSVProcessor tempObject=new CSVProcessor();

        String[][] studentsArrayInvalid=tempObject.readCSV(args[0]);
        if (studentsArrayInvalid==null){
            System.out.println("Exiting program");
        }

        else{



            boolean hasAllFields=tempObject.hasAllFieldsMethod(studentsArrayInvalid);

            if (hasAllFields==false){
                System.out.println("Exiting program");
            }

            else{

                String[][] studentsArrayValid=tempObject.validateData(studentsArrayInvalid);
                ArrayList<Student> students = new ArrayList<Student>();
                students = tempObject.createArrayList(studentsArrayValid);

                boolean isExit=false;

                while(isExit==false){
                    String menuOption=displayMenu();
                    if (menuOption.toLowerCase().contains("view")){
                        viewStudents(menuOption, students);
                    }

                    else if (menuOption.toLowerCase().contains("display student count")){
                        displayHouseCount(menuOption, students);
                    }


                    else if (menuOption.toLowerCase().contains("gpa for all students")){
                        displayAverageGPA(menuOption, students);
                    }

                    else if (menuOption.toLowerCase().contains("gpa for all gryffindor")){
                        displayGryffindorAverageGPA(menuOption, students);
                    }

                    else if (menuOption.toLowerCase().contains(" gpa for all slytherin")){
                        displaySlytherinAverageGPA(menuOption, students);
                    }

                    else if (menuOption.toLowerCase().contains("gpa for all hufflepuff")){
                        displayHufflepuffAverageGPA(menuOption, students);
                    }

                    else if (menuOption.toLowerCase().contains("gpa for all ravenclaw")){
                        displayRavenclawAverageGPA(menuOption, students);
                    }

                    else if (menuOption.toLowerCase().contains("exit")){
                        isExit=true;
                    }
                }
            }
        }


    }
}

