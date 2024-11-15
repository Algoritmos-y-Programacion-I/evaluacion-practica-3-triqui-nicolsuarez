package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {

        flag = false;

        while (!flag) {

            System.out.println("\n\nBienvenido al menu:\n");
            System.out.println("Opciones:\n" + "1. Imprimir tablero \n" + "2. Jugada de la máquina \n"
                    + "3. Jugada de humano \n" + "4. Verificar ganador \n" + "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.exit(0);
                    break;
                default:
                    System.out.print("Por favor ingrese una opcion valida");
                    continue;
            }

        }

    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La máquina ha realizado su jugada.");
        imprimirTablero();
    }

    private void jugadaHumano() {

        boolean flag = false;
        do {
            System.out.print("Ingrese la fila donde quiere colocar la pieza (0-2): ");
            int filaOpcion = reader.nextInt();

            if(filaOpcion >= 0 && filaOpcion <= 2) {
    
                System.out.print("Ingrese la columna donde quiere colocar la pieza (0-2): ");
                int columnaOpcion = reader.nextInt();

                if(columnaOpcion >= 0 && columnaOpcion <= 2) {
                    System.out.println(cont.jugadaUsuario(filaOpcion,columnaOpcion));
                    flag = true;
                } else {
                    System.out.println("Ingrese una columna valida");
                    continue;
                }

            } else {
                System.out.println("Ingrese una fila valida");
            }
        } while (!flag); 
    }

    private void validarGanador() {
        /*
         * ¿que hay que hacer?
         * Validar si en el tablero actual, ya existe un ganador, 
         * ya sea que hayan hecho tres en raya en alguna columna, fila o diagonal. 
         * En caso de haber ganador, decir si fue la máquina (tres X seguidas en fila, columna o diagonal) 
         * o el jugador humano (tres O seguidas en fila, columna o diagonal).
         */
        System.out.println(cont.verificarJugada());
    }
}