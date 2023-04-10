import java.util.LinkedList;

public class GerenciadorRodadas {

    public void gerenciadorDeRodadas(int rodadas, LinkedList<Macaco> listaMacacos) {
        for (int i = 0; i < rodadas; i++) {
            for (int j = 0; j < listaMacacos.size(); j++) {
                listaMacacos.get(j).arremessaCoco(listaMacacos);
            }
        }
    }

    public int macacoGanhador(LinkedList<Macaco> listaMacacos) {
        Macaco aux = listaMacacos.get(0);
        int indexGanhador = 0;
        for (int i = 0; i < listaMacacos.size(); i++) {
            if (listaMacacos.get(i).cocos.size() > aux.cocos.size()) {
                aux = listaMacacos.get(i);
                indexGanhador = i;
            }
        }
        return indexGanhador;
    }
}