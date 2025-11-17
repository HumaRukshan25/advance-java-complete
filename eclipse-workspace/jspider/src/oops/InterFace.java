package oops;

public interface InterFace {

	int a=10;
    void a1() ;
    
    public static void n1() {
    	System.out.println("Static");
    }
    public default void n2() {
    	System.out.println("nonsatctic");
    }
   
    
}
