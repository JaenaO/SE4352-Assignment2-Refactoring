public class NewReleaseFrequentRenterPoints implements FrequentRenterPointsStrategy {

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
