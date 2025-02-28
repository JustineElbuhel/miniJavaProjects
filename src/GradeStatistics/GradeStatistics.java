package GradeStatistics;

import java.util.ArrayList;

public class GradeStatistics {
     private ArrayList<Integer> grades;
     private ArrayList<Integer> passingGrades;
     private ArrayList<Integer> points;

     public GradeStatistics(){
         this.grades = new ArrayList<>();
         this.passingGrades = new ArrayList<>();
         this.points = new ArrayList<>();
     }

     public void addGrade(int grade){
         if(grade <= 100 && grade >= 0){
             grades.add(grade);
             this.grades.add(gradesToPoints(grade));
         }

         if(grade <= 100 && grade >= 50){
             passingGrades.add(grade);
         }
     }

     public String overallAverage(){
         int sumOfGrades = 0;
         for(int grade: grades){
             sumOfGrades += grade;
         }
         double overallAvg = 1.0 * sumOfGrades/grades.size();

         return "Point average (All Grades): " + overallAvg;
     }

     public String passingAverage() {
         int sumOfPassingGrades = 0;

         if (passingGrades.isEmpty()) {
             return "Point average (Passing Grades): -";
         }

         for (int grade : passingGrades) {
             sumOfPassingGrades += grade;
         }
         double passingAvg = 1.0 * sumOfPassingGrades / passingGrades.size();
         return "Point average (Passing Grades): " + passingAvg;
     }

     public String passingPercentage(){
         System.out.println("Passing Grades size: " + passingGrades.size());
         System.out.println("Grades size: " + grades.size());
         double passingPercentage = 100.0 * passingGrades.size()/ grades.size();
         return "Passing Percentage: " + passingPercentage + "%";
     }

     public int numberOfGrades(int grade){
        int stars = 0;
        for(int inGrades : grades){
            if(inGrades == grade){
                stars++;
            }
        }
        return stars;
     }

     public static int gradesToPoints(int grade){
         int point = 0;
         if(grade < 50){
             point = 0;
         } else if(grade < 60){
             point = 1;
         } else if(grade < 70){
             point = 2;
         } else if (grade < 80){
             point = 3;
         } else if (grade < 90){
             point = 4;
         } else {
             point = 5;
         }

         return point;
     }
}
