package unidad;

/**
 * La clase abstracta UnidadEquipada extiende de la clase Unidad. y tiene una Unidad <br>
 * Funciona como Decorador de dicha clase, ya que permite "equipar" a las
 * unidades con distintos ítems. <br>
 * Tiene un constructor por copia que recibe una Unidad, ya que los ítems
 * modifican atributos.
 * 
 * @author JavaDabaDuu
 */

public abstract class UnidadEquipada extends Unidad {

	/**
	 * Unidad que es equipada con un ítem
	 */
	protected Unidad unidad;
	
	/**
	 * El constructor por copia Unidad recibe una Unidad de la cual copiará sus
	 * atributos.
	 * 
	 * @param unidad
	 *            es la unidad a equipar.
	 */
	public UnidadEquipada(Unidad unidad) {
		super(unidad);
		this.unidad = unidad;
	}

	/**
	 * Sobreescritura del método de la clase Padre, dependerá del tipo de Unidad
	 * que lo llame.
	 */
	@Override
	public void consumirAgua() {
		this.unidad.consumirAgua();
	}
	
	/**
	 * Sobreescritura del método de la clase Padre, dependerá del tipo de Unidad
	 * que lo llame.
	 */
	@Override
	public void recibirPaquete() {
		this.unidad.recibirPaquete();
	}

	/**
	 * Sobreescritura del método de la clase Padre, dependerá del tipo de Unidad
	 * que lo llame.
	 * 
	 * @return un booleano que indica si se puede realizar un ataque
	 */
	@Override
	protected boolean puedeRealizarAtaque() {
		return this.unidad.puedeRealizarAtaque();
	}

	/**
	 * Sobreescritura del método de la clase Padre, dependerá del tipo de Unidad
	 * que lo llame.
	 */
	@Override
	protected void realizarAtaque() {
		this.unidad.realizarAtaque();
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
		this.unidad.serAtacado(danio);
	}
	
	/**
	 * Getter del atributo salud. <br>
	 * 
	 * @return retorna la salud de la Unidad.
	 */
	public int getSalud() {
		return this.unidad.getSalud();
	}

	/**
	 * Getter del atributo ataque. <br>
	 * 
	 * @return retorna el ataquede la Unidad.
	 */
	public int getAtaque() {
		return this.unidad.getAtaque();
	}

	/**
	 * Getter del atributo defensa. <br>
	 * 
	 * @return retorna la defensa de la Unidad.
	 */
	public int getDefensa() {
		return this.unidad.getDefensa();
	}

	/**
	 * Getter del atributo distanciaMinima. <br>
	 * 
	 * @return retorna la distanciaMinima desde la cual la unidad puede atacar.
	 */
	public double getDistanciaMinima() {
		return this.unidad.getDistanciaMinima();
	}

	/**
	 * Getter del atributo distanciaMaxima. <br>
	 * 
	 * @return retorna la distanciaMaxima desde la cual la unidad puede atacar.
	 */
	public double getDistanciaMaxima() {
		return this.unidad.getDistanciaMaxima();
	}

	/**
	 * Getter del atributo EnergiaTopeActual. <br>
	 * 
	 * @return retorna la energía tope actual de la unidad.
	 */
	protected int getEnergiaTopeActual() {
		return this.unidad.getEnergiaTopeActual();
	}

	/**
	 * Setter de la posición. <br>
	 * 
	 * @param posicion
	 *            es la posicion de la unidad
	 */
	void setPosicion(Punto posicion) {
		this.unidad.setPosicion(posicion);
	}

	/**
	 * Getter de la posición. <br>
	 * 
	 * @return retorna la posición actual de la Unidad.
	 */
	public Punto getPosicion() {
		return this.unidad.getPosicion();
	}

	/**
	 * El método estaMuerto() informa si la unidad está muerta o no. <br>
	 * 
	 * @return retorna si la unidad está muerta o no.
	 */
	public boolean estaMuerto() {
		return this.unidad.estaMuerto();
	}
	
	/**
	 * Getter de la cantidad de flechas. <br>
	 * 
	 * @return retorna la posición actual de la Unidad.
	 */
	public int getCantidadFlechas() {
		return this.unidad.getCantidadFlechas();
	}
	
}