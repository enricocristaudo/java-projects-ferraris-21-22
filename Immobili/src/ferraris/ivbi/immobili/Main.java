public class Main {
    public static void main(String[] args) {

        Villa villa1 = new Villa(12, 200, "Via Torretta 163a", "Acireale", 3, 50, true);
        Villa villa2 = new Villa(12, 200, "Via Verga 4", "Acireale", 3, 50, true);
        Villa villa3 = new Villa(14, 200, "Via Torretta 163a", "Acireale", 3, 50, true);
        Appartamento ap1 = new Appartamento(4, 70, "Via Rossi 34", "Bologna", 3, true, 1);

        System.out.println("*** VILLA 1 ***\n"+villa1.toString());
        System.out.println("\n*** APPARTAMENTO 1 ***\n"+ap1.toString());

        System.out.println(villa1.equals(villa2));
        System.out.println(villa1.equals(villa3));
    }
}