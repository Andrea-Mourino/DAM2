

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Tarea03 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido");
        System.out.println("Pasame el nombre del editor");

        String procesadortxt = sc.nextLine();
        System.out.println("Pasame la ruta del archivo");

        String rutatxt = sc.nextLine();

        String[] comando = {procesadortxt, rutatxt};
        ProcessBuilder pb = new ProcessBuilder(comando);

    }
}