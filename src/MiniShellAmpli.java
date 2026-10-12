import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MiniShellAmpli {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean salir=false;

        ArrayList<String> programas= new ArrayList<>();
        ArrayList<Process> listaProcesos = new ArrayList<>();
        while (!salir){
            System.out.println("Desea introducir un proframa; S/N");
            String resp= sc.nextLine();
            if(resp.equalsIgnoreCase("s")){
                System.out.println("Introduzca el nombre de programa que quiere ejecutar: ");
                String programa=sc.nextLine();
                programas.add(programa);

            }else {
                salir=true;
             }
        }
        try{
            for (String p :programas){
                ProcessBuilder pb= new ProcessBuilder("cmd","/c",p);
                Process p1= pb.start();
                listaProcesos.add(p1);
                 }

            for (Process p:listaProcesos){
                ProcessHandle handle1= p.toHandle();
                System.out.println("PID: "+ handle1.pid());
                System.out.println("Esta activo: "+handle1.isAlive());
                int cod1= p.waitFor();
                System.out.println("El codigo de salida es "+cod1);
                 }
             }catch (IOException e) {
            System.out.println("Error al iniciar el proceso");
             } catch (InterruptedException e) {
            System.out.println("Error durante la ejecuccion del proceso");
          }
    }

}
