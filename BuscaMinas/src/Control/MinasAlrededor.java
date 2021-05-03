package Control;

import Modelo.Rejilla;

public class MinasAlrededor {

	public static Rejilla contarMinasAlrededro(Rejilla tablero) {
		int[][] posicion={{-1,-1},{-1,0},{-1,+1},
						  {0,-1},{0,+1},
						  {+1,-1},{+1,0},{+1,+1}};
		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				if (tablero.getTablero()[i][j].isMina()) {
					for (int[] js : posicion) {
						try {
							tablero.getTablero()[i+js[0]][j+js[1]].setMinasAlrededor(tablero.getTablero()[i+js[0]][j+js[1]]
									.getMinasAlrededor() + 1);
						} catch (Exception e) {
						}				
					}
					
				}
			}
		}

		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				if (tablero.getTablero()[i][j].isMina()) {
					tablero.getTablero()[i][j].setMinasAlrededor(0);
				}
			}
		}

		return tablero;
	}

}
