package Feedback.feedback1;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Creo un ArrayList con todas las rutas
        ArrayList<String> rutas = new ArrayList<>();
        rutas.add("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        rutas.add("C:\\Program Files\\Microsoft Office\\root\\Office16\\POWERPNT.EXE");
        rutas.add("C:\\Program Files (x86)\\Windows Media Player\\wmplayer.exe");
        rutas.add("C:\\Program Files\\Adobe\\Acrobat DC\\Acrobat\\Acrobat.exe");
        rutas.add("C:\\Program Files\\MySQL\\MySQL Workbench 8.0\\MySQLWorkbench.exe");

        //Instanciamos la clase RunProcess
        RunProcess process = new RunProcess();

        //Creo un foreach y ejecutamos el método ejecutar
        //en cada iteración cojera como parámetro la ruta de cada posición del Arraylist
        for(String ruta : rutas){
            System.out.println("Abriendo proceso: " + ruta);
            process.ejecutar(ruta);
        }
        System.out.println("Finalizado");
    }
}