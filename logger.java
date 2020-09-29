
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;

public class Logger {

     public static void addlog(String log) throws IOException{
        
        File logs = new File("logs.txt");
        String temp=log;
        BufferedReader reader;
			reader = new BufferedReader(new FileReader("logs.txt"));
			String line = reader.readLine();
			while (line != null) {
				temp=temp+"\r\n"+line;
				line = reader.readLine();
			}

			reader.close();
        PrintWriter writer = new PrintWriter("logs.txt");
        writer.write(temp);
        writer.close();
    }


    
    static void openLog(){
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe","logs.txt");
        try {
            pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
