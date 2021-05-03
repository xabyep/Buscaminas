package Modelo;

public class Rejilla {
	private  Casilla[][] tablero;
	private int filas;
	private int columnas;



	public Rejilla(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		tablero=new Casilla[filas][columnas];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j]=new Casilla();
			}
		}
		
	}

	public Casilla[][] getTablero() {
		return tablero;
	}

	public void setTablero(Casilla[][] tablero) {
		this.tablero = tablero;
	}
}
