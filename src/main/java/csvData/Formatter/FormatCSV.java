package csvData.Formatter;

import csvData.Data.CSVBookEntry;

import java.util.List;

/**
 * Controller class for the CSVFormatter program. Creates a reader to read the file, uses a formatter class to
 * add the calculated columns to items within the list. Creates a writer class to output the file.
 */
public class FormatCSV {
    private CSVReader reader;
    private CSVWriter writer;
    private CSVFormatter formatter;
    private RatingListComparator comparator;

    /**
     * No argument constructor. Initializes a reader, writer, formatter, and comparator for use.
     */
    public FormatCSV() {
        reader = new CSVReader();
        writer = new CSVWriter();
        formatter = new CSVFormatter();
        comparator = new RatingListComparator();
    }

    /**
     * Main method for the CSVFormatter program. Platform method that everything starts from.
     * @param args command line arguments. Ends if any other number of arguments except 1 is passed.
     */
    public void getDataFromRunner(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid arguments, should be csv file only");
            return;
        }
        System.out.println("Beginning file read");

        reader.readFile(args[0]);

        List<CSVBookEntry> dataList = reader.getMasterList();

        dataList.sort(comparator);

        formatter.addCalculatedColumns(dataList);

        writer.writeToFile(dataList, "final_data.csv");

        System.out.println("Finished converting CSV file");
    }


}
