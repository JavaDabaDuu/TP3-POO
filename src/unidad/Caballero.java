package unidad;

public class Caballero extends Unidad {

	private final static int ENERGIA = 0;
	private final static int SALUD = 200;
	private final static int ATAQUE = 50;
	private final static int DEFENSA = 4;
	private final static double DISTANCIA_MINIMA = 1;
	private final static double DISTANCIA_MAXIMA = 2;
	
	private boolean caballoRebelde;
	private int ataquesRecibidos;

	public Caballero(Punto posicion) {
		super(posicion);
		this.energiaTopeActual = ENERGIA;
		this.salud = SALUD;
		this.ataque = ATAQUE;
		this.defensa = DEFENSA;
		this.distanciaMinima = DISTANCIA_MINIMA;
		this.distanciaMaxima = DISTANCIA_MAXIMA;
		this.caballoRebelde = false;
		this.ataquesRecibidos = 0;
	}

	@Override
	public void consumirAgua() {
		if(!this.estaMuerto())
			this.caballoRebelde = false;
	}

	@Override
	protected void realizarAtaque() {

	}

	@Override
	protected void serAtacado(int daño) {
		if (daño > this.defensa) {
			if (this.salud < daño)
				this.salud = 0;
			else
				this.salud -= daño*(1 - this.temple) - this.defensa;
		}
		if (!this.estaMuerto()) {
			if (!this.caballoRebelde)
				this.ataquesRecibidos++;
			if (this.ataquesRecibidos == 3) {
				this.caballoRebelde = true;
				this.ataquesRecibidos = 0;
			}
		}
	}

	@Override
	protected boolean puedeRealizarAtaque() {
		return !this.caballoRebelde;
	}

	public boolean isCaballoRebelde() {
		return caballoRebelde;
	}

	public int getAtaquesRecibidos() {
		return ataquesRecibidos;
	}

}
