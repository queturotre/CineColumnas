import java.util.Scanner;

public class Main {
    public static void main (String args[]){
        Scanner miguel = new Scanner(System.in);
        char[][] sala = new char [5][5]; // La sala de cine es una matriz.
        int puestosTotales = sala.length * sala[0].length;
        int filas = 0;
        int columnas = 0;
        int puestosPorTurno;
        int tarjeta;
        int estandar = 7000, preferencial = 9000;
        double total = 0; // Total máximo.

        for (int i = 0; i < sala.length; i++){
            for (int j = 0; j < sala[1].length; j++){
                sala[i][j] = 'O'; // Se rellena la matriz con caracteres O
            }
        }

        while (puestosTotales > 0){
            double totalPorReserva = 0; // Total por reserva.
            System.out.println("La sala está así, pantalla arriba:\nX = Ocupado.\nO = Vacío.\n");
            for (int i = 0; i < sala.length; i++){
                for (int j = 0; j < sala[1].length; j++){
                    System.out.print("["+sala[i][j]+"] "); // Se imprime la matriz, muestra qué puestos están vacíos y llenos.
                }
                System.out.println();
            }

            do{
                System.out.print("\n¿Cuántos puestos deseas? ");
                puestosPorTurno = miguel.nextInt();
                if (puestosPorTurno < 1 || puestosPorTurno > puestosTotales){
                    System.out.println("No puedes elegir esa cantidad de puestos. ");
                }
            }while(puestosPorTurno < 1 || puestosPorTurno > puestosTotales);

            for (int z = 1; z <= puestosPorTurno; z++){ // Ciclo que termina en la cantidad de puestos elegidos.
                do{
                    System.out.println(z+") ¿Qué puesto deseas?\nIngresa la fila");
                    filas = miguel.nextInt();
                    System.out.println("Ingresa la columna");
                    columnas = miguel.nextInt();

                    if (filas > sala.length || columnas > sala[0].length || filas < 1 || columnas < 1 || sala[filas-1][columnas-1] == 'X') {
                        System.out.println("Ese puesto no puede ser reservado.\n");
                    }
                }while(filas > sala.length || columnas > sala[0].length || filas < 1 || columnas < 1 || sala[filas-1][columnas-1] == 'X');

                for (int i = 0; i < sala.length; i++){
                    for (int j = 0; j < sala[1].length; j++){
                        sala[filas-1][columnas-1] = 'X'; // Rellenamos el puesto deseado con X.
                    }
                }
                puestosTotales--;
                System.out.println("Tu puesto ha sido reservado.\n");

                if (sala.length < 5 || filas < sala.length-1){
                    totalPorReserva += estandar; // La silla es una estándar de 7000 pesos
                } else {
                    totalPorReserva += preferencial; // La silla es una preferencial de 9000 pesos
                }
            }

            do{
                System.out.print("¿Utilizas Tarjeta Cinecolumnas? 1) Sí 2) No. ");
                tarjeta = miguel.nextInt();
                if (tarjeta == 1){
                    totalPorReserva -= (totalPorReserva * 0.1); // Rebaja del 10%
                }
            }while(tarjeta != 1 && tarjeta != 2);

            System.out. println("El costo de la reserva es: $"+totalPorReserva+"\n");
            total += totalPorReserva;

            System.out.println("Gracias por utilizar nuestros servicios.\n\n ");
            System.out.println("¿Cuántos puestos quedan?"+puestosTotales);
        }

        System.out.println("Esta sala está llena. ");
        for (int i = 0; i < sala.length; i++){
            for (int j = 0; j < sala[1].length; j++){
                System.out.print("["+sala[i][j]+"] ");
            }
            System.out.println();
        }
        System.out.println("Total recaudado: $"+total);
    }
}
/*
 * Hecho por Ricardo García tras entender que esto es lo que hubiera tenido que entregarle a la profe Mireya en segundo semestre de haber entendido programación en ese entonces
 */
