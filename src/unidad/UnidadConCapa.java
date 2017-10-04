package unidad;

/**
 * La clase UnidadConCapa es una UnidadEquipada. <br>
 * Tendrá las características particulares que no tiene una UnidadEquipada.
 */

public class UnidadConCapa extends UnidadEquipada {

	/**
	 * Porcentaje que se aplicará al ataque de la unidad.
	 */
	protected static final double REDUCCION_ATAQUE = 0.9;

	/**
	 * Porcentaje que se aplicará a la energía de la unidad.
	 */
	protected static final double INCREMENTO_ENERGIA = 2;

	/**
	 * Constructor de UnidadConCapa que recibe una Unidad que se decora con una capa
	 * 
	 * @param unidad
	 *            es la unidad que se equipa con una capa
	 */
	public UnidadConCapa(Unidad unidad) {
		super(unidad);
	}
	
	/**
	 * Getter del atributo defensa. <br>
	 * 
	 * @return retorna la defensa de la Unidad.
	 */
	public int getEnergiaTopeActual() {
		return (int) (this.unidad.getEnergiaTopeActual() * INCREMENTO_ENERGIA);
	}
	
	
	/**
	 * Getter del atributo defensa. <br>
	 * 
	 * @return retorna la defensa de la Unidad.
	 */
	public int getAtaque() {
		return (int) (this.unidad.getAtaque() * 0.9);
	}
}