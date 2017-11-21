package csvData.Formatter;

import csvData.Data.CSVBookEntry;

import java.util.Comparator;

/**
 * Comparator class used for sorting the list of CSV data.
 */
public class RatingListComparator implements Comparator<CSVBookEntry> {

    /**
     * No argument constructor.
     */
    public RatingListComparator() {
    }

    /**
     * Override of the compare function. Compares to CSVBookEntry classes based on their number of ratings.
     * @param book1 the first book entry
     * @param book2 the second book entry
     * @return positive if book2 has the greater number of ratings, negative if book1 has a greater amount, and 0
     * if they are equal.
     */
    @Override
    public int compare(CSVBookEntry book1, CSVBookEntry book2) {
        if (book1.getNumberOfRatings() > book2.getNumberOfRatings()) {
            return -1;
        }

        if (book1.getNumberOfRatings() < book2.getNumberOfRatings()) {
            return 1;
        }

        return 0;
    }
}
