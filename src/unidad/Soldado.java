package unidad;

/**
 * La clase soldado es una Unidad.<br>
 * Tiene las caracterñsticas particulares de un soldado que no tiene unidad.
 * 
 * @author JavaDabaDuu
 */
public class Soldado extends Unidad {

	/**
	 * Energña inicial de un soldado.
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
	 * Distancia mñnima a la que puede atacar un soldado.
	 */
	private final static double DISTANCIA_MINIMA = 0.5;
	/**
	 * Distancia mñxima a la que puede atacar un soldado.
	 */
	private final static double DISTANCIA_MAXIMA = 1;

	/**
	 * Energña actual del soldado.
	 */
	private int energia;

	/**
	 * Constructor de la clase Soldado. <br>
	 * Establece los atributos de soldado a los valores iniciales
	 * predeterminados.<br>
	 * 
	 * @param posicion
	 *            es la posiciñn inicial del soldado.
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
	 * Sobreescritura del mñtodo consumirAgua de la clase Unidad.<br>
	 * Mñtodo del soldado para consumir una pociñn de agua.
	 */
	@Override
	public void consumirAgua() {
		if (!this.estaMuerto())
			this.energia = this.energiaTopeActual;
	}

	/**
	 * Sobreescritura del mñtodo realizarAtaque de la clase Unidad.<br>
	 * Mñtodo del soldado para actualizar susu atributos luego de realizar un
	 * ataque.
	 */
	@Override
	protected void realizarAtaque() {
		this.energia -= 10;
	}

	/**
	 * Sobrescritura del mñtodo serAtacado de la clase Unidad.<br>
	 * Mñtodo del soldado para recibir el impacto del daño recibido en un ataque
	 * sobre su salud.
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
				this.salud -= daño*(1 - this.temple) - this.defensa;
		}
	}

	/**
	 * Sobreescritura del mñtodo puedeRealizarAtaque de la clase Unidad.<br>
	 * Mñtodo del soldado para analizar si puede realizar un ataque.
	 * 
	 * @return un booleano que indica si se puede realizar el ataque.
	 */
	@Override
	protected boolean puedeRealizarAtaque() {
		return this.energia >= 10;
	}

	/**
	 * Setter del atributo energña del soldado.<br>
	 * 
	 * @return la energña actual del soldado
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Setter del atributo energña del soldado.<br>
	 * 
	 * @param energia
	 *            es la energña que se le establece luego de equiparse una capa.
	 */
	void setEnergia(int energia) {
		this.energia = energia;
	}

}