public class StandardFrequentRenterPoints implements FrequentRenterPointsStrategy {

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
