import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

class minhaThread extends Thread{

    ArrayList<String> calibrations = new ArrayList<>();
    private int inicio;
    private int fim;
    private int soma;
    private final CountDownLatch barreira;

    public minhaThread(ArrayList<String> calibrations, int inicio, int fim,CountDownLatch barreira){
        this.calibrations = calibrations;
        this.inicio = inicio;
        this.fim = fim;
        this.barreira = barreira;
        this.soma = 0;
    }

    public void run() {
        for (int i = inicio; i < fim; i++) {
            soma += Calibracao.valorCalibracao(calibrations.get(i));
        }

        barreira.countDown();
    }
       public int getSoma(){
           return soma;
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
        }

        int tamanhoLista = calibrations.size();
        int meio = tamanhoLista / 2;

        CountDownLatch barreira = new CountDownLatch(2);

        minhaThread thread1 = new minhaThread(calibrations,0,meio,barreira);
        minhaThread thread2 = new minhaThread(calibrations, meio, tamanhoLista, barreira);


        thread1.start();
        thread2.start();

        barreira.await();

        int somaTotal = thread1.getSoma() + thread2.getSoma();

        System.out.println("Soma Global: " + somaTotal);

        long tempoFinal = System.currentTimeMillis();

        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

    }
}