import java.time.LocalDate;

public abstract sealed class Estate permits Apartment, House{
    protected String street;
    protected int houseNr;
    protected String city;
    protected String postCode;
    protected double area;
    protected double price;
    protected LocalDate offerDate;
    public Estate (String street, int houseNr, String city, String postCode, double area, double price, LocalDate offerDate) {
        this.street = street;
        this.houseNr = houseNr;
        this.city = city;
        this.postCode = postCode;
        this.area = area;
        this.price = price;
        this.offerDate = offerDate;
    }
    public String getCity() {
        return city;
    }
    public double getArea() {
        return area;
    }
    public double getPrice() {
        return price;
    }
    public LocalDate getOfferDate() {
        return offerDate;
    }
}