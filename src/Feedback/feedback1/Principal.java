package Feedback.feedback1;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            String ruta = teclado.nextLine();



            //instancias
            ProcessBuilder pb = new ProcessBuilder("\"C:\\\\Program Files\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe\"");
            pb.start();





            System.out.println("\"C:\\\\Program Files\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe\"" + " iniciada");
            Thread.sleep(5000);
            pb = new ProcessBuilder("C:\\Program Files\\Adobe\\Acrobat DC\\Acrobat\\Acrobat.exe");
            pb.start();
            System.out.println("C:\\Program Files\\Adobe\\Acrobat DC\\Acrobat\\Acrobat.exe" + " iniciada");
            Thread.sleep(5000);


        }catch (IOException | InterruptedException e) {
            System.out.println("Error en el proceso...");
            e.printStackTrace();
        }
    }

}
