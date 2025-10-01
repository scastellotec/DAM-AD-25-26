package BufferedReader_Writer;

import java.io.*;
import java.util.Scanner;

public class Ejercicio46 {
    public static void main(String[] args) throws IOException {

        // Abro los buffers que necesito
        Scanner br1 = new Scanner(new FileReader("fusion1.txt"));
        Scanner br2 = new Scanner(new FileReader("fusion2.txt"));
        BufferedWriter bw = new BufferedWriter(new PrintWriter("fusion3.txt"));

        while(br1.hasNextLine()||br2.hasNextLine()){
            if(br1.hasNextLine()){
                bw.write(br1.nextLine());
                bw.newLine();
            }
            if(br2.hasNextLine()){
                bw.write(br2.nextLine());
                bw.newLine();
            }
        }

        br1.close();
        br2.close();
        bw.close();
    }
}
