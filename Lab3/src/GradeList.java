import java.util.ArrayList;
//import java.util.Collections;

public class GradeList {
    private final ArrayList<Double> grades = new ArrayList<Double>();
    public boolean returnStatus() { return grades.isEmpty(); }
    public void addGrade(double grade) { grades.add(grade); };
    public double getMean(){
        double sum = 0;
        for (double grade : grades) { sum += grade; }
        return sum / grades.size();
    }
    public double highestGrade(){
        double max = grades.get(0);
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) > max) {
                max = grades.get(i);
            }
        } return max;
        }
    public double lowestGrade(){
        double min = grades.get(0);
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) < min) {
                min = grades.get(i);
            }
        } return min;
    }
}


