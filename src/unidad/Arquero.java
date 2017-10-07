package unidad;

/**
 * La clase Arquero es una Unidad.<br>
 * Tiene las características particulares de un arquero que no tiene unidad.
 * 
 * @author JavaDabaDuu
 */
public class Arquero extends Unidad {

	/**
	 * Energía inicial de un arquero.
	 */
	private final static int ENERGIA_BASE = 0;
	/**
	 * Salud inicial de un arquero.
	 */
	private final static int SALUD_BASE = 50;
	/**
	 * Ataque inicial de un arquero.
	 */
	private final static int ATAQUE_BASE = 5;
	/**
	 * Defensa inicial de un arquero.
	 */
	private final static int DEFENSA_BASE = 1;
	/**
	 * Distancia mínima a la que puede atacar un arquero.
	 */
	private final static double DISTANCIA_MINIMA = 2;
	/**
	 * Distancia máxima a la que puede atacar un arquero.
	 */
	private final static double DISTANCIA_MAXIMA = 5;
	/**
	 * Cantidad inicial de flechas que el arquero tiene en su carcaj.
	 */
	private final static int CANTIDAD_FLECHAS = 20;
	
	/**
	 * Cantidad actual de flechas que el arquero tiene en su carcaj.
	 */
	protected int cantidadFlechas;

	/**
	 * Constructor de la clase Arquero. <br>
	 * Establece los atributos de arquero a los valores iniciales
	 * predeterminados.<br>
	 * 
	 * @param posicion
	 *            es la posición inicial del arquero.
	 */
	public Arquero(Punto posicion) {
		super(posicion);
		this.energiaTopeActual = ENERGIA_BASE;
		this.salud = SALUD_BASE;
		this.ataque = ATAQUE_BASE;
		this.defensa = DEFENSA_BASE;
		this.distanciaMinima = DISTANCIA_MINIMA;
		this.distanciaMaxima = DISTANCIA_MAXIMA;
		this.cantidadFlechas = CANTIDAD_FLECHAS;
	}

	/**
	 * Sobreescritura del método consumirAgua de la clase Unidad.<br>
	 * Método del arquero para consumir una poción de agua.
	 */
	@Override
	public void consumirAgua() {
		
	}

	/**
	 * Sobreescritura del método realizarAtaque de la clase Unidad.<br>
	 * Método del arquero para actualizar sus atributos luego de realizar un
	 * ataque.
	 */
	@Override
	protected void realizarAtaque() {
		this.cantidadFlechas--;
	}

	/**
	 * Sobreescritura del método puedeRealizarAtaque de la clase Unidad.<br>
	 * Método del arquero para analizar si puede realizar un ataque.<br>
	 * El arquero puede atacar si al menos cuenta con una flecha en el carcaj.
	 * 
	 * @return un booleano que indica si se puede realizar el ataque.
	 */
	@Override
	protected boolean puedeRealizarAtaque() {
		return this.getCantidadFlechas() > 0;
	}

	/**
	 * Método del arquero para recibir un paquete de flechas para recargar su
	 * carcaj. Todos los paquetes de flechas tienen 6 flechas.<br>
	 * El arquero recarga su carcaj con flechas sin límite.
	 */
	@Override
	public void recibirPaquete() {
		if (!this.estaMuerto()) {
			if (this.cantidadFlechas + 6 <= Integer.MAX_VALUE)
				this.cantidadFlechas += 6;
		}
	}

	
	protected int getCantidadFlechas() {
		return this.cantidadFlechas;
	}
}