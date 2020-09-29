import java.io.IOException;
import java.util.Scanner;

public class Members {

    public static void mainPage() throws IOException {
        System.out.println("Welcome to the main page of members :"
                + "\n 1. Update your profile"
                + "\n 2. Search for a book by Name/Category"
                + "\n 3. Borrow/Return a book"
                + "\n 4. Renew membership"
                + "\n 5. log out"
                + "\n Answer: ");
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        switch (input) {
            case 1:
                UpdatePro();
                break;
            case 2:
                BookSearching();
                break;
            case 3:
                BorrowAndReturn();
                break;
            case 4:
                RenewMembership();
                break;
            case 5:
                Library.login();
                break;
            default:
                System.out.println("Wrong number, Insert again");
                mainPage();
                break;
        }
    }

    public static void UpdatePro() throws IOException {
        System.out.println("1. change your password \n2. go back ");
        Scanner s2 = new Scanner(System.in);
        int input = s2.nextInt();
        switch (input) {
            case 1:
                System.out.println("Enter Username:");
                String a = s2.next();
                System.out.println("Enter Password:");
                String b = s2.next();
                if (Database.Login(a, b) == true) {
                    System.out.println("Enter a new Password");
                    String NP = s2.next();
                    Database.editP(a, b, NP);
                    System.out.println("---Password changed successfully---");
                    System.out.println("1. Library Page"
                            + " \n 2. Member Page");
                    int input2 = s2.nextInt();
                    switch (input2) {
                        case 1:
                            Library.login();
                            break;
                        case 2:
                            mainPage();
                            break;
                    }

                } else {
                    System.out.println("Wrong info");
                    mainPage();
                }
                break;
            case 2:
                mainPage();
                break;
        }
    }

    public static void BookSearching() throws IOException {
        System.out.println("1. Search by Name "
                + "\n2. search by Category "
                + "\n3. search all books");
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int input3 = s.nextInt();
        switch (input3) {
            case 1:
                System.out.println("Enter book name");
                String a1 = s1.nextLine();
                Database.searchSpecific(a1);
                System.out.println("Do you want to borrow this book? "
                        + "\n 1. yes "
                        + "\n 2. no");
                int input4 = s.nextInt();
                switch (input4) {
                    case 1:
                        if (Database.borrow(a1) == true) {
                            Logger.addlog("Book " + a1 + " was borrowed");
                            System.out.println("--Book Borrowed Successfully--");
                        } else {
                            System.out.println("Book not found or already borrowed");
                        }
                        mainPage();
                        break;
                    case 2:
                        mainPage();
                        break;

                }
                break;
            case 2:
                System.out.println("Enter Category name");
                a1 = s2.nextLine();
                Database.searchCategory(a1);
                mainPage();
                break;
            case 3:
                Database.search();
                mainPage();
        }

    }

    public static void BorrowAndReturn() throws IOException {
        System.out.println("1. Borrow \n2. Return");
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        int input5 = s1.nextInt();
        switch (input5) {
            case 1:
                System.out.println("Enter the name of the book you want to borrow:"
                        + "\n");
                String a = s2.nextLine();
                if(Database.borrow(a)==true){
                Logger.addlog("Book "+a+" was borrowed");
                System.out.println("--Book Borrowed Successfully--");
                }else{
                    System.out.println("Book not found or already borrowed");
                }
                mainPage();
                
                break;
            case 2:
                System.out.println("Enter the name of the book you want to return:"
                        + "\n");
                String b = s3.nextLine();
                if(Database.return1(b)==true){
                Logger.addlog("Book "+b+" was returned");
                System.out.println("--Book returned Successfully--");
                }else{
                    System.out.println("Book name not found or not borrowed");
                }
                mainPage();
                break;
        }
        mainPage();
    }

    public static void RenewMembership() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Username:");
        String a = s.nextLine();
        System.out.println("Enter Password:");
        String b = s.nextLine();
        if (Database.Login(a, b) == true) {
            System.out.println("---Membership renewed for 30 days---");
            Database.editMembership(a, b);
            Logger.addlog("Membership of "+a+" was renewed");
        } else {
            System.out.println("Wrong info");
        }
        System.out.println("1. Library Page \n 2. Member Page");
        int input = s.nextInt();
        switch (input) {
            case 1:
                Library.login();
                break;
            case 2:
                mainPage();
                break;
        }

    }
}
