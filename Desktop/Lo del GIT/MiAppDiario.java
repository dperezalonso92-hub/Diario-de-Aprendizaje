import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        return "\n--- Entrada " + fecha + " ---\nAprendido: " + aprendido + "\n--Realizado: " + realizado;
    }
}

public class MiAppDiario {
    
    private static Map<String, String> usuarios = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("¡Bienvenido al Gestor de Aprendizaje!");
        
    }
}