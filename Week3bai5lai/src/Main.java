import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            // F "Nguyễn Văn A" 1500 200 50
            String[] parts = line.split("\"");
            String type = parts[0].trim(), name = parts[1];
            String[] nums = parts[2].trim().split("\\s+");
            if (type.equals("F")) {
                double baseSalary = Double.parseDouble(nums[0]);
                double bonus = Double.parseDouble(nums[1]);
                double penalty = Double.parseDouble(nums[2]);
                employees[i] = new FullTimeEmployee(name, baseSalary, bonus, penalty);
            }
            else if (type.equalsIgnoreCase("P")) {
                double workingHours = Double.parseDouble(nums[0]);
                double hourlyRate = Double.parseDouble(nums[1]);
                employees[i] = new PartTimeEmployee(name, workingHours, hourlyRate);
            }
        }
        for (Employee emp : employees) {
            System.out.println(emp.getName() + " - " + emp.getType() + " - " + emp.calculateSalary());
        }
    }
}

