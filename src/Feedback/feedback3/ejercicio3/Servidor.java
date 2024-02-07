package Feedback.feedback3.ejercicio3;
/*
Utilizar la clase DataInputStream y DataOutputStream
    3. Crea un programa con un objeto rectángulo que tenga implementado
       el método del área y del perímetro. Además, incluirá los atributos área y perímetro (los dejamos inicializados a 0.0).

       El objeto se va a enviar del cliente al servidor, el servidor realizará la operación de área y perímetro
       y lo meterá en los atributos anteriores (setter's con los métodos)
       Posteriormente se le devolverá el objeto y el cliente mostrará el valor de esos atributos. (getter's)
 */


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {

        try {
            int puerto = 5000;

            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Puerto: " + servidor.getLocalPort() + " abierto...");
            System.out.println("Conexion establecia...");
            Socket cliente = servidor.accept();
            Socket cliente2 = servidor.accept();
            System.out.println("Cliente1 conectado...");
            System.out.println("Cliente2 conectado...");

            //Leer los datos enviados
            ObjectInputStream objetoEntrada = new ObjectInputStream(cliente.getInputStream());
            Rectangulo rectangulo = (Rectangulo) objetoEntrada.readObject();
            System.out.println("Recibiendo objeto del cliente...");
            System.out.println("objeto recibido:\n" + rectangulo.toString());
            System.out.println("calculando...");

            ObjectInputStream objetoEntrada2 = new ObjectInputStream(cliente2.getInputStream());
            Rectangulo rectangulo2 = (Rectangulo) objetoEntrada2.readObject();
            System.out.println("Recibiendo objeto del cliente2...");
            System.out.println("objeto recibido:\n" + rectangulo2.toString());
            System.out.println("calculando...");



            //Escribir respuesta al cliente
            rectangulo.setArea(500.0);
            rectangulo.setPerimetro(200.0);
            ObjectOutputStream objetoSalida = new ObjectOutputStream(cliente.getOutputStream());
            objetoSalida.writeObject(rectangulo);
            System.out.println("Mandando mensaje al cliente...");
            rectangulo2.setArea(5000.0);
            rectangulo2.setPerimetro(2000.0);
            ObjectOutputStream objetoSalida2 = new ObjectOutputStream(cliente2.getOutputStream());
            objetoSalida.writeObject(rectangulo2);
            System.out.println("Mandando mensaje al cliente2...");



            //se cierra el recursos
            objetoSalida.close();
            objetoEntrada.close();
            cliente.close();
            servidor.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Fallo en la conexion");
            e.printStackTrace();
        }

    }
}
