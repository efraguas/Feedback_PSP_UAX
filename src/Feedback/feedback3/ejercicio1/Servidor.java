package Feedback.feedback3.ejercicio1;
/*
Utilizar la clase DataInputStream y DataOutputStream

    1. Crea un programa servidor que envíe un mensaje a otro programa cliente y el programa cliente
       le devuelva el mensaje en minúscula
 */


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Puerto: " + servidor.getLocalPort() + " abierto...");
            System.out.println("Conexion establecia...");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado...");

            //Leer los datos enviados
            InputStream entrada = cliente.getInputStream();
            DataInputStream datosEntrada = new DataInputStream(entrada);
            System.out.println("Recibiendo datos de cliente: ");
            String mensaje = datosEntrada.readUTF();
            System.out.println(mensaje);

            //Escribir respuesta al cliente
            OutputStream salida = cliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            System.out.println("Mandando respuesta al cliente...");
            flujoSalida.writeUTF(mensaje.toLowerCase());

            //se cierra el recursos
            entrada.close();
            flujoSalida.close();
            salida.close();
            datosEntrada.close();
            cliente.close();
            servidor.close();

        } catch (IOException e) {
            System.out.println("Fallo en la conexion");
            e.printStackTrace();
        }

    }
}
