import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    public enum BookTestament {
        NewTestament,
        OldTestament;
    }
    public static void main(String args[]) throws FileNotFoundException {

        boolean running = true;
        do {
            System.out.println("Do you want to:\nA - Search for verses for a word or phrase\nB - Associate a word with a verse\nC - Search for a specific verse\nD - Get random verse");
            Scanner s = new Scanner(System.in);
            String task = s.next();
            if (task.equalsIgnoreCase("A")) {
                System.out.println("What do you want to search for?");
                Scanner wordScanner = new Scanner(System.in);
                String word = wordScanner.nextLine();
                System.out.println("Verses with word:\n");
                try {
                    Scanner s2 = new Scanner(new File("BibleWithBookNames.txt"));
                    while (s2.hasNextLine()) {
                        String line = s2.nextLine();
                        String newline = line;
                        Pattern pat = Pattern.compile("[0-9]+:[0-9]+");
                        Matcher m = pat.matcher(line);
                        while (m.find()) {
                            int e = m.end();
                            newline = line.substring(e);
                        }
                        if (newline.indexOf(word) != -1) {
                            System.out.println(line);
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error Reading File; " + e);
                }
                System.out.println("\nVerses associated with word:\n");
                try {
                    Scanner s2 = new Scanner(new File("KeyWords.txt"));
                    while (s2.hasNextLine()) {
                        String line = s2.nextLine();
                        if (line.indexOf(word) != -1) {
                            String[] arrOfStr = line.split(",");
                            for (int i = 1; i < arrOfStr.length; i++){
                                Scanner s3 = new Scanner(new File("BibleWithBookNames.txt"));
                                while (s3.hasNextLine()) {
                                    String BibleLine = s3.nextLine();
                                    if (BibleLine.indexOf(arrOfStr[i]) != -1) {
                                        System.out.println(BibleLine);
                                    }
                                }
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error Reading File; " + e);
                }
            }
            else if (task.equalsIgnoreCase("B")){
                ArrayList<String> myArray = new ArrayList<>();
                Scanner r = new Scanner(System.in);
                System.out.println("What verse do you want to associate a word with?");
                String verse = r.nextLine();
                System.out.println("What do you want to add to this verse?");
                String word = r.nextLine();
                boolean found = false;
                try {
                    Scanner s2 = new Scanner(new File("KeyWords.txt"));
                    while (s2.hasNextLine()) {
                        String line = s2.nextLine();
                        if (line.indexOf(word) != -1) {
                            found = true;
                            myArray.add(line + "," + verse);
                            break;
                        }
                        else{
                            myArray.add(line);
                        }
                    }
                    if (!found){
                        myArray.add(word + "," + verse);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error Reading File; " + e);
                }
                try {
                    FileWriter myWriter = new FileWriter("KeyWords.txt");
                    for (int i = 0; i < myArray.size(); i++){
                        myWriter.write(myArray.get(i) + "\n");
                    }
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
            else if (task.equalsIgnoreCase("C")) {
                try {
                    System.out.println("What verse do you want to search for?");
                    Scanner myScanner = new Scanner(System.in);
                    String verse = myScanner.nextLine();
                    Scanner s2 = new Scanner(new File("BibleWithBookNames.txt"));
                    while (s2.hasNextLine()) {
                        String line = s2.nextLine();
                        if (line.indexOf(verse + " ") != -1) {
                            System.out.println(line);
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error Reading File; " + e);
                }
            }
            else if (task.equalsIgnoreCase("D")){
                Random rand = new Random();
                int verseLineNumber = rand.nextInt(31102);
                try {
                    Scanner s3 = new Scanner(new File("BibleWithBookNames.txt"));
                    for (int i = 0; i < verseLineNumber; i++) {
                        if (s3.hasNextLine()) {
                            s3.nextLine();
                        }
                    }
                    System.out.println(s3.nextLine());
                    System.out.println();
                }catch (FileNotFoundException e) {
                    System.out.println("Error Reading File; " + e);
                }
            }
            else {
                System.out.println("Invalid input...");
            }
        System.out.println("\nType \"c\" to continue.\nType anything else to exit.");
            String answer = s.next();
            if (!answer.equalsIgnoreCase("c")){
                running = false;
            }
        }while (running);
    }
}


//Search for just verses associated orf just verses with word
//Groups of verses instead of just single verses (+3 from starting verse implies starting verse and next 3)
//Similar words (friend, friendship)
//Plural (friend, friends)
//Check for proper formatting (to avoid corrupt KeyWords.txt file)
//Remove words
//Be able to associate word with verse searched
//Be able to associate a word with verse in list of verses that come up
//Show verse before associating word
//Give random verse                                                                                             DONE
//Give random word list from KeyWords.txt
//Have choice to select wrong verse
//Make words not case sensitive or require proper format
//Say if verse doesn't exist
//Show format for verses
//Search for groups of verses