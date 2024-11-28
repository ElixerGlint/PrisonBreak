public class Driver {
    public static void main(String[] args) throws Exception {
        Prison abc = new Prison(10);

        System.out.println(abc.simulate(100000, false));
        System.out.println(abc.simulate(100000, true));


    }
}
