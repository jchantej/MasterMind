package models;

import utils.IO;

public class Board {

    private char[][] decodificador;
    private char[] decodificadorAux;
    private char[] codificador;
    boolean existeMarterMind = false;
    private Game game;
    int filaPivote=0;
    int contador=0;

    public Board() {
        decodificador = new char[6][8];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                decodificador[i][j] = '_';
            }
        }
        
    }
    
    public char[] getCodificador() {
        codificar();
        return this.codificador;
    }

    public void codificar() {
        this.codificador = new char[4];
        int colorGenerado;
        for (int i = 0; i < 4; i++) {

            colorGenerado = (int) (Math.random() * 4) + 1;
            switch (colorGenerado) {
            case 1:
                this.codificador[i] = 'A';
                break;
            case 2:
                this.codificador[i] = 'R';
                break;

            case 3:
                this.codificador[i] = 'V';
                break;

            case 4:
                this.codificador[i] = 'Z';
                break;

            default:
                break;
            }

        }

    }

    public void write() {
        IO io = new IO();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                io.write(this.decodificador[i][j] + " ");
            }
            io.writeln();
        }
    }
    
    
    public boolean existMasterMind(char[] codificadorAux) {
        return this.existMasterMind(codificadorAux, this.decodificadorAux);
    }
    public boolean existMasterMind(char[] codificado, char[] decodificado) {
        game = new Game();
        decodificadorAux = new char[4];
        
        for (int i = 0; i < decodificado.length; i++) {

            if (codificado[i] == decodificado[i]) {
                existeMarterMind = true;
            } else {
                existeMarterMind = false;
                i = decodificado.length;
               
            }
            if (!existeMarterMind) {
                
                decodificadorAux = game.verificarMuertosYHeridos(codificado, decodificado);
                
                for (int k = 0; k< 6; k++) {
                    for (int j = 0; j < 1; j++) {
                        if (decodificador[k][j] == '_') {
                        filaPivote = k;
                        k=6;
                      }
                    }
                }
                
                
                for (int k = 4; k < 8; k++) {
                    decodificador[filaPivote-1][k] = decodificadorAux[contador] ;
                    contador++;
                    
                }
                
                this.write();
            }
            
        }

        return existeMarterMind;
    }
    
    public void asignarColores() {
        game = new Game();

        decodificadorAux = new char[4];
        decodificadorAux = game.put();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 1; j++) {
                if (decodificador[i][j] == '_') {
                filaPivote = i;
                i=6;
              }
            }
        }
        
        for (int k = 0; k < decodificadorAux.length; k++) {
            decodificador[filaPivote][k] = decodificadorAux[k] ;
            
        }
        
       // this.write();

    }
}
