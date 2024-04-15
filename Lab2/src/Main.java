import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Cylinder walec = new Cylinder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Program calculates the characteristics of a cylinder with given parameters");
        int m = 1;
        while (m != 0) {
            System.out.println("Choose: 0-Exit   1-Display current parameters   2-Set new parameters   " +
                                "3-Calculate areas   4-Calculate volume");
            m = sc.nextInt();
            switch(m){
                case 0 -> System.out.println("Finished");
                case 1 -> displayParams(walec);
                case 2 -> setParams(walec, sc);
                case 3 -> calcArea(walec);
                case 4 -> calcVolume(walec);
            }
        }
    }
    public static void displayParams(Cylinder cylinder) {
        double height = cylinder.getHeight();
        double radius = cylinder.getRadius();
        System.out.println("Height: " + height + "\n" + "Radius: " + radius);
    }
    public static void setParams(Cylinder cylinder, Scanner sc) {
        System.out.println("Enter height: ");
        double height = sc.nextDouble();
        System.out.println("Enter radius: ");
        double radius = sc.nextDouble();
        cylinder.setHeight(height);
        cylinder.setRadius(radius);
        System.out.println("Parameters updated successfully");
    }
    public static void calcArea(Cylinder cylinder){
        double base = cylinder.baseArea();
        double lateral = cylinder.lateralArea();
        double total = cylinder.totalArea();
        System.out.println("Lateral Area: " + lateral + "\n" + "Base Area: " + base + "\n" + "Total Area: " + total);
    }
    public static void calcVolume(Cylinder cylinder){
        double volume = cylinder.volume();
        System.out.println("Volume: " + volume);
    }
}
