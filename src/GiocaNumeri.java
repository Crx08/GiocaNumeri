/*
- Applicazione multithreading e diagramma degli stati

 */

/*
- @see UdA n. 1: Esercitazione n. 1 - Giocanumeri

- @author cesare sonaglia

 */
public class GiocaNumeri {
    /*
- @param args the command line arguments

     */
    public static void main(String[] args) {

        System.out.println("Benevenuto");
        long inizio = System.currentTimeMillis();

        Giocatore g1 = new Giocatore("monica");
        Giocatore g2 = new Giocatore("paolo");

        Thread tg1 = new Thread(g1);
        Thread tg2 = new Thread(g2);

        // Thread tg1 prima di start
        System.out.println("ID: "+ tg1.getId());
        System.out.println("Nome: "+ tg1.getName());
        System.out.println("Stato: "+ tg1.getState());
        System.out.println("Priorità: "+ tg1.getPriority());
        System.out.println("Attivo: "+ tg1.isAlive());

        // Thread tg2 prima di start
        System.out.println("ID: "+ tg2.getId());
        System.out.println("Nome: "+ tg2.getName());
        System.out.println("Stato: "+ tg2.getState());
        System.out.println("Priorità: "+ tg2.getPriority());
        System.out.println("Attivo: "+ tg2.isAlive());

        tg1.start();
        tg2.start();

        // Thread tg1
        System.out.println("ID: "+ tg1.getId());
        System.out.println("Nome: "+ tg1.getName());
        System.out.println("Stato: "+ tg1.getState());
        System.out.println("Priorità: "+ tg1.getPriority());
        System.out.println("Attivo: "+ tg1.isAlive());

        // Thread tg2
        System.out.println("ID: "+ tg2.getId());
        System.out.println("Nome: "+ tg2.getName());
        System.out.println("Stato: "+ tg2.getState());
        System.out.println("Priorità: "+ tg2.getPriority());
        System.out.println("Attivo: "+ tg2.isAlive());


        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.err.println("Erroe: interruzione del thread durante l'attesa");
        }

        try {
            tg1.join();
            tg2.join();
        } catch (InterruptedException e) {
            System.err.println("Erroe: interruzione dell'attesa dei giocatori");
        }

        //Thread.currentThread().sleep();

        long fine= System.currentTimeMillis();
        long durata = (fine - inizio);

        System.out.println("Durata esecuzione: " + durata + "ms");
        System.out.println("Fine gioco");
    }
}