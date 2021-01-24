
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileAssignment1{
  public static void main(String[] arguments) {
    String sourceName = "a.txt";
    try {
	System.out.println("File Assignemnt");
      Path source = FileSystems.getDefault().getPath(sourceName);
      Path temp = FileSystems.getDefault().getPath("tmp_" + sourceName);

      // Create input stream
      FileReader fr = new FileReader(source.toFile());
      BufferedReader in = new BufferedReader(fr);

      // Create output stream
      FileWriter fw = new FileWriter(temp.toFile());
      BufferedWriter out = new BufferedWriter(fw);

      boolean eof = false;
      int inChar;
      do {
        inChar = in.read();
        if (inChar != -1) {
          char outChar = Character.toUpperCase((char) inChar);
          out.write(outChar);
        } else
          eof = true;
      } while (!eof);
      in.close();
      out.close();

      Files.delete(source);
      Files.move(temp, source);
    } catch (IOException | SecurityException se) {
      System.out.println("Error -- " + se.toString());
    }
  }
}