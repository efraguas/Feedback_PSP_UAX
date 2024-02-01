package Feedback.feedback2;
/*
Realiza un programa que realice la suma de varios sumatorios y lo divida entre 3, por ejemplo:

Sumatorio de 23: 23+22+21+20+....+1
Sumatorio de 13: 13+12+11+10+...+1
Sumatorio de 15: 15+14+13+12+....+1
Cuando acaben estas operaciones (se realizarán a la vez gracias a los hilos) se realizará la suma y la división entre 3

 */
public class Main {

    public static void main(String[] args) {

        //Instancio la clase suma con valores 23, 13, 15 de los que se calcularan los sumatorios
        Suma sumatorio23 = new Suma(23);
        Suma sumatorio13 = new Suma(13);
        Suma sumatorio15 = new Suma(15);

        //Inicio los hilos de los tres sumatorios creados, cada instancia comienza en un hilo separado
        // (for del método run sobrescrito) es el que efectuará el sumatorio de cada instancia de la clase Suma
        sumatorio23.start();
        sumatorio13.start();
        sumatorio15.start();

        //llamo al método join para sincronizar los hilos y esperar a que se efectúen los sumatorios antes de realizar
        //la suma total y la media
        //lo metemos dentro de try catch para gestionar la excepción InterruptedException que lanza el método

        try{
            sumatorio23.join();
            sumatorio13.join();
            sumatorio15.join();

        //Calculo de los totales y media

            double total = Suma.getTotales(sumatorio23.getResultado(),sumatorio13.getResultado(),sumatorio15.getResultado());
            double avg = Suma.media(3,sumatorio23.getResultado(),sumatorio13.getResultado(),sumatorio15.getResultado());
            String sumaTotal = String.format("Total: %19.0f",total);
            String media = String.format("Media:%20.1f",avg);
            String total23 = sumatorio23.toString();
            String total13 = sumatorio13.toString();
            String total15 = sumatorio15.toString();

            //Salida formateada con el método format
            Suma.format(total23,total13,total15,sumaTotal,media);

        }catch (InterruptedException e) {
            System.out.println("Programa interrumpido...");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
