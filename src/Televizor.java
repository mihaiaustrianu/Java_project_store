import javax.tools.Diagnostic;
import java.util.Scanner;

public class Televizor extends Produs {
    private float diagonala;
    private boolean smart;

    Televizor()
    {

    }
    Televizor(String producator, int pret, int nrProduse, float diagonala, boolean smart) {
        this.producator = producator;
        this.pret = pret;
        this.nrProduse = nrProduse;
        this.diagonala = diagonala;
        this.smart = smart;
    }

    public float getDiagonala() {
        return diagonala;
    }

    public void setDiagonala(float diagonala) {
        this.diagonala = diagonala;
    }
    public Televizor citireTelevizor(Televizor t) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdu producatorul:");
        String producator = sc.nextLine();
        System.out.println("Introdu pretul (int):");
        Integer pret = sc.nextInt();
        System.out.println("Introdu numarul de produse(int):");
        Integer nrProduse = sc.nextInt();
        System.out.println("Introdu dimenisunea diagonalei (int):");
        Integer diagonala = sc.nextInt();
        System.out.println("Smart?(boolean):");
        Boolean smart = sc.nextBoolean();

        t.setNrProduse(nrProduse);
        t.setPret(pret);
        t.setProducator(producator);
        t.setDiagonala(diagonala);
        t.setSmart(smart);
        return t;
    }
    public boolean isSmart() {
        return smart;
    }

    public void setSmart(boolean smart) {
        this.smart = smart;
    }

    @Override
    public String toString() {
        return "Televizor{" +
                "diagonala=" + diagonala +
                ", smart=" + smart +
                ", producator='" + producator + '\'' +
                ", pret=" + pret +
                ", nrProduse=" + nrProduse +
                '}';
    }
}