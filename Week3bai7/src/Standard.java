public class Standard extends Order{
    public Standard(int SoNgay){
        super(SoNgay);
    }
    public double GiaTien(){
        if(SoNgay<=3) return 500000*SoNgay;
        else return 500000*SoNgay*0.95;
    }
}
