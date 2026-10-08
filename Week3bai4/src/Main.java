public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        if (a instanceof Cat) {
            Cat c = (Cat) a;
            System.out.println("Ép kiểu thành công!");
        } else {
            System.out.println("Đây không phải là Mèo!");
        }
    }
}
