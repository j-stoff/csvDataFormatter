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
                outList.add(addValuesToList(list.get(index)));
            }
        }

        //formatLine(list.get(0));
        int median = calculateMedianRatings(outList);

        System.out.println(median);
    }

    public void formatLine(String line) {
        if (line == null || line.isEmpty()) {
            // Bad data, skip this one.
            return;
        }
        String formattedLine = removeStrings(line);
        //System.out.println(formattedLine);
        String[] data = formattedLine.split(",");
        //System.out.println("Fields: " + data[3] + "  " + data[4]);

    }

    public String addValuesToList(String line) {
        String formattedLine = removeStrings(line);
        String[] data = formattedLine.split(",");

        return data[3] + ","  +data[4];
    }

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
