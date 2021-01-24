import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
public class FileAssignment3{
public static String capitalizeWord(String str){  
    String words[]=str.split("\\s");  
    String capitalizeWord="";  
    for(String w:words){  
        String first=w.substring(0,1);  
        String afterfirst=w.substring(1);  
        capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
    }  
    return capitalizeWord.trim();  
} 
  public static void main(String[] arguments) {

    try {
	String content = new String(Files.readAllBytes(Paths.get("a.txt")), StandardCharsets.UTF_8);
System.out.println(capitalizeWord(content));
Files.write( Paths.get("a.txt"), capitalizeWord(content).getBytes());
    } catch (IOException | SecurityException se) {
      System.out.println("Error -- " + se.toString());
    }
  }
}