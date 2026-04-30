import java.util.List;

public class TwentyPointsForFourOrMoreRentalsCouponStrategy implements CouponPointsStrategy {

    @Override
    public int extraPoints(Customer customer, List<RentalComponent> rentals, double subtotal) {
        if (rentals.size() >= 4) {
            return 20;
        }
        return 0;
    }
}
