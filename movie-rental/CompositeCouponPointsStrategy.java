import java.util.Arrays;
import java.util.List;

public class CompositeCouponPointsStrategy implements CouponPointsStrategy {

    private final List<CouponPointsStrategy> strategies;

    public CompositeCouponPointsStrategy(CouponPointsStrategy... strategies) {
        this.strategies = Arrays.asList(strategies);
    }

    @Override
    public int extraPoints(Customer customer, List<RentalComponent> rentals, double subtotal) {
        int points = 0;
        for (CouponPointsStrategy strategy : strategies) {
            points += strategy.extraPoints(customer, rentals, subtotal);
        }
        return points;
    }
}
