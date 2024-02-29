package Feedback.feedback1;

import java.io.IOException;
import java.util.Scanner;

public class Examen {
    public static void main(String[] args) {
        try {
            String chrome = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            String acrobat = "C:\\Program Files\\Adobe\\Acrobat DC\\Acrobat\\Acrobat.exe";
            String seleccion = "";
            Scanner teclado = new Scanner(System.in);
            System.out.println("Seleccione que programa desea iniciar (Chrome, Acrobat): ");
            while (!seleccion.equalsIgnoreCase("chrome") && !seleccion.equalsIgnoreCase("acrobat")){
                System.out.println("Seleccion invalida teclee un programa correcto:");
                seleccion = teclado.nextLine();
            }
            //instancias
            if(seleccion.equalsIgnoreCase("chrome")){
                ProcessBuilder pb = new ProcessBuilder(chrome);
                pb.start();
                System.out.println(chrome + " iniciado");
            }else{
                ProcessBuilder pb  = new ProcessBuilder(acrobat);
                pb.start();
                System.out.println(acrobat + " iniciada");
                Thread.sleep(5000);
            }
        }catch (IOException | InterruptedException e) {
            System.out.println("Error en el proceso...");
            e.printStackTrace();
        }
    }

}
