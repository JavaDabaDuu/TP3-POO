package unidad;

/**
 * La clase abstracta UnidadEquipada extiende de la clase Unidad. <br>
 * Funciona como Decorador de dicha clase, ya que permite "equipar" a las unidades con distintos items. <br>
 * Tiene un constructor por copia que recibe una Unidad, ya que los items modifican atributos.
 * 
 * @author JavaDabaDuu
 */

public abstract class UnidadEquipada extends Unidad{
	
	/**
	 * El constructor por copia Unidad recibe una Unidad de la cual copiará sus atributos.
	 */
	public UnidadEquipada(Unidad unidad) {
		super(unidad);
	}

	/**
	 * Sobreescritura del metodo de la clase Padre, dependerá del tipo de Unidad que lo llame.
	 */
	@Override
	public void consumirAgua() {
		this.consumirAgua();
	}

	/**
	 * Sobreescritura del metodo de la clase Padre, dependerá del tipo de Unidad que lo llame.
	 */
	@Override
	protected boolean puedeRealizarAtaque() {
		return this.puedeRealizarAtaque();
	}

	/**
	 * Sobreescritura del metodo de la clase Padre, dependerá del tipo de Unidad que lo llame.
	 */
	@Override
	protected void realizarAtaque() {
		this.realizarAtaque();
	}

	/**
	 * Sobreescritura del metodo de la clase Padre, dependerá del tipo de Unidad que lo llame.
	 */
	@Override
	protected void serAtacado(int daño) {
		this.serAtacado(daño);
	}
	
}