package csvData.Formatter;

import csvData.Data.CSVBookEntry;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that is designed to read CSV files. Really simple right now.
 */
public class CSVReader {
    private ArrayList<CSVBookEntry> masterList;
    private CSVFormatter formatter;

    /**
     * No argument constructor. Initializes an empty array list to fill the CSV data with. Also makes a CSVFormatter class
     * with which to help parse the data and create CSVBookEntry items to add to the list.
     */
    public CSVReader() {
        masterList = new ArrayList<CSVBookEntry>();
        formatter = new CSVFormatter();
    }


    /**
     * Retrieval method for the list created by reading the CSV file.
     * @return the list with all csv data.
     */
    public List<CSVBookEntry> getMasterList() {
        return masterList;
    }

    /**
     * Read in a file and add the values to a list of CSVBookEntry type.
     * @param fileName the file to read.
     */
    public void readFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return;
        }

        String data = null;
        CSVBookEntry entry = null;
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            while (input.ready()) {
                data = input.readLine();
                if (data != null && !data.isEmpty()) {
                    entry = formatter.formatLine(input.readLine(), 0, 1, 2);
                    masterList.add(entry);
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
