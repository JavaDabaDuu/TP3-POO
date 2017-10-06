package unidad;

/**
 * La clase abstracta Unidad engloba las características comunes a todas las
 * unidades. <br>
 * Tiene un constructor que recibe la posición inicial de la unidad, y uno por
 * copia. <br>
 * 
 * @author JavaDabaDuu
 */

public abstract class Unidad {

	/**
	 * Salud inicial de la unidad.
	 */
	protected int salud;

	/**
	 * Ataque inicial de la unidad.
	 */
	protected int ataque;

	/**
	 * Defensa inicial de la unidad.
	 */
	protected int defensa;

	/**
	 * Distancia mínima desde la cual una unidad puede atacar a otra.
	 */
	protected double distanciaMinima;

	/**
	 * Distancia máxima desde la cual una unidad puede atacar a otra.
	 */
	protected double distanciaMaxima;

	/**
	 * Posición actual de la unidad.
	 */
	protected Punto posicion;

	/**
	 * Tope de energía que tiene el soldado. <br>
	 * Este tope puede ser modificado al equipar una capa.
	 */
	protected int energiaTopeActual;

	/**
	 * Cantidad actual de flechas que el arquero tiene en su carcaj.
	 */
	protected int cantidadFlechas;
	
	/**
	 * El constructor de Unidad recibe un punto en el que se sitúa la unidad.
	 * 
	 * @param posicion
	 *            es la posicion en la se en ubica la unidad
	 */
	public Unidad(Punto posicion) {
		this.posicion = posicion;
	}

	/**
	 * El constructor por copia Unidad recibe una Unidad de la cual copiará sus
	 * atributos.
	 * 
	 * @param unidad
	 *            es la unidad de la que se copian los atributos
	 */
	public Unidad(Unidad unidad) {
		this.ataque = unidad.getAtaque();
		this.defensa = unidad.getDefensa();
		this.distanciaMaxima = unidad.getDistanciaMaxima();
		this.distanciaMinima = unidad.getDistanciaMinima();
		this.energiaTopeActual = unidad.getEnergiaTopeActual();
		this.salud = unidad.getSalud();
		this.posicion = unidad.getPosicion();
		this.cantidadFlechas = unidad.getCantidadFlechas();
	}

	/**
	 * El método consumirAgua() será implementado por cada una de las clases
	 * hijas.
	 */
	public abstract void consumirAgua();
	
	/**
	 * El método recibirPaquete() será implementado por cada una de las clases
	 * hijas.
	 */
	public abstract void recibirPaquete();
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
		if (this.puedeAtacar(unidad)) {
			this.realizarAtaque();
			unidad.serAtacado(this.ataque);
			return true;
		}
		return false;
	}

	/**
	 * El método puedeAtacar() se encarga de verificar si una unidad puede
	 * atacar o no a otra. <br>
	 * Para esto verifica que ninguna de las dos unidades esté muerta, que la
	 * distancia entre ella sea la apropiada, y otra condición especifica de la
	 * unidad que realiza el ataque. <br>
	 * 
	 * @param unidad
	 *            Unidad la cual puede o no ser atacada. <br>
	 * @return retorna si la unidad puede atacar o no.
	 */
	protected boolean puedeAtacar(Unidad unidad) {
		if (this.estaMuerto() || unidad.estaMuerto())
			return false;
		double distancia = this.posicion.distanciaCon(unidad.getPosicion());
		if (distancia >= this.distanciaMinima && distancia <= this.distanciaMaxima && this.puedeRealizarAtaque())
			return true;
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
		if (danio > this.defensa) {
			if (this.salud < danio)
				this.salud = 0;
			else
				this.salud -= danio - this.defensa;
		}
	}

	/**
	 * El método puedeRealizarAtaque() será implementado por cada una de las
	 * clases hijas. <br>
	 * 
	 * @return retorna si la unidad puede realizar el ataque o no.
	 */
	protected abstract boolean puedeRealizarAtaque();

	/**
	 * El método realizarAtaque() será implementado por cada una de las clases
	 * hijas. <br>
	 * Se encarga de realizar ciertas modificaciones a la unidad luego de atacar
	 * a otra.
	 */
	protected abstract void realizarAtaque();

	/**
	 * Getter del atributo salud. <br>
	 * 
	 * @return retorna la salud de la Unidad.
	 */
	public int getSalud() {
		return salud;
	}

	/**
	 * Getter del atributo ataque. <br>
	 * 
	 * @return retorna el ataquede la Unidad.
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * Getter del atributo defensa. <br>
	 * 
	 * @return retorna la defensa de la Unidad.
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * Getter del atributo distanciaMinima. <br>
	 * 
	 * @return retorna la distanciaMinima desde la cual la unidad puede atacar.
	 */
	public double getDistanciaMinima() {
		return distanciaMinima;
	}

	/**
	 * Getter del atributo distanciaMaxima. <br>
	 * 
	 * @return retorna la distanciaMaxima desde la cual la unidad puede atacar.
	 */
	public double getDistanciaMaxima() {
		return distanciaMaxima;
	}

	/**
	 * Getter del atributo EnergiaTopeActual. <br>
	 * 
	 * @return retorna la energía tope actual de la unidad.
	 */
	protected int getEnergiaTopeActual() {
		return this.energiaTopeActual;
	}

	/**
	 * Setter de la posición. <br>
	 * 
	 * @param posicion
	 *            es la posicion de la unidad
	 */
	void setPosicion(Punto posicion) {
		this.posicion = posicion;
	}

	/**
	 * Getter de la posición. <br>
	 * 
	 * @return retorna la posición actual de la Unidad.
	 */
	public Punto getPosicion() {
		return posicion;
	}
	
	/**
	 * Getter de la cantidad de flechas. <br>
	 * 
	 * @return retorna la posición actual de la Unidad.
	 */
	public int getCantidadFlechas() {
		return this.cantidadFlechas;
	}

	/**
	 * El método estaMuerto() informa si la unidad está muerta o no. <br>
	 * 
	 * @return retorna si la unidad está muerta o no.
	 */
	public boolean estaMuerto() {
		return this.salud == 0;
	}
}