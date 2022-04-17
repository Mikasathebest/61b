/**
 *  Tests Body
 *  create two body and print out pairwise force between them  
 */
public class TestBody{
    public static void main(String[] args){
        checkbody();
    }
    /**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     *  @param  eps         Tolerance for the double comparison.
     */
    private static void checkEquals(double expected, double actual, String label, double eps) {
        if (Double.isNaN(actual) || Double.isInfinite(actual)) {
            System.out.println("FAIL: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        } else if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        }
    }
    
    /** create two body and check their pairwise force
    */
    private static void checkbody(){
        System.out.println("Checking body...");
        Body b1 = new Body(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Body b2 = new Body(1.0, 2.0, 3.0, 4.0, 10.0, "jupiter.gif");
        double f = b1.calcForceExertedBy(b2);
        checkEquals(3.335e-9, f, "force between two bodys", 0.01);
    }
}
