package ferraris.ivbi.slot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tester {

    private static Slot[] vetSlot = new Slot[3];
    private static List<Giocatore> listaGiocatori = new ArrayList<Giocatore>();
    private static final int CASSA_1 = 100000;
    private static final int CASSA_2 = 50000;
    private static final int CASSA_3 = 10000;

    public static void main(String[] args) throws Exception {

        vetSlot[0] = new Slot(CASSA_1);
        vetSlot[1] = new Slot(CASSA_2);
        vetSlot[2] = new Slot(CASSA_3);

        IO.sout("*** BENVENUTO AL GIOCO DELLE SLOT MACHINE! ***\n");
        IO.sout("Prima di cominciare, registrati\n");
        String nome = IO.inString("Nome: ");
        String cognome = IO.inString("Cognome: ");
        double denaro = IO.inDouble("Denaro: ");

        listaGiocatori.add(new Giocatore(nome, cognome, denaro));

        int index = 0, indexSlot = 0, minPuntata = 0;
        int scelta;
        do {
            String k = IO.inString("\nPremi INVIO per continuare...");
            IO.sout("\033[H\033[2J");
            System.out.flush();
            scelta = menu();
            switch (scelta) {
            case 1:
                IO.sout(listaGiocatori.get(index).getStato());
                break;

            case 2:
                IO.sout("Con quale Slot Machine vuoi giocare?\n");
                int s = Slot.menuSlot();
                switch (s) {
                case 1:
                    indexSlot = 0;
                    minPuntata = 200;
                    break;
                case 2:
                    indexSlot = 1;
                    minPuntata = 100;
                    break;
                case 3:
                    indexSlot = 2;
                    minPuntata = 20;
                    break;
                }
                if (vetSlot[indexSlot].getCassa() == 0) {
                    IO.sout("\nSpiacenti, denaro in cassa terminato.");
                    IO.sout("\nRicarica cassa in corso...");
                    TimeUnit.SECONDS.sleep(1);
                    vetSlot[indexSlot].setCassa(CASSA_2);
                    break;
                }
                listaGiocatori.get(index).setNumPartite(listaGiocatori.get(index).getNum_partite() + 1);

                double puntata = IO.inDouble("\nQuanto vuoi puntare? ");

                if (puntata > listaGiocatori.get(index).getDenaro()) {
                    IO.sout("Non hai abbastanza denaro.");
                    break;
                }
                if (puntata < minPuntata) {
                    IO.sout("Devi puntare almeno " + minPuntata + "€!");
                    break;
                }

                double risultato[] = new double[2];

                risultato = vetSlot[indexSlot].gioca(puntata, indexSlot);

                vetSlot[indexSlot].setPartite(vetSlot[indexSlot].getPartite() + 1);
                if (risultato[0] == 0) {
                    IO.sout("\nRitenta, sarai piu' fortunato!\n");
                    listaGiocatori.get(index).setDenaro(listaGiocatori.get(index).getDenaro() - puntata);
                }
                if (risultato[0] != 0 && risultato[1] == 0) {
                    IO.sout("\nComplimenti! Hai vinto " + risultato[0] + "€!\n");
                    listaGiocatori.get(index).ricaricaDenaro(risultato[0] - puntata);
                }
                if (risultato[0] != 0 && risultato[1] != 0) {
                    IO.sout("\nComplimenti! Hai vinto " + risultato[0] + "€ e " + risultato[1] + "€ in buoni!");
                    listaGiocatori.get(index).ricaricaDenaro(risultato[0] - puntata);
                    listaGiocatori.get(index).setBuoni(risultato[1]);
                }
                break;

            case 3:
                double x = IO.inDouble("\nQuanto vuoi ricaricare? ");
                listaGiocatori.get(index).ricaricaDenaro(x);
                break;

            case 4:
                if (listaGiocatori.get(index).getBuoni() == 0) {
                    IO.sout("\nNessun buono disponibile.\n");
                    break;
                }
                IO.sout("\nHai scambiato i tuoi buoni e hai ottenuto " + listaGiocatori.get(index).getBuoni() + "€\n");
                listaGiocatori.get(index).scambiaBuoni();
                break;

            case 5:
                int isd = indexSlot + 1;
                IO.sout("Slot Machine n." + isd + ":\n");
                IO.sout(vetSlot[indexSlot].getStato());
                break;

            case 6:
                String nome2 = IO.inString("\nNome: ");
                String cognome2 = IO.inString("Cognome: ");
                double denaro2 = IO.inDouble("Denaro: ");
                listaGiocatori.add(new Giocatore(nome2, cognome2, denaro2));
                break;

            case 7:
                IO.sout("Che giocatore vuoi selezionare?\n");
                int s2, j = 1;
                do {
                    for (int i = 0; i < listaGiocatori.size(); i++) {
                        IO.sout("\nGIOCATORE " + j + "\n");
                        IO.sout("Nome: " + listaGiocatori.get(i).getNome() + "\n");
                        IO.sout("Cognome: " + listaGiocatori.get(i).getCognome() + "\n");
                        IO.sout("Denaro: " + listaGiocatori.get(i).getDenaro() + "€\n");
                        IO.sout("-----------\n");
                        j++;
                    }
                    s2 = IO.inInt("Scelta: ");
                } while (s2 < 1 || s2 > listaGiocatori.size() + 1);

                index = s2 - 1;
                break;
            case 8:
                k = "" + k;
                break;
            }
        } while (scelta != 8);

    }

    public static int menu() throws NumberFormatException, IOException {
        String s = "";
        int scelta;
        do {
            s = s + "\n******** MENU ********\n";
            s = s + "1] Mostra il tuo stato\n";
            s = s + "2] Gioca\n";
            s = s + "3] Ricarica denaro\n";
            s = s + "4] Scambia buoni\n";
            s = s + "5] Mostra stato slot machine\n";
            s = s + "------------------------\n";
            s = s + "6] Registra un nuovo giocatore\n";
            s = s + "7] Cambia giocatore\n";
            s = s + "8] Termina\n";
            s = s + "------------------------\n";
            IO.sout(s);
            scelta = IO.inInt("Scelta: ");
        } while (scelta < 1 || scelta > 8);

        return scelta;
    }

}