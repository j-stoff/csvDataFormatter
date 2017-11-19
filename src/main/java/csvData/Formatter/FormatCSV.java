package csvData.Formatter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FormatCSV {
    private String csvFileName;
    private CSVReader reader;
    private CSVWriter writer;
    private CSVFormatter formatter;

    public FormatCSV() {
        reader = new CSVReader();
        writer = new CSVWriter();
        formatter = new CSVFormatter();
    }

    public void getDataFromRunner(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid arguments, should be csv file only");
            return;
        }

        csvFileName = args[0];

        parseFile(csvFileName);
    }

    public void parseFile(String fileName) {
        // Open the file, read contents
        reader.readFile(fileName);

        List<String> master = reader.getMasterList();

        //sendDataToFormatter(master);

        // Create new output and amend as necessary
    }

    private void sendDataToFormatter(List<String> master) {
        //formatter.formatList(master.get(0));
        List<String> sortedList = formatter.sortList(master);
        int counter = 0;
        for (String value :
                sortedList) {
            counter += 1;
            System.out.println(value + " " + counter);
        }
        System.out.println("Data formatted");
    }

}
