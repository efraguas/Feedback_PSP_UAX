package Feedback.feedback3.ejercicio1;

import java.io.*;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try {
            int puerto = 5000;
            String host = "127.0.0.1";

            Socket cliente = new Socket(host, puerto);
            System.out.println("Programa Cliente conectado...");

            //Escribir mensaje al servidor
            OutputStream salida = cliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            System.out.println("Mandando mensaje al servidor:");
            flujoSalida.writeUTF("ESTE ES UN MENSAJE DE PRUEBA DEL FEEDBACK 3");

            //Leer mensaje del servidor
            InputStream entrada = cliente.getInputStream();
            DataInputStream datosEntrada = new DataInputStream(entrada);
            System.out.println("Respuesta del servidor: \n" + datosEntrada.readUTF());

            //Se cierra el recursos
            salida.close();
            flujoSalida.close();
            cliente.close();
        } catch (IOException e) {
            System.out.println("Fallo en la conoxion con el servidor");
            e.printStackTrace();
        }

    }


}
