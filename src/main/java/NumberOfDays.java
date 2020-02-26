import java.util.Scanner;

public class NumberOfDays {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enther the month: ");
        String month = scan.next();
        switch(month){
            case "January":
                System.out.println("days = 31");
                break;
            case "February":
                System.out.println("days = 28");
                break;
            case "March":
                System.out.println("days = 31");
                break;
            case "April":
                System.out.println("days = 30");
                break;
            case "May":
                System.out.println("days = 31");
                break;
            case "June":
                System.out.println("days = 30");
                break;
            case "July":
                System.out.println("days = 31");
                break;
            case "August":
                System.out.println("days = 31");
                break;
            case "September":
                System.out.println("days = 30");
                break;
            case "October":
                System.out.println("days = 28");
                break;
            case "November":
                System.out.println("days = 30");
                break;
            case "December":
                System.out.println("days = 31");
                break;
        }
    }
}
