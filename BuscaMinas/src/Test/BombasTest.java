package Test;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.junit.Test;

import Control.Bombas;
import Modelo.Rejilla;
import Vista.ParaTableroUI;
import Vista.TableroUI;

public class BombasTest {
	Bombas bomba = new Bombas();
	JPanel prueba = new JPanel();
	ImageIcon  imagen = new ImageIcon("/Imagenes/minaMaximizada.png");
	JButton botones[][] = new JButton[3][3];
	@Test
	public void testExplotarBombas() {
		prueba.setBounds(400, 300, 500, 500);
		for (int fila = 0; fila < botones.length; fila++) {
			for (int columna = 0; columna < botones[fila].length; columna++) {
				botones[fila][columna] = new JButton();
				prueba.add(botones[fila][columna]);
			}
		}
		Rejilla tablero = new Rejilla(3, 3);
		Rejilla tablero2 = new Rejilla(3, 3);
		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				if (j%2 == 0) {
					tablero.getTablero()[i][j].setMina(true);
					tablero.getTablero()[i][j].setVelada(false);
				}else{
					tablero.getTablero()[i][j].setMina(false);
					tablero.getTablero()[i][j].setVelada(true);
				}
			}
		}
		
		for (int i = 0; i < tablero2.getTablero().length; i++) {
			for (int j = 0; j < tablero2.getTablero()[i].length; j++) {
				if (j%2 == 0) {
					tablero2.getTablero()[i][j].setMina(true);
				}
			}
		}
		bomba.explotarBombas(tablero2, botones, prueba, imagen);
		//bomba.explotarBombas(tablero2);
		
		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				assertEquals(tablero.getTablero()[i][j].isVelada(), tablero2.getTablero()[i][j].isVelada());
			}
			//assertArrayEquals(tablero.getTablero()[i], tablero2.getTablero()[i]);
		}
		
		//assertEquals(tablero, tablero2);
	}

}
