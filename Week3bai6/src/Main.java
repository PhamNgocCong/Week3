import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    int n=Integer.parseInt(sc.nextLine().trim());
    Product[] products= new Product[n];
    double Total=0;
    for(int i=0;i<n;i++) {
        String line=sc.nextLine().trim();
//E "Laptop" 1000 50
//F "Milk" 30 2025-03-15
//F "Bread" 20 2025-03-05
       String[] parts=line.split("\"");
       String type = parts[0].trim(),name = parts[1];
       if(type.equals("E")) {
           String[] phu =  parts[2].trim().split("\\s+");
           double basePrice=Double.parseDouble(phu[0]),
                warrantyFee= Double.parseDouble(phu[1]);
           products[i]=new Electronics(name,basePrice,warrantyFee);
           System.out.println(products[i].getName() + " - " + products[i].getProduct() + " - "+ products[i].getBasePrice());
       }
       if(type.equals("F")) {
           String[] phu =  parts[2].trim().split("\\s+");
           double basePrice=Double.parseDouble(phu[0]);
           String phuphu[]=phu[1].trim().split("-");
           int year=Integer.parseInt(phuphu[0]),month=Integer.parseInt(phuphu[1]),day=Integer.parseInt(phuphu[2]);
           LocalDate expiryDate=LocalDate.of(year,month,day);
           products[i]=new Food(name,basePrice,expiryDate);
           System.out.println(products[i].getName() + " - " + products[i].getProduct() + " - " +products[i].getBasePrice());



       }
    Total+=products[i].getBasePrice();
    }
    System.out.println("Total = "+Total);
    }
}
