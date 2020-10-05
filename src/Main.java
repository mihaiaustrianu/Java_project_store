public class Main {
    public static void main(String[] args) {
        Magazin magazin = Magazin.getInstance();

        Laptop l1 = new Laptop("Apple MacBook pro 13", 4000, 3, 4, true);
        Laptop l2 = new Laptop("Apple MacBook 13", 3000, 0, 4, true);
        magazin.adaugaStoc(l1);
        magazin.adaugaStoc(l2);


        Thread thread1=new Thread(new ProgramPrincipal(magazin));
        Thread thread2=new Thread(new ProgramStoc(magazin));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }
        catch(InterruptedException e) {
            System.out.println("Caught:" + e);
        }

    }
}
