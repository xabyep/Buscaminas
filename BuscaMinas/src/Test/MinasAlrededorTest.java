package Test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import Control.MinasAlrededor;
import Modelo.Rejilla;

public class MinasAlrededorTest {
	MinasAlrededor minas = new MinasAlrededor();
	
	@Test
	public void testContarMinasAlrededro() {
		
		//Con minas en el tablero
		Rejilla tablero = new Rejilla(3, 3);
		tablero.getTablero()[1][1].setMina(true);
		Rejilla tablero2 = new Rejilla(3, 3);
		tablero2.getTablero()[1][1].setMina(true);
		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				if (!tablero.getTablero()[i][j].isMina()) {
					tablero.getTablero()[i][j].setMinasAlrededor(1);
				}
			}
		}
		tablero2 = minas.contarMinasAlrededro(tablero2);
		
		for (int i = 0; i < tablero.getTablero().length; i++) {
			assertArrayEquals(tablero.getTablero()[i], tablero2.getTablero()[i]);
		}
		
		//Cuando no tenemos ninguna mina en el tablero
		tablero.getTablero()[1][1].setMina(false);
		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				if (!tablero.getTablero()[i][j].isMina()) {
					tablero.getTablero()[i][j].setMinasAlrededor(0);
				}
			}
		}
		tablero2.getTablero()[1][1].setMina(false);
		for (int i = 0; i < tablero.getTablero().length; i++) {
			assertArrayEquals(tablero.getTablero()[i], tablero2.getTablero()[i]);
		}
	}

}
