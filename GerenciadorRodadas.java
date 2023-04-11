import java.util.LinkedList;

public class GerenciadorRodadas {

    public void gerenciadorDeRodadas(int rodadas, LinkedList<Macaco> listaMacacos) {
        for (int i = 0; i < rodadas; i++) {
            for (int j = 0; j < listaMacacos.size(); j++) {
                listaMacacos.get(j).arremessaCoco(listaMacacos);
            }
        }
    }

    
    public String macacoGanhador(LinkedList<Macaco> listaMacacos) {
        Macaco aux = listaMacacos.get(0);
        int indexGanhador = 0;
        for (int i = 0; i < listaMacacos.size(); i++) {
            if (listaMacacos.get(i).quantidadeCocosTotais() > aux.quantidadeCocosTotais()){
                aux = listaMacacos.get(i);
                indexGanhador = i;
            }
        }
        return "O macaco ganhador é: " + indexGanhador + " com a quantidade " + listaMacacos.get(indexGanhador).quantidadeCocosTotais() + " de Cocos";
    }
}