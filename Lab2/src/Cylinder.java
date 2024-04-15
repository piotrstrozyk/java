public class Cylinder {
    private double radius;
    private double height;
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getRadius() {
        return radius;
    }
    public double getHeight() {
        return height;
    }
    public Cylinder(double radius, double height) {
    this.radius = radius;
    this.height = height;
    }
    public Cylinder(){}
    public double baseArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    public double lateralArea(){
        return 2 * Math.PI * radius * height;
    }
    public double totalArea(){
        return 2 * baseArea() + lateralArea();
    }
    public double volume(){
        return baseArea() * height;
    }
}
