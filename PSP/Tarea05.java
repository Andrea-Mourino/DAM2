//* Crea un programa en Java que esté en bucle realizando lo siguiente:

//1. Pide por consola al usuario un comando y sus parámetros a ejecutar (si fuese necesario) (Por ejemplo, ls, gnome-text-editor, open...)
//2. Lanza el proceso y obtén el código de finalización del mismo.
//3. Muestra el nombre del programa y el código de finalización del mismo.
//
//El programa finaliza cuando un usuario introduce “salir” y devolverá un código de salida = 0. Prueba a introducir comandos y/o parámetros inexistentes y observa el código de finalización.


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Tarea05 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Porfavor ingrese aqui su comando (o 'salir' para terminar): ");
                String linea= reader.readLine();
                if (linea == null || linea.trim().equalsIgnoreCase("SALIR")) {
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                }
                String[] comando = linea.trim().split("\\s+");

                String nombrePrograma = comando [0];

                ProcessBuilder pb= new ProcessBuilder(comando);
                pb.inheritIO();
                Process proceso= pb.start();

                int codigoSalida = proceso.waitFor();
                System.out.println("Programa: " + nombrePrograma + " | Código de salida: " + codigoSalida);


            } catch (IOException e) {
                System.out.println("Error al ejecutar el comando: " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("El proceso fue interrumpido.");

            }
        }
    }
}
