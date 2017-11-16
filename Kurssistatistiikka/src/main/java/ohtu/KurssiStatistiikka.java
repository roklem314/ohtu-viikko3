
package ohtu;

import java.util.ArrayList;

public class KurssiStatistiikka {
    private int students;
    private int hour_total;
    private int exercise_total;
    private ArrayList<Integer> hours;
    private ArrayList<Integer> exercies;

    public KurssiStatistiikka( int students, int hour_total, int exercise_total, ArrayList<Integer> hours, ArrayList<Integer> exercies) {
        this.students = students;
        this.hour_total = hour_total;
        this.exercise_total = exercise_total;
        this.hours = hours;
        this.exercies = exercies;
    }

    public ArrayList<Integer> getExercies() {
        return exercies;
    }

    public int getExercise_total() {
        return exercise_total;
    }

    public int getHour_total() {
        return hour_total;
    }

    public ArrayList<Integer> getHours() {
        return hours;
    }

    public int getStudents() {
        return students;
    }

    public void setExercies(ArrayList<Integer> exercies) {
        this.exercies = exercies;
    }

    public void setExercise_total(int exercise_total) {
        this.exercise_total = exercise_total;
    }

    public void setHour_total(int hour_total) {
        this.hour_total = hour_total;
    }

    public void setHours(ArrayList<Integer> hours) {
        this.hours = hours;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
