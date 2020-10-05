import java.util.*;

public class Magazin {
    private ArrayList<Client> listaClienti = new ArrayList<>();
    private ArrayList<Produs> listaProduse = new ArrayList<>();
    private static Magazin instance;

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public boolean isExit() {
        return exit;
    }

    private boolean exit =false;

    public void setListaProduse(ArrayList<Produs> listaProduse) {
        this.listaProduse = listaProduse;
    }

    public ArrayList<Produs> getListaProduse() {
        return listaProduse;
    }

    private Magazin() {

    }

    public static final Magazin getInstance() {
        if (instance == null)
            instance = new Magazin();

        return instance;
    }

    public void adaugaClient(Client c,String nume) throws ClientDejaInregistratException{
        boolean check;
        check=existaClient(nume);
        if(check==true)
            throw new ClientDejaInregistratException("Clientul este deja inregistrat");

        System.out.println("A fost adaugat un client !");
        listaClienti.add(c);
    }
    public void stergereProdus(String nume,String numeProducator) throws ClientInexistentException {

        boolean check = existaClient(nume);
        if (check == false)
            throw new ClientInexistentException("Clientul nu exista !");

        int index = 0;
        for (int i = 0; i < listaClienti.size(); i++)
            if (listaClienti.get(i).equals(nume))
                index = i;

        for (int i = 0; i < listaClienti.get(index).cosCumparaturi.size(); i++) {
            listaClienti.get(index).cosCumparaturi.get(i).getProducator().equals(numeProducator);
            {
                listaClienti.get(index).cosCumparaturi.get(i).setNrProduse(listaClienti.get(index).cosCumparaturi.get(i).getNrProduse() + 1);
                listaClienti.get(index).cosCumparaturi.remove(i);


            }
        }
    }

    public void getStock() {
        System.out.println("Produse disponibile:");
        for (int i = 0; i < listaProduse.size(); i++) {
            //if(listaProduse.get(i).getNrProduse()>0)
            System.out.println("["+i+"] "+ "Nume:"+listaProduse.get(i).getProducator()
                    +" Stoc: "+listaProduse.get(i).getNrProduse()+" ");
        }
    }

    public void afisareClienti() {
        for (int i = 0; i < listaClienti.size(); i++) {
            System.out.println(listaClienti.get(i).getNume());
            System.out.println(listaClienti.get(i).getAnInregistrare());
        }
    }

    public boolean existaClient(String nume) {
        boolean check = false;
        for (int i = 0; i < listaClienti.size(); i++)
            if (listaClienti.get(i).getNume().equals(nume))
                check = true;
        return check;
    }
    public String citireClient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdu numele clientului : ");
        String nume = sc.nextLine();

        return nume;
    }
    public int citireNrProdus() throws ProdusInexistentException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdu numarul produsului: ");
        int nrProdus = sc.nextInt();
        if(nrProdus>listaProduse.size()) {
                throw new ProdusInexistentException("Produsul nu exista in magazin, va rugam selectati alt produs!");
            }

        return nrProdus;
    }
    public void verificaStoc(int nrProdus) throws StocInexistentException
    {
        if(listaProduse.get(nrProdus).getNrProduse()==0)
            throw new StocInexistentException("Produsul nu mai este pe stoc!!");
    }
    public void adaugaProdus(String nume, Produs p) throws ClientInexistentException  {
        //adaugare produs in cos
        boolean check = existaClient(nume);
        if (!check)
            throw new ClientInexistentException("Clientul nu exista !");

        for (int i = 0; i < listaClienti.size(); i++)
            if (listaClienti.get(i).getNume().equals(nume))
                listaClienti.get(i).cosCumparaturi.add(p);
    }
    public int calculPretCos(Client c)
    {
        int pret=0 ;
        for(int i=0;i<c.cosCumparaturi.size();i++)
            pret=pret+c.cosCumparaturi.get(i).getPret();
        if(c.isReducere())
            pret=pret*80/100;
        return pret;
    }
    public void afisareCos(String nume) throws ClientInexistentException {
        boolean check = existaClient(nume);
        if (check == false)
            throw new ClientInexistentException("Clientul nu exista !");
        for (int i = 0; i < listaClienti.size(); i++)
            if (listaClienti.get(i).getNume().equals(nume))
            {
                System.out.println(listaClienti.get(i));
                System.out.println("Pretul total este "+calculPretCos(listaClienti.get(i)));
            }
    }

    public void adaugaStoc(Produs p) {
        listaProduse.add(p);
    }

    public void afisareCompleta() {
        ArrayList<Client> listaClientiSortata = new ArrayList<>(listaClienti);
        Collections.sort(listaClientiSortata, Client.ClientNameComparator);

        for (int i = 0; i < listaClientiSortata.size(); i++) {
            System.out.println(listaClientiSortata.get(i));
            System.out.println("Pretul total este "+calculPretCos(listaClienti.get(i)));
        }
    }

    public void StergeToateProdusele(String nume) throws ClientInexistentException {
        boolean check = existaClient(nume);
        if (check == false)
            throw new ClientInexistentException("Clientul nu exista !");

        for (int i = 0; i < listaClienti.size(); i++)
            if (listaClienti.get(i).getNume().equals(nume)) {
                for(int j=0;j<listaProduse.size();j++)
                    for(int k=0;k<listaClienti.get(i).getCosCumparaturi().size();k++)
                        if(listaProduse.get(j) == listaClienti.get(i).getCosCumparaturi().get(k))
                            listaProduse.get(j).setNrProduse(listaProduse.get(j).getNrProduse()+1);
                listaClienti.get(i).stergereProduseCos();
            }
    }
}

