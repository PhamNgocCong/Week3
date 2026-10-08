public class FullTimeEmployee extends Employee{
    double baseSalary,bonus,penalty;
    public FullTimeEmployee(String name, double baseSalary, double bonus, double penalty) {
        super(name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }
    public double calculateSalary() {
        return baseSalary + bonus - penalty;
    }
    public String getType() {
        return "Full-time";
    }
}
