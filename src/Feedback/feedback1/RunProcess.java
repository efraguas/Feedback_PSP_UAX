package Feedback.feedback1;

import java.io.IOException;

public class RunProcess {
    /**
     * Método que ejecuta el archivo contenido en el parámetro
     * ruta y luego espera un tiempo de 5 segundos.
     * @param ruta String con la ruta del ejecutable
     */
    public void ejecutar(String ruta){
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(ruta);
            pb.start();
            System.out.println(ruta + " iniciada");
            Thread.sleep(5000);
        }catch (IOException | InterruptedException e) {
            System.out.println("Error en el proceso...");
            e.printStackTrace();
        }
    }



}
