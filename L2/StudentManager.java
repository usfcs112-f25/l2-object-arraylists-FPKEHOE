/*
javac StudentDriver.java
java MovieDriver
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



    public static double[] extractNumericColumn(String[][] inputColumnData, int inputColumnIndex) {
        int numericDataCounter=0;

        for(int x = 0; x < inputColumnData.length; x++) {
            try{
                Double.parseDouble(inputColumnData[x][inputColumnIndex]);
                numericDataCounter++;
            }
            catch(NumberFormatException excpt){}
        }

        double columnArray[] = new double[numericDataCounter];

        numericDataCounter=0;

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





