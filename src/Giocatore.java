/**
 *
 @author cesare sonaglia
 */
public class Giocatore implements Runnable{
    String nome;
    private String parola;
    private int punteggio;
    /**
     *
     -
     @param nome del Giocatore
     */
    public Giocatore(String nome){
        this.nome = nome;
    }
    public String getParola() {
        return parola;
    }
    public void setParola(String parola) {
        this.parola = parola;
    }
    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
    /**
     - gioca, metodo che implementa la logica del gioco e calcola il punteggio

     */
    public void gioca(){
        long inizioG = System.currentTimeMillis();
        int numero = 19;
        String parola = "Diveritti";
        setParola(parola);

        for (int i=0; i<numero; i++) {
            System.out.println("Giocatore : " + nome + " i: " + i);
            try {
                Thread.sleep(2000); // Chiamata statica a Thread.sleep()
            } catch (InterruptedException e) {
                System.err.println("Errore nella transizione runnig - sleaping");
            }
            Thread.yield();

        }
        setPunteggio(100);
        System.out.println("Giocatore : " + nome + " parola: " + getParola() + " punteggio: " + punteggio);

        long fineG = System.currentTimeMillis();
        long durataG = fineG - inizioG;

        System.out.println("Durata giocatore "+ nome + durataG + " ms");
    }
    public void comunica(){}

    @Override
    public void run() {
        gioca();
    }



}