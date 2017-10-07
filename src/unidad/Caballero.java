package unidad;

/**
 * La clase Caballero es una Unidad.<br>
 * Tiene las características particulares de un caballero que no tiene unidad.
 * 
 * @author JavaDabaDuu
 */
public class Caballero extends Unidad {

	/**
	 * Energía inicial de una caballero.
	 */
	private final static int ENERGIA_BASE = 0;
	/**
	 * Salud inicial de un caballero.
	 */
	private final static int SALUD_BASE = 200;
	/**
	 * Ataque inicial de un caballero.
	 */
	private final static int ATAQUE_BASE = 50;
	/**
	 * Defensa inicial de un caballero.
	 */
	private final static int DEFENSA_BASE = 4;
	/**
	 * Distancia mínima a la que puede atacar un caballero.
	 */
	private final static double DISTANCIA_MINIMA = 1;
	/**
	 * Distancia máxima a la que puede atacar un caballero.
	 */
	private final static double DISTANCIA_MAXIMA = 2;

	/**
	 * Estado del caballo de un caballero.<br>
	 * El caballo puede estar rebelde o no estarlo.<br>
	 * El caballo se pone rebelde de acuerdo a la cantidad de ataques recibidos.
	 */
	private boolean caballoRebelde;

	/**
	 * Cantidad de ataques que recibió un caballero.
	 */
	private int ataquesRecibidos;

	/**
	 * Constructor de la clase Caballero. <br>
	 * Establece los atributos de caballero a los valores iniciales
	 * predeterminados.<br>
	 * 
	 * @param posicion
	 *            es la posición inicial del caballero.
	 */
	public Caballero(Punto posicion) {
		super(posicion);
		this.energiaTopeActual = ENERGIA_BASE;
		this.salud = SALUD_BASE;
		this.ataque = ATAQUE_BASE;
		this.defensa = DEFENSA_BASE;
		this.distanciaMinima = DISTANCIA_MINIMA;
		this.distanciaMaxima = DISTANCIA_MAXIMA;
		this.caballoRebelde = false;
		this.ataquesRecibidos = 0;
	}

	/**
	 * Sobreescritura del método consumirAgua de la clase Unidad.<br>
	 * Método del caballero para consumir una poción de agua.<br>
	 * Al consumir agua, el caballo se calma y deja de estar rebelde.
	 */
	@Override
	public void consumirAgua() {
		if (!this.estaMuerto())
			this.caballoRebelde = false;
	}

	/**
	 * Sobreescritura del método realizarAtaque de la clase Unidad.<br>
	 * Método del caballero para actualizar sus atributos luego de realizar un
	 * ataque.
	 */
	@Override
	protected void realizarAtaque() {

	}

	/**
	 * Sobrescritura del método serAtacado de la clase Unidad.<br>
	 * Método del caballero para recibir el impacto del daño recibido en un
	 * ataque sobre su salud.<br>
	 * El daño recibido es reducido por la defensa.<br>
	 * Se actualiza el estado del caballo luego de recibir el ataque.
	 * 
	 * @param danio
	 *            es el daño recibido por una unidad en un ataque
	 */
	@Override
	protected void serAtacado(int danio) {
		if (danio > this.defensa) {
			if (this.salud < danio)
				this.salud = 0;
			else
				this.salud -= danio - this.defensa;
		}
		if (!this.estaMuerto()) {
			if (!this.caballoRebelde)
				this.ataquesRecibidos++;
			if (this.ataquesRecibidos == 3) {
				this.caballoRebelde = true;
				this.ataquesRecibidos = 0;
			}
		}
	}

	/**
	 * Sobreescritura del método puedeRealizarAtaque de la clase Unidad.<br>
	 * Método del caballero para analizar si puede realizar un ataque.<br>
	 * El caballero puede atacar si su caballo no está rebelde.
	 * 
	 * @return un booleano que indica si se puede realizar el ataque.
	 */
	@Override
	protected boolean puedeRealizarAtaque() {
		return !this.caballoRebelde;
	}

	/**
	 * Método del caballero para saber si el caballo está rebelde.
	 * 
	 * @return un booleano que indica si el caballo está rebelde.
	 */
	public boolean isCaballoRebelde() {
		return caballoRebelde;
	}

	/**
	 * Getter del atributo cantidad de ataques recibidos del caballero.
	 * 
	 * @return la cantidad de ataques que recibió el caballero.
	 */
	public int getAtaquesRecibidos() {
		return ataquesRecibidos;
	}

	/**
	 * Sobreescritura del método consumirAgua de la clase Unidad.<br>
	 * Método del caballero para recibir un paquete de flechas.
	 */
	@Override
	public void recibirPaquete() {
		
	}

}
