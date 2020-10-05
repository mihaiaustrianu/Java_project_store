import java.util.Scanner;

public class Laptop extends Produs {

    private int nrProcesoare;
    private boolean touchscreen;

    Laptop() {

    }

    Laptop(String producator, int pret, int nrProduse, int nrProcesoare, boolean touchscreen) {
        this.producator = producator;
        this.pret = pret;
        this.nrProduse = nrProduse;
        this.nrProcesoare = nrProcesoare;
        this.touchscreen = touchscreen;
    }

    public int getNrProcesoare() {
        return nrProcesoare;
    }

    public void setNrProcesoare(int nrProcesoare) {
        this.nrProcesoare = nrProcesoare;
    }

    public boolean isTouchscreen() {
        return touchscreen;
    }

    public void setTouchscreen(boolean touchscreen) {
        this.touchscreen = touchscreen;
    }

    public Laptop citire(Laptop l) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdu producatorul:");
        String producator = sc.nextLine();
        System.out.println("Introdu pretul (int):");
        Integer pret = sc.nextInt();
        System.out.println("Introdu numarul de produse(int):");
        Integer nrProduse = sc.nextInt();
        System.out.println("Introdu numarul de procesoare(int):");
        Integer nrProcesoare = sc.nextInt();
        System.out.println("Touchscreen?(boolean):");
        Boolean touchscreen = sc.nextBoolean();

        l.setNrProduse(nrProduse);
        l.setPret(pret);
        l.setProducator(producator);
        l.setNrProcesoare(nrProcesoare);
        l.setTouchscreen(touchscreen);
        return l;
    }

    @Override
    public String toString() {
        String s;
        if (touchscreen == true)
            s = "Are touchscreen";
        else
            s = "Nu are touchscreen";

        return "Laptop fabricat de " + this.producator + ". Pretul este de "
                + this.pret + " lei"
                + " si numarul de procesoare " + this.nrProcesoare + " ."
                + s;
    }
}