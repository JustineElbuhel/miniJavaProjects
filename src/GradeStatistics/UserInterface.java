package GradeStatistics;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private GradeStatistics gradeStatistics;

    public UserInterface(Scanner scanner, GradeStatistics gradeStatistics){
        this.scanner = scanner;
        this.gradeStatistics = gradeStatistics;
    }

    public void start(){
        System.out.println("Enter point totals (-1 Stops Program): ");
        while(true){
            int grade = Integer.valueOf(scanner.nextLine());

            if(grade == -1){
                break;
            }

            if(grade <= 100 && grade >= 0){
                gradeStatistics.addGrade(grade);
            }
        }

        System.out.println(gradeStatistics.overallAverage());
        System.out.println(gradeStatistics.passingAverage());
        System.out.println(gradeStatistics.passingPercentage());
        printGradeDistribution();
    }

    public void printGradeDistribution(){
        int grade = 5;
        while(grade >= 0){
            int stars = gradeStatistics.numberOfGrades(grade);
            System.out.print(grade + ": ");
            printStars(stars);
            System.out.println("");

            grade--;
        }
    }

    public static void printStars(int stars){
        while(stars > 0) {
            System.out.print("* ");
            stars--;
        }
    }
}
