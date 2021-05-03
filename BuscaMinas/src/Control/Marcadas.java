package Control;

import Modelo.Rejilla;

public class Marcadas {
	public static boolean comprobarMarcadas(Rejilla tablero, int X, int Y) {
		int[][] posicion = { { -1, -1 }, { -1, 0 }, { -1, +1 }, { 0, -1 }, { 0, +1 }, { +1, -1 }, { +1, 0 }, { +1, +1 } };
		int contador = 0;

		for (int[] is : posicion) {
			if ((X + is[0] >= 0 && X + is[0] <= tablero.getTablero().length - 1)
					&& (Y + is[1] >= 0 && Y + is[1] <= tablero.getTablero().length - 1)) {
				if (tablero.getTablero()[X + is[0]][Y + is[1]].isMarcada()) {
					contador++;
				}
			}
		}
		if (contador == tablero.getTablero()[X][Y].getMinasAlrededor() && !tablero.getTablero()[X][Y].isMina() ) {
			return true;
		} else {
			return false;
		}

	}
}
