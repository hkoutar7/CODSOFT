import java.util.ArrayList;
import java.util.Scanner;

public class SubjectCalculator {

    public static ArrayList<String> subjectNames = new ArrayList<String>() ;
    public static ArrayList<Float> subjectMarks = new ArrayList<Float>();

    public static void programOperation(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean isEnded = false;

        System.out.println("Hi Mr student, Welcome to your subject's grade calculator");
        System.out.println("please choose one of the following operation : ");

        do {
            System.out.println("1- Add a new subject grade\n2- view your subject's grade \n3- View your total mark \n4- Quit the program");
            System.out.print("response : ");
            choice = scanner.nextInt();

            while (!(choice > 0 && choice <= 4)) {
                System.out.print("your response is incorrect,reenter again : ");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1:
                    enterAddSubject();
                    break;
                case 2:
                    viewSubjectGrades ();
                    break;
                case 3:
                    System.out.println("the total mark is : " + viewTotalMark() + " %");
                    break;
                default:
                    System.out.println("------ The System have terminated ------");
                    isEnded = true;
            }
        }while (!isEnded);
    }

    public static void enterAddSubject (){
        Scanner scanner = new Scanner(System.in);
        String  subjectName = "";
        float subjectMark = 0.F;

        System.out.print("enter your subject name : ");
        subjectName = scanner.nextLine().trim().toLowerCase();
        do{
            System.out.print("enter your subject mark (0 - 100) : ");
            subjectMark = scanner.nextFloat();
        }while (subjectMark <0 || subjectMark >100);

        addSubject(subjectName,subjectMark);
    }

    public static void addSubject (String name, float mark){
        subjectMarks.add(mark);
        subjectNames.add(name);
    }

    public static void viewSubjectGrades (){

        int subjectNumber = subjectMarks.size();

        for (var i = 0 ;i <subjectNumber ;i++ ){
            System.out.println("For The " + subjectNames.get(i) + " subject, you\'ve scored " +Math.round( subjectMarks.get(i)));
        }
    }

    public static double viewTotalMark(){
        float totalMark = 0.0f;

        for (var mark : subjectMarks)
            totalMark += mark;

        return  (float)Math.round(totalMark / subjectMarks.size());
    }

}
