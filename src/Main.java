import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
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
        ArrayList<String> myArray = new ArrayList<>();
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
            FileWriter myWriter = new FileWriter("NewBible2.txt");
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
}