public class Employee {
    String name;
    String NgaySinh;
    String MSNV;
    public String getName() {
        return name;
    }
    public Employee(){};
    public Employee(String name){
        this.name=name;
    }
    public double calculateSalary(){return 2;};
    public String getType(){return "2";};
}
