package fp;

import java.util.ArrayList;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Calculator {

	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		return x.getClass();
	}

	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */
	public static List<Integer> fibonacci(int n) {
		List<Integer> lFibonacci = new ArrayList<Integer>();
		if (n > 0) {
			lFibonacci.add(1);
			if (n > 1) {
				lFibonacci.add(1);
				if (n > 2)
					for (int i = 2; i < n; i++)
						lFibonacci.add(lFibonacci.get(lFibonacci.size() - 1) + lFibonacci.get(lFibonacci.size() - 2));
			}
		}

		return lFibonacci;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		int n = number - step;

		while (n > 0) {
			lista.add(n);
			n -= step;
		}

		int numbers[] = new int[lista.size()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = lista.get(i);
		}
		return numbers;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		int aux = n;
		while (aux != 0) {
			if (n % aux == 0) {
				lista.add(aux);
			}
			aux--;
		}
		int divisores[] = new int[lista.size()];

		if (n == 0) {
			divisores = null;
		} else {
			for (int i = 0; i < divisores.length; i++) {
				divisores[i] = lista.get(i);
			}
		}
		return divisores;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		String queGraciosoMiProfesor[] = { "á", "[éè]", "í", "ó", "ú" };
		String dosHorasPorLaè[] = { "a", "e", "i", "o", "u" };
		int ini = 0;

		if (cadena == null)
			return false;

		for (int i = 0; i < queGraciosoMiProfesor.length; i++)
			cadena = cadena.replaceAll(queGraciosoMiProfesor[i], dosHorasPorLaè[i]);

		cadena = cadena.replaceAll("[^\\w]", "");
		cadena = cadena.toLowerCase();
		int fin = cadena.length() - 1;

		while (ini < fin) {
			if (cadena.charAt(ini) != cadena.charAt(fin)) {
				return false;
			}
			ini++;
			fin--;
		}
		return true;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String frase = "";
		String unidades[] = { "Cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve" };
		String dieces[] = { "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho",
				"diecinueve" };
		String decenas[] = { "Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta",
				"Noventa" };

		if (n < 10) {
			frase = unidades[n];

		} else if (n < 20 && n != 10) {
			frase = dieces[(n % 10) - 1];

		} else if (n % 10 == 0) {
			frase = decenas[(n / 10) - 1];

		} else {
			int unidad = n % 10;
			int decena = n / 10;
			frase = decenas[decena - 1] + " y " + unidades[unidad];
		}
		return frase;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		boolean bisiesto;
		String ano;
		int nAno;

		if (fecha != "") {
			ano = fecha.substring(fecha.length() - 4);
			nAno = Integer.parseInt(ano);
			bisiesto = nAno % 400 == 0 || (nAno % 4 == 0 && nAno % 100 != 0);
			if (bisiesto)
				return true;
		}
		return false;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		// faltan test para febrero

		String ano, mes, dia;
		int nAno, nMes, nDia, cont = 0, b = 0;
		char[] caracteres = date.toCharArray();
		char clave = '-';
		boolean valido = false;

		for (int i = 0; i < caracteres.length; i++)
			if (caracteres[i] == clave)
				cont++;

		if (cont == 2) {
			if (isLeapYear(date))
				b++;
			dia = date.substring(0, 2);
			mes = date.substring(3, 5);
			ano = date.substring(6, 10);
			nDia = Integer.parseInt(dia);
			nMes = Integer.parseInt(mes);
			nAno = Integer.parseInt(ano);
			if ((nAno >= 1 && nMes >= 1 && nMes < 13 && nDia >= 1 && nDia < 32))
				valido = true;
			if (nMes == 2 && nDia > (29 + b))
				valido = false;

		}
		return valido;
	}
}
