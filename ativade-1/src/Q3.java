import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Q3 {
    public static void main(String[] args) {
        int total = 0;

        String caminhoArq = "C:\\Users\\savos\\Downloads\\calibration_text.txt";
        ArrayList<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArq))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                list.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String nome : list) {
            Integer valor1 = null;
            Integer valor2 = null;
            for (char c : nome.toCharArray()) {
                if (Character.isDigit(c)) {
                    if (valor1 == null) {
                        valor1 = Character.getNumericValue(c);
                    } else {
                        valor2 = Character.getNumericValue(c);
                    }
                }
            }
            if (valor1 != null && valor2 == null) {
                valor2 = valor1;
            }
            if (valor1 != null && valor2 != null) {
                total += valor1 * 10 + valor2;
            }
        }

        System.out.println(total);
    }
}