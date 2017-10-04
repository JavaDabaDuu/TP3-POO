package unidad;

/**
 * La clase UnidadConEscudo es una UnidadEquipada. <br>
 * Tendrá las características particulares que no tiene una UnidadEquipada.
 */

public class UnidadConEscudo extends UnidadEquipada {

	/**
	 * Porcentaje de reducción que se aplicará al daño recibido por la unidad.
	 */
	protected final static double PORCENTAJE_REDUCCION_DANIO = 0.6;

	/**
	 * Constructor de UnidadConEscudo que recibe una Unidad que se decora con un
	 * escudo
	 * 
	 * @param unidad
	 *            es la unidad que se equipa con un escudo
	 */
	public UnidadConEscudo(Unidad unidad) {
		super(unidad);
	}

	/**
	 * Sobreescritura del metodo serAtacado, aplicándose el porcentaje de
	 * reducción de daño.
	 * 
	 * @param danio
	 *            es el daño recibido en un ataque
	 */
	@Override
	protected void serAtacado(int danio) {
		this.unidad.serAtacado((int) (danio * PORCENTAJE_REDUCCION_DANIO));
	}

}