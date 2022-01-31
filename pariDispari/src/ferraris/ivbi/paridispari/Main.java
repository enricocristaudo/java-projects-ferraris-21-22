package ferraris.ivbi.paridispari;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        try {
            JFrame fff = new JFrame();
            JFileChooser fd1 = new JFileChooser("dati");
            JFileChooser fd2 = new JFileChooser("dati");
            int n = fd1.showOpenDialog(fff);
            int n2 = fd2.showOpenDialog(fff);
            System.out.println("" + n);
            if (n != JFileChooser.APPROVE_OPTION || n2 != JFileChooser.APPROVE_OPTION)
                return;

            File g1 = fd1.getSelectedFile();
            File g2 = fd2.getSelectedFile();

            BufferedReader in1 = new BufferedReader(new FileReader(g1));
            BufferedReader in2 = new BufferedReader(new FileReader(g2));

            String line1, line2;
            int counter = 1;
            while ((line1 = in1.readLine()) != null) {
                System.out.println("\nRound " + counter + " -------");

                String pd1, pd2;

                String[] scelta1 = line1.split(" ");

                line2 = in2.readLine();
                String[] scelta2 = line2.split(" ");
                if (scelta1[0].equalsIgnoreCase("p"))
                    pd1 = "Pari";
                else
                    pd1 = "Dispari";
                if (scelta2[0].equalsIgnoreCase("p"))
                    pd2 = "Pari";
                else
                    pd2 = "Dispari";
                System.out.println("Giocatore 1: " + pd1 + ", " + scelta1[1]);
                System.out.println("Giocatore 2: " + pd2 + ", " + scelta2[1]);

                int somma = Integer.parseInt(scelta1[1]) + Integer.parseInt(scelta2[1]);

                if (somma % 2 == 0) {
                    if (scelta1[0].equals("p"))
                        System.out.println(somma + ": Vince il giocatore 1");
                    else
                        System.out.println(somma + ": Vince il giocatore 2");

                } else if (somma % 2 != 0) {
                    if (scelta1[0].equals("d"))
                        System.out.println(somma + ": Vince il giocatore 1");
                    else
                        System.out.println(somma + ": Vince il giocatore 2");
                }
                counter++;
            }

            in1.close();
            in2.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);

        }

    }

}
