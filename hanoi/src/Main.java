import java.util.Scanner;

public class Main {
    static int stepNum = 0;

    public static void move(int n, String source, String goal, String helper) {
        if (n > 1) {
            move(n - 1, source, helper, goal);
        }
        stepNum++;
        System.out.println(stepNum + ": " + source + " --> " + goal);
        if (n > 1) {
            move(n - 1, helper, goal, source);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("A - palik startowy\nB - palik pomocniczy\nC - palik docelowy");
        System.out.print("Ile krążków przenieść? ");
        int n = scanner.nextInt();
        move(n, "A", "C", "B");
        scanner.close();
    }
}