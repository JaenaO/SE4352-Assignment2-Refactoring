import java.util.Enumeration;
import java.util.Vector;

// create new class #1
public class Statement {
  private Customer _customer;
  private Vector   _rentals;

    public Statement(Customer customer) {
        _customer = customer;
        _rentals  = customer._rentals;
    }

    // moving method #1 from Customer to Statement
    // renaming operations #1
    public String createStatement() {
        double      totalAmount          = 0;
        int         frequentRenterPoints = 0;
        Enumeration rentals              = _rentals.elements();
        String      result               = "Rental Record for " + _customer.getName() + "\n";
        
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each       = (Rental) rentals.nextElement();
            
            // method extraction #1 
            thisAmount = determineAmount(each);
            
            // add frequent renter points
            frequentRenterPoints++;
            
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                (each.getDaysRented() > 1)) {
                    frequentRenterPoints++;
            }
            
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() +
                        "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                    " frequent renter points";
        return result;
    }

    // moving method operations #1
    // determine amounts for each line
    private double determineAmount(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2) {
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3) {
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }
}