import java.util.logging.Level;
import java.util.logging.Logger;

public class GiocaNumeri {

    /**
     -
     @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("INIZIO");
            Cifratura cifratura = new Cifratura(); // Aggiunto per decifrare le parole

            Giocatore g1 = new Giocatore("Francesco");
            Thread tg1 = new Thread(g1);
            tg1.start();

            tg1.join();
            System.out.println("Parola decifrata " + g1.nome + ": " + cifratura.decifra(g1.getParola()));

            Thread.currentThread().sleep(5000);
            Giocatore g2 = new Giocatore("Milena");
            Thread tg2 = new Thread(g2);
            tg2.start();
            tg2.join();
            System.out.println("Parola decifrata " + g2.nome + ": " + cifratura.decifra(g2.getParola()));

            System.out.println("FINE");
        } catch (InterruptedException ex) {
            Logger.getLogger(GiocaNumeri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}