package Modelo;

public class Minas {
	private static int numeroMinas;
	private static int minas[] = {10, 40, 99 };

	public static int nivelDificultad(int numero) {
		numeroMinas = minas[numero];
		return numeroMinas;
	}
}
