public class Movie {

    public static final int CHILDRENS   = 2;
    public static final int REGULAR     = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private PricingStrategy              pricingStrategy;
    private FrequentRenterPointsStrategy frequentRenterPointsStrategy;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return pricingStrategy.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                pricingStrategy = new RegularPricingStrategy();
                frequentRenterPointsStrategy = new StandardFrequentRenterPoints();
                break;
            case NEW_RELEASE:
                pricingStrategy = new NewReleasePricingStrategy();
                frequentRenterPointsStrategy = new NewReleaseFrequentRenterPoints();
                break;
            case CHILDRENS:
                pricingStrategy = new ChildrensPricingStrategy();
                frequentRenterPointsStrategy = new StandardFrequentRenterPoints();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code: " + priceCode);
        }
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return pricingStrategy.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return frequentRenterPointsStrategy.getFrequentRenterPoints(daysRented);
    }
}
