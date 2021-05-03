package Pruebas;

import javax.swing.JButton;

import Control.Marcadas;
import Modelo.Rejilla;

public class Pantalla {
	public static void mostrarTableroPantalla(int posx, int posy, Rejilla rejilla,JButton botonera[][]){
		System.out.println("Minas");
		System.out.println();
		for (int j = 0; j < botonera.length; j++) {
			for (int j2 = 0; j2 < botonera[j].length; j2++) {
				System.out.print(rejilla.getTablero()[j][j2].isMina()+"\t");
			}
			System.out.println();
		}
		System.out.println("Marcadas");
		System.out.println();
		for (int j = 0; j < botonera.length; j++) {
			for (int j2 = 0; j2 < botonera[j].length; j2++) {
				System.out.print(rejilla.getTablero()[j][j2].isMarcada()+"\t");
			}
			System.out.println();
		}
		
		System.out.println("Minas alrededor");
		System.out.println();
		for (int i = 0; i < rejilla.getTablero().length; i++) {
			for (int j = 0; j < rejilla.getTablero()[i].length; j++) {
				System.out.print(rejilla.getTablero()[i][j].getMinasAlrededor()+"\t");
			}
			System.out.println();
		}
		
		System.out.println("Casillas veladas");
		System.out.println();
		for (int j = 0; j < botonera.length; j++) {
			for (int j2 = 0; j2 < botonera[j].length; j2++) {
				System.out.print(rejilla.getTablero()[j][j2].isVelada()+"\t");
			}
			System.out.println();
		}
		System.out.println(posy+" "+posx);
		System.out.println(Marcadas.comprobarMarcadas(rejilla, posy, posx));
	}
	
}
