import java.util.Scanner;

public class Telefon extends Produs {
    private int nrMegapixeli;
    private float dimensiuneBaterie;

    Telefon(){

    }
    Telefon(String producator, int pret, int nrProduse, int nrMegapixeli, float dimensiuneBaterie) {
        this.producator = producator;
        this.pret = pret;
        this.nrProduse = nrProduse;
        this.nrMegapixeli = nrMegapixeli;
        this.dimensiuneBaterie = dimensiuneBaterie;
    }
    public Telefon citireTelefon(Telefon t)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdu producatorul:");
        String producator = sc.nextLine();
        System.out.println("Introdu pretul (int):");
        Integer pret = sc.nextInt();
        System.out.println("Introdu numarul de produse(int):");
        Integer nrProduse = sc.nextInt();
        System.out.println("Introdu numarul de megapixeli(int):");
        Integer nrMegapixeli = sc.nextInt();
        System.out.println("Introdu dimensiune baterie:");
        Float dimensiuneBaterie = sc.nextFloat();

        t.setNrProduse(nrProduse);
        t.setPret(pret);
        t.setProducator(producator);
        t.setNrMegapixeli(nrMegapixeli);
        t.setDimensiuneBaterie(dimensiuneBaterie);
        return t;
    }
    public int getNrMegapixeli() {
        return nrMegapixeli;
    }

    public void setNrMegapixeli(int nrMegapixeli) {
        this.nrMegapixeli = nrMegapixeli;
    }

    public float getDimensiuneBaterie() {
        return dimensiuneBaterie;
    }

    public void setDimensiuneBaterie(float dimensiuneBaterie) {
        this.dimensiuneBaterie = dimensiuneBaterie;
    }

    @Override
    public String toString() {
        return "Telefon{" +
                "nrMegapixeli=" + nrMegapixeli +
                ", dimensiuneBaterie=" + dimensiuneBaterie +
                ", producator='" + producator + '\'' +
                ", pret=" + pret +
                ", nrProduse=" + nrProduse +
                '}';
    }
}