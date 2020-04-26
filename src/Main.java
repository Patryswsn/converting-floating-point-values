public class Main {



    public static void main(String[] args){
//this program helps to avoid the precision problem in storing floating point values


        Solver solv = new Solver(16,6);
        System.out.println(solv.toString());
        System.out.println(solv.putChainTogether());

        Solver solv1 = new Solver(0.758);
        System.out.println(solv1.toString());
        System.out.println(solv1.compare(solv.getNumberChain()));















    }








}
