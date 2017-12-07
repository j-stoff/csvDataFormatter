package csvData.Data;

/**
 * Data storage class for the CSVFormatter.
 */
public class CSVBookEntry {
    private String authorName;
    private double rating;
    private int numberOfRatings;
    private int ratingValue;
    private int consideredGood;

    /**
     * No argument constructor
     */
    public CSVBookEntry() {
    }

    /**
     * Convience constructor taking in the necessary fields.
     * @param givenRating the passed rating as a double.
     * @param givenNumberOfRatings the passed number of ratings as an int.
     */
    public CSVBookEntry(String author, double givenRating, int givenNumberOfRatings) {
        authorName = author;
        rating = givenRating;
        numberOfRatings = givenNumberOfRatings;
    }

    /**
     * The full constructor. Not used currently in this program.
     * @param givenRating rating of this item passed as a double.
     * @param givenNumberOfRatings number of ratings for this item as an int.
     * @param givenRatingValue the calculated value of this rating times median value.
     * @param givenConsideredGood 1 if the book is above the threshold, 0 if it not.
     */
    public CSVBookEntry(String author, double givenRating, int givenNumberOfRatings, int givenRatingValue, int givenConsideredGood) {
        authorName = author;
        rating = givenRating;
        numberOfRatings = givenNumberOfRatings;
        ratingValue = givenRatingValue;
        consideredGood = givenConsideredGood;
    }

    /**
     * Getter for the author's name
     * @return author name field.
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Setter for the author name.
     * @param authorName the new author name.
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * Getter for the rating field.
     * @return rating field.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Setter for the rating field.
     * @param rating the new rating value.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Getter for the number of ratings.
     * @return number of ratings field.
     */
    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    /**
     * Setter for the number of ratings.
     * @param numberOfRatings the new number of ratings.
     */
    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    /**
     * Getter for the rating value.
     * @return the rating value field.
     */
    public int getRatingValue() {
        return ratingValue;
    }

    /**
     * Setter for the rating value field.
     * @param ratingValue the new rating value.
     */
    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    /**
     * Getter for the considered good field.
     * @return 1 if the book is above threshold, 0 if it is not.
     */
    public int getConsideredGood() {
        return consideredGood;
    }

    /**
     * Setter for the considered good field.
     * @param consideredGood new considered good value. Must be 1 or 0 only, if not defaulted to 0.
     */
    public void setConsideredGood(int consideredGood) {
        if (consideredGood  != 1) {
            this.consideredGood = 0;
        }
        this.consideredGood = consideredGood;
    }

    /**
     * Override of the toString method
     * @return the fields as a string output.
     */
    @Override
    public String toString() {
        return "CSVBookEntry{" +
                "rating=" + rating +
                ", numberOfRatings=" + numberOfRatings +
                ", ratingValue=" + ratingValue +
                ", consideredGood=" + consideredGood +
                '}';
    }

    /**
     * Similar to the toString but in a CSV format not declaring the fields.
     * @return String in CSV format. (rating, numberOfRatings, ratingValue, consideredGood)
     */
    public String toCSVString() {
        return "\"" + authorName +"\"," + rating + "," + numberOfRatings + "," + ratingValue + "," + consideredGood;
    }
}
