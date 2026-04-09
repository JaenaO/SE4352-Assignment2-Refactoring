public class OneDollarOffOverFiveDecorator extends RentalDecorator {

    public OneDollarOffOverFiveDecorator(RentalComponent wrappedRental) {
        super(wrappedRental);
    }

    public double getCharge() {
        double originalCharge = wrappedRental.getCharge();
        if (originalCharge > 5.0) {
            return Math.max(0.0, originalCharge - 1.0);
        }
        return originalCharge;
    }
}
