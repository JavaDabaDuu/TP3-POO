package unidad;

public class Punto {

	private double x;
	private double y;

	public Punto(double d, double e) {
		this.x = d;
		this.y = e;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public double distanciaCon(Punto punto) {
		return Math.sqrt(Math.pow(x - punto.x, 2) + Math.pow(y - punto.y, 2));
	}
	
}
