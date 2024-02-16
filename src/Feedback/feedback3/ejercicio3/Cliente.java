package Feedback.feedback3.ejercicio3;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {

        int puerto = 5000;
        String host = "127.0.0.1";

        try {
            Socket cliente;
            cliente = new Socket(host, puerto);
            System.out.println("Programa Cliente conectado...");

            //Escribir mensaje al servidor
            Rectangulo rectangulo = new Rectangulo();
            ObjectOutputStream objetoSalida = new ObjectOutputStream(cliente.getOutputStream());
            System.out.println("Mandando mensaje al servidor...");
            objetoSalida.writeObject(rectangulo);

            //Leer mensaje del servidor
            ObjectInputStream objetoEntrada = new ObjectInputStream(cliente.getInputStream());
            System.out.println("Respuesta del servidor");
            Rectangulo rectanguloServer = (Rectangulo) objetoEntrada.readObject();
            System.out.println(rectanguloServer.toString());

            //Se cierra el recursos
            objetoEntrada.close();
            objetoSalida.close();
            cliente.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Fallo en la conoxion con el servidor");
            e.printStackTrace();
        }

    }
}
