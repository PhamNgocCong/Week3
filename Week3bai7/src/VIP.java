public class VIP extends Order{
    public VIP(int SoNgay){
        super(SoNgay);
    }
    public double GiaTien(){
        return 2000000*SoNgay;
    }
}
