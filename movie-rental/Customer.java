import java.util.ArrayList;
import java.util.List;
public class Customer {

    private String                 name;
    private List<RentalComponent>  rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(RentalComponent rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public List<RentalComponent> getRentals() {
        return rentals;
    }
}