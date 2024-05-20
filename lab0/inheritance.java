// //calendar.java
// import java.lang.reflect.Array;
// import java.time.LocalTime;
// import java.util.ArrayList;
// import java.util.function.Predicate;

// public class Kalendarz{
//     private ArrayList<Spotkanie>[] tydzien = new ArrayList[7];

//     public Kalendarz(){
//         this(7);
//     }

//     public Kalendarz(int dni){
//         for(int i = 0; i < dni; i++){
//             tydzien[i] = new ArrayList<Spotkanie>();
//         }
//     }

//     public void dodajSpotkanie(int dzien, String opis, LocalTime czasPoczatku, LocalTime czasKonca, String priorytet){
//         tydzien[dzien].add(new Spotkanie(opis, czasPoczatku, czasKonca, priorytet));
//     }

//     public void usunSpotkanie(int dzien, int index){
//         tydzien[dzien].remove(index);
//     }

//     public Spotkanie getSpotkanie(int dzien, int index) {
//         Spotkanie spotkanie = tydzien[dzien].get(index);
//         return spotkanie;
//     }

//     public ArrayList<Spotkanie> getSpotkaniaDniaTygodnia(int dzien){
//         return tydzien[dzien];
//     }

//     public ArrayList<Spotkanie> getSpotkaniaDniaTygodniaOPriorytecie(int dzien, String priorytet){
//         ArrayList<Spotkanie> spotkania = tydzien[dzien];
//         for (Spotkanie spotkanie : tydzien[dzien]){
//             if (spotkanie.getPriorytet().equals(Spotkanie.PriorytetVals.valueOf(priorytet))){
//                 spotkania.add(spotkanie);
//             }
//         }
//         return spotkania;
//     }

//     // public Predicate<Spotkanie> getOdPodanejGodziny(LocalTime czas){
//     //     return s -> s.getCzasPoczatku().compareTo(czas) >= 0;
//     // }

//     // public Predicate<Spotkanie> getDoPodanejGodziny(LocalTime czas){
//     //     return s -> s.getCzasZakonczenia().compareTo(czas) <= 0;
//     // }

//     // public Predicate<Spotkanie> getOPriorytecie(String priorytet){
//     //     return s -> s.getPriorytet().equals(Spotkanie.PriorytetVals.valueOf(priorytet));
//     // }
    
//     public ArrayList<Spotkanie> getDzien(int dzien, Predicate<Spotkanie> warunek){
//         ArrayList<Spotkanie> spotkania = new ArrayList<>();
//         for (Spotkanie spotkanie : tydzien[dzien]){
//             if (warunek.test(spotkanie)){
//                 spotkania.add(spotkanie);
//             }
//         }
//         return spotkania;
//     }
// }


//##################################################################################################
//Main.java
// import java.time.LocalTime;
// import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.function.Predicate;

// public class Main {
//     public static void main(String[] args){
//         Scanner inputInt = new Scanner(System.in);
//         Scanner inputString = new Scanner(System.in);

//         Kalendarz mojKalendarz = new Kalendarz();

//         System.out.println("Program do zarządzania kalendrzem spotkań");
//         int wybor = 0;
//         do{
//             System.out.println("Co chcesz zrobić?  \n1-Dodaj spotkanie\n2-Usun spotkanie\n3-Wyswietl spotkania z wybranego dnia\n4-Wyswietl spotkania z wybranego dnia o wybranym priorytecie\n5-Wyświetl spotkania w wybranym dniu od podanego czasu\n6-Wyświetl spotkania w wybranym dniu w przedziale czasowym\n7-Wyświetl spotkania w wybranym dniu o wybranym priorytecie i od podanego czasu\n8-Wyjscie");
//             wybor = inputInt.nextInt();
//             switch (wybor){
//                 case 1 ->   addMeeting(mojKalendarz, inputInt, inputString);
//                 case 2 ->   removeMeeting(mojKalendarz, inputInt);
//                 case 3 ->   showMeetings(mojKalendarz, inputInt);
//                 case 4 ->   showMeetingsWithPriority(mojKalendarz, inputInt, inputString);
//                 case 5 ->   showMeetingsFrom(mojKalendarz, inputInt, inputString);
//                 case 6 ->   showMeetingsFromTo(mojKalendarz, inputInt, inputString);
//                 case 7 ->   showMeetingsFromWithPriority(mojKalendarz, inputInt, inputString);
//             }
//         }while (wybor != 8);

