import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Q4 {
    public static void main(String[] args) {

        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("one", 1);
        mapa.put("two", 2);
        mapa.put("three", 3);
        mapa.put("four", 4);
        mapa.put("five", 5);
        mapa.put("six", 6);
        mapa.put("seven", 7);
        mapa.put("eight", 8);
        mapa.put("nine", 9);

        String caminhoArq = "C:\\Users\\savos\\IdeaProjects\\atividade-1\\src\\calibration_text.txt";
        ArrayList<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArq))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                list.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Integer total = 0;
        String nome;
        for(int i = 0; i < list.size(); i++){
            nome = list.get(i);
            String soma = "";
            String valor = "";
            valor = String.valueOf(palavraNum(nome, mapa));
            char c = valor.charAt(0);
            char s = valor.charAt(valor.length() -1);
            soma += c;
            soma += s;
            total += Integer.valueOf(soma);
        }
        System.out.println(total);
    }

    public static int palavraNum(String str, Map<String, Integer> mapa) {
        StringBuilder resultado = new StringBuilder();
        StringBuilder palavra = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                resultado.append(c);
            } else {
                palavra.append(c);
                if (mapa.containsKey(palavra.toString())) {
                    resultado.append(mapa.get(palavra.toString()));
                    palavra.setLength(0);
                }
            }
        }
        return Integer.parseInt(resultado.toString());}
}
