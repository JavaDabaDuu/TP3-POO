package unidad;

/**
 * La clase Lancero es una Unidad.<br>
 * Tiene las características particulares de un lancero que no tiene unidad.
 * 
 * @author JavaDabaDuu
 */
public class Lancero extends Unidad {

	/**
	 * Energía inicial de un lancero.
	 */
	private final static int ENERGIA_BASE = 0;
	/**
	 * Salud inicial de un lancero.
	 */
	private final static int SALUD_BASE = 150;
	/**
	 * Ataque inicial de un lancero.
	 */
	private final static int ATAQUE_BASE = 25;
	/**
	 * Defensa inicial de un lancero.
	 */
	private final static int DEFENSA_BASE = 2;
	/**
	 * Distancia mínima a la que puede atacer un lancero.
	 */
	private final static double DISTANCIA_MINIMA = 1;
	/**
	 * Distancia máxima a la que puede atacar un lancero.
	 */
	private final static double DISTANCIA_MAXIMA = 3;

	/**
	 * Constructor de la clase Lancero. <br>
	 * Establece los atributos de lancero a los valores iniciales
	 * predeterminados.<br>
	 * 
	 * @param posicion
	 *            es la posición inicial del lancero.
	 */
	public Lancero(Punto posicion) {
		super(posicion);
		this.energiaTopeActual = ENERGIA_BASE;
		this.salud = SALUD_BASE;
		this.ataque = ATAQUE_BASE;
		this.defensa = DEFENSA_BASE;
		this.distanciaMinima = DISTANCIA_MINIMA;
		this.distanciaMaxima = DISTANCIA_MAXIMA;
	}

	/**
	 * Sobreescritura del método consumirAgua de la clase Unidad.<br>
	 * Método del lancero para consumir una poción de agua.
	 */
	@Override
	public void consumirAgua() {

	}

	/**
	 * Sobreescritura del método realizarAtaque de la clase Unidad.<br>
	 * Método del lancero para actualizar sus atributos luego de realizar un
	 * ataque.
	 */
	@Override
	protected void realizarAtaque() {

	}

	/**
	 * Sobrescritura del método serAtacado de la clase Unidad.<br>
	 * Método del lancero para recibir el impacto del daño recibido en un ataque
	 * sobre su salud.<br>
	 * El daño recibido es reducido por la defensa.
	 * 
	 * @param daño
	 *            es el daño recibido por una unidad en un ataque
	 */
	@Override
	protected void serAtacado(int daño) {
		if (daño > this.defensa) {
			if (this.salud < daño)
				this.salud = 0;
			else
				this.salud -= daño - this.defensa;
		}
	}

	/**
	 * Sobreescritura del método puedeRealizarAtaque de la clase Unidad.<br>
	 * Método del lancero para analizar si puede realizar un ataque.
	 * 
	 * @return un booleano que indica si se puede realizar el ataque.
	 */
	@Override
	protected boolean puedeRealizarAtaque() {
		return true;
	}

}
