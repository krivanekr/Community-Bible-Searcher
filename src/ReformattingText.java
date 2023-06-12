import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ReformattingText {
    /*public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("Bible.txt"));
            while (input.hasNextLine()) {
                lines.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error Reading File; " + e);
        }
    }*/

    public static void main(String[] args) {
        ArrayList<String> booknames = new ArrayList<>();
        booknames.add("Genesis");
        booknames.add("Exodus");
        booknames.add("Leviticus");
        booknames.add("Numbers");
        booknames.add("Deuteronomy");
        booknames.add("Joshua");
        booknames.add("Judges");
        booknames.add("Ruth");
        booknames.add("1 Samuel");
        booknames.add("2 Samuel");
        booknames.add("1 Kings");
        booknames.add("2 Kings");
        booknames.add("1 Chronicles");
        booknames.add("2 Chronicles");
        booknames.add("Ezra");
        booknames.add("Nehemiah");
        booknames.add("Esther");
        booknames.add("Job");
        booknames.add("Psalm");
        booknames.add("Proverbs");
        booknames.add("Ecclesiastes");
        booknames.add("Song of Solomon");
        booknames.add("Isaiah");
        booknames.add("Jeremiah");
        booknames.add("Lamentations");
        booknames.add("Ezekiel");
        booknames.add("Daniel");
        booknames.add("Hosea");
        booknames.add("Joel");
        booknames.add("Amos");
        booknames.add("Obadiah");
        booknames.add("Jonah");
        booknames.add("Micah");
        booknames.add("Nahum");
        booknames.add("Habakkuk");
        booknames.add("Zephaniah");
        booknames.add("Haggai");
        booknames.add("Zechariah");
        booknames.add("Malachi");
        booknames.add("Matthew");
        booknames.add("Mark");
        booknames.add("Luke");
        booknames.add("John");
        booknames.add("Acts");
        booknames.add("Romans");
        booknames.add("1 Corinthians");
        booknames.add("2 Corinthians");
        booknames.add("Galatians");
        booknames.add("Ephesians");
        booknames.add("Philippians");
        booknames.add("Colossians");
        booknames.add("1 Thessalonians");
        booknames.add("2 Thessalonians");
        booknames.add("1 Timothy");
        booknames.add("2 Timothy");
        booknames.add("Titus");
        booknames.add("Philemon");
        booknames.add("Hebrews");
        booknames.add("James");
        booknames.add("1 Peter");
        booknames.add("2 Peter");
        booknames.add("1 John");
        booknames.add("2 John");
        booknames.add("3 John");
        booknames.add("Jude");
        booknames.add("Revelation");
        /*ArrayList<String> myArray = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File("Bible.txt"));
            skipLines(s, 104);//skip 105 lines of input.txt file
            //read the rest of the file
            while (s.hasNextLine()) {
                String line = s.nextLine();
                reformatBible(line, myArray);
            }
        }catch (FileNotFoundException e) {
            System.out.println("Error Reading File; " + e);
        }
        try {
            FileWriter myWriter = new FileWriter("NewBible.txt");
            for (int i = 0; i < myArray.size(); i++){
                myWriter.write(myArray.get(i) + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //System.out.println(myArray.size());
        ArrayList<String> myArray2 = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File("NewBible.txt"));
            //skipLines(s, 104);//skip 105 lines of input.txt file
            //read the rest of the file
            while (s.hasNextLine()) {
                String line = s.nextLine();
                verseSeparater(line, myArray2);
            }
        }catch (FileNotFoundException e) {
            System.out.println("Error Reading File; " + e);
        }
        try {
            FileWriter myWriter = new FileWriter("ReadableBible.txt");
            for (int i = 0; i < myArray2.size(); i++){
                myWriter.write(myArray2.get(i) + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }*/
        ArrayList<String> myArray2 = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File("ReadableBible.txt"));
            s.nextLine();
            int b = 0;
            //read the rest of the file
            while (s.hasNextLine()) {
                String line = s.nextLine();
                char ch = line.charAt(0);
                if (ch == '*'){
                    b++;
                }
                else if (ch == '^'){

                }
                else{
                    myArray2.add(booknames.get(b) + " "  + line);
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("Error Reading File; " + e);
        }
        try {
            FileWriter myWriter = new FileWriter("BibleWithBookNames.txt");
            for (int i = 0; i < myArray2.size(); i++){
                myWriter.write(myArray2.get(i) + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void reformatBible(String line, ArrayList<String> myArray){
        if (line.equals("")){

        }
        else{
            char ch = line.charAt(0);
            if (ch >= '0' && ch <= '9') {
                /*if (line.substring(6).indexOf("1") == -1 && line.substring(6).indexOf("2") == -1 && line.substring(6).indexOf("3") == -1 && line.substring(6).indexOf("4") == -1 && line.substring(6).indexOf("5") == -1 && line.substring(6).indexOf("6") == -1 && line.substring(6).indexOf("7") == -1 && line.substring(6).indexOf("8") == -1 && line.substring(6).indexOf("9") == -1){
                    boolean b = true;
                    while (b){
                        Scanner s = new Scanner(line);
                        while (s.hasNextLine()) {
                            String st = s.next();
                            char ch2 = st.charAt(0);
                            if (ch2 == '1' || ch2 == '2' || ch2 == '3' || ch2 == '4' || ch2 == '5' || ch2 == '6' || ch2 == '7' || ch2 == '8' || ch2 == '9'){

                            }
                        }
                    }
                }*/
                /*boolean b = true;
                boolean a = true;
                 while (b) {
                     a = false;
                    for (int i = 0; i < line.length(); i++) {
                        char ch2 = line.charAt(i);
                        if (ch2 == '1' || ch2 == '2' || ch2 == '3' || ch2 == '4' || ch2 == '5' || ch2 == '6' || ch2 == '7' || ch2 == '8' || ch2 == '9') {
                            myArray.add(line.substring(0, i));
                            line = line.substring(i);
                            a = true;
                        }
                    }
                    if (!a){
                        b = false;
                    }
                }*/
                myArray.add(line);
            }
            else
            {
                myArray.set((myArray.size() - 1), (myArray.get(myArray.size() - 1) + " " + line));
            }
        }
    }
    public static void skipLines(Scanner s,int lineNum){
        for(int i = 0; i < lineNum; i++){
            if(s.hasNextLine())s.nextLine();
        }
    }
    public static void verseSeparater(String line, ArrayList<String> myArray) {
        Pattern pat = Pattern.compile("[0-9]+:[0-9]+");
        Matcher m = pat.matcher(line);
        ArrayList<Integer> starts = new ArrayList<>();
        /*ArrayList<Integer> ends = new ArrayList<>();
        ArrayList<Integer> lengths = new ArrayList<>();*/
        /*while (m.find()) {
            System.out.print("Start index: " + m.start());
            System.out.print(" End index: " + m.end());
            System.out.println(" Found: " + m.group());
            System.out.println("Length: " + m.group().length());
        }
        System.out.println("End of line");*/
        while (m.find()){
            starts.add(m.start());
        }
        if (starts.size() > 1){
            for (int a = 0; a < starts.size() - 1; a++){
                myArray.add(line.substring(starts.get(a), starts.get(a + 1)));
            }
            /*myArray.add(line.substring(starts.get(0), starts.get(1)));
            System.out.println("Size: " + starts.size());
            line = line.substring(starts.get(0));
            System.out.println(line);*/
            myArray.add(line.substring(starts.get(starts.size() - 1)));
        }
        else{
            myArray.add(line);
        }
    }
    public static void addBookNames(String line, ArrayList<String> myArray){

    }
}