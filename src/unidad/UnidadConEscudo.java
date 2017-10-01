package unidad;

/**
 * La clase UnidadConEscudo es una UnidadEquipada. <br>
 * Tendrá las características particulares que no tiene una UnidadEquipada.
 */

public class UnidadConEscudo extends UnidadEquipada {

	/**
	 * Porcentaje de reducción que se aplicará al daño recibido por la unidad.
	 */
	protected final static double PORCENTAJE_REDUCCION_DAÑO = 0.4;

	/**
	 * Constructor de UnidadConCapa que recibe una Unidad. En este caso no
	 * cambian sus atributos.
	 * 
	 * @param unidad
	 *            es la unidad a la se equipa con un escudo
	 */
	public UnidadConEscudo(Unidad unidad) {
		super(unidad);
	}

	/**
	 * Sobreescritura del metodo serAtacado, aplicándose el porcentaje de
	 * reducción de daño.
	 * 
	 * @param daño
	 *            es el daño recibido en un ataque
	 */
	@Override
	protected void serAtacado(int daño) {
		if (daño > this.defensa) {
			if (this.salud < (int) (daño * PORCENTAJE_REDUCCION_DAÑO))
				this.salud = 0;
			else
				this.salud -= (int) ((daño - this.defensa) * PORCENTAJE_REDUCCION_DAÑO);
		}
	}
}