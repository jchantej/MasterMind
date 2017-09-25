package utils;

import utils.IO;

public class Coordinate {

    private char value;

    public char read() {
        IO io = new IO();
        value = io.readChar("Escoja Color: A=Amarillo R=Rojo V=Verde Z=Azul");
        return value;
    }

}
