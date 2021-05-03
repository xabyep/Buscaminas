package Control;

import Modelo.Rejilla;

public class Contiguas {
	public static Rejilla desvelarContigua(Rejilla tablero, int X, int Y, boolean verificar) {
		int[][] posicion = { { -1, -1 }, { -1, 0 }, { -1, +1 }, { 0, -1 }, { 0, +1 }, { +1, -1 }, { +1, 0 }, { +1, +1 } };

		// Recursividad
		if ((tablero.getTablero()[X][Y].getMinasAlrededor() == 0 || verificar)
				&& (!tablero.getTablero()[X][Y].isMina() && (tablero.getTablero()[X][Y].isVelada() || verificar))
				&& !tablero.getTablero()[X][Y].isMarcada()) {
			tablero.getTablero()[X][Y].setVelada(false);
			for (int[] is : posicion) {
				if ((X + is[0] >= 0 && X + is[0] <= tablero.getTablero().length - 1)
						&& (Y + is[1] >= 0 && Y + is[1] <= tablero.getTablero()[0].length - 1)) {
					tablero = desvelarContigua(tablero, X + is[0], Y + is[1], false);
				}
			}
		} else {// Caso base
				// Para que nos muestre los números cercanos a las minas
				// Las que esten marcadas no las dervelará, pero si las minas,
				// si estan no estan bien marcadas
			if (!tablero.getTablero()[X][Y].isMarcada()) {
				tablero.getTablero()[X][Y].setVelada(false);
			}
		}

		return tablero;
	}
}
