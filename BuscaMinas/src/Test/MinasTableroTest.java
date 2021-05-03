package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Control.MinasTablero;
import Modelo.Rejilla;

public class MinasTableroTest {

	@Test
	public void testColocarMinas() {
		Rejilla tablero = new Rejilla(10,10);
		int minas[] = {0,20};
		tablero = MinasTablero.colocarMinas(minas[0], tablero);
		int contadorMinas = 0;
		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				if (tablero.getTablero()[i][j].isMina()) {
					contadorMinas++;
				}
			}
		}
		
		assertEquals(contadorMinas, minas[0]);
		
		contadorMinas = 0;
		
		tablero = MinasTablero.colocarMinas(minas[1], tablero);
		
		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				if (tablero.getTablero()[i][j].isMina()) {
					contadorMinas++;
				}
			}
		}
		
		assertEquals(contadorMinas, minas[1]);
		
	}

}
