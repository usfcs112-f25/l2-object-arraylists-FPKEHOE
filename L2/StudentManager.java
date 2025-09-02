/*
javac StudentDriver.java
java StudentDriver hogwarts-students.csv
*/

import java.util.ArrayList; 


class CSVProcessor{
    public static String[][] readCSV(String inputFile) {
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



    public static String[][] analyzeColumnProperties(String[][] inputColumnData, int inputColumnIndex) {
        String[][] returnColumnPropertiesArray = new String[1][1];
        columnLengthCounter=0

        if((inputColumnData[0][inputColumnIndex]).equalsIgnoreCase(student id) || (inputColumnData[0][inputColumnIndex]).equalsIgnoreCase(credit hours)) {
            returnColumnPropertiesArray[0]="int";

             for(int x = 0; x < inputColumnData.length; x++) {
                try {
                    Integer.parseInteger(inputColumnData[x][inputColumnIndex]);
                    columnLengthCounter++;
                }
                catch(NumberFormatException excpt) {
                    System.out.println("Error: invalid data type: " + inputColumnData[x][inputColumnIndex]);
                }
            }
            returnColumnPropertiesArray[0][0]=Integer.toString(columnLengthCounter);
            return returnColumnPropertiesArray;
        }

        
        else if((inputColumnData[0][inputColumnIndex]).equalsIgnoreCase("first name") || (inputColumnData[0][inputColumnIndex]).equalsIgnoreCase("last name") || (inputColumnData[0][inputColumnIndex]).equalsIgnoreCase("email") || (inputColumnData[0][inputColumnIndex]).equalsIgnoreCase("major") || (inputColumnData[0][inputColumnIndex]).equalsIgnoreCase("house")) {
            returnColumnPropertiesArray[0]="string";
                for(int x = 0; x < inputColumnData.length; x++) {
                    try {
                        Integer.parseInteger(inputColumnData[x][inputColumnIndex]);
                        System.out.println("Error: invalid data type: " + inputColumnData[x][inputColumnIndex]);
                    }
                    catch(NumberFormatException excpt) {
                        columnLengthCounter++;               
                    }
                }
            returnColumnPropertiesArray[0]0]=Integer.toString(columnLengthCounter);
            return returnColumnPropertiesArray;

        }
        
        else if((inputColumnData[0][inputColumnIndex]).equalsIgnoreCase("gpa")) {
            returnColumnPropertiesArray[0]="double";
            for(int x = 0; x < inputColumnData.length; x++) {
                try {
                    Double.parseDouble(inputColumnData[x][inputColumnIndex]);
                    columnLengthCounter++;
                }
                catch(NumberFormatException excpt) {
                    System.out.println("Error: invalid data type: " + inputColumnData[x][inputColumnIndex]);
                }
            }
            returnColumnPropertiesArray[0][0]=Double.toString(columnLengthCounter);
            return returnColumnPropertiesArray;
        }
        
        else {
            System.out.println("Data title does not match what is supposed to be there")
            return null
        }
    }










    public static double[] createColumnArray(String[][] inputColumnData, int inputColumnIndex, String[][] inputColumnProperties) {
        int numericDataCounter=0;
        int currentColumnLength=inputColumnProperties[1];
        String currentColumnDataType=inputColumnProperties[1][1];
        
        if(currentColumnDataType.equalsIgnoreCase("int")) {
            int returnColumnArray[] = new int[currentColumnLength];
        }

        else if(currentColumnDataType.equalsIgnoreCase("string")) {
            String returnColumnArray[] = new String[currentColumnLength];
        }
        








        for(int x = 0; x < inputColumnData.length; x++) {
            try{
                Double.parseDouble(inputColumnData[x][inputColumnIndex]);
                
            }
            catch(NumberFormatException excpt){
                System.out.println("Error: invalid data");
        }
        }

        for(int x = 0; x < inputColumnData.length; x++) {
            try{
                columnArray[numericDataCounter] = Double.parseDouble(inputColumnData[x][inputColumnIndex]);
                numericDataCounter++;
            }
            catch(NumberFormatException excpt){}
        }

        return columnArray;
    }

}


public class StudentManager{

    public static void displayStatistics(double[] inputValues, String inputColumnName) {
        // Calculate and display all required statistics
        double average = 0;
        double minimum = Double.POSITIVE_INFINITY;
        double maximum = Double.NEGATIVE_INFINITY;

        int medianIndex = 0;
        double median; 
        double[] medianArray = new double[inputValues.length];

        double[] standardDeviationArray = new double[inputValues.length];
        double standardDeviation = 0;

        for(int x = 0; x < inputValues.length; x++) {

            average = average + inputValues[x];

            if(inputValues[x] > maximum) {
                maximum = inputValues[x];
            }

            if(inputValues[x] < minimum) {
                minimum = inputValues[x];
            }

            medianArray[x] = inputValues[x];
            standardDeviationArray[x] = inputValues[x];

        }
        average = average / (inputValues.length);

        Arrays.sort(medianArray);

        if(medianArray.length % 2 == 0) {
            medianIndex = medianArray.length / 2;
            median = (medianArray[(int)((double)medianIndex + 0.5)] + medianArray[(int)((double)medianIndex - 0.5)]) / 2;
        }
        else {
            medianIndex = medianArray.length / 2;
            median = medianArray[medianIndex];
        }

        for(int x = 0; x < standardDeviationArray.length; x++) {
            standardDeviationArray[x] = standardDeviationArray[x] - average;
            standardDeviationArray[x] = standardDeviationArray[x] * standardDeviationArray[x];
            standardDeviation = standardDeviation + standardDeviationArray[x];
        }

        standardDeviation = standardDeviation / (inputValues.length);
        standardDeviation = Math.sqrt(standardDeviation);


        if(inputColumnName.equalsIgnoreCase("price")) {
            System.out.println("\n" + inputColumnName + ":");
            System.out.printf("Average: " + "$%.2f",average);
            System.out.printf("\nMaximum: "+"$%.2f",maximum);
            System.out.printf("\nMinimum: "+"$%.2f",minimum);
            System.out.printf("\nMedian: "+"$%.2f",median);
            System.out.printf("\nStandard deviation: "+"$%.2f",standardDeviation);
        }
        else{
            System.out.println("\n" + inputColumnName + ":");
            System.out.printf("Average: " + "%.3f",average);
            System.out.printf("\nMaximum: "+"%.3f",maximum);
            System.out.printf("\nMinimum: "+"%.3f",minimum);
            System.out.printf("\nStandard deviation: "+"%.3f",standardDeviation);
        }
    }






	public static void main (String [] args){
		Movie jaws=new Movie("Jaws", 1975, "Universal Pictures");
		Movie highschoolmusical=new Movie("High School Musical", 2006, "Disney Channel");
		Movie moonstruck=new Movie("Moonstruck", 1987, "Metro-Goldwyn-Mayer");
		Movie airbuddies=new Movie("Air Buddies", 2006, "Air Bud Entertainment");
		Movie toystory=new Movie("Toy Story", 1995, "Pixar");

/*IMPORTANT THIS IS THERE YOU LEFT OFF ------------------------------------*/
        for xxxx{
            student arraylist0=new student(x xxx xxxx)
        }

		ArrayList<Movie> movies=new ArrayList<Movie>();
		movies.add(jaws);
		movies.add(highschoolmusical);
		movies.add(moonstruck);
		movies.add(airbuddies);
		movies.add(toystory);

		for(Movie x:movies){
			System.out.println(x);
		}
	}
}





