public class Electronics extends Product{
   private double warrantyFee;

   public Electronics(String name,double basePrice,double warrantyFee)
   {
       super(name,basePrice);
       this.warrantyFee=warrantyFee;
   }
   public double getBasePrice(){
       return basePrice*1.1+warrantyFee;
   }
   public String getProduct(){
       return "Electronics";
   }
}
