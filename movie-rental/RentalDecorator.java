public abstract class RentalDecorator implements RentalComponent {

    protected final RentalComponent wrappedRental;

    protected RentalDecorator(RentalComponent wrappedRental) {
        this.wrappedRental = wrappedRental;
    }

    public Movie getMovie() {
        return wrappedRental.getMovie();
    }

    public int getDaysRented() {
        return wrappedRental.getDaysRented();
    }

    public double getCharge() {
        return wrappedRental.getCharge();
    }

    public int getFrequentRenterPoints() {
        return wrappedRental.getFrequentRenterPoints();
    }
}