//     }

//     public static void addMeeting(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
//         System.out.println("Podaj dzień tygodnia (0-6)");
//         int dzien = inputInt.nextInt();
//         System.out.println("Podaj opis spotkania");
//         String opis = inputString.nextLine();
//         System.out.println("Podaj godzine rozpoczecia");
//         String czasPoczatku = inputString.nextLine();
//         while (LocalTime.parse(czasPoczatku).compareTo(Spotkanie.MIN_CZAS) < 0){
//             System.out.println("Godzina niepoprawna, podaj jeszcze raz");
//             czasPoczatku = inputString.nextLine();
//         }
//         System.out.println("Podaj godzine zakonczenia");
//         String czasKonca = inputString.nextLine();
//         System.out.println("Podaj priorytet (niski, sredni, wysoki)");
//         String priorytet = inputString.nextLine();
//         mojKalendarz.dodajSpotkanie(dzien, opis, LocalTime.parse(czasPoczatku), LocalTime.parse(czasKonca), priorytet);
//     }

//     public static void removeMeeting(Kalendarz mojKalendarz, Scanner inputInt){
//         System.out.println("Podaj dzień tygodnia (0-6)");
//         int dzien = inputInt.nextInt();
//         System.out.println("Podaj indeks spotkania");
//         int index = inputInt.nextInt();
//         mojKalendarz.usunSpotkanie(dzien, index);
//     }

//     // public static void showMeetingsWithPriority(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
//     //     System.out.println("Podaj dzień tygodnia (0-6)");
//     //     int dzien = inputInt.nextInt();
//     //     System.out.println("Podaj priorytet (wysoki, sredni, niski)");
//     //     String priorytet = inputString.nextLine();
//     //     printElems(mojKalendarz.getSpotkaniaDniaTygodniaOPriorytecie(dzien, priorytet));
//     // }

//     public static void showMeetings(Kalendarz mojKalendarz, Scanner inputInt){
//         System.out.println("Podaj dzień tygodnia (0-6)");
//         int dzien = inputInt.nextInt();
//         printElems(mojKalendarz.getSpotkaniaDniaTygodnia(dzien));
//     }

//     public static void showMeetingsWithPriority(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
//         System.out.println("Podaj dzień tygodnia (0-6)");
//         int dzien = inputInt.nextInt();
//         System.out.println("Podaj priorytet (wysoki, sredni, niski)");
//         String priorytet = inputString.nextLine();
//         // printElems(mojKalendarz.getDzien(dzien, mojKalendarz.getOPriorytecie(priorytet)));
//         printElems(mojKalendarz.getDzien(dzien, s -> s.getPriorytet().equals(Spotkanie.PriorytetVals.valueOf(priorytet))));
//     }

//     public static void showMeetingsFrom(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
//         System.out.println("Podaj dzień tygodnia (0-6)");
//         int dzien = inputInt.nextInt();
//         System.out.println("Podaj godzine rozpoczecia");
//         String czasPoczatku = inputString.nextLine();
//         // printElems(mojKalendarz.getDzien(dzien, mojKalendarz.getOdPodanejGodziny(LocalTime.parse(czasPoczatku))));
//         printElems(mojKalendarz.getDzien(dzien, s -> s.getCzasPoczatku().compareTo(LocalTime.parse(czasPoczatku)) >= 0));
//     }

