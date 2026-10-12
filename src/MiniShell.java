import java.io.IOException;
import java.util.Scanner;

public class MiniShell {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduzca el primer programa que quiere ejecutar: ");
        String programa1=sc.nextLine();
        System.out.println("Introduzca el segundo programa que quiere ejecutar: ");
        String programa2=sc.nextLine();

        ProcessBuilder pb1= new ProcessBuilder("cmd","/c",programa1);
        ProcessBuilder pb2=new ProcessBuilder("cmd","/c",programa2);

        try{
            Process p1= pb1.start();
            Process p2= pb2.start();
            ProcessHandle handle1= p1.toHandle();
            ProcessHandle handle2=p2.toHandle();

            System.out.println("PID: "+ handle1.pid());
            System.out.println("Esta activo: "+handle1.isAlive());
            System.out.println("PID: "+ handle2.pid());
            System.out.println("Esta activo: "+ handle2.isAlive());
            int cod1= p1.waitFor();
            int cod2= p2.waitFor();

            if(cod1== 0){
                System.out.println("El primer proceso finalizo con exito ");
            }else {
                System.out.println("El primer proceso no finalizo correctamente");
            }
            if(cod2== 0){
                System.out.println("El segundo proceso finalizo con exito ");
            }else {
                System.out.println("El segundo proceso no finalizo correctamente");
            }

        } catch (IOException e) {
            System.out.println("Error al iniciar el proceso");
        } catch (InterruptedException e) {
            System.out.println("Error durante la ejecuccion del proceso");
        }

    }
}
