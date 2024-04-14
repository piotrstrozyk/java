package lab0;

//import java.time.LocalTime;
//import java.util.ArrayList;
//
//public class Kalendarz{
//    private ArrayList<Spotkanie>[] tydzien = new ArrayList[7];
//
//    public Kalendarz(){
//        this(7);
//    }
//
//    public Kalendarz(int dni){
//        for(int i = 0; i < dni; i++){
//            tydzien[i] = new ArrayList<Spotkanie>();
//        }
//    }
//
//    public void dodajSpotkanie(int dzien, String opis, LocalTime czasPoczatku, LocalTime czasKonca, String priorytet){
//        tydzien[dzien].add(new Spotkanie(opis, czasPoczatku, czasKonca, priorytet));
//    }
//
//    public void usunSpotkanie(int dzien, int index){
//        tydzien[dzien].remove(index);
//    }
//
//    public Spotkanie getSpotkanie(int dzien, int index) {
//        Spotkanie spotkanie = tydzien[dzien].get(index);
//        return spotkanie;
//    }
//
//    public ArrayList<Spotkanie> getSpotkaniaDniaTygodnia(int dzien){
//        return tydzien[dzien];
//    }
//
//    public ArrayList<Spotkanie> getSpotkaniaDniaTygodniaOPriorytecie(int dzien, String priorytet){
//        ArrayList<Spotkanie> spotkaniaOPriorytecie = new ArrayList<Spotkanie>();
//        for(int i=0; i<tydzien[dzien].size(); i++){
//            if(tydzien[dzien].get(i).getPriorytet().equals(Spotkanie.PriorytetVals.valueOf(priorytet))){
//                spotkaniaOPriorytecie.add(tydzien[dzien].get(i));
//            }
//        }
//        return spotkaniaOPriorytecie;
//    }
//}

//  Main
//import java.time.LocalTime;
//import java.util.Scanner;
//import java.util.ArrayList;
//
//public class Main {
//    public static void main(String[] args){
//        Scanner inputInt = new Scanner(System.in);
//        Scanner inputString = new Scanner(System.in);
//
//        Kalendarz mojKalendarz = new Kalendarz();
//
//        System.out.println("Program do zarządzania kalendrzem spotkań");
//        int wybor = 0;
//        do{
//            System.out.println("Co chcesz zrobić?  \n1-Dodaj spotkanie\n2-Usun spotkanie\n3-Wyswietl spotkania z wybranego dnia\n4-Wyswietl spotkania z wybranego dnia o wybranym priorytecie\n5-Wyjscie");
//            wybor = inputInt.nextInt();
//            switch (wybor){
//                case 1 ->   addMeeting(mojKalendarz, inputInt, inputString);
//                case 2 ->   removeMeeting(mojKalendarz, inputInt);
//                case 3 ->   showMeetings(mojKalendarz, inputInt);
//                case 4 ->   showMeetingsWithPriority(mojKalendarz, inputInt, inputString);
//            }
//        }while (wybor != 5);
//
//    }
//
//    public static void addMeeting(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
//        System.out.println("Podaj dzień tygodnia (0-6)");
//        int dzien = inputInt.nextInt();
//        System.out.println("Podaj opis spotkania");
//        String opis = inputString.nextLine();
//        System.out.println("Podaj godzine rozpoczecia");
//        String czasPoczatku = inputString.nextLine();
//        while (LocalTime.parse(czasPoczatku).compareTo(Spotkanie.MIN_CZAS) < 0){
//            System.out.println("Godzina niepoprawna, podaj jeszcze raz");
//            czasPoczatku = inputString.nextLine();
//        }
//        System.out.println("Podaj godzine zakonczenia");
//        String czasKonca = inputString.nextLine();
//        System.out.println("Podaj priorytet (niski, sredni, wysoki)");
//        String priorytet = inputString.nextLine();
//        mojKalendarz.dodajSpotkanie(dzien, opis, LocalTime.parse(czasPoczatku), LocalTime.parse(czasKonca), priorytet);
//    }
//
//    public static void removeMeeting(Kalendarz mojKalendarz, Scanner inputInt){
//        System.out.println("Podaj dzień tygodnia (0-6)");
//        int dzien = inputInt.nextInt();
//        System.out.println("Podaj indeks spotkania");
//        int index = inputInt.nextInt();
//        mojKalendarz.usunSpotkanie(dzien, index);
//    }
//
//    public static void showMeetingsWithPriority(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
//        System.out.println("Podaj dzień tygodnia (0-6)");
//        int dzien = inputInt.nextInt();
//        System.out.println("Podaj priorytet (wysoki, sredni, niski)");
//        String priorytet = inputString.nextLine();
//        printElems(mojKalendarz.getSpotkaniaDniaTygodniaOPriorytecie(dzien, priorytet));
//    }
//
//    public static void showMeetings(Kalendarz mojKalendarz, Scanner inputInt){
//        System.out.println("Podaj dzień tygodnia (0-6)");
//        int dzien = inputInt.nextInt();
//        printElems(mojKalendarz.getSpotkaniaDniaTygodnia(dzien));
//    }
//
//    public static void printElems(ArrayList<Spotkanie> elems){
//        for (Spotkanie spotkanie : elems){
//            System.out.println(spotkanie.wypisz());
//        }
//    }
//
//}

// Spotkanie
//import java.time.LocalTime;
//
//public class Spotkanie {
//
//    public static final LocalTime MIN_CZAS = LocalTime.of(8, 0);
//    private String opis;
//    private LocalTime czasPoczatku;
//    private LocalTime czasKonca;
//    private PriorytetVals priorytet;
//
//    public enum PriorytetVals {
//        niski, sredni, wysoki
//    }
//
//
//    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasKonca, String priorytet) {
//        this.opis = opis;
//        this.czasPoczatku = czasPoczatku;
//        this.czasKonca = czasKonca;
//        this.priorytet = PriorytetVals.valueOf(priorytet);
//    }
//
//    public String getOpis() {
//        return opis;
//    }
//
//    public LocalTime getCzasPoczatku() {
//        return czasPoczatku;
//    }
//
//    public LocalTime getCzasZakonczenia() {
//        return czasKonca;
//    }
//
//    public PriorytetVals getPriorytet(){
//        return this.priorytet;
//    }
//
//    public String wypisz(){
//        return ("\t" + this.opis + "\n\t" + this.czasPoczatku + "-" + this.czasKonca + "\n\tpriorytet: " + this.priorytet);
//    }
//}