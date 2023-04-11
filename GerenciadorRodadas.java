public class GerenciadorRodadas {

    public void gerenciadorDeRodadas(int rodadas, Macaco[] listaMacacos) {
        for (int i = 0; i < rodadas; i++) {
            for (int j = 0; j < listaMacacos.length; j++) {
                listaMacacos[j].arremessaCoco(listaMacacos);
            }
        }
    }

    
    public String macacoGanhador(Macaco[] listaMacacos) {
        Macaco aux = listaMacacos[0];
        int indexGanhador = 0;
        for (int i = 0; i < listaMacacos.length; i++) {
            if (listaMacacos[i].quantidadeCocosTotais() > aux.quantidadeCocosTotais()){
                aux = listaMacacos[i];
                indexGanhador = i;
            }
        }
        return "O macaco ganhador é: " + indexGanhador + " com a quantidade " + listaMacacos[indexGanhador].quantidadeCocosTotais() + " de Cocos";
    }
}