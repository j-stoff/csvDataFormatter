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
    private ArrayList<String> masterList;
    private CSVFormatter formatter;

    public CSVReader() {
        masterList = new ArrayList<String>();
        formatter = new CSVFormatter();
    }

    public CSVReader(String fileName) {
        this();
        csvFileName = fileName;
    }


    public List<String> getMasterList() {
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

        String data = null;
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            int counter = 0;
            while (input.ready()) {
                for (int index = 0; index < MAX_NUMBER_OF_LINES_IN_LIST; index++) {
                    data = input.readLine();
                    if (data != null && !data.isEmpty()) {
                        data = formatter.formatLine(input.readLine());
                        masterList.add(data);
                    }
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println("Read file complete");
    }
}
