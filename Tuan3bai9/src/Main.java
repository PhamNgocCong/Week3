import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
interface IPayable {
    double getPaymentAmount();
}
abstract class Staff implements IPayable {
    private String id;
    private String name;

    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class PartTimeStaff extends Staff {
    private int workingHours;
    private double hourlyRate;

    public PartTimeStaff(String id, String name, int workingHours, double hourlyRate) {
        super(id, name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getPaymentAmount() {
        return workingHours * hourlyRate;
    }
}
class Invoice implements IPayable {
    private String itemName;
    private int quantity;
    private double pricePerItem;

    public Invoice(String itemName, int quantity, double pricePerItem) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }
}
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();
        List<IPayable> payableList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            char type = parts[0].charAt(0);

            if (type == 'S') {
                String id = parts[1];
                String name = parts[2];
                int workingHours = Integer.parseInt(parts[3]);
                double hourlyRate = Double.parseDouble(parts[4]);

                payableList.add(new PartTimeStaff(id, name, workingHours, hourlyRate));
            } else if (type == 'I') {
                String itemName = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                double pricePerItem = Double.parseDouble(parts[3]);

                payableList.add(new Invoice(itemName, quantity, pricePerItem));
            }
        }
        scanner.close();

        double totalPayment = 0;

        for (IPayable item : payableList) {
            double amount = item.getPaymentAmount();
            totalPayment += amount;
            if (item instanceof PartTimeStaff) {
                PartTimeStaff staff = (PartTimeStaff) item;
                System.out.println("PartTimeStaff " + staff.getName() + " - Payment: " + amount);
            } else if (item instanceof Invoice) {
                Invoice inv = (Invoice) item;
                System.out.println("Invoice " + inv.getItemName() + " - Payment: " + amount);
            }
        }

        System.out.println("Total Payment = " + totalPayment);
    }
}
