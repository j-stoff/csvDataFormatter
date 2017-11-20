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
    private RatingListComparator comparator;

    public CSVFormatter() {
        comparator = new RatingListComparator();
    }

    public void formatList(List<String> list) {
        int index;
        ArrayList<String> outList = new ArrayList<String>();

        for (index = 0; index < list.size(); index++) {
            if (list.get(index) != null && !list.get(index).isEmpty()) {
                outList.add(formatLine(list.get(index)));
            }
        }

        //formatLine(list.get(0));
        //int median = calculateMedianRatings(outList);

        //System.out.println(median);
    }

    public String formatLine(String line) {
        String formattedLine = removeStrings(line);
        String[] data = formattedLine.split(",");
        //System.out.println("Fields: " + data[3] + "  " + data[4]);
        return data[3] + "," + data[4];
    }

    public CSVBookEntry makeBookEntry(String data) {
        double ratingValue = parseStringForDouble(data, 0);
        int numberOfRatings = parseStringForInt(data, 1);
        return new CSVBookEntry(ratingValue, numberOfRatings);
    }

    /*
    public String addValuesToList(String line) {
        String formattedLine = removeStrings(line);
        String[] data = formattedLine.split(",");

        return data[3] + ","  +data[4];
    }
    */

    /*
    public int calculateMedianRatings(List<String> ratings) {
        int numberOfItems = 0;
        int total = 0;

        for (String value:
             ratings) {
            numberOfItems += 1;
            String[] data = value.split(",");
            total += Integer.parseInt(data[1]);
        }

        return total / numberOfItems;

    }
    */

    public void sortList(List<CSVBookEntry> ratings) {
        /*
        List<CSVBookEntry> output = new ArrayList<CSVBookEntry>();
        String[] split = null;
        int currentIndex;
        int currentBookValue;

        // Seed value
        output.add(new CSVBookEntry(0,0));

        for (CSVBookEntry book :
                ratings) {
            currentIndex = 0;
            currentBookValue = book.getNumberOfRatings();
            for (CSVBookEntry outBook :
                    output) {
                if (currentBookValue <= outBook.getNumberOfRatings()) {
                    currentIndex += 1;
                } else  {
                    output.add(currentIndex, book);
                }
            }
            /*
            value = parseStringForInt(data, 1);
            currentIndex = 0;

            for (String entry :
                    output) {
                if (currentIndex == output.size()) {
                    output.add(currentIndex, data);
                    break;
                }

                int outputListValue = parseStringForInt(output.get(currentIndex), 1);

                if (value <= outputListValue) {
                    currentIndex += 1;
                } else {
                    output.add(currentIndex, data);
                    break;
                }

            }


        }

        // Remove seed value, is the last value always.
        int size = output.size();
        output.remove(size - 1);

        return output;
        */
        //List.sort(ratings, comparator);
        ratings.sort(comparator);
    }

    public int parseStringForInt(String input, int indexPosition) {
        String[] split = input.split(",");
        if (split[1].contains(".")) {
            return 0;
        }
        return Integer.parseInt(split[indexPosition]);
    }

    public double parseStringForDouble(String input, int indexPosition) {
        String[] split = input.split(",");
        if (split[1].contains(".")) {
            return 0;
        }
        return Double.parseDouble(split[indexPosition]);
    }

    public void addCalculatedColumn(List<CSVBookEntry> ratingList, int startPosition, int endPosition) {
        // use list.size() to get the max size and loop through calling the method to calculate the average
        // Then add the average to those columns
        /*
        int realEndPosition;

        if (endPosition > ratingList.size()) {
            realEndPosition = ratingList.size() - 1;
        } else {
            realEndPosition = endPosition;
        }

        int medianIndex = (startPosition + realEndPosition) / 2;
        String medianEntry = ratingList.get(medianIndex);
        String[] medianSplit = medianEntry.split(",");
        int medianValue = Integer.parseInt(medianSplit[1]);

        // Update values from the start position to have as 3rd partion to the string
        */
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



