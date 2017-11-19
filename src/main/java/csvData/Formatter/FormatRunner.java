package csvData.Formatter;

public class FormatRunner {
    public static void main(String[] args) {
        //System.out.println("hello world");
        FormatCSV someFile = new FormatCSV();
        someFile.getDataFromRunner(args);
    }
}
