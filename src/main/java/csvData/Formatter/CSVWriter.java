package csvData.Formatter;

import csvData.Data.CSVBookEntry;

import java.io.*;
import java.util.List;

/**
 * A writer class for the CSVFormatter. Simple at the moment, but writes the output file to specified location.
 */
public class CSVWriter {

    /**
     * No argument constructor
     */
    public CSVWriter() {
    }

    /**
     * Write to the specified output file. No error checking on either parameter.
     * @param ratingList The list with all the data to output.
     * @param outputFileName the file to write to.
     */
    public void writeToFile(List<CSVBookEntry> ratingList, String outputFileName) {
        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)))) {
            output.println("book_rating,book_num_rating,book_relative_value,is_book_good");
            for (CSVBookEntry entry:
                 ratingList) {
                output.println(entry.toCSVString());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
