import java.util.ArrayList;
import java.util.function.Predicate;

public class OfferList {
    private final ArrayList<Estate> offerList;

    public OfferList() {
        offerList = new ArrayList<Estate>();
    }

    public void addEstate(House house) {
        offerList.add(house);
    }

    public void addEstate(Apartment apartment) {
        offerList.add(apartment);
    }

    public ArrayList<Estate> getOfferList(Predicate<Estate> condition) {
        ArrayList<Estate> list = new ArrayList<Estate>();
        for (Estate estate : offerList) {
            if (condition.test(estate)) {
                list.add(estate);
            }
        }
        return list;
    }
}