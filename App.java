import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o arquivo que você quer executar? ");
        String FILE_PATH = teclado.nextLine();
        
        long startTime = System.nanoTime();
        File file = new File(FILE_PATH);

        Macaco[] listaMacacos = new Macaco[contadorDeMacacos(FILE_PATH)];
        
        GerenciadorRodadas gRodadas = new GerenciadorRodadas();

        try (Scanner sc = new Scanner(file)) {
            int rodadas = Integer.parseInt(sc.nextLine().replaceAll("\\D+", ""));
            for(int i = 0; sc.hasNextLine() ; i++) {
                String testeParse = sc.nextLine();
                String[] testeResult = testeParse.split(" ");
                int cocosPares = 0;
                int totalDeCocosPorMacaco = Integer.parseInt(testeResult[9]);
                for (int j = 11; j < testeResult.length; j++) {
                    if(Integer.parseInt(testeResult[j]) % 2 == 0) {
                        cocosPares++;
                    } 
                }
                int cocosImpares = totalDeCocosPorMacaco - cocosPares;
                listaMacacos[i] = new Macaco(Integer.parseInt(testeResult[7]), Integer.parseInt(testeResult[4]),cocosImpares, cocosPares);
            }
            gRodadas.gerenciadorDeRodadas(rodadas, listaMacacos);
            System.out.println(gRodadas.macacoGanhador(listaMacacos));
            long endTime = System.nanoTime();
            long fileTime = endTime - startTime;
            System.out.println("===================================================");
            System.out.println("Tempo decorrido para executar o jogo: " + convertLongToTime(fileTime));
        } catch (Exception e) {
            System.err.println("Arquivo vazio");
        }
    }
    public static String convertLongToTime(long time) {
        long milliseconds = time / 1000000;
        long seconds = (time / 1000000000) % 60;
        long minutes = (time / 60000000000L) % 60;
        long hours = (time / 3600000000000L) % 24;

        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
    }

    public static int contadorDeMacacos(String fILE_PATH) throws FileNotFoundException {
        try (Scanner countLine = new Scanner(new File(fILE_PATH))) {
            int i;
            for(i = 0; countLine.hasNextLine(); i++) {
                countLine.nextLine();
            }
            return i-1;
        } catch (Exception e) {
            return -1;
        }
    }

}