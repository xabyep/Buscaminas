package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Control.Marcadas;
import Control.MinasAlrededor;
import Modelo.Rejilla;

public class MarcadasTest {

	@Test
	public void testComprobarMarcadas() {
		Rejilla tablero = new Rejilla(3,3);
		tablero.getTablero()[1][1].setMina(true);
		tablero.getTablero()[1][1].setMarcada(true);
		tablero = MinasAlrededor.contarMinasAlrededro(tablero);
		int[] posicion = {0,0};
		
		//assertTrue(Marcadas.comprobarMarcadas(tablero, posicion[0], posicion[1]));
		
		
		Rejilla tableroDos = new Rejilla(3,3);
		tableroDos.getTablero()[0][1].setMina(true);
		tableroDos.getTablero()[1][0].setMina(true);
		tableroDos.getTablero()[1][1].setMarcada(true);
		tableroDos = MinasAlrededor.contarMinasAlrededro(tableroDos);
		int[] posicionDos = {0,0};
		assertFalse(Marcadas.comprobarMarcadas(tableroDos, posicionDos[0], posicionDos[1]));
		
	}

}
