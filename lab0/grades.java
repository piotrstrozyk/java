package lab0;

import java.util.ArrayList;

//public class GradeList {
//    private ArrayList<Double> grades = new ArrayList<Double>();
//
//    public void addGrade(double grade) {
//        if (grade < 2 || grade > 5) {
//            return;
//        }
//        else{
//            grades.add(grade);
//        }
//    }
//
//    public double getAverage() {
//        double sum = 0;
//        if (grades.isEmpty()) {
//            return 0;
//        }
//        else{
//            for (double grade : grades) {
//                sum += grade;
//            }
//            return sum / grades.size();
//        }
//    }
//
//    public double getHighest() {
//        double highest = 0;
//        if (grades.isEmpty()){
//            return 0;
//        }
//        else{
//            for (double grade : grades) {
//                if (grade > highest) {
//                    highest = grade;
//                }
//            }
//            return highest;
//        }
//    }
//
//    public double getLowest() {
//        double lowest = 7;
//        if (grades.isEmpty()){
//            return 0;
//        }
//        else{
//            for (double grade : grades) {
//                if (grade < lowest) {
//                    lowest = grade;
//                }
//            }
//            return lowest;
//        }
//    }
//}

//Main
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        GradeList gradeList = new GradeList();
//        System.out.println("Program do obslugi listy ocen");
//        int wybor = 0;
//        Scanner scanner = new Scanner(System.in);
//        do {
//            System.out.println("Wybierz opcje:");
//            System.out.println("1 - Dodawanie nowej oceny");
//            System.out.println("2 - Wyliczenie sredniej ze wszystkich ocen");
//            System.out.println("3 - Wyszukanie i wyswietlenie najwyzszej oceny");
//            System.out.println("4 - Wyszukanie i wyswietlenie najnizszej oceny");
//            System.out.println("5 - Wyjscie z programu");
//            wybor = scanner.nextInt();
//            switch(wybor) {
//                case 1:
//                    System.out.println("Podaj ocene: ");
//                    double ocena = scanner.nextDouble();
//                    gradeList.addGrade(ocena);
//                    break;
//                case 2:
//                    double srednia = gradeList.getAverage();
//                    if (srednia == 0.0) System.out.println("Brak ocen");
//                    else System.out.println("Srednia ocen: " + srednia);
//                    break;
//                case 3:
//                    double najwyzsza = gradeList.getHighest();
//                    if(najwyzsza == 0.0) System.out.println("Brak ocen");
//                    else System.out.println("Najwyzsza ocena: " + gradeList.getHighest());
//                    break;
//                case 4:
//                    double najnizsza = gradeList.getLowest();
//                    if(najnizsza == 0.0) System.out.println("Brak ocen");
//                    else System.out.println("Najnizsza ocena: " + gradeList.getLowest());
//                    break;
//                case 5:
//                    System.out.println("Wyjscie z programu");
//                    break;
//                default:
//                    System.out.println("Nieprawidlowa opcja");
//                    break;
//            }
//        } while(wybor != 5);
//        scanner.close();
//    }
//}