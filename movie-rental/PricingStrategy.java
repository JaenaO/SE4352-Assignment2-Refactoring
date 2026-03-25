public interface PricingStrategy {

    int getPriceCode();

    double getCharge(int daysRented);
}
