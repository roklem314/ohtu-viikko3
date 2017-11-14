package ohtu;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.util.ArrayList;

public class Submission {
    private int maximi;
    private int week;
    private int hours;
    private ArrayList<Integer> exercises;

//    public Submission(int week, int hours,ArrayList<Integer> teht) {
//        this.week = week;
//        this.hours = hours;
//        this.teht = teht;
//    }
    

    public int getMaximi() {
        return maximi;
    }

    public void setMaximi(int maximi) {
        this.maximi = maximi;
    }
    
    

    public void exercises(ArrayList<String> teht) {
        this.exercises = new ArrayList<>();
    }

    public void setWeek(int week) {
        this.week = week;
    }
    public void setHours(int hours){
        this.hours = hours;
    }

    public int getWeek() {
        return week;
    }
    public int getHours(){
        return hours;
    }
    public ArrayList getExercies(){
        return exercises;
    }
    public String tehtdyTeht(){
        String merkkijono = "";
        for (Integer integer : exercises) {
            merkkijono += integer +" ";
            
        }
        return  merkkijono;  
    }

    @Override
    public String toString() {
        
        return "viikko "+week+":\n tehtyjä tehtäviä yhteensä: " + exercises.size()+ " (maksimi "+ this.exercises.size()+" )"+" , aikaa kului " + hours +" tuntia, tehdyt tehtävät: " + tehtdyTeht();
    }
    
}