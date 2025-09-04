Video: https://drive.google.com/file/d/1No7qcpl-JwSqHs0cUUeN43B1gsgx-To9/view?usp=sharing

Franny Kehoe
20682345
B grade
Run program by inputting csv file into command line
AI Use: none
hurdles: the amount of time it took to create the arraylist of objects

CHECKLIST:
Student Class
- [x] An equals() method that compares students by ID
- [x] A toString() method that returns a formatted string representation
- [x] A parameterized constructor that accepts all field values
- [x] Getter methods for all fields
- [x] Private instance variables for all data fields

 CSVProcessor Class
- [x] Input validation for data types and required fields
- [x] Proper exception handling for file operations
- [x] A method to read the CSV file and return an array of Student objects

StudentManager Class (Main Class):
- [x] This class contains the main method
- [x] It reads in the file, processes it through the CSVProcessor, and displays a menu to demonstrates your program’s functionality
- [x] Methods to display student information
- [x] At least one method that performs analysis on the student data (e.g., calculate average GPA, count students by major)

File:
- [x] Implement proper exception handling for malformed data
- [x] Validate data types during parsing
- [x] Handle the header row appropriately
- [x] Parse CSV data manually (do not use external libraries)
- [x] Use Java’s built-in file reading capabilities (Scanner, BufferedReader, or similar)

Code:
- [x] Handle edge cases and invalid input gracefully
- [x] Include appropriate comments and JavaDoc documentation
- [x] Implement proper encapsulation principles
- [x] Use meaningful variable and method names
- [x] Follow Java naming conventions

C grade
- [x] toString() method returns student information in readable format
- [x] Displays a menu that allows the user to:
    - [x] View all the students
    - [x] View all the students in a specific house
    - [x] Exit the program
- [x] Stores Student objects in an ArrayList
- [x] Creates Student objects from parsed data
- [x] Program reads the provided CSV file
- [x] Getter and Setter methods for all fields
- [x] Parameterized constructor that initializes all fields
- [x] All required instance variables declared and properly encapsulated
- [ ] 
B grade
- [x] JavaDoc documentation for all public methods and classes
- [x] Add an option to the menu that writes out the average GPA for all the students to a file (gpa.txt)
- [x] Add an option to the menu that displays the average GPA calculation for all the students in a user-specified house
- [x] An improved Student Class
    - [x] Input validation in constructor (e.g., non-negative GPA)
    - [x] equals() method implemented correctly
    - [x] toString() method provides well-formatted, professional output
- [x] Validate data types during parsing (catches NumberFormatException)
- [x] Handle header row in the CSV correctly (skips or processes appropriately)
- [x] Implement exception handling for file not found
- [x] All the requirements for a C and
