
package ferraris.ivbi.slot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
    private static BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

    public static void sout(String msg) {
        System.out.print(msg);
    }

    public static int inInt(String msg) throws NumberFormatException, IOException {
        int num;
        sout(msg);
        num = Integer.parseInt(tastiera.readLine());
        return num;
    }

    public static double inDouble(String msg) throws NumberFormatException, IOException {
        double num;
        sout(msg);
        num = Double.parseDouble(tastiera.readLine());
        return num;
    }

    public static String inString(String msg) throws IOException {
        String s = "";
        sout(msg);
        s = tastiera.readLine();
        return s;
    }
}
