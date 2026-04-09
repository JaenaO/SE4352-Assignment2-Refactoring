public class HalfOffCouponDecorator extends RentalDecorator {

    public HalfOffCouponDecorator(RentalComponent wrappedRental) {
        super(wrappedRental);
    }

    public double getCharge() {
        return wrappedRental.getCharge() * 0.5;
    }
}
