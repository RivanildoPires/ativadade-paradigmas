import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um valor: ");

        int num = sc.nextInt();

        for(int i = 0; num > i; num--){
            int res = num;
            String asterisco = "";
            for (int j = 0; res > j; j++){
                asterisco = asterisco + "*";
            }
            System.out.println(asterisco + "\n");
        }
    }
}
