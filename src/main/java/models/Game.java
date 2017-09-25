package models;

import models.Coordinate;
import utils.IO;

public class Game {

    int totalIngresos = 4;

    private char[] decodicador;

    private char[] decodicadorAux = {'_', '_', '_', '_'};

    private char[] muertosYHeridos = {'_', '_', '_', '_'};


    public char[] put() {
        decodicador = new char[4];
        Coordinate target = new Coordinate();
        for (int i = 0; i < decodicador.length; i++) {
            decodicador[i] = target.read();
        }

        return decodicador;

    }

    public char[] verificarMuertos(char[] codificador, char[] decodificador) {

        return null;

    }

    public char[] verificarMuertosYHeridos(char[] codificado, char[] decodificado) {
        muertosYHeridos = new char[4];
        int contador = 0;

        for (int i = 0; i < codificado.length; i++) {

            for (int j = 0; j < decodificado.length; j++) {

                if (codificado[i] == decodificado[j] && i == j) {
                    decodicadorAux[contador] = decodificado[j];
                    muertosYHeridos[contador] = 'N';
          
                    contador++;

                } else {
                    if (codificado[i] == decodificado[j]) {
                        decodicadorAux[contador] = decodificado[j];
                        muertosYHeridos[contador] = 'B';
                        contador++;
                    }

                }
            }

        }

        return muertosYHeridos;
    }

    public void win() {
        new IO().writeln("Victoria!!!! ");
    }

}
