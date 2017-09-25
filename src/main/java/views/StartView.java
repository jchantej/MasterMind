package views;


import utils.LimitedIntDialog;

class StartView {

	void interact(){
		new LimitedIntDialog("1. Partida, 2. Demo", 1, 2).read();
        
    }
	 
}
