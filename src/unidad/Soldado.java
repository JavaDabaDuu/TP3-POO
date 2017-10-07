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
	private final static int ENERGIA_BASE = 100;
	/**
	 * Salud inicial de un soldado.
	 */
	private final static int SALUD_BASE = 200;
	/**
	 * Ataque inicial de un soldado.
	 */
	private final static int ATAQUE_BASE = 10;
	/**
	 * Defensa inicial de un soldado.
	 */
	private final static int DEFENSA_BASE = 3;
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
		this.energiaTopeActual = ENERGIA_BASE;
		this.energia = this.getEnergiaTopeActual();
		this.salud = SALUD_BASE;
		this.ataque = ATAQUE_BASE;
		this.defensa = DEFENSA_BASE;
		this.distanciaMinima = DISTANCIA_MINIMA;
		this.distanciaMaxima = DISTANCIA_MAXIMA;
	}

	/**
	 * Sobreescritura del método consumirAgua de la clase Unidad.<br>
	 * Método del soldado para consumir una poción de agua. Reestablece el valor
	 * de energía actual al de su tope.
	 */
	@Override
	public void consumirAgua() {
		if (!this.estaMuerto())
			this.energia = this.getEnergiaTopeActual();
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
	 * Sobreescritura del método puedeRealizarAtaque de la clase Unidad.<br>
	 * Método del soldado para analizar si puede realizar un ataque.<br>
	 * El soldado puede atacar si tiene un mínimo valor de energía.
	 * 
	 * @return un booleano que indica si se puede realizar el ataque.
	 */
	@Override
	protected boolean puedeRealizarAtaque() {
		return this.getEnergia() > 0;
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
	 * Sobreescritura del método consumirAgua de la clase Unidad.<br>
	 * Método del soldado para recibir un paquete de flechas.
	 */
	@Override
	public void recibirPaquete() {
		
	}

}