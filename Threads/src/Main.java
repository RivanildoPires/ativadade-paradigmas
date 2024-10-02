import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class minhaThread extends Thread{

    ArrayList<String> calibrations = new ArrayList<>();
    int inicio;
    int fim;

    public minhaThread(ArrayList<String> calibrations, int inicio, int fim){
        this.calibrations = calibrations;
        this.inicio = inicio;
        this.fim = fim;
    }

    public void run(){
        long tempoInicial = System.currentTimeMillis();

        int soma = 0;
        int count = 0;

        for(int i = inicio; i < fim; i ++){
            String linha = calibrations.get(i);
            soma += Calibracao.valorCalibracao(linha);
            count++;
        }

        System.out.println("A soma dos valores é: " + soma);
        System.out.println("Total de linhas: " + count);

        long tempoFinal = System.currentTimeMillis();

        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    }
}

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        long tempoInicial = System.currentTimeMillis();

        String caminhoArq = "C:\\Users\\savos\\IdeaProjects\\Threads\\src\\resource\\new_calibration_text.txt";
        ArrayList<String> calibrations = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArq))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                calibrations.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int soma = 0;
        int count = 0;

        for (String line: calibrations) {
            soma += Calibracao.valorCalibracao(line);
            count++;
        }

        int tamanhoLista = calibrations.size();
        int meio = tamanhoLista / 2;

        minhaThread thread1 = new minhaThread(calibrations,0,meio);
        minhaThread thread2 = new minhaThread(calibrations, meio, tamanhoLista);


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        System.out.println("A soma dos valores é: " + soma);
        System.out.println("Total de linhas: " + count);

        long tempoFinal = System.currentTimeMillis();

        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

    }
}