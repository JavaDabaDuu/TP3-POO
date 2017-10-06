package unidad;

/**
 * La clase UnidadConPuñal es una UnidadEquipada. <br>
 * Tendrá las características particulares que no tiene una UnidadEquipada.
 */

public class UnidadConPunial extends UnidadEquipada {

	/**
	 * Valor en el cual se incrementará el ataque de la unidad.
	 */
	protected static final int INCREMENTO_ATAQUE = 3;

	/**
	 * Valor en el cual se decrementará la defensa de la unidad.
	 */
	protected static final int REDUCCION_DEFENSA = 3;

	/**
	 * Constructor de UnidadConPuñal que recibe una Unidad que se decora con un
	 * puñal
	 * 
	 * @param unidad
	 *            es la unidad que se equipa con un puñal
	 */
	public UnidadConPunial(Unidad unidad) {
		super(unidad);
	}

	/**
	 * Getter del atributo ataque. <br>
	 * 
	 * @return retorna el ataquede la Unidad.
	 */
	public int getAtaque() {
		return this.unidad.getAtaque() + INCREMENTO_ATAQUE;
	}

	/**
	 * Getter del atributo defensa. <br>
	 * 
	 * @return retorna la defensa de la Unidad.
	 */
	public int getDefensa() {
		return this.unidad.getDefensa() - REDUCCION_DEFENSA;
	}
	
	/**
	 * El método atacar() se encarga de realizar el ataque de una unidad a otra.
	 * <br>
	 * Devuelve un booleano informando si el ataque se pudo realizar o no. <br>
	 * Las condiciones bajo a las cuales una unidad puede atacar a otra dependen
	 * de la posición relativa entre ellas, entre otras condiciones especificas
	 * para cada unidad. <br>
	 * 
	 * @param unidad
	 *            Unidad la cual es atacada. <br>
	 * @return retorna si el ataque fue realizado satisfactoriamente.
	 */
	public boolean atacar(Unidad unidad) {
		if (this.unidad.puedeAtacar(unidad)) {
			this.unidad.realizarAtaque();
			unidad.serAtacado(this.getAtaque());
			return true;
		}
		return false;
	}
	
	/**
	 * El método serAtacado() se encarga de modificar la salud de la Unidad
	 * luego de ser atacada por otra.
	 * 
	 * @param danio
	 *            es el daño que se recibe en un ataque
	 */
	protected void serAtacado(int danio) {
		this.unidad.serAtacado(danio - this.getDefensa());
	}
}