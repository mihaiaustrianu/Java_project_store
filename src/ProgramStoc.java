public class ProgramStoc implements Runnable {

    Magazin magazin;
    Thread t;

    ProgramStoc(Magazin magazin) {
        this.magazin = magazin;

    }

    @Override
    public void run() {

            try {
                while (true) {
                    magazin.getStock();
                    Thread.sleep(30000);
                }
            } catch (InterruptedException e) {

            }
        }
    }


