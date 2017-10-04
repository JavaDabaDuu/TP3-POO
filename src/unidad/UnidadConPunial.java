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
}