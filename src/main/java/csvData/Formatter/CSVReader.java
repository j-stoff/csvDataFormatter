package csvData.Formatter;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static final int MAX_NUMBER_OF_LINES_IN_LIST = 100;
    private String csvFileName;
    private ArrayList<List> masterList;

    public CSVReader() {
        masterList = new ArrayList<List>();
    }

    public CSVReader(String fileName) {
        this();
        csvFileName = fileName;
    }


    public List<List> getMasterList() {
        return masterList;
    }

    /**
     * Overlapping method that calls all others.
     * @param fileName the file to read.
     */
    public void readFile(String fileName) {
        if (csvFileName == null) {
            csvFileName = fileName;
        }
        ArrayList<String> lineList = null;
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            while (input.ready()) {
                lineList = new ArrayList<String>();
                for (int index = 0; index < MAX_NUMBER_OF_LINES_IN_LIST; index++) {
                    lineList.add(input.readLine());
                }
                masterList.add(lineList);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println("Read file complete");
    }
}
