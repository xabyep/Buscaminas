package Control;

import java.awt.Color;

import javax.swing.JButton;

import Modelo.Rejilla;

public class ColorNumeros {
	
		public static void color(Rejilla rejilla, int i, int j, JButton botonera[][]){
			if (rejilla.getTablero()[i][j].getMinasAlrededor() != 0) {
				switch (rejilla.getTablero()[i][j].getMinasAlrededor()) {
				case 1:
					botonera[i][j].setForeground(new Color(7,229,14));
					break;
				case 2:
					botonera[i][j].setForeground(new Color(38,237,252));
					break;
				case 3:
					botonera[i][j].setForeground(new Color(0,43, 252));
					break;
				case 4:
					botonera[i][j].setForeground(new Color(252, 213, 89));
					break;
				case 5:
					botonera[i][j].setForeground(new Color(252,178,8));
					break;
				case 6:
					botonera[i][j].setForeground(new Color(189,0,170));
					break;
				case 7:
					botonera[i][j].setForeground(new Color(252,53,13));
					break;
				case 8:
					botonera[i][j].setForeground(new Color(252,0,0));
					break;
				}
				
			}
		}
}
