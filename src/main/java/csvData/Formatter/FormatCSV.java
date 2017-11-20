package csvData.Formatter;

import csvData.Data.CSVBookEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormatCSV {
    private String csvFileName;
    private CSVReader reader;
    private CSVWriter writer;
    private CSVFormatter formatter;
    private List<CSVBookEntry> dataList;

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

        //List<CSVBookEntry> master = reader.getMasterList();
        dataList = reader.getMasterList();

        //sendDataToFormatter(master);
        formatter.sortList(dataList);

        // Create new output and amend as necessary
        addCalculatedRatingColumn();
    }

    private void addCalculatedRatingColumn() {
        int counter = 0;
        for (CSVBookEntry value :
                dataList) {
            counter += 1;
            System.out.println(value + " " + counter);
        }




        System.out.println("Added calculated column");
    }

    private void sendDataToFormatter(List<CSVBookEntry> master) {
        //formatter.formatList(master.get(0));
        //List<CSVBookEntry> sortedList = formatter.sortList(master);
        formatter.sortList(master);


        int counter = 0;
        for (CSVBookEntry value :
                master) {
            //counter += 1;
            System.out.println(value);
        }

        /*
        int startIndex = 0;
        int increaseFactor = sortedList.size() / 100;
        int endIndex = increaseFactor;


        while(endIndex < sortedList.size()) {
            formatter.addCalculatedColumn(sortedList, startIndex, endIndex);
            startIndex += increaseFactor;
            endIndex += increaseFactor;
        }
        */
        System.out.println("Data formatted");
    }

}
