import java.util.List;

public interface CouponStrategy {
    double applyDiscount(Customer customer, List<RentalComponent> rentals, double subtotal, int frequentRenterPoints);
}
