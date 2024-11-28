public class Driver {
    public static void main(String[] args) throws Exception {
        Prison abc = new Prison(5);

        System.out.println(abc.simulate(1000000, false));
        System.out.println(abc.simulate(1000, true));



    }
}
