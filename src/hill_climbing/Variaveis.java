package hill_climbing;

import java.math.BigDecimal;	
import java.math.RoundingMode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Variaveis {

	private double aux = 0.01;
	private double theta = Math.PI / 4;

	public double arredodar(double value) {
		BigDecimal bd = new BigDecimal(value).setScale(4, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public double funcao(double x, double y) {
		return arredodar(Math.abs(x*Math.sin(y*theta) + y*Math.sin(x*theta)));
	}

	public void hillClimbing() {
		double theMax;
		double x = Math.random() * 20;
		double y = Math.random() * 20;

		double vizinhoX1 = x + aux;
		double vizinhoY1 = y + aux;
		double vizinhoX2 = x - aux;
		double vizinhoY2 = y - aux;

		while (true) {
			double a = funcao(x, y);

			double b = funcao(vizinhoX1, y);

			double c = funcao(vizinhoX2, y);

			double d = funcao(x, vizinhoY1);

			double e = funcao(vizinhoX1, vizinhoY1);

			double f = funcao(vizinhoX2, vizinhoY1);

			double g = funcao(vizinhoX2, vizinhoY2);

			double h = funcao(x, vizinhoY2);

			double i = funcao(vizinhoX1, vizinhoY2);

			List<Double> vizinhos = new LinkedList<Double>();

			vizinhos.add(a);
			vizinhos.add(b);
			vizinhos.add(c);

			vizinhos.add(d);
			vizinhos.add(e);
			vizinhos.add(f);

			vizinhos.add(g);
			vizinhos.add(h);
			vizinhos.add(i);

			//System.out.println(vizinhos);
			 theMax = Collections.max(vizinhos);

			if (theMax == a) break;
		    else if (theMax == b) x += aux;
		    else if (theMax == c) x -= aux;
			else if (theMax == d) y += aux;
			else if (theMax == e) {
				x += aux;
				y += aux;
			} else if (theMax == f) {
				x -= aux;
				y += aux;
			} else if (theMax == g) {
				x -= aux;
				y -= aux;
			} else if (theMax == h) {
				y -= aux;
			} else if (theMax == i) {
				x += aux;
				y -= aux;
			}

		}
		//System.out.println("Contador: " + cont + "\nMáximo: " + theMax);
		System.out.println("\nMaximo= "+theMax);
	}
}