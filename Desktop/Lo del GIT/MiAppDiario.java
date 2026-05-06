import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

// Clase para los datos del diario
class EntradaDiario implements Serializable {
    String fecha, aprendido, realizado, dificultades, herramientas;

    public EntradaDiario(String f, String a, String r, String d, String h) {
        this.fecha = f;
        this.aprendido = a;
        this.realizado = r;
        this.dificultades = d;
        this.herramientas = h;
    }

    @Override
    public String toString() {
        return "\n--- Entrada " + fecha + " ---\n Aprendido: " + aprendido + 
               "\n Realizado: " + realizado + "\n Dificultades: " + dificultades + 
               "\n Herramientas: " + herramientas + "\n--------------------";
    }
}

public class MiAppDiario {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- GESTIÓN DE APRENDIZAJE ---");
        System.out.println("1. Registro");
        System.out.println("2. Login");
        System.out.print("Elige una opción: ");
        
        try {
            int opcion = Integer.parseInt(sc.nextLine()); // Forma más segura de leer números

            if (opcion == 1) {
                registrarUsuario(sc);
            } else if (opcion == 2) {
                hacerLogin(sc);
            } else {
                System.out.println("Opción no válida.");
            }
        } catch (Exception e) {
            System.out.println("Error: Introduce un número válido.");
        }
    }

    public static void registrarUsuario(Scanner sc) {
        System.out.print("Introduce tu email: ");
        String email = sc.nextLine();
        System.out.print("Introduce tu contraseña: ");
        String password = sc.nextLine();

        try (FileWriter fw = new FileWriter("usuarios.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(email + "," + password);
            bw.newLine();
            System.out.println("¡Usuario guardado!");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }

    public static void hacerLogin(Scanner sc) {
        System.out.print("Email: ");
        String emailIntento = sc.nextLine();
        System.out.print("Password: ");
        String passIntento = sc.nextLine();

        boolean exito = false;
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(emailIntento) && datos[1].equals(passIntento)) {
                    exito = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error: No hay usuarios registrados aún.");
        }

        if (exito) {
            System.out.println("¡Login correcto!");
            menuDiario(sc);
        } else {
            System.out.println("Email o contraseña incorrectos.");
        }
    }

    public static void menuDiario(Scanner sc) {
        System.out.println("\n--- MI DIARIO DE APRENDIZAJE ---");
        System.out.print("Fecha: "); String f = sc.nextLine();
        System.out.print("Lo aprendido: "); String a = sc.nextLine();
        System.out.print("Lo realizado: "); String r = sc.nextLine();
        System.out.print("Dificultades: "); String d = sc.nextLine();
        System.out.print("Herramientas: "); String h = sc.nextLine();

        EntradaDiario nuevaEntrada = new EntradaDiario(f, a, r, d, h);

        // Guardar la entrada en un archivo de texto
        try (FileWriter fw = new FileWriter("diario.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(nuevaEntrada.toString());
            bw.newLine();
            System.out.println("¡Entrada guardada en diario.txt!");
        } catch (IOException e) {
            System.out.println("Error al guardar en el diario.");
        }
    }
}