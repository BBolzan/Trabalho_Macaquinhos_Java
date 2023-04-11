import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String args[]) throws FileNotFoundException {
        LinkedList<Macaco> listaMacacos = new LinkedList<Macaco>();
        GerenciadorRodadas gRodadas = new GerenciadorRodadas();
        String FILE_PATH = "1000macacos.txt";

        File file = new File(FILE_PATH);
        long startTime = System.nanoTime();

        try (Scanner sc = new Scanner(file)) {
            int rodadas = Integer.parseInt(sc.nextLine().replaceAll("\\D+", ""));
            while (sc.hasNextLine()) {
                String testeParse = sc.nextLine();
                String[] testeResult = testeParse.split(" ");
                int cocosImpares = 0;
                int cocosPares = 0;
                
                for (int i = 11; i < testeResult.length; i++) {
                    if(Integer.parseInt(testeResult[i]) % 2 == 0) {
                        cocosPares++;
                    } else {
                        cocosImpares++;
                    }
                }
                listaMacacos.add(new Macaco(Integer.parseInt(testeResult[4]), Integer.parseInt(testeResult[7]),cocosImpares, cocosPares));
            }
            gRodadas.gerenciadorDeRodadas(rodadas, listaMacacos);
            long endTime = System.nanoTime();
            long fileTime = endTime - startTime;
            System.out.println(gRodadas.macacoGanhador(listaMacacos));
            System.out.println("===================================================");
            System.out.println("Tempo decorrido para executar o jogo: " + convertLongToTime(fileTime));
        }
    }
    public static String convertLongToTime(long time) {
        long milliseconds = time / 1000000;
        long seconds = (time / 1000000000) % 60;
        long minutes = (time / 60000000000L) % 60;
        long hours = (time / 3600000000000L) % 24;

        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
    }

}