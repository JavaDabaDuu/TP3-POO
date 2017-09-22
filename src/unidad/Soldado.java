package unidad;

public class Soldado extends Unidad {

	private final static int ENERGIA = 100;
	private final static int SALUD = 200;
	private final static int ATAQUE = 10;
	private final static int DEFENSA = 3;
	private final static double DISTANCIA_MINIMA = 0.5;
	private final static double DISTANCIA_MAXIMA = 1;

	private int energia;
	private int energiaTopeActual;

	public Soldado(Punto posicion) {
		super(posicion);
		this.energiaTopeActual = ENERGIA;
		this.energia = this.energiaTopeActual;
		this.salud = SALUD;
		this.ataque = ATAQUE;
		this.defensa = DEFENSA;
		this.distanciaMinima = DISTANCIA_MINIMA;
		this.distanciaMaxima = DISTANCIA_MAXIMA;
	}

	@Override
	public void consumirAgua() {
		if(!this.estaMuerto())
			this.energia = this.energiaTopeActual;
	}

	@Override
	protected void realizarAtaque() {
		this.energia -= 10;
	}

	@Override
	protected void serAtacado(int daño) {
		if (daño > this.defensa) {
			if (this.salud < daño)
				this.salud = 0;
			else
				this.salud -= daño - this.defensa;
		}
	}

	@Override
	protected boolean puedeRealizarAtaque() {
		return this.energia >= 10;
	}

	public int getEnergia() {
		return energia;
	}

	void setEnergia(int energia) {
		this.energia = energia;
	}

}
