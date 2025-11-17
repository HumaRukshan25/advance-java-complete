import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Company {
    
    static Scanner sc = new Scanner(System.in);
    
    static void addEmployee() throws IOException {
    	
        System.out.println("Enter Id: ");
        String id = sc.next();
        
        System.out.println("Enter Name: ");
        String name = sc.next();
        
        System.out.println("Enter Sal: ");
        String sal = sc.next();
        
        System.out.println("Enter Dept No: ");
        String dno = sc.next();
        
        String emp = id + "," + name + "," + sal + "," + dno;
        
        String path = "C:\\Users\\Sania Mir\\eclipse-workspace\\AdvancejavaFirstclass\\src\\emps";
        
        File f = new File(path);
        FileWriter fw = new FileWriter(f, true);
        PrintWriter pw = new PrintWriter(fw, false);
        
        pw.println(emp);
        pw.close();
        
    }
    
    
    static void displayEmployee() throws IOException {
        String path = "C:\\Users\\Sania Mir\\eclipse-workspace\\AdvancejavaFirstclass\\src\\emps";
        File f = new File(path);
        
        FileReader fr = new FileReader(f);
        int c = fr.read();
        
        while (c != -1) {
            System.out.print((char) c);
            c = fr.read();
        }
        
        fr.close();
    }
    
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Enter Choice");
            System.out.println("1) Add Emp");
            System.out.println("2) View Emps");
            
            int key = sc.nextInt();
            
            switch (key) {
                case 1:
                    addEmployee();
                    break;
                
                case 2:
                    displayEmployee();
                    break;
                
                default:
                    System.out.println("Invalid Choice...");
            }
        }
    }
}