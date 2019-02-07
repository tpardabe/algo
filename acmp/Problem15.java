package acmp;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
public class Problem15 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            PrintWriter os =  new PrintWriter(System.out);
            int length = sc.nextInt();
            int counter = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    int tmp = sc.nextInt();
                    if (i <= j && tmp == 1) counter++;
                }
            }
            sc.close();
            os.println(counter);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}