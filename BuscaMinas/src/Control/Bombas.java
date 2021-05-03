package Control;

import java.awt.Image;
import java.io.ObjectInputStream.GetField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Modelo.Rejilla;

public class Bombas {
	

	public static void explotarBombas(Rejilla tablero, JButton[][] botonera, JPanel panel, ImageIcon bombaMaximizada){
		ImageIcon bombaEscala=new ImageIcon(bombaMaximizada.getImage().getScaledInstance(botonera[0][0].getSize().height-2, botonera[0][0].getSize().height-2, Image.SCALE_SMOOTH));
		
		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				if (tablero.getTablero()[i][j].isMina()) {
					tablero.getTablero()[i][j].setVelada(false);
					botonera[i][j].setContentAreaFilled(false);
					botonera[i][j].setIcon((bombaEscala));
					botonera[i][j].setDisabledIcon(bombaEscala);
					
				}
			}
		}
	}
}
