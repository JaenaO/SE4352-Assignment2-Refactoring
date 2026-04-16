import java.util.List;

public class FiveOffFiveOrMoreRentalsCouponStrategy implements CouponStrategy {

    @Override
    public double applyDiscount(Customer customer, List<RentalComponent> rentals, double subtotal, int frequentRenterPoints) {
        if (rentals.size() >= 5) {
            return Math.max(0.0, subtotal - 5.0);
        }
        return subtotal;
    }
}
