import java.util.Arrays;
import java.util.List;

public class CompositeCouponStrategy implements CouponStrategy {

    private final List<CouponStrategy> strategies;

    public CompositeCouponStrategy(CouponStrategy... strategies) {
        this.strategies = Arrays.asList(strategies);
    }

    @Override
    public double applyDiscount(Customer customer, List<RentalComponent> rentals, double subtotal, int frequentRenterPoints) {
        double total = subtotal;
        for (CouponStrategy strategy : strategies) {
            total = strategy.applyDiscount(customer, rentals, total, frequentRenterPoints);
        }
        return total;
    }
}
