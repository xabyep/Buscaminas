package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Control.Contiguas;
import Control.MinasAlrededor;
import Modelo.Rejilla;

public class ContiguasTest {
	
	Contiguas contigua = new Contiguas();
	@Test
	public void testDesvelarContigua() {
		Rejilla tableroUno = new Rejilla(3,3);
		Rejilla tableroUnoEsperado = new Rejilla(3,3);
		tableroUno.getTablero()[2][1].setMina(true);
		tableroUnoEsperado.getTablero()[2][1].setMina(true);
		int posicion[] = {0,0};
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < tableroUno.getTablero()[i].length; j++) {
				tableroUno.getTablero()[i][j].setVelada(false);
			}
		}
		tableroUno = MinasAlrededor.contarMinasAlrededro(tableroUno);
		tableroUnoEsperado = MinasAlrededor.contarMinasAlrededro(tableroUnoEsperado);
		tableroUnoEsperado = contigua.desvelarContigua(tableroUnoEsperado, posicion[0], posicion[1], true);
		for (int i = 0; i < tableroUno.getTablero().length; i++) {
			for (int j = 0; j < tableroUno.getTablero()[i].length; j++) {
				assertEquals(tableroUno.getTablero()[i][j].isVelada(),  tableroUnoEsperado.getTablero()[i][j].isVelada());
			}
		}
		
		
		Rejilla tableroDos = new Rejilla(3,3);
		Rejilla tableroDosEsperado = new Rejilla(3,3);
		tableroDos.getTablero()[1][1].setMina(true);
		tableroDosEsperado.getTablero()[1][1].setMina(true);
		tableroDos= MinasAlrededor.contarMinasAlrededro(tableroDos);
		tableroDosEsperado = MinasAlrededor.contarMinasAlrededro(tableroDosEsperado);
		
		tableroDos.getTablero()[0][0].setVelada(false);
		
		tableroDosEsperado = contigua.desvelarContigua(tableroDosEsperado, posicion[0], posicion[1], false);
		for (int i = 0; i < tableroDos.getTablero().length; i++) {
			for (int j = 0; j < tableroDos.getTablero()[i].length; j++) {
				assertEquals(tableroDos.getTablero()[i][j].isVelada(),  tableroDosEsperado.getTablero()[i][j].isVelada());
				System.out.println("Tablero1: "+tableroDos.getTablero()[i][j].isVelada()+" "+i+"-"+j);
				System.out.println("Tablero2: "+tableroDosEsperado.getTablero()[i][j].isVelada());
			}
			//assertArrayEquals(tableroTres.getTablero()[i], tableroTresEsperado.getTablero()[i]);
		}
		
		
		Rejilla tableroTres = new Rejilla(3,3);
		Rejilla tableroTresEsperado = new Rejilla(3,3);
		
		tableroTres.getTablero()[1][1].setMina(true);
		tableroTresEsperado.getTablero()[1][1].setMina(true);
		tableroTres.getTablero()[1][1].setMarcada(true);
		tableroTresEsperado.getTablero()[1][1].setMarcada(true);
		tableroTres= MinasAlrededor.contarMinasAlrededro(tableroTres);
		tableroTresEsperado = MinasAlrededor.contarMinasAlrededro(tableroTresEsperado);
		
		tableroTres.getTablero()[0][0].setVelada(false);
		tableroTres.getTablero()[0][1].setVelada(false);
		tableroTres.getTablero()[1][0].setVelada(false);
		
		tableroTresEsperado = contigua.desvelarContigua(tableroTresEsperado, posicion[0], posicion[1], true);
		for (int i = 0; i < tableroTres.getTablero().length; i++) {
			for (int j = 0; j < tableroTres.getTablero()[i].length; j++) {
				assertEquals(tableroTres.getTablero()[i][j].isVelada(),  tableroTresEsperado.getTablero()[i][j].isVelada());
				System.out.println("Tablero1: "+tableroTres.getTablero()[i][j].isVelada()+" "+i+"-"+j);
				System.out.println("Tablero2: "+tableroTresEsperado.getTablero()[i][j].isVelada());
			}
			//assertArrayEquals(tableroTres.getTablero()[i], tableroTresEsperado.getTablero()[i]);
		}
		
	
		Rejilla tableroCuatro = new Rejilla(3,3);
		Rejilla tableroCuatroEsperado = new Rejilla(3,3);
		
		tableroCuatro.getTablero()[2][2].setMina(true);
		tableroCuatroEsperado.getTablero()[2][2].setMina(true);
		
		tableroCuatro.getTablero()[1][2].setMarcada(true);
		tableroCuatroEsperado.getTablero()[1][2].setMarcada(true);
		
		tableroCuatro = MinasAlrededor.contarMinasAlrededro(tableroCuatro);
		tableroCuatroEsperado = MinasAlrededor.contarMinasAlrededro(tableroCuatroEsperado);
		
		for (int i = 0; i < tableroCuatro.getTablero().length; i++) {
			for (int j = 0; j < tableroCuatro.getTablero()[i].length; j++) {
				if (!tableroCuatro.getTablero()[i][j].isMarcada()) {
					tableroCuatro.getTablero()[i][j].setVelada(false);
				}
			}
		}
		
		tableroCuatroEsperado = contigua.desvelarContigua(tableroCuatroEsperado, 1, 1, true);
		
		for (int i = 0; i < tableroCuatro.getTablero().length; i++) {
			for (int j = 0; j < tableroCuatro.getTablero()[i].length; j++) {
				assertEquals(tableroCuatro.getTablero()[i][j].isVelada(), tableroCuatroEsperado.getTablero()[i][j].isVelada());
			}
		}
		
		
	}

}
