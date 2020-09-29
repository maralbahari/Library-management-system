
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Scanner;

public class Database {

    public static boolean HLL(String a, String b) {
        if (a.equals("admin") && b.equals("admin123")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean addUser(String Username, String Password) {
        int membership = 30;
        try {
            File f = new File("Users.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(f, true));
            pw.append("\r\n"+Username + "," + Password + "," + membership + " days\n");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean addBook(String a, String b, String c, boolean d) {

        try {
            File f = new File("books.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(f, true));
            pw.append(a + "," + b + "," + c + "," + d + "\n");
            pw.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void delete(String a) throws FileNotFoundException, IOException {

        String fileName = "books.txt";
        String tempFile = "";
        File oldFile = new File(fileName);


        String currentLine;
        String data[];
        try {


            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            boolean again = true;
            while ((currentLine = br.readLine()) != null) {

                data = currentLine.split(",");
                if (again == false) {
                    data[0] = "hahahahaha u cant come";
                }
                if ((data[0].equalsIgnoreCase(a))) {
                    again = false;
                } else {
                    tempFile = tempFile+currentLine+"\n";
                }
            }

            fr.close();
            br.close();
            FileWriter writer = new FileWriter("Books.txt");
            writer.write(tempFile);
            writer.close();

        } catch (Exception e) {

        }
    }

    public static void edit(String a, String nb, String nc, boolean nd, String a2, String nb2, String nc2, boolean nd2) throws IOException {
        String x = a + "," + nb + "," + nc + "," + nd;
        String y = a2 + "," + nb2 + "," + nc2 + "," + nd2;
        try {
            File file = new File("Books.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "", oldtext = "";
            while ((line = reader.readLine()) != null) {
                oldtext += line + "\r\n";
            }
            reader.close();
            // replace a word in a file
            //String newtext = oldtext.replaceAll("drink", "Love");

            //To replace a line in a file
            String newtext = oldtext.replaceAll(y, x);

            FileWriter writer = new FileWriter("Books.txt");
            writer.write(newtext);
            writer.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static void edit2(String a, String nb, String nc, boolean nd, String a2, String nb2, String nc2, boolean nd2) throws IOException {
        String x = a + "," + nb + "," + nc + "," + nd;
        String y = a2 + "," + nb2 + "," + nc2 + "," + nd2;
        try {
            File file = new File("Books.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "", oldtext = "";
            while ((line = reader.readLine()) != null) {
                oldtext += line + "\r\n";
            }
            reader.close();
            // replace a word in a file
            //String newtext = oldtext.replaceAll("drink", "Love");

            //To replace a line in a file
            String newtext = oldtext.replaceFirst(y, x);

            FileWriter writer = new FileWriter("Books.txt");
            writer.write(newtext);
            writer.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static boolean borrow(String name) {

        String fileName = "books.txt";
        String currentLine;
        String data[];
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(",");

                if ((data[0].equalsIgnoreCase(name))) {
                    if (data[3].equals("true")) {
                        Database.edit2(data[0], data[1], data[2], false, data[0], data[1], data[2], true);
                        return true;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("REACHEDEEEEE");
        }
        return false;
    }

    public static boolean return1(String name) {

        String fileName = "books.txt";
        String currentLine;
        String data[];
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(",");

                if ((data[0].equalsIgnoreCase(name))) {
                    if (data[3].equals("false")) {
                        Database.edit2(data[0], data[1], data[2], true, data[0], data[1], data[2], false);
                        return true;

                    }
                }
            }

        } catch (Exception e) {
            System.out.println("REACHEDEEEEE");
        }
        return false;
    }

    public static void search() {

        String fileName = "books.txt";
        String currentLine;
        String data[];
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(",");

                for (int i = 0; i < data.length; i++) {
                    System.out.print(data[i] + " ");
                }
                System.out.println("");

            }

        } catch (Exception e) {
            System.out.println("REACHEDEEEEE");
        }

    }

    public static void searchSpecific(String name) {
        String fileName = "books.txt";
        String currentLine;
        String data[] = new String[4];
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            System.out.println("Name,Author,Category,Available");

            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(",");
                if ((data[0].equalsIgnoreCase(name))) {
                    for (int i = 0; i < data.length; i++) {
                        System.out.print(data[i] + " ");

                    }
                    System.out.println("");
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("REACHEDEEEEE");
        }

    }

    static String clockin(String time) {
        System.out.println("Librarian Clocked in at " + time);
        return time;

    }

    static String clockout(String time) {
        System.out.println("Librarian Clocked out at " + time);
        return time;

    }

    public static boolean Login(String Username, String Password) {
        boolean correct = false;
        String fileName = "Users.txt";
        String currentLine;
        String data[];
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(",");
                if ((data[0].equalsIgnoreCase(Username))) {
                    if (data[1].equalsIgnoreCase(Password)) {
                        correct = true;
                    }
                }
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return correct;
    }

    public static void editP(String U, String OP, String NP) throws IOException {
        String x = U + "," + NP;
        String y = U + "," + OP;
        try {
            File file = new File("Users.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "", oldtext = "";
            while ((line = reader.readLine()) != null) {
                oldtext += line + "\r\n";
            }
            reader.close();
            // replace a word in a file
            //String newtext = oldtext.replaceAll("drink", "Love");

            //To replace a line in a file
            String newtext = oldtext.replaceAll(y, x);

            FileWriter writer = new FileWriter("Users.txt");
            writer.write(newtext);
            writer.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static void editMembership(String U, String P) throws IOException {
        int om = 30;
        int nm = om + 30;

        String x = U + "," + P + "," + nm;
        String y = U + "," + P + "," + om;
        try {
            File file = new File("Users.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "", oldtext = "";
            while ((line = reader.readLine()) != null) {
                oldtext += line + "\r\n";
            }
            reader.close();
            // replace a word in a file
            //String newtext = oldtext.replaceAll("drink", "Love");

            //To replace a line in a file
            String newtext = oldtext.replaceAll(y, x);

            FileWriter writer = new FileWriter("Users.txt");
            writer.write(newtext);
            writer.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static void searchCategory(String name) {

        String fileName = "books.txt";
        String currentLine;
        String data[];
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            System.out.println("Name,Author,Category,Available");
            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(",");
                if ((data[2].equalsIgnoreCase(name))) {
                    for (int i = 0; i < data.length; i++) {

                        System.out.print(data[i] + " ");

                    }
                    System.out.println("");
                }
            }

        } catch (Exception e) {
            System.out.println("REACHEDEEEEE");
        }

    }

}
