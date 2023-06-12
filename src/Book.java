public class Book {
    Main.BookTestament testament;
    String name;
    int startLine;
    int endLine;

    public Book(Main.BookTestament t, String BookName, int firstLineNumber, int lastLineNumber) {
        testament = t;
        name = BookName;
        startLine = firstLineNumber;
        endLine = lastLineNumber;
    }
    public Main.BookTestament getTestament(){
        return testament;
    }
    public String getName(){
        return name;
    }
    public int getStartLine(){
        return startLine;
    }
    public int getEndLine(){
        return endLine;
    }

}
