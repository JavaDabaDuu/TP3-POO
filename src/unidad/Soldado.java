package unidad;

/**
 * La clase Soldado es una Unidad.<br>
 * Tiene las características particulares de un soldado que no tiene unidad.
 * 
 * @author JavaDabaDuu
 */
public class Soldado extends Unidad {

	/**
	 * Energía inicial de un soldado.
	 */
	private final static int ENERGIA = 100;
	/**
	 * Salud inicial de un soldado.
	 */
	private final static int SALUD = 200;
	/**
	 * Ataque inicial de un soldado.
	 */
	private final static int ATAQUE = 10;
	/**
	 * Defensa inicial de un soldado.
	 */
	private final static int DEFENSA = 3;
	/**
	 * Distancia mínima a la que puede atacar un soldado.
	 */
	private final static double DISTANCIA_MINIMA = 0.5;
	/**
	 * Distancia máxima a la que puede atacar un soldado.
	 */
	private final static double DISTANCIA_MAXIMA = 1;

	/**
	 * Energía actual del soldado.
	 */
	private int energia;

	/**
	 * Constructor de la clase Soldado. <br>
	 * Establece los atributos de soldado a los valores iniciales
	 * predeterminados.<br>
	 * 
	 * @param posicion
	 *            es la posición inicial del soldado.
	 */
	public Soldado(Punto posicion) {
		super(posicion);
		this.energiaTopeActual = ENERGIA;
		this.energia = this.energiaTopeActual;
		this.salud = SALUD;
		this.ataque = ATAQUE;
		this.defensa = DEFENSA;
		this.distanciaMinima = DISTANCIA_MINIMA;
		this.distanciaMaxima = DISTANCIA_MAXIMA;
	}

	/**
	 * Sobreescritura del método consumirAgua de la clase Unidad.<br>
	 * Método del soldado para consumir una poción de agua.
	 * Reestablece el valor de energía actual al de su tope.
	 */
	@Override
	public void consumirAgua() {
		if (!this.estaMuerto())
			this.energia = this.energiaTopeActual;
	}

	/**
	 * Sobreescritura del método realizarAtaque de la clase Unidad.<br>
	 * Método del soldado para actualizar sus atributos luego de realizar un
	 * ataque.
	 */
	@Override
	protected void realizarAtaque() {
		this.energia -= 10;
	}

	/**
	 * Sobrescritura del método serAtacado de la clase Unidad.<br>
	 * Método del soldado para recibir el impacto del daño recibido en un ataque
	 * sobre su salud.<br>
	 * El daño recibido es reducido por el temple.
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
	 * Método del soldado para analizar si puede realizar un ataque.<br>
	 * El soldado puede atacar si tiene un mínimo valor de energía.
	 * 
	 * @return un booleano que indica si se puede realizar el ataque.
	 */
	@Override
	protected boolean puedeRealizarAtaque() {
		return this.energia >= 10;
	}

	/**
	 * Setter del atributo energía del soldado.<br>
	 * 
	 * @return la energía actual del soldado
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Setter del atributo energía del soldado.<br>
	 * 
	 * @param energia
	 *            es la energía que se le establece luego de equiparse una capa.
	 */
	void setEnergia(int energia) {
		this.energia = energia;
	}

}