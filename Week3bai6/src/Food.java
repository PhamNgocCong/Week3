import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Food extends Product {
    private LocalDate expiryDate;

    public Food(String name, double basePrice, LocalDate expiryDate) {
        super(name, basePrice);
        this.expiryDate = expiryDate;
    }

    public double getBasePrice() {
        LocalDate referenceDate = LocalDate.of(2025, 3, 1);
        long daysRemaining = ChronoUnit.DAYS.between(referenceDate, expiryDate);
        if (daysRemaining > 7) return basePrice;
        else if (daysRemaining > 0 && daysRemaining < 7) return basePrice * 0.8;
        else
        {
            System.out.println("San Pham Het Han");
            return 0;
        }


    }

    public String getProduct() {
        return "Food";
    }
}
