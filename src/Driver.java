public class Driver {
    public static void main(String[] args) throws Exception {
        Prison abc = new Prison(100);

        double duf = abc.simulate(100000, true);
        
        System.out.println(duf);



    }
}
