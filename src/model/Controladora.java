package model;

import java.util.Random;

public class Controladora {

    private String[][] tableroTresEnRaya;

    /**
     * Constructor de la clase Controladora para inicializar
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controladora 
     */
    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero con valores vacíos.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    /**
     * Devuelve el tablero en formato String.
     */
    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }

    /**
     * Realiza una jugada aleatoria para la máquina.
     */
    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
    }

    /**
     * Realiza la jugada del usuario
     * Verifica primero si la posicion ya está ocupada
     * @param fila la fila elegida por el usuario
     * @param columna la columna elegida por el usuario
     * @return Un string con el mensaje si se pudo guardar el movimiento o no
     */
    public String jugadaUsuario(int fila, int columna) {
        if(tableroTresEnRaya[fila][columna] == "X" || tableroTresEnRaya[fila][columna] == "O") {
            return "El campo ya se encuentra ocupado";
        } else {
            tableroTresEnRaya[fila][columna] = "O";
        }
        return "Jugada realizada con éxito";
    }

    public String verificarJugada() {

        String mensaje = "No hay ningun ganador todavía"; // mensaje predeterminado

        // verificar rayas horizontales
        for(int i = 0; i < 3; i++) {
            int contadorHumano = 0;
            int contadorMaquina = 0;
            for(int j = 0; j < 3; j++) {
                if(tableroTresEnRaya[j][i] == "O"){
                    contadorHumano ++;
                } else if(tableroTresEnRaya[j][i] == "X"){
                    contadorMaquina ++;
                }
            }
            if(contadorHumano == 3) {
                mensaje = "El jugador humano ha ganado";
            } else if(contadorMaquina == 3) {
                mensaje = "La maquina ha ganado";
            }
        }
        // verificar rayas verticales
        for(int i = 0; i < 3; i++) {
            int contadorHumano = 0;
            int contadorMaquina = 0;
            for(int j = 0; j < 3; j++) {
                if(tableroTresEnRaya[i][j] == "O"){
                    contadorHumano ++;
                } else if(tableroTresEnRaya[i][j] == "X"){
                   contadorMaquina ++;
                }
            }
            
            if(contadorHumano == 3) {
                mensaje = "El jugador humano ha ganado";
            } else if(contadorMaquina == 3) {
                mensaje = "La maquina ha ganado";
            }
        }
        // verificar rayas diagonales
        for(int i = 0; i < 3; i++) {
            // verificar diagonal de izquierda a derecha
            if (tableroTresEnRaya[0][0] == "O" && tableroTresEnRaya[1][1] == "O" && tableroTresEnRaya[2][2] == "O"){
                mensaje = "El jugador humano ha ganado";
            } else if(tableroTresEnRaya[0][0] == "X" && tableroTresEnRaya[1][1] == "X" && tableroTresEnRaya[2][2] == "X"){
                mensaje = "La maquina ha ganado";
            }
            // verificar diagonal de derecha a izquierda
            if(tableroTresEnRaya[0][2] == "X" && tableroTresEnRaya[1][1] == "X" && tableroTresEnRaya[2][0] == "X"){
                mensaje = "La maquina ha ganado";
            } else if(tableroTresEnRaya[0][2] == "O" && tableroTresEnRaya[1][1] == "O" && tableroTresEnRaya[2][0] == "O"){
                mensaje = "El jugador humano ha ganado";
            }
        }
        return mensaje;
    }
}