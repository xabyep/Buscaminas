package Control;

import Modelo.Rejilla;

public class MinasTablero {
	
	public static Rejilla colocarMinas(int minas, Rejilla tablero) {
		
		for (int i = 0; i < minas; i++) {
			int filas = (int) ((Math.random() * (tablero.getTablero()[0].length)));
			int columnas = (int) ((Math.random() * (tablero.getTablero().length)));
			if ((!tablero.getTablero()[columnas][filas].isMina())) {
			tablero.getTablero()[columnas][filas].setMina(true);;
			}else {
				i--;
			}
		}
				
		return tablero;
	}
}
