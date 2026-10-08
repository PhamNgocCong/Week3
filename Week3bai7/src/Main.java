import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        Scanner sc=new Scanner(System.in);
        String Line=sc.nextLine();
        String luu[] = Line.split("\\s+");
        int SoNgay=Integer.parseInt(luu[1].trim());
     if(luu[0].equals("S")) {
        order= new Standard(SoNgay);
        System.out.println(order.GiaTien());

     }
     else if(luu[0].equals("V")) {
         order= new VIP(SoNgay);
         System.out.println(order.GiaTien());

     }
    }
}
