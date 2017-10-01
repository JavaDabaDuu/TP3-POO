package unidad;

/**
 * La clase Punto cuenta con dos coordenadas x e y
 * 
 * @author JavaDabaDuu
 *
 */
public class Punto {

	/**
	 * Coordenada del punto en el eje de las abscisas.
	 */
	private double x;
	/**
	 * Coordenada del punto en el eje de las ordenadas.
	 */
	private double y;

	/**
	 * Constructor parametrizado de la clase Punto
	 * 
	 * @param x
	 *            es la coordenada en el eje x
	 * @param y
	 *            es la coordenada en el eje y
	 */
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter de la coordenada x del punto
	 * 
	 * @return la coordenada x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Getter de la coordenada y del punto
	 * 
	 * @return la coordenada y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Método para calcular la distancia entre dos puntos.
	 * 
	 * @param punto
	 *            es el punto hasta el que se calcula la distancia.
	 * @return retorna la distancia que hay entre el punto llamador y el mandado
	 *         por parámetro.
	 */
	public double distanciaCon(Punto punto) {
		return Math.sqrt(Math.pow(x - punto.x, 2) + Math.pow(y - punto.y, 2));
	}

}
