import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Robot{
    private int id;
    private String modelName;
    private int batteryLevel;
    public Robot(int id,String modelName){
        this.id=id;
        this.modelName=modelName;
        this.batteryLevel = 100;
    }
    public String getModelName() {
        return modelName;
    }
    public int getId() {
        return id;
    }
    public void chargeBattery(){
        batteryLevel=100;
    }
    public final void showIdentity()
    {
        System.out.println(id+" "+modelName);
    }
    public abstract void performMainTask();
}

interface Flyable{
    void fly();
}

interface Swimmable{
    void swim();
}

interface GPS {
    void getCoordinates();
}
interface ElectronicDevice {
    void turnOn();
}
class DroneRobot extends Robot implements Flyable,GPS{
    public DroneRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    @Override
    public void fly() {
        System.out.println(getModelName() + " flying");
    }

    @Override
    public void getCoordinates() {
        System.out.println(getModelName() + " getting coordinates");
    }
}
class FishRobot extends Robot implements Swimmable{
    public FishRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    @Override
    public void swim() {
        System.out.println(getModelName() + " swimming");
    }
}
class AmphibiousRobot extends Robot implements Flyable,GPS,Swimmable{
    public AmphibiousRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    @Override
    public void fly() {
        System.out.println(getModelName() + " flying");
    }

    @Override
    public void swim() {
        System.out.println(getModelName() + " swimming");
    }

    @Override
    public void getCoordinates() {
        System.out.println(getModelName() + " getting coordinates");
    }
}
class abc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Robot> robotList = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            int id = Integer.parseInt(parts[1]);
            String modelName = parts[2];

            if (type.equals("DR")) {
                robotList.add(new DroneRobot(id, modelName));
            } else if (type.equals("FR")) {
                robotList.add(new FishRobot(id, modelName));
            } else if (type.equals("AR")) {
                robotList.add(new AmphibiousRobot(id, modelName));
            }
        }
        scanner.close();

        for (Robot r : robotList) {
            r.performMainTask();

            if (r instanceof Flyable) {
                ((Flyable) r).fly();
            }
            if (r instanceof Swimmable) {
                ((Swimmable) r).swim();
            }
            if (r instanceof GPS) {
                ((GPS) r).getCoordinates();
            }

            System.out.println();
        }

    }
}