//     public static void showMeetingsFromTo(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
//         System.out.println("Podaj dzień tygodnia (0-6)");
//         int dzien = inputInt.nextInt();
//         System.out.println("Podaj godzine rozpoczecia");
//         String czasPoczatku = inputString.nextLine();
//         System.out.println("Podaj godzine zakonczenia");
//         String czasKonca = inputString.nextLine();
//         // printElems(mojKalendarz.getDzien(dzien, mojKalendarz.getOdPodanejGodziny(LocalTime.parse(czasPoczatku)).and(mojKalendarz.getDoPodanejGodziny(LocalTime.parse(czasKonca)))));
//         printElems(mojKalendarz.getDzien(dzien, s -> s.getCzasPoczatku().compareTo(LocalTime.parse(czasPoczatku)) >= 0 && s.getCzasZakonczenia().compareTo(LocalTime.parse(czasKonca)) <= 0));
//     }

//     public static void showMeetingsFromWithPriority(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
//         System.out.println("Podaj dzień tygodnia (0-6)");
//         int dzien = inputInt.nextInt();
//         System.out.println("Podaj godzine rozpoczecia");
//         String czasPoczatku = inputString.nextLine();
//         System.out.println("Podaj priorytet (wysoki, sredni, niski)");
//         String priorytet = inputString.nextLine();
//         // printElems(mojKalendarz.getDzien(dzien, mojKalendarz.getOdPodanejGodziny(LocalTime.parse(czasPoczatku)).and(mojKalendarz.getOPriorytecie(priorytet))));
//         printElems(mojKalendarz.getDzien(dzien, s -> s.getCzasPoczatku().compareTo(LocalTime.parse(czasPoczatku)) >= 0 && s.getPriorytet().equals(Spotkanie.PriorytetVals.valueOf(priorytet))));
//     }

//     public static void printElems(ArrayList<Spotkanie> elems){
//         for (Spotkanie spotkanie : elems){
//             System.out.println(spotkanie.toString());
//         }
//     }

// }

//##################################################################################################
//Meeting.java
// import java.time.LocalTime;

// public final class Spotkanie extends Wydarzenie{
    
//     public static final LocalTime MIN_CZAS = LocalTime.of(8, 0);
//     private PriorytetVals priorytet;

//     public enum PriorytetVals {
//         niski, sredni, wysoki
//     }
    

//     public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasKonca, String priorytet) {
//         super(opis, czasPoczatku, czasKonca);
//         this.priorytet = PriorytetVals.valueOf(priorytet);
//     }

//     public PriorytetVals getPriorytet(){
//         return this.priorytet;
//     }

//     @Override
//     public String toString(){
//         return "\t" + this.opis + "\n\t" + this.czasPoczatku + "-" + this.czasKonca + "\n\tpriorytet: " + this.priorytet;
//     }
// }

//##################################################################################################

//Wydarzenie.java
// import java.time.LocalTime;

// abstract sealed class Wydarzenie permits Zadanie, Spotkanie{
//     protected String opis;
//     protected LocalTime czasPoczatku;
//     protected LocalTime czasKonca;
    
//     public Wydarzenie(String opis, LocalTime czasPoczatku, LocalTime czasKonca) {
//         this.opis = opis;
//         this.czasPoczatku = czasPoczatku;
//         this.czasKonca = czasKonca;
//     }

//     public String getOpis() {
//         return opis;
//     }

//     public LocalTime getCzasPoczatku() {
//         return czasPoczatku;
//     }

//     public LocalTime getCzasZakonczenia() {
//         return czasKonca;
//     }

// }

//##################################################################################################

//Zadanie.java
// import java.io.ObjectInputFilter.Status;
// import java.time.LocalTime;

// public final class Zadanie extends Wydarzenie {
//     private StatusVals status;
//     public static final LocalTime MIN_CZAS = LocalTime.of(8, 0);

//     enum StatusVals{
//         planowane, potwierdzone, realizowane, wykonane
//     }

//     public Zadanie(String opis, LocalTime czasPoczatku, LocalTime czasKonca, String status) {
//         super(opis, czasPoczatku, czasKonca);
//         this.status= StatusVals.valueOf(status);
//     }

//     public StatusVals getStatus(){
//         return this.status;
//     }

//     @Override
//     public String toString(){
//         return "\t" + this.opis + "\n\t" + this.czasPoczatku + "-" + this.czasKonca + "\n\tstatus: " + this.status;
//     }
    
// }