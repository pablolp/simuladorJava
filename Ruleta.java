package simulacion;

import java.util.Random;

public class Ruleta {
	public static double probabilidad = 0.48;
	public static int banca = 0;

	private static boolean getResultado() {
		boolean resultado = false;
		if (Math.random() <= probabilidad) {
			resultado = true;
		}
		return resultado;
	}

	public static int hacerApuesta(int apuesta) {
		int premio = 0;
		banca += apuesta;
		if (getResultado()) {
			premio = apuesta * 2;
		}
		return premio;
	}
}
