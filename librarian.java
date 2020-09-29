
import java.io.IOException;
import java.util.Scanner;

public class Librarian {

    public static void mainPage() throws IOException {
        System.out.printf("----------Welcome to the main page of librarian----------"
                + "%n 1. Add a new member"
                + "%n 2. Add/Modify/Delete books"
                + "%n 3. Manage books"
                + "%n 4. clock in/out"
                + "%n 5. go back"
                + "%n Answer: ");
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        switch (input) {
            case 1:
                AddMember();
                break;
            case 2:
                AddModifyDelete();
                break;
            case 3:
                ManageBooks();
                break;
            case 4:
                ClockinOut();
                break;
            case 5:
                Library.login();
                break;
            default:
                System.out.println("Wrong choice enter again");
                mainPage();
                break;
        }
    }

    public static void AddMember() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter member username: ");
        String a = s.next();
        System.out.println("Enter Password: ");
        String b = s.next();
        if (Database.addUser(a, b) == true) {
            System.out.println("Member created");
            Logger.addlog("A new Member (" + a + ") Created");
        } else {
            System.out.println("There was a problem");
        }
        System.out.println("1. Library Page \n2. Librarian Page");
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

    public static void AddModifyDelete() throws IOException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        System.out.println("1. Add a new book"
                + "\n2. Modify a book"
                + "\n3. Delete a book"
                + "\n Answer: ");
        int input1 = s.nextInt();
        switch (input1) {
            case 1:
                System.out.printf("Enter book Name: ");
                String a1 = s1.nextLine();
                System.out.println("Enter Author's name: ");
                String b1 = s2.nextLine();
                System.out.println("Enter Category: ");
                String c2 = s3.nextLine();
                if (Database.addBook(a1, b1,c2,true) == true) {
                    System.out.println("Book added");
                    Logger.addlog("A new Book (" + a1 + ") has been created");
                } else {
                    System.out.println("There was a problem");
                }
                mainPage();
                break;
            case 2:
                System.out.printf("Enter book Name: ");
                a1 = s1.nextLine();
                System.out.println("Enter Author's name: ");
                b1 = s2.nextLine();
                System.out.println("Enter Category: ");
                c2 = s3.nextLine();
                System.out.printf("Enter new book Name: ");
                String a2 = s1.nextLine();
                System.out.println("Enter new Author's name: ");
                String b2 = s2.nextLine();
                System.out.println("Enter new Category: ");
                String c3 = s3.nextLine();
                System.out.println("--Modify was Successfull--");
                Database.edit(a2, b2, c3, true, a1, b1, c2, true);
                Logger.addlog("Book "+a1+" was edited");
                mainPage();
                break;
            case 3:
                System.out.println("Enter the name of the book that you want to delete:"
                        + "\n Answer: ");
                String a = s1.nextLine();
                Database.delete(a);
                System.out.println("Book Deleted Successfully");
                Logger.addlog("Book "+a+" was deleted");
                mainPage();
                break;
            default:
                System.out.println("Wrong choice enter again");
                mainPage();
                break;
        }
        mainPage();
    }

    public static void ManageBooks() throws IOException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        System.out.println("1. borrow a book"
                + "\n2. return a book");
        int input3 = s.nextInt();
        switch (input3) {
            case 1:
                System.out.println("Enter the name of the book you want to borrow:"
                        + "\n");
                String a = s1.nextLine();
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
                String b = s2.nextLine();
                if(Database.return1(b)==true){
                Logger.addlog("Book "+b+" was returned");
                System.out.println("--Book returned Successfully--");
                }else{
                    System.out.println("Book name not found or not borrowed");
                }
                mainPage();
                break;
        }
    }

    public static void ClockinOut() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("1. clock in \n2. clock out");
        int input4 = s.nextInt();
        switch (input4) {
            case 1:
                System.out.println("What time is it?");
                String time = s.next();
                Database.clockin(time);
                System.out.println("Time in recorded");
                Logger.addlog("Librarian Clocked in at "+time);
                mainPage();
                break;
            case 2:
                System.out.println("What time is it?");
                time = s.next();
                Database.clockout(time);
                System.out.println("Time out Saved");
                Logger.addlog("Librarian Clocked out at "+time);
                mainPage();
                break;
        }
    }
}
