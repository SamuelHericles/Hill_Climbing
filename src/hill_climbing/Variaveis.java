package hill_climbing;

public class Variaveis {

	//A função dada na questão
	public double funcao(double x, double y) {
		double theta = Math.PI / 4;
		return Math.abs(x * Math.sin(y * theta) + y * Math.sin(x * theta));
	}

	//O algoritmo Hill Climbing
	public void hillClimbing() {
		
		double theMax = Double.MIN_VALUE;//declaração para que possa achar o maior valor no vetor
		int count = 0;//contandor de reinicio no vizinho com maior imagem
		double aux = 0.01;
		double x = Math.random() * 20;//x com valor aleatório de (0,20)
		double y = Math.random() * 20;//y com valor aleatório de (0,20)

		while (true) {
			count += 1;
			
			//Variaveis auxiliares dos vizinhos
			double vizinhoX1 = x + aux;
			double vizinhoY1 = y + aux;
			double vizinhoX2 = x - aux;
			double vizinhoY2 = y - aux;
			
			//os oitos vizinhos de um ponto na função f(x,y)
			double a = funcao(x, y);
			
			double d = funcao(x, vizinhoY1);
			double h = funcao(x, vizinhoY2);
			
			double b = funcao(vizinhoX1, y);
			double e = funcao(vizinhoX1, vizinhoY1);
			double i = funcao(vizinhoX1, vizinhoY2);
			
			double c = funcao(vizinhoX2, y);
			double f = funcao(vizinhoX2, vizinhoY1);
			double g = funcao(vizinhoX2, vizinhoY2);

			//Vetor para armazenar os oito vizinhos + o valor central
			double[] vizinhos = new double[9];
			vizinhos[0] = a;
			vizinhos[1] = b;
			vizinhos[2] = c;
			vizinhos[3] = d;
			vizinhos[4] = e;
			vizinhos[5] = f;
			vizinhos[6] = g;
			vizinhos[7] = h;
			vizinhos[8] = i;
			
			//Ciclo for para achar o maior vizinho
			for(int temp = 0;temp<vizinhos.length; temp++) {
				theMax = Math.max(theMax,vizinhos[temp]);
			}
	
			//Condicionais para que procurar o maior valor central, sem que nenhum vizinho seja maior
			if (theMax == a) {
				break;
			} else if (theMax == b) {
				x += aux;
			} else if (theMax == c) {
				x -= aux;
			} else if (theMax == d) {
				y += aux;
			} else if (theMax == e) {
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
		
		System.out.println("Count: "+count+"--Maximo= "+theMax);
	}
}