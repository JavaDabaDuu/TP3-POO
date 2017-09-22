package unidad;

import java.util.ArrayList;

public abstract class Unidad {

	protected final static int CANT_MAX_ITEMS = 3;
	
	protected int salud;
	protected int ataque;
	protected int defensa;
	protected double distanciaMinima;
	protected double distanciaMaxima;
	protected Punto posicion;
	protected ArrayList<Item> items;
	
	public Unidad(Punto posicion) {
		this.posicion = posicion;
	}
	
	public abstract void consumirAgua();
	
	public boolean atacar(Unidad unidad) {
		if(this.puedeAtacar(unidad)) {
			this.realizarAtaque();
			unidad.serAtacado(this.ataque);
			return true;
		}
		return false;
	}
	
	protected boolean puedeAtacar(Unidad unidad) {
		if(this.estaMuerto() || unidad.estaMuerto())
			return false;
		double distancia = this.posicion.distanciaCon(unidad.getPosicion());
		if(distancia >= this.distanciaMinima && distancia <= this.distanciaMaxima && this.puedeRealizarAtaque())
			return true;
		return false;
	}
	
	protected abstract boolean puedeRealizarAtaque();

	protected abstract void realizarAtaque();

	protected abstract void serAtacado(int daño);
	
	public int getSalud() {
		return salud;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public double getDistanciaMinima() {
		return distanciaMinima;
	}

	public double getDistanciaMaxima() {
		return distanciaMaxima;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public Punto getPosicion() {
		return posicion;
	}
	
	public boolean estaMuerto() {
		return this.salud == 0;
	}
	
	/*
	protected boolean equipar(Item item) {
		if(this.items.size() < CANT_MAX_ITEMS) {
			items.add(item);
			item.aplicarbonus();
			return true;
		}
		
		return false;
	}
	*/
}
