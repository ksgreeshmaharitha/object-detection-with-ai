import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Scanner;
public class webpageDownloader { 
    @SuppressWarnings("deprecation")
    public static void downloadWebPage(String webpage) {
        try {
            URL url = new URL(webpage);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("Download.html"));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            reader.close();
            writer.close();
            System.out.println("Successfully Downloaded.");
        } catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised: " + mue.getMessage());
        } catch (IOException ie) {
            System.out.println("IOException raised: " + ie.getMessage());
        }
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the URL: ");
        String url = scanner.nextLine();
        downloadWebPage(url);
        scanner.close();
    }
}
