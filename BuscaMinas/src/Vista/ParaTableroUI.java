package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Bombas;
import Control.ColorNumeros;
import Control.Contiguas;
import Control.Marcadas;
import Control.MinasAlrededor;
import Control.MinasTablero;
import Control.ColorNumeros;
import Control.Sonido;
import Modelo.Casilla;
import Modelo.Minas;
import Modelo.Rejilla;
import Modelo.Tablero;
import Pruebas.Pantalla;
import Pruebas.Prueba;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class ParaTableroUI extends TableroUI {

	private Rejilla rejilla;
	private int minas;
	private int tamanoTablero = 0;
	private int totalMinasMarcadas = 0;
	private static boolean juegoPerdido = false;
	private static boolean juegoGanado = false;
	private static int casillasPorDesvelar = 0;
	protected ImageIcon bandera = new ImageIcon(getClass().getResource("/Imagenes/banderaPeque.png"));
	protected ImageIcon bombaMaximizada = new ImageIcon(getClass().getResource("/Imagenes/minaMaximizada.png"));
	protected ImageIcon sonidoEncendido = new ImageIcon(TableroUI.class.getResource("/Imagenes/sonido_encendido.png"));
	protected ImageIcon sonidoEscalaOn = new ImageIcon(sonidoEncendido.getImage().getScaledInstance(20, 20,
			Image.SCALE_SMOOTH));
	protected ImageIcon sonidoOff = new ImageIcon(TableroUI.class.getResource("/Imagenes/sonido_apagado.png"));
	protected ImageIcon sonidoEscalaOff = new ImageIcon(sonidoOff.getImage().getScaledInstance(20, 20,
			Image.SCALE_SMOOTH));
	Sonido sonido = new Sonido();
	private boolean audio = true;

	ActionListener empezar = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			lblFin.setText("");
			juegoGanado = false;
			juegoPerdido = false;
			totalMinasMarcadas = 0;
			switch (e.getActionCommand().toString()) {
			case "Facil":
				tamanoTablero = 10;
				minas = 10;
				crearPanel(e);
				panelBotones.setVisible(true);
				panelPersonalizado.setVisible(false);
				panelInformativo.setVisible(true);
				textDificultad.setText("Facil");
				setBounds(400, 300, 500, 500);
				// Para centrar la ventana en pantalla
				setLocationRelativeTo(null);
				break;
			case "Medio":
				tamanoTablero = 15;
				minas = 40;
				crearPanel(e);
				panelBotones.setVisible(true);
				panelPersonalizado.setVisible(false);
				panelInformativo.setVisible(true);
				textDificultad.setText("Medio");
				setBounds(400, 200, 700, 700);
				setLocationRelativeTo(null);
				break;
			case "Hardcore":
				tamanoTablero = 20;
				minas = 99;
				crearPanel(e);
				panelBotones.setVisible(true);
				panelPersonalizado.setVisible(false);
				panelInformativo.setVisible(true);
				textDificultad.setText("Hardcore");
				setBounds(400, 100, 900, 900);
				setLocationRelativeTo(null);
				break;
			case "Personalizado":
				panelPersonalizado.setVisible(true);
				panelBotones.setVisible(false);
				panelInformativo.setVisible(false);
				ActionListener aceptar = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						tamanoTablero = (int) spnTamanoX.getValue();
						if ((int) spnMinas.getValue() < (tamanoTablero * tamanoTablero)) {
							minas = (int) spnMinas.getValue();
						} else {
							minas = ((tamanoTablero * tamanoTablero) - 1);
						}

						crearPanel(e);
						panelPersonalizado.setVisible(false);
						panelBotones.setVisible(true);
						panelInformativo.setVisible(true);
					}
				};
				btnAceptar.addActionListener(aceptar);
				textDificultad.setText("Personalizado");
				setBounds(400, 100, 500, 500);
				setLocationRelativeTo(null);
				break;
			}

		}

		private void crearPanel(ActionEvent e) {
			// Obtenemos el numero de minas y el tamaño del tablero segun el
			// nivel elegido
			rejilla = Tablero.crearTablero(tamanoTablero);
			// Teniendo el tamaño del tablero creamos los botones
			crearBotonera(tamanoTablero, tamanoTablero);
			// Asignamos a los txt los valores de minas
			txtNMinas.setText(String.valueOf(minas));
			// Colocamos las minas en el tablero y contamos las minas que hay
			// alrededor de cada bomba
			rejilla = MinasTablero.colocarMinas(minas, rejilla);
			rejilla = MinasAlrededor.contarMinasAlrededro(rejilla);

		}
	};

	// Usamos este tipo de evento para poder diferenciar el boton del ratón
	// pulsado
	// Si pulsamos el boton izquierdo devuelve 1 si pulsamos derecho devuelve 2
	MouseListener listener = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {/*
												 * TODO Auto-generated method
												 * stub
												 */
		}

		@Override
		public void mousePressed(MouseEvent e) {/*
												 * TODO Auto-generated method
												 * stub
												 */
		}

		@Override
		public void mouseExited(MouseEvent e) {/*
												 * TODO Auto-generated method
												 * stub
												 */
		}

		@Override
		public void mouseEntered(MouseEvent e) {/*
												 * TODO Auto-generated method
												 * stub
												 */
			if (audio) {
				sonido.daleplay("encima"); 
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			ImageIcon banderaEscala = new ImageIcon(bandera.getImage().getScaledInstance(
					botonera[0][0].getSize().height - 2, botonera[0][0].getSize().height - 2, Image.SCALE_SMOOTH));
			JButton boton = (JButton) e.getSource();
			int posx = 0;
			int posy = 0; 
			for (int fila = 0; fila < botonera.length; fila++) {
				for (int columna = 0; columna < botonera[fila].length; columna++) {
					if (boton.equals(botonera[fila][columna])) {
						posx = columna;
						posy = fila;
						break;
					}
				}
			}

			// Si pulsamos con el boton derecho y no está marcada
			if (e.getButton() == 1 && !rejilla.getTablero()[posy][posx].isMarcada()) {

				// Si la casilla que hemos pulsado es mina
				if (rejilla.getTablero()[posy][posx].isMina()) {
					// sonido.daleplay("perder");
					// sonido.daleplay("bomba");
					Bombas.explotarBombas(rejilla, botonera, panelBotones, bombaMaximizada);
					// lblFin.setText("YOU LOSE");
					// juegoPerdido = true;
				} else {
					// Si no es mina, desvelaremos las casillas
					rejilla = Contiguas.desvelarContigua(rejilla, posy, posx,
							Marcadas.comprobarMarcadas(rejilla, posy, posx));
					if (audio) {
						sonido.daleplay("click");
					}
				}
				// Mostramos en pantalla el panel con los cambios realizado en
				// el tablero
				for (int i = 0; i < rejilla.getTablero().length; i++) {
					for (int j = 0; j < rejilla.getTablero()[i].length; j++) {
						if (!rejilla.getTablero()[i][j].isVelada()) {
							// Al llamar a este metodo lo que nos hace es darle
							// la apariencia a el boton como si estubiese
							// desactivado.
							botonera[i][j].setContentAreaFilled(false);

							// Con esta propiedad lo que hacemos es quitarle el
							// efecto de pasar por encima del boton
							botonera[i][j].setRolloverEnabled(false);
							if (rejilla.getTablero()[i][j].getMinasAlrededor() != 0) {
								ColorNumeros.color(rejilla, i, j, botonera);
								botonera[i][j].setText(String.valueOf(rejilla.getTablero()[i][j].getMinasAlrededor()));
							}
							if (rejilla.getTablero()[i][j].isMina()) {
								juegoPerdido = true;

							}

						}

					}
				}
			} else if (rejilla.getTablero()[posy][posx].isVelada() && e.getButton() != 1) {
				// Si pulsamos con el boton izquierdo pondremos una bandera
				// Si la casilla ya está marcada quitaremos la bandera y la
				// desmarcaremos
				if (audio) {
					sonido.daleplay("bandera");
				}
				if (rejilla.getTablero()[posy][posx].isMarcada()) {
					rejilla.getTablero()[posy][posx].setMarcada(false);
					botonera[posy][posx].setIcon(null);
					txtNMinas.setText(String.valueOf(Integer.valueOf(txtNMinas.getText()) + 1));
					totalMinasMarcadas--;
				} else if (Integer.valueOf(txtNMinas.getText()) > 0) {
					// Si no esta marcada la marcamos y ponemos la bandera
					botonera[posy][posx].setIcon(banderaEscala);
					rejilla.getTablero()[posy][posx].setMarcada(true);
					txtNMinas.setText(String.valueOf(Integer.valueOf(txtNMinas.getText()) - 1));
					comprobarCasilla(rejilla.getTablero()[posy][posx]);
				}
			}

			// Comprobamos si hemos ganado
			if (comprobarGanador(casillasPorDesvelar, rejilla, juegoPerdido)) {
				lblFin.setText("WINNER");
				juegoGanado = true;
				if (audio) {
					sonido.daleplay("ganar");
				}
				Bombas.explotarBombas(rejilla, botonera, panelBotones, bombaMaximizada);
				System.out.println("Entra en ganar");
			}
			if (juegoPerdido && !juegoGanado) {
				if (audio) {
					sonido.daleplay("perder");
					sonido.daleplay("bomba2");
				}
				Bombas.explotarBombas(rejilla, botonera, panelBotones, bombaMaximizada);
				lblFin.setText("YOU LOSE");
			}
			if (juegoPerdido || juegoGanado) {
				for (int i = 0; i < botonera.length; i++) {
					for (int j = 0; j < botonera[i].length; j++) {
						botonera[i][j].setContentAreaFilled(false);
						botonera[i][j].setRolloverEnabled(false);
						ColorNumeros.color(rejilla, i, j, botonera);
						if (rejilla.getTablero()[i][j].isMarcada() && !rejilla.getTablero()[i][j].isMina()) {
							botonera[i][j].setIcon(null);
						}

						if (rejilla.getTablero()[i][j].getMinasAlrededor() != 0)
							botonera[i][j].setText(String.valueOf(rejilla.getTablero()[i][j].getMinasAlrededor()));
					}
				}

			}

			Pantalla.mostrarTableroPantalla(posx, posy, rejilla, botonera);

		}

		private void comprobarCasilla(Casilla casilla) {

			if (casilla.isMina()) {
				totalMinasMarcadas++;
			}
			System.out.println("Total banderas: " + totalMinasMarcadas);
		}

		private boolean comprobarGanador(int casillasPorDesvelar, Rejilla rejilla, boolean juegoPerdido) {
			int contador = 0;
			for (int i = 0; i < rejilla.getTablero().length; i++) {
				for (int j = 0; j < rejilla.getTablero()[i].length; j++) {
					if (rejilla.getTablero()[i][j].isVelada()) {
						contador++;
					}
				}
			}
			if (contador == minas && !juegoPerdido || totalMinasMarcadas == minas) {
				return true;
			} else {
				return false;
			}

		}

	};

	/**
	 * Create the frame.
	 */

	public ParaTableroUI() {
		super();

		mntmHardcore.addActionListener(empezar);
		mntmMedio.addActionListener(empezar);
		mntmFacil.addActionListener(empezar);
		mntmPersonalizado.addActionListener(empezar);
		lblSonido.setIcon(sonidoEscalaOn);
		lblSonido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (audio == false) {
					audio = true;
					lblSonido.setIcon(sonidoEscalaOn);
				} else {
					audio = false;
					lblSonido.setIcon(sonidoEscalaOff);
				}
			}
		});

	}

	private void crearBotonera(int filas, int columnas) {
		panelBotones.removeAll();
		panelBotones.setLayout(new GridLayout(filas, columnas));
		botonera = new JButton[filas][columnas];
		for (int fila = 0; fila < botonera.length; fila++) {
			for (int columna = 0; columna < botonera[fila].length; columna++) {
				botonera[fila][columna] = new JButton();
				// botonera[fila][columna].setRolloverIcon(new
				// ImageIcon("/Imagenes/boton.png"));
				panelBotones.add(botonera[fila][columna]);
			}
		}
		this.revalidate();

		// Le añadimos a la botonera los action listener
		for (int i = 0; i < botonera.length; i++) {
			for (int j = 0; j < botonera[i].length; j++) {
				botonera[i][j].addMouseListener(listener);
				botonera[i][j].setBackground(Color.DARK_GRAY);
			}
		}
	}
}
