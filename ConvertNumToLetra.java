public class ConvertNumToLetra {

	final private static String[] units = { "cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho",
			"nueve" };
	final private static String[] decs = { "X", "y", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta",
			"ochenta", "noventa" };
	final private static String[] dieces = { "diez", "once", "doce", "trece", "catorce", "quince", "dieciseis",
			"diecisiete", "dieciocho", "diecinueve" };
	final private static String[] cientos= {"x", "cien", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos","ochocientos","novecientos"};

	public int intdiv(int num, int dv) {
		return num / dv;
	}

	public String convertNumLetra(int num) {
		// Millones
		int millones = intdiv(num, 1000000);
		// Millares
		int millares = intdiv(num, 1000) % 1000;
		// Centenas
		int centenas = intdiv(num, 100) % 10;
		// Decenas
		int decenas = intdiv(num, 10) % 10;
		// Unidades
		int unidades = num % 10;
		StringBuilder letras = new StringBuilder();

		if (millones == 1) {
			letras.append("un millón");
		} else if (millones > 1) {
			letras.append(convertNumLetra(millones)).append(" millones");
		}
		if (millares == 1) {
			letras.append("un mil");
		} else if (millares > 0) {
			letras.append(" ").append(convertNumLetra(millares)).append(" mil");
		}
		if (centenas == 1) {
			letras.append((num % 100 == 0 ? " cien" : " ciento"));
		} else if (centenas > 0) {
			letras.append(' ').append(cientos[centenas]);
		}
		if (decenas == 1) {
			letras.append(' ').append(dieces[num % 10]);
			unidades = 0;
		} else if (decenas == 2 && unidades > 0) {
			letras.append(" veinti").append(units[unidades]);
			unidades = 0;
		} else if (decenas > 1) {
			letras.append(" ").append(decs[decenas]);
			if (unidades > 0) {
				letras.append(" y");
			}
		}
		if (unidades > 0) {
			letras.append(" ").append(units[unidades]);
		} else if (num == 0) {
			letras.append(units[0]);

		}
		return letras.toString().trim();
	}
  }
