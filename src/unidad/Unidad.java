package unidad;

import java.util.ArrayList;

/**
 * La clase abstracta Unidad engloba las caracteristicas comunes a todas las
 * unidades. <br>
 * Tiene un constructor que recibe la posicion inicial de la unidad. <br>
 * 
 * @author JavaDabaDuu
 */

public abstract class Unidad {

	/**
	 * Cantidad de items máxima que pueden equiparse en una Unidad.
	 */
	protected final static int CANT_MAX_ITEMS = 3;

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
	 * Porcentaje de reducción de daño.
	 */
	protected double temple;

	/**
	 * DistanciaMinima desde la cual una unidad puede atacar a otra.
	 */
	protected double distanciaMinima;

	/**
	 * DistanciaMaxima desde la cual una unidad puede atacar a otra.
	 */
	protected double distanciaMaxima;

	/**
	 * Posicion actual de la unidad, respecto del 0.
	 */
	protected Punto posicion;

	/**
	 * Tope de energía que tiene el soldado. <br>
	 * Este tope puede ser modificado al equipar una capa.
	 */
	protected int energiaTopeActual;

	/**
	 * Array con los items equipados en la unidad actualmente.
	 */
	protected ArrayList<Item> items;

	/**
	 * El constructor de Unidad recibe un Punto, que representa la posicion de
	 * la Unidad.
	 */
	public Unidad(Punto posicion) {
		this.posicion = posicion;
	}

	/**
	 * El método consumirAgua() será implementado por cada una de las clases
	 * hijas.
	 */
	public abstract void consumirAgua();

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
	 * El método serAtacado() será implementado por cada una de las clases
	 * hijas. <br>
	 * Se encarga de ciertas modificaciones a la unidad luego de ser atacada por
	 * otra.
	 * 
	 * @param daño
	 */
	protected abstract void serAtacado(int daño);

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
	 * Getter del array de items. <br>
	 * 
	 * @return retorna el array de items que tiene equipados la unidad. <br>
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Setter de la posición. <br>
	 */
	void setPosicion(Punto posicion) {
		this.posicion = posicion;
	}

	/**
	 * Getter de la posición. <br>
	 * 
	 * @return retorna la posicion actual de la Unidad.
	 */
	public Punto getPosicion() {
		return posicion;
	}

	/**
	 * El método estaMuerto() informa si la unidad está muerta o no. <br>
	 * 
	 * @return retorna si la unidad esta muerta o no.
	 */
	public boolean estaMuerto() {
		return this.salud == 0;
	}

	/**
	 * Método para equipar un ítem.<br>
	 * Al aplcar un ítem, se aplica un bonus sobre la unidad.
	 * 
	 * @param item
	 *            es el ítem a equipar.
	 * @return un booleano que indica si el ítem fue equipado.
	 */
	protected boolean equipar(Item item) {
		if (this.items.size() < CANT_MAX_ITEMS) {
			items.add(item);
			item.aplicarbonus();
			return true;
		}
		return false;
	}

}
