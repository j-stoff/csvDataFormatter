package csvData.Formatter;

import csvData.Data.CSVBookEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is the critical class that will format the data passed to in to
 * the desired output.
 */
public class CSVFormatter {
    private static final int GOOD_ENOUGH_LIMIT = 1000;

    /**
     * No argument constructor
     */
    public CSVFormatter() {
    }

    /**
     * Retrieves specific pieces of the data based on the input indecies.
     * @param line the string of data to be parsed, must be in CSV format.
     * @return the new CSVEntry.
     */
    public CSVBookEntry formatLine(String line, int authorIndex, int ratingIndex, int numberOfRatingsIndex) {
        String[] splitLine = line.split("\t");
        String authorName = splitLine[authorIndex];
        authorName = authorName.substring(1, authorName.length() - 1);
        double rating = Double.parseDouble(splitLine[ratingIndex]);
        int numberOfRatings = Integer.parseInt(splitLine[numberOfRatingsIndex]);

        CSVBookEntry entry = new CSVBookEntry(authorName, rating, numberOfRatings);

        System.out.println(entry.getAuthorName());
        return entry;
    }


    /**
     * Helper method to take an input string, split the string based on a comma, and return the value as a parsed int.
     * @param input The string input to be split.
     * @param indexPosition the position to be called in the split array.
     * @return the value at the split index position as an int.
     */
    public int parseStringForInt(String input, int indexPosition) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] split = input.split(",");
        if (split[4].contains(".")) {
            return 0;
        }

        return Integer.parseInt(split[indexPosition]);
    }


    /**
     * Helper method to take an input string, split the string base on a comma, and return the value parsed from string
     * to double.
     * @param input the string to be parsed and converted.
     * @param indexPosition the position of the split array to be converted and returned.
     * @return the value of split index position as a double.
     */
    public double parseStringForDouble(String input, int indexPosition) {
        String[] split = input.split(",");
        String out = split[indexPosition];
        if (out.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(out);
    }

    /**
     * A method to fill in the calculated columns within a CSVBookEntry item within the list passed in.
     * The method splits the list into 100 portions, finds the median index of each portion and gets that CSVBookEntry's
     * number of ratings to use a value to multiply for the rest of the portion.
     * @param ratingList the list with entries to be edited.
     */
    public void addCalculatedColumns(List<CSVBookEntry> ratingList) {
        int increaseFactor = ratingList.size() / 100;
        int startPosition = 0;
        int endPosition = increaseFactor;

        for (int index = 0; index < 100; index += 1) {
            int medianIndex = (startPosition + endPosition) / 2;
            CSVBookEntry medianEntry = ratingList.get(medianIndex);
            int medianValue = medianEntry.getNumberOfRatings();
            for (int innerIndex = startPosition; innerIndex <= endPosition; innerIndex += 1) {
                CSVBookEntry currentEntry = ratingList.get(innerIndex);
                int ratingValue = (int)(medianValue * currentEntry.getRating());
                currentEntry.setRatingValue(ratingValue);
                if (ratingValue > GOOD_ENOUGH_LIMIT) {
                    currentEntry.setConsideredGood(1);
                } else {
                    currentEntry.setConsideredGood(0);
                }
            }
            startPosition += increaseFactor;
            endPosition += increaseFactor;
        }
    }



    /**
     * Method to parse a CSV file to remove additional strings denoted by quotes.
     * @param line the line to be altered.
     * @return the finished string with associated quotes removed.
     */
    private String removeStrings(String line) {
        String result = line;
        int firstQuote = result.indexOf("\"");
        String temp = null;
        while (firstQuote > 0) {
            int secondQuote = result.indexOf("\"", firstQuote + 1);
            temp = result.substring(firstQuote, secondQuote + 1);
            result = result.replace(temp, "");
            firstQuote = result.indexOf("\"");
        }
        return result;
    }
}



