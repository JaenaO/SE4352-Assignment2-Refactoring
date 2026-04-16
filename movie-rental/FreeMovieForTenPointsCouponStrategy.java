import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FreeMovieForTenPointsCouponStrategy implements CouponStrategy {

    @Override
    public double applyDiscount(Customer customer, List<RentalComponent> rentals, double subtotal, int frequentRenterPoints) {
        int freeMovies = frequentRenterPoints / 10;
        if (freeMovies <= 0 || rentals.isEmpty()) {
            return subtotal;
        }

        List<Double> charges = new ArrayList<>();
        for (RentalComponent rental : rentals) {
            charges.add(rental.getCharge());
        }
        Collections.sort(charges);

        double discount = 0.0;
        int appliedFreeMovies = Math.min(freeMovies, charges.size());
        for (int i = 0; i < appliedFreeMovies; i++) {
            discount += charges.get(i);
        }

        return Math.max(0.0, subtotal - discount);
    }
}
