import java.util.List;

public class TenPointsForTenDollarRentalCouponStrategy implements CouponPointsStrategy {

    @Override
    public int extraPoints(Customer customer, List<RentalComponent> rentals, double subtotal) {
        int points = 0;
        for (RentalComponent rental : rentals) {
            if (rental.getCharge() >= 10.0) {
                points += 10;
            }
        }
        return points;
    }
}
