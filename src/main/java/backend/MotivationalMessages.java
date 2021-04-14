package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *Public class which handles the motivational messages requirements.
 */
public class MotivationalMessages {
    // Fields
    // the directory in which the file with motivational messages can be found
    private static final File directory = new File(".\\src");
    private static final File[] files = directory.listFiles();
    private final ArrayList<String> txtFiles; // contains all the txt files' names
    private ArrayList<String> line;
    public int numberOfRows = 0;
    public ArrayList<String> generalQuotesList; // more general quotes
    public int numberOfGeneralQuotes = 0;
    public ArrayList<String> educationQuotesList; // quotes related to education
    public int numberOfEducationQuotes = 0;
    public ArrayList<String> exerciseQuotesList; // quotes related to exercise
    public int numberOfExerciseQuotes = 0;

    /**
     * Constructor. An arrayList with all .txt files is initialised.
     */
    public MotivationalMessages() {
        txtFiles = new ArrayList<>();
        setPathsOfTheFiles();
    }

    /**
     * All .txt files of the src folder are added an array list.
     */
    private void setPathsOfTheFiles(){
        // complete path from the root directories of the given file object
        if(files!= null){
            for(File file:files){
                // if the file contains .txt
                if(file.getName().contains(".txt")){
                    txtFiles.add(file.getName());
                }
            }
        }
    }

    /**
     * Method which chooses the document containing the motivational quotes.
     * @return String representing the name of the file which has the motivational messages.
     */
    private String chooseTheRightDocument() {
        String rightFile = null;
        if (txtFiles != null) {
            for (String pathsOfTheFile : txtFiles) {
                if (pathsOfTheFile.contains("motivationalMessages")) {
                    rightFile = pathsOfTheFile;
                }
            }
        }
        return rightFile;
    }

    /**
     * Method in which all motivational quotes are sorted in lists.
     * The general quotes are added to an array list of general quotes.
     * The quotes related to education are added to an array list of education quotes.
     * The quotes related to exercise are added to an array list of exercise quotes.
     */
    private void getMotivationalMessage() {
        String fileName = chooseTheRightDocument();
        line = new ArrayList<>(); // are lines of the document are saved in this list
        generalQuotesList = new ArrayList<>();
        educationQuotesList = new ArrayList<>();
        exerciseQuotesList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File( ".\\src\\" + fileName));
            while (scanner.hasNextLine()) {
                line.add(scanner.nextLine());
                // handles general quotes
                if (line.get(numberOfRows).equals("GENERAL")) {
                    String newLine;
                    do {
                        newLine = scanner.nextLine();
                        line.add(newLine);
                        numberOfRows++;
                        if (!line.get(numberOfRows).isEmpty() && !line.get(numberOfRows).startsWith("EDUCATION") &&
                        !line.get(numberOfRows).startsWith("EXERCISE")) {
                            lineIsAGeneralMotivationalMessage();
                        }
                    } while (scanner.hasNextLine() && !newLine.startsWith("EDUCATION") && !newLine.startsWith("EXERCISE"));
                }
                // handles the quotes related to education
                if(line.get(numberOfRows).equals("EDUCATION")){
                    String educationNewLine;
                    do{
                        educationNewLine = scanner.nextLine();
                        line.add(educationNewLine);
                        numberOfRows++;
                        if (!line.get(numberOfRows).isEmpty() && !line.get(numberOfRows).startsWith("GENERAL") &&
                                !line.get(numberOfRows).startsWith("EXERCISE")) {
                            lineIsEducationQuote();
                        }
                    } while(scanner.hasNextLine() && !educationNewLine.startsWith("GENERAL") &&
                            !educationNewLine.startsWith("EXERCISE"));
                }
                // selects the quotes related to exercise
                if(line.get(numberOfRows).equals("EXERCISE")){
                    String exerciseNewLine;
                    do{
                        exerciseNewLine = scanner.nextLine();
                        line.add(exerciseNewLine);
                        numberOfRows++;
                        if(!line.get(numberOfRows).isEmpty() && !line.get(numberOfRows).startsWith("GENERAL") &&
                                !line.get(numberOfRows).startsWith("EDUCATION")){
                            lineIsExerciseQuote();
                        }
                    } while(scanner.hasNextLine() && !exerciseNewLine.startsWith("GENERAL") &&
                            !exerciseNewLine.startsWith("EXERCISE"));

                }
                numberOfRows++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds each general quote to the general quotes list.
     */
    private void lineIsAGeneralMotivationalMessage(){
        generalQuotesList.add(line.get(numberOfRows));
        numberOfGeneralQuotes++;
    }

    /**
     * Adds each education quote to the education quotes list.
     */
    private void lineIsEducationQuote(){
        educationQuotesList.add(line.get(numberOfRows));
        //System.out.println(line.get(numberOfRows));
        numberOfEducationQuotes++;
    }

    /**
     * Adds each exercise quote to the education quotes list.
     */
    private void lineIsExerciseQuote(){
        exerciseQuotesList.add(line.get(numberOfRows));
        numberOfExerciseQuotes++;
    }

    /**
     * Method which randomly chooses a general quote.
     * @return - String representing a quote or a message.
     */
    public String chooseAGeneralQuote(){
        Random random = new Random();
        if(!generalQuotesList.isEmpty()){
            int index = random.nextInt(numberOfGeneralQuotes);
            return generalQuotesList.get(index);
        }
        return "Invalid string.";
    }

    /**
     * Method which randomly chooses an education-related quote.
     * @return - String representing a quote or a message.
     */
    public String chooseAnEducationQuote(){
        Random rand = new Random();
        if(!educationQuotesList.isEmpty()){
            int ind = rand.nextInt(numberOfEducationQuotes);
            return educationQuotesList.get(ind);
        }
        return "Invalid string.";
    }

    /**
     * Method which randomly selects an exercise-related quote.
     * @return - String representing a quote or a message.
     */
    public String chooseAnExerciseQuote(){
        Random element = new Random();
        if(!exerciseQuotesList.isEmpty()){
            int no = element.nextInt(numberOfExerciseQuotes);
            return exerciseQuotesList.get(no);
        }
        return "Invalid string.";
    }

    /**
     * Main method of the MotivationalMessages class.
     * Creates an object.
     * Prints 3 motivational quotes (1st -general, 2nd - education, 3rd - exercise)
     * @param args - command line arguments.
     */
    public void testing(String[] args){
        MotivationalMessages message = new MotivationalMessages();
        message.getMotivationalMessage();
        if(!message.generalQuotesList.isEmpty())
            System.out.println(message.chooseAGeneralQuote());
        if(!message.educationQuotesList.isEmpty()){
            System.out.println(message.chooseAnEducationQuote());
        }
        if(!message.exerciseQuotesList.isEmpty()){
            System.out.println(message.chooseAnExerciseQuote());
        }
    }
}
