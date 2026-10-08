public class PartTimeEmployee extends Employee {
    double workingHours, hourlyRate;

    public PartTimeEmployee(String name, double workingHours, double hourlyRate) {
        super(name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalary() {
        return workingHours * hourlyRate;
    }

    public String getType() {
        return "Part-time";
    }
}
