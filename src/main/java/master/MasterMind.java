package master;

import views.ConsoleView;
import models.Board;
import models.Game;
import utils.IO;;

public class MasterMind {
    IO io = new IO();

    private Board board;
    private Game game;
    
    public void play(){
        new ConsoleView();
        char[] codificador = board.getCodificador();
        board.write();
        codificador = board.getCodificador();
        for (int i = 0; i < 4; i++) {
            io.write(codificador[i] + " ");
        }
        io.writeln();
        
        do {
            
            board.asignarColores();
        
        } while(!board.existMasterMind(codificador));
        
        game.win();
     }
     
    
    public MasterMind() {
        board = new Board();
        game = new Game();
    }
	public static void main(String[] args) {
 
	  
	  new MasterMind().play();
	}
}
