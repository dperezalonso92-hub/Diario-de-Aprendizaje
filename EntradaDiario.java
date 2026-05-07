import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
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
        return "\n--- Entradhjghgha " + fecha + " ---\n Aprendido: " + aprendido + 
               "\n Realizado: " + realizado + "\n Dificultades: " + dificultades + 
               "\n Herramientas: " + herramientas + "\n--------------------";
    }
}

