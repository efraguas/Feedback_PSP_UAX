package Feedback.feedback4;


import org.apache.commons.net.ftp.FTPClient;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Principal {

    public static void main(String[] args) throws IOException {

        String usuario = "efraguas";
        String password = "fraguas";
        String hostname = "192.168.56.1";

        //Conectare al servido
        FTPClient cliente = new FTPClient();
        cliente.connect(hostname,21);
        System.out.println("Programa Cliente conectado...");
        System.out.println("Introduzca Usuario y password:");
        //imprimir mensahje de respuesta del servidor"
        System.out.println(cliente.getReplyString());
        //imprimir el codigo devuelto por el cliente FTP
        System.out.println(cliente.getReplyCode());
        cliente.login(usuario,password);
        System.out.println("Correcto, logged in...");

        //Establecer el tipo de fichero
        cliente.setFileType(FTPClient.BINARY_FILE_TYPE);

        //Inicializar el objeto JFileChooser para podeder explorar los archivos
        JFileChooser jFile = new JFileChooser();

        int selector = jFile.showOpenDialog(jFile);

        //Controlar el flujo:
        if(selector == JFileChooser.APPROVE_OPTION){
            //recoger el seleccionado
            File seleccionado = jFile.getSelectedFile();
            String nombre = seleccionado.getName();
            InputStream flujooEntrada = new FileInputStream(seleccionado);
            //guradarlo en el servidor
            cliente.storeFile("/" + nombre, flujooEntrada);
            System.out.println("Archivo" + seleccionado.getName() + " subido en el servidor...");
            flujooEntrada.close();
        }

        //Salida y cerrar recursos
        System.out.println("Desconectado...");
        cliente.logout();
        cliente.disconnect();







    }
}
