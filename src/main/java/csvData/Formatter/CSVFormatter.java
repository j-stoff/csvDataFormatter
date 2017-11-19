package csvData.Formatter;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the critical class that will format the data passed to in to
 * the desired output.
 */
public class CSVFormatter {

    public CSVFormatter() {
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

    public List<String> sortList(List<String> ratings) {
        List<String> output = new ArrayList<String>();
        String[] split = null;
        int currentIndex;
        int value;

        // Seed value
        output.add("0,0");

        for (String data :
                ratings) {
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
    }

    public int parseStringForInt(String input, int indexPosition) {
        String[] split = input.split(",");
        if (split[1].contains(".")) {
            return 0;
        }
        return Integer.parseInt(split[indexPosition]);
    }

    public void addCalculatedColumn(List<String> ratingList) {
        // Some for loop that takes in the list, a start position, and end position, calls
        // get(position) and finds the average from start to ending positions.

        // use list.size() to get the max size and loop through calling the method to calculate the average
        // Then add the average to those columns

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
