package unidad;

/**
 * La clase soldado es una Unidad.<br>
 * Tiene las caracter�sticas particulares de un soldado que no tiene unidad.
 * 
 * @author JavaDabaDuu
 */
public class Soldado extends Unidad {

	/**
	 * Energ�a inicial de un soldado.
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
	 * Distancia m�nima a la que puede atacar un soldado.
	 */
	private final static double DISTANCIA_MINIMA = 0.5;
	/**
	 * Distancia m�xima a la que puede atacar un soldado.
	 */
	private final static double DISTANCIA_MAXIMA = 1;

	/**
	 * Energ�a actual del soldado.
	 */
	private int energia;
	/**
	 * Tope de energ�a que tiene el soldado. <br>
	 * Este tope puede ser modificado al equipar una capa.
	 */
	private int energiaTopeActual;

	/**
	 * Constructor de la clase Soldado. <br>
	 * Establece los atributos de soldado a los valores iniciales
	 * predeterminados.<br>
	 * 
	 * @param posicion
	 *            es la posici�n inicial del soldado.
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
	 * Sobreescritura del m�todo consumirAgua de la clase Unidad.<br>
	 * M�todo del soldado para consumir una poci�n de agua.
	 */
	@Override
	public void consumirAgua() {
		if (!this.estaMuerto())
			this.energia = this.energiaTopeActual;
	}

	/**
	 * Sobreescritura del m�todo realizarAtaque de la clase Unidad.<br>
	 * M�todo del soldado para actualizar susu atributos luego de realizar un
	 * ataque.
	 */
	@Override
	protected void realizarAtaque() {
		this.energia -= 10;
	}

	/**
	 * Sobrescritura del m�todo serAtacado de la clase Unidad.<br>
	 * M�todo del soldado para recibir el impacto del da�o recibido en un ataque
	 * sobre su salud.
	 * 
	 * @param da�o
	 *            es el da�o recibido por una unidad en un ataque
	 */
	@Override
	protected void serAtacado(int da�o) {
		if (da�o > this.defensa) {
			if (this.salud < da�o)
				this.salud = 0;
			else
				this.salud -= da�o - this.defensa;
		}
	}

	/**
	 * Sobreescritura del m�todo puedeRealizarAtaque de la clase Unidad.<br>
	 * M�todo del soldado para analizar si puede realizar un ataque.
	 * 
	 * @return un booleano que indica si se puede realizar el ataque.
	 */
	@Override
	protected boolean puedeRealizarAtaque() {
		return this.energia >= 10;
	}

	/**
	 * Setter del atributo energ�a del soldado.<br>
	 * 
	 * @return la energ�a actual del soldado
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Setter del atributo energ�a del soldado.<br>
	 * 
	 * @param energia
	 *            es la energ�a que se le establece luego de equiparse una capa.
	 */
	void setEnergia(int energia) {
		this.energia = energia;
	}

}