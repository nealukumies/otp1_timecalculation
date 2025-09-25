import java.util.Scanner;

public class TimeCal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter distance in km: ");
        double distance = sc.nextDouble();
        System.out.println("Enter speed in km/h: ");
        double speed = sc.nextDouble();
        double time = calculateTime(distance, speed);
        System.out.println("Time taken: " + time + " hours");
    }

    public static double calculateTime(double x, double v){
        return x/v;
    }
}
