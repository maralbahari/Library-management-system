import java.io.IOException;
import java.util.Scanner;
public class HeadLibrarian {
    public static void mainPage(String user,String pass) throws IOException{
        System.out.println("-----------Welcome to the main page of Head librarian----------"
                + "\n 1. Check the logs"
                + "\n 2. Log out");
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        switch(input){
            case 1:
                Logger.openLog();
                mainPage(user,pass);
                break;
            case 2:
                Library.login();
                break;
            default:
                System.out.println("Wrong choice enter again");
                mainPage(user,pass);
                break;
        }
    }
}
