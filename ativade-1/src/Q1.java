import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um valor: ");

        int num = sc.nextInt();

        String asterisco = "*";

        for(int i = 0; num > i; i++){
            System.out.println(asterisco + "\n");
            asterisco = asterisco + " *";
        }
    }
}