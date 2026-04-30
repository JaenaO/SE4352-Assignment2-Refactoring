import java.util.List;

public interface CouponPointsStrategy {
    int extraPoints(Customer customer, List<RentalComponent> rentals, double subtotal);
}
