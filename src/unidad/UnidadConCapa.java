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
	 * Constructor de UnidadConCapa que recibe una Unidad a la cual se le
	 * modificarán sus atributos.
	 * 
	 * @param unidad
	 *            es la unidad que se equipa con una capa
	 */
	public UnidadConCapa(Unidad unidad) {
		super(unidad);
		this.energiaTopeActual *= INCREMENTO_ENERGIA;
		this.ataque *= REDUCCION_ATAQUE;
	}
}