package Pruebas;

import Control.Contiguas;
import Control.MinasAlrededor;
import Control.MinasTablero;
import Modelo.Minas;
import Modelo.Rejilla;
import Modelo.Tablero;

public class Prueba {
public static void main(String[] args) {
	Minas minas=new Minas();
	Tablero tablero=new Tablero();
	MinasTablero minasTablero=new MinasTablero();
	Rejilla unTablero=tablero.crearTablero(10);
	MinasAlrededor minasAlrededor=new MinasAlrededor();
	Contiguas contiguas=new Contiguas();
	
	
	int numeroMinas=minas.nivelDificultad(0);
	unTablero=minasTablero.colocarMinas(numeroMinas, unTablero);
	
	
	int comprobarMinas=0;
	
	for (int i = 0; i < unTablero.getTablero().length; i++) {
		for (int j = 0; j <unTablero.getTablero()[i].length; j++) {
			if(unTablero.getTablero()[i][j].isMina()){
				comprobarMinas++;
			}		
		}		
	}
	for (int i = 0; i < unTablero.getTablero().length; i++) {
		for (int j = 0; j < unTablero.getTablero()[i].length; j++) {
			System.out.print(unTablero.getTablero()[i][j].isMina()+"\t");
		}
		System.out.println();
	}
	System.out.println(comprobarMinas);
	
	unTablero=minasAlrededor.contarMinasAlrededro(unTablero);
	
	for (int i = 0; i < unTablero.getTablero().length; i++) {
		for (int j = 0; j < unTablero.getTablero()[i].length; j++) {
			System.out.print(unTablero.getTablero()[i][j].getMinasAlrededor()+"\t");
		}
		System.out.println();
	}
	
	unTablero=contiguas.desvelarContigua(unTablero, 0, 0, true);
	
	for (int i = 0; i < unTablero.getTablero().length; i++) {
		for (int j = 0; j < unTablero.getTablero()[i].length; j++) {
			System.out.print(unTablero.getTablero()[i][j].isVelada()+"\t");
		}
		System.out.println();
	}

}
}
