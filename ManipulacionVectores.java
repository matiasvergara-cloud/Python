import java.util.Scanner;

public class ManipulacionVectores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vector = new int[15];
        // Commit 2: Búsqueda y máximos/mínimos
        // ==========================================
        // 1. Crear y llenar el vector (10 a 100)
        // ==========================================
        System.out.println("--- LLENADO DEL VECTOR ---");
        for (int i = 0; i < 15; i++) {
            int numero;
            do {
                System.out.print("Ingrese el valor para la posición " + i + " (entre 10 y 100): ");
                numero = scanner.nextInt();
                if (numero < 10 || numero > 100) {
                    System.out.println("¡Error! El número está fuera del rango. Intente de nuevo.");
                }
            } while (numero < 10 || numero > 100);
            vector[i] = numero;
        }

        System.out.println("\n--- VECTOR LLENADO ---");
        for (int i = 0; i < 15; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();

        // ==========================================
        // 2. Buscar un valor en el vector
        // ==========================================
        System.out.println("\n--- BÚSQUEDA DE VALOR ---");
        System.out.print("Ingrese un número a buscar en el vector: ");
        int buscar = scanner.nextInt();
        
        boolean encontrado = false;
        for (int i = 0; i < 15; i++) {
            if (vector[i] == buscar) {
                System.out.println("¡Número encontrado! Está en la posición (índice): " + i);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("El número " + buscar + " no se encuentra en el vector.");
        }

        // ==========================================
        // 3. Determinar Mayor y Menor
        // ==========================================
        System.out.println("\n--- MAYOR Y MENOR ---");
        int mayor = vector[0];
        int menor = vector[0];

        for (int i = 1; i < 15; i++) {
            if (vector[i] > mayor) {
                mayor = vector[i];
            }
            if (vector[i] < menor) {
                menor = vector[i];
            }
        }
        System.out.println("El número mayor es: " + mayor);
        System.out.println("El número menor es: " + menor);

        // ==========================================
        // 4. Identificar Múltiplos de X
        // ==========================================
        System.out.println("\n--- MÚLTIPLOS DE X ---");
        System.out.print("Ingrese un número X para buscar sus múltiplos: ");
        int x = scanner.nextInt();
        
        boolean hayMultiplos = false;
        System.out.println("Los múltiplos de " + x + " en el vector son:");
        for (int i = 0; i < 15; i++) {
            if (vector[i] % x == 0) {
                System.out.print(vector[i] + " ");
                hayMultiplos = true;
            }
        }
        if (!hayMultiplos) {
            System.out.println("No hay múltiplos de " + x + " en el vector.");
        }
        System.out.println();

        // ==========================================
        // 5. Calcular la Suma
        // ==========================================
        System.out.println("\n--- SUMA TOTAL ---");
        int suma = 0;
        for (int i = 0; i < 15; i++) {
            suma += vector[i];
        }
        System.out.println("La suma de todos los valores es: " + suma);

        // ==========================================
        // 6. Promedio y Nuevo Vector (Mayores al promedio)
        // ==========================================
        System.out.println("\n--- PROMEDIO Y NUEVO VECTOR ---");
        double promedio = (double) suma / 15; 
        System.out.println("El promedio es: " + promedio);

        int contador = 0;
        for (int i = 0; i < 15; i++) {
            if (vector[i] > promedio) {
                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("No hay números mayores que el promedio en el vector.");
        } else {
            int[] nuevoVector = new int[contador];
            int indiceNuevo = 0;
            
            for (int i = 0; i < 15; i++) {
                if (vector[i] > promedio) {
                    nuevoVector[indiceNuevo] = vector[i];
                    indiceNuevo++;
                }
            }

            System.out.println("Números por encima del promedio (" + contador + " en total):");
            for (int i = 0; i < nuevoVector.length; i++) {
                System.out.print(nuevoVector[i] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}