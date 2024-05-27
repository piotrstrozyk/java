import java.time.LocalDate;

public final class House extends Estate {

    private double plotArea;

    public House(String street, int houseNr, String city, String postCode, double area, double price, LocalDate offerDate, int plotArea) {
        super(street, houseNr, city, postCode, area, price, offerDate);
        this.plotArea = plotArea;
    }

    public double getPlotArea() {
        return plotArea;
    }

    @Override
    public String toString(){
        return (
                "  House: " + '"' + street + '"' +
                        "  House Number: " + houseNr +
                        "  City: " + city +
                        "  Post Code: " + postCode +
                        "  Area: " + area +
                        "  Price: " + price +
                        "  Offer Date: " + offerDate +
                        "  Plot Area: " + plotArea
        );
    }
}
