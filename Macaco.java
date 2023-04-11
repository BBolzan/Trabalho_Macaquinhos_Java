import java.util.LinkedList;

public class Macaco {
    private int ataqueImpar;
    private int ataquePar;
    private int cocosImpares;
    private int cocosPares;

    public Macaco(int ataqueImpar, int ataquePar,int cocosImpares, int cocosPares ) {
        this.ataqueImpar = ataqueImpar;
        this.ataquePar = ataquePar;
        this.cocosImpares = cocosImpares;
        this.cocosPares = cocosPares;
    }

    public void setCocosImpares(int cocosImpares) {
        this.cocosImpares += cocosImpares;
    }

    public void setCocosPares(int cocosPares) {
        this.cocosPares += cocosPares;
    }

    public int quantidadeCocosTotais() {
        int total = this.cocosImpares + this.cocosPares;
        return total;
    }
    
    public void arremessaCoco(LinkedList<Macaco> listaMacacos) {
        listaMacacos.get(ataqueImpar).setCocosImpares(cocosImpares);
        listaMacacos.get(ataquePar).setCocosPares(cocosPares);
        this.cocosImpares = 0;
        this.cocosPares = 0;
    }
}
