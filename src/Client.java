import java.util.*;

public class Client {

    private String nume;
    private int anInregistrare;
    private boolean reducere;
    ArrayList<Produs> cosCumparaturi = new ArrayList<>();

    Client(String nume, int anInregistrare, boolean reducere) {
        this.nume = nume;
        this.anInregistrare = anInregistrare;
        this.reducere = reducere;
    }

    public String getNume() {
        return nume;
    }

    public int getAnInregistrare() {
        return anInregistrare;
    }

    public boolean isReducere() {
        return reducere;
    }

    public ArrayList<Produs> getCosCumparaturi() {
        return cosCumparaturi;
    }

    public void setListaProduse(ArrayList<Produs> cosCumparaturi) {
        this.cosCumparaturi = cosCumparaturi;
    }

    public void stergereProduseCos() {
        cosCumparaturi.clear();
    }

    public static Comparator<Client> ClientNameComparator = new Comparator<Client>() {

        public int compare(Client c1, Client c2) {
            String NumeClient1 = c1.getNume().toUpperCase();
            String NumeClient2 = c2.getNume().toUpperCase();
            return NumeClient1.compareTo(NumeClient2);
        }
    };

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", an inregistrare=" + anInregistrare +
                ", reducere=" + reducere +
                ", produse cos cumparaturi=" + cosCumparaturi +
                '}';
    }
}