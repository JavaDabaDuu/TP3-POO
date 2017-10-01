package unidad;

/**
 * La clase abstracta UnidadEquipada extiende de la clase Unidad. <br>
 * Funciona como Decorador de dicha clase, ya que permite "equipar" a las
 * unidades con distintos ítems. <br>
 * Tiene un constructor por copia que recibe una Unidad, ya que los ítems
 * modifican atributos.
 * 
 * @author JavaDabaDuu
 */

public abstract class UnidadEquipada extends Unidad {

	/**
	 * El constructor por copia Unidad recibe una Unidad de la cual copiará sus
	 * atributos.
	 * 
	 * @param unidad
	 *            es la unidad a equipar.
	 */
	public UnidadEquipada(Unidad unidad) {
		super(unidad);
	}

	/**
	 * Sobreescritura del método de la clase Padre, dependerá del tipo de Unidad
	 * que lo llame.
	 */
	@Override
	public void consumirAgua() {
		this.consumirAgua();
	}

	/**
	 * Sobreescritura del método de la clase Padre, dependerá del tipo de Unidad
	 * que lo llame.
	 * 
	 * @return un booleano que indica si se puede realizar un ataque
	 */
	@Override
	protected boolean puedeRealizarAtaque() {
		return this.puedeRealizarAtaque();
	}

	/**
	 * Sobreescritura del método de la clase Padre, dependerá del tipo de Unidad
	 * que lo llame.
	 */
	@Override
	protected void realizarAtaque() {
		this.realizarAtaque();
	}

	/**
	 * Sobreescritura del método de la clase Padre, dependerá del tipo de Unidad
	 * que lo llame.
	 * 
	 * @param danio
	 *            es el daño que recibe la unidad en un ataque.
	 */
	@Override
	protected void serAtacado(int danio) {
		this.serAtacado(danio);
	}

}