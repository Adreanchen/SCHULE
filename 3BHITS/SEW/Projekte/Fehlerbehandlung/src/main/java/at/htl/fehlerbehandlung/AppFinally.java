package at.htl.fehlerbehandlung;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Fehlerbehandlung mit finally
 */
public class AppFinally {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            String line;
            br = new BufferedReader(new FileReader("C:/temp/text.txt"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException fnfex) {
            System.out.println("FileNotFoundException");
        } catch (IOException ioex) {
            System.out.println("IOException");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ioex) {
                ioex.printStackTrace();
            }
        }
    }
}
