package Feedback.feedback3.ejercicio2;
/*
Utilizar la clase DataInputStream y DataOutputStream

    2. Crea un programa cliente que introduzca por teclado un número entero y se lo envíe al servidor.
       El servidor le devolverá el cuadrado del número

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
            int datos = datosEntrada.readInt();
            System.out.println("Datos recibidos: " + datos);

            //Escribir respuesta al cliente
            OutputStream salida = cliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            System.out.println("Mandando respuesta al cliente...");
            flujoSalida.writeInt((int) Math.pow(datos, 2));

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
