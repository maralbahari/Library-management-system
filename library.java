    
import java.io.*;
import java.util.Scanner;

public class Library {

    public static void main(String[] args) throws IOException {
        login();
    }

    public static void login() throws IOException {
        System.out.println("----------Hello, This is our Library management system----------"
                + "\n 1. log in as a Head librarian"
                + "\n 2. log in as a Librarian"
                + "\n 3. log in as a Member "
                + "\n Answer: ");
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        switch (input) {
            case 1:
               HeadLogin();
                break;
            case 2:
                LibrarianLogin();
                break;
            case 3:
              MemberLogin();
                break;
        }
    }
    public static void HeadLogin() throws IOException{
        Scanner s = new Scanner(System.in);
          System.out.println("Enter Username as Head Librarian:");
                String a = s.next();
                System.out.println("Enter Password as Head Librarian:");
                String b = s.next();
                if (Database.HLL(a, b) == true) {
                    HeadLibrarian.mainPage(a,b);
                } else {
                    System.out.println("Wrong info, Try again");
                    login();
                }
    }
    public static void LibrarianLogin() throws IOException{
        Scanner s = new Scanner(System.in);
          System.out.println("Enter Username as Librarian:");
                String a = s.next();
                System.out.println("Enter Password as Librarian:");
                String b = s.next();
                if (Database.HLL(a, b) == true) {
                    Librarian.mainPage();
                }
    }
    public static void MemberLogin() throws IOException{
        Scanner s = new Scanner(System.in);
         System.out.println("Enter Username as a member:");
               String a = s.next();
                System.out.println("Enter Password as a member:");
               String  b = s.next();
                if (Database.Login(a, b) == true){
                Members.mainPage();
                }else{
                    System.out.println("Wrong info");
                    login();
                }
    }
}
