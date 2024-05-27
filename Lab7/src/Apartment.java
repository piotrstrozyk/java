
import java.time.LocalDate;

public final class Apartment extends Estate {
    private int apartmentNr;
    private int floor;
    public Apartment(String street, int houseNr, String city, String postCode, double area, double price, LocalDate offerDate, int floor, int apartmentNr) {
        super(street, houseNr, city, postCode, area, price, offerDate);
        this.floor = floor;
        this.apartmentNr = apartmentNr;
    }
    public int getFloor() {
        return floor;
    }
    @Override
    public String toString(){
        return (
                "  apartment: " + '"' + street + '"' +
                        "  House Number: " + houseNr +
                        "  Apartment Number: " + apartmentNr +
                        "  Floor: " + floor +
                        "  City: " + city +
                        "  Post Code: " + postCode +
                        "  Area: " + area +
                        "  Price: " + price + " PLN" +
                        "  Offer Date: " + offerDate
        );
    }
}
