import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OfferList list = new OfferList();
        testingHouse(list);
        testingApart(list);
        System.out.println("Program handles offers of sales of houses and apartments");
        int m = 1;
        while (m != 0) {
            System.out.println("""
                    Choose:\s
                    0-Exit
                    1-Add new house offer
                    2-Add new apartment offer
                    3-Display all active house offers
                    4-Display all active apartment offers
                    5-Display all active house offers in given city of area greater than given
                    6-Display all active apartment offers in given city, of price less than given and on given floor up
                    """);
            m = sc.nextInt();
            switch (m) {
                case 0 -> System.out.println("Finished");
                case 1 -> addHouse(list, sc);
                case 2 -> addApart(list, sc);
                case 3 -> displayHouses(list);
                case 4 -> displayAparts(list);
                case 5 -> displayHousesInCityOfArea(list, sc);
                case 6 -> displayApartsInCityOfPriceOnFloor(list, sc);
                default -> System.out.println("Incorrect input");
            }
        }
    }
    public static void addHouse(OfferList list, Scanner sc) {
        System.out.println("Enter street name: ");
        String street = sc.next();
        System.out.println("Enter house number: ");
        int houseNr = sc.nextInt();
        System.out.println("Enter city: ");
        String city = sc.next();
        System.out.println("Enter post code: ");
        String postCode = sc.next();
        System.out.println("Enter area: ");
        double area = sc.nextDouble();
        System.out.println("Enter price: ");
        double price = sc.nextDouble();
        System.out.println("Enter offer date: ");
        String date = sc.next();
        System.out.println("Enter plot area: ");
        int plotArea = sc.nextInt();
        list.addEstate(new House(street, houseNr, city, postCode, area, price, LocalDate.parse(date), plotArea));
    }
    public static void addApart(OfferList list, Scanner sc) {
        System.out.println("Enter street name: ");
        String street = sc.next();
        System.out.println("Enter house number: ");
        int houseNr = sc.nextInt();
        System.out.println("Enter city: ");
        String city = sc.next();
        System.out.println("Enter post code: ");
        String postCode = sc.next();
        System.out.println("Enter area: ");
        double area = sc.nextDouble();
        System.out.println("Enter price: ");
        double price = sc.nextDouble();
        System.out.println("Enter offer date: ");
        String date = sc.next();
        System.out.println("Enter floor: ");
        int floor = sc.nextInt();
        System.out.println("Enter apartment number: ");
        int apartmentNr = sc.nextInt();
        list.addEstate(new Apartment(street, houseNr, city, postCode, area, price, LocalDate.parse(date), floor, apartmentNr));
    }
    public static void displayHouses(OfferList list) {
        LocalDate currentDate = LocalDate.now();
        ArrayList<Estate> list1 = list.getOfferList(estate -> estate instanceof House && !estate.getOfferDate().isBefore(currentDate));
        for (Estate estate : list1) {
            System.out.println(estate);
        }
    }
    public static void displayAparts(OfferList list) {
        LocalDate currentDate = LocalDate.now();
        ArrayList<Estate> list1 = list.getOfferList(estate -> estate instanceof Apartment && !estate.getOfferDate().isBefore(currentDate));
        for (Estate estate : list1) {
            System.out.println(estate);
        }
    }
    public static void displayHousesInCityOfArea(OfferList list, Scanner sc) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Enter city: ");
        String city = sc.next();
        System.out.println("Enter area: ");
        double area = sc.nextDouble();
        ArrayList<Estate> list1 = list.getOfferList(estate -> estate instanceof House && !estate.getOfferDate().isBefore(currentDate) && estate.getCity().equals(city) && estate.getArea() >= area);
        for (Estate estate : list1) {
            System.out.println(estate);
        }
    }
    public static void displayApartsInCityOfPriceOnFloor(OfferList list, Scanner sc) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Enter city: ");
        String city = sc.next();
        System.out.println("Enter price: ");
        double price = sc.nextDouble();
        System.out.println("Enter floor: ");
        int floor = sc.nextInt();
        ArrayList<Estate> list1 = list.getOfferList(estate -> estate instanceof Apartment && !estate.getOfferDate().isBefore(currentDate) && estate.getCity().equals(city) && estate.getPrice() <= price && ((Apartment) estate).getFloor() >= floor);
        for (Estate estate : list1) {
            System.out.println(estate);
        }
    }
    public static void testingHouse(OfferList list) {
        list.addEstate(new House("Toruńska", 1, "Bielsko-Biała", "43-310", 324.0, 3000000.0, LocalDate.of(2021, 10, 10), 500));
        list.addEstate(new House("Piłsudskiego", 2, "Białystok", "15-032", 30.0, 6000000.0, LocalDate.of(2026, 10, 10), 100));
        list.addEstate(new House("Morgowska", 3, "Gliwice", "44-105", 345.0, 2000000.0, LocalDate.of(2024, 10, 10), 50));
        list.addEstate(new House("Czerniakowska", 4, "Kielce", "25-212", 100.0, 3000000.0, LocalDate.of(2020, 10, 10), 120));
        list.addEstate(new House("Kwiatowa", 5, "Szczecin", "70-390", 145.0, 9000000.0, LocalDate.of(2029, 10, 10), 400));
        list.addEstate(new House("Kwiatowa", 6, "Szczecin", "70-390", 300.0, 5000000.0, LocalDate.of(2029, 10, 10), 100));
        list.addEstate(new House("Kwiatowa", 7, "Szczecin", "70-390", 145.0, 6000000.0, LocalDate.of(2029, 10, 10), 350));
        list.addEstate(new House("Kwiatowa", 8, "Szczecin", "70-390", 200.0, 8000000.0, LocalDate.of(2029, 10, 10), 240));
        list.addEstate(new House("Kwiatowa", 9, "Szczecin", "70-390", 145.0, 3000000.0, LocalDate.of(2029, 10, 10), 460));
    }
    public static void testingApart(OfferList list) {
        list.addEstate(new Apartment("Kwiatowa", 1, "Białystok", "01-001", 100.0, 1000000.0, LocalDate.of(2025, 10, 10), 1, 1));
        list.addEstate(new Apartment("Kwiatowa", 2, "Warsaw", "01-001", 100.0, 6000000.0, LocalDate.of(2027, 10, 10), 6, 1));
        list.addEstate(new Apartment("Kwiatowa", 3, "Warsaw", "01-001", 100.0, 6000000.0, LocalDate.of(2028, 10, 10), 5, 2));
        list.addEstate(new Apartment("Kwiatowa", 4, "Warsaw", "01-001", 100.0, 4000000.0, LocalDate.of(2022, 10, 10), 4, 5));
        list.addEstate(new Apartment("Kwiatowa", 5, "Warsaw", "01-001", 100.0, 5000000.0, LocalDate.of(2020, 10, 10), 3, 6));
        list.addEstate(new Apartment("Kwiatowa", 6, "Warsaw", "01-001", 100.0, 6000000.0, LocalDate.of(2026, 10, 10), 2, 3));
        list.addEstate(new Apartment("Kwiatowa", 7, "Warsaw", "01-001", 100.0, 3000000.0, LocalDate.of(2026, 10, 10), 8, 6));
        list.addEstate(new Apartment("Kwiatowa", 8, "Warsaw", "01-001", 100.0, 4000000.0, LocalDate.of(2026, 10, 10), 7, 2));
        list.addEstate(new Apartment("Kwiatowa", 9, "Warsaw", "01-001", 100.0, 5000000.0, LocalDate.of(2026, 10, 10), 9, 21));
    }
}