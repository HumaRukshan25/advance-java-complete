package oops;
import java.util.*;
public interface InterFace2 extends InterFace
{

    public static void n1() {
    	System.out.println("jj");
    }
    public default void n2() {
    	System.out.println("nonsatctic");
    }
    public static void main(String[] args) {
  		InterFace2.n1();
  	
  	
  	}

}
