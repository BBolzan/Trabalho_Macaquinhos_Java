import java.util.LinkedList;
import java.util.List;

public class Macaco {
    public List<Integer> cocos = new LinkedList<Integer>(); // [22, 44, 55, 66]
    private int ataqueImpar;
    private int ataquePar;

    public Macaco(int ataqueImpar, int ataquePar, List<Integer> listaCocosMacaco) {
        this.ataqueImpar = ataqueImpar;
        this.ataquePar = ataquePar;
        this.cocos = listaCocosMacaco;
    }

    public void arremessaCoco(LinkedList<Macaco> listaDeMacacos) {
        if (cocos.size() != 0) {

            if (cocos.get(0) % 2 == 0) {
                listaDeMacacos.get(ataquePar).adicionaCoco(cocos.get(0));
                cocos.remove(0);
            } else if (cocos.get(0) % 2 != 0) {
                listaDeMacacos.get(ataqueImpar).adicionaCoco(cocos.get(0));
                cocos.remove(0);
            }
        }
    }

    public void adicionaCoco(int coco) {
        cocos.add(coco);
    };
}
