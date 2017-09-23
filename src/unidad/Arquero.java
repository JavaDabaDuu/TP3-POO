package unidad;

public class Arquero extends Unidad {

	private final static int ENERGIA = 0;
	private final static int SALUD = 50;
	private final static int ATAQUE = 5;
	private final static int DEFENSA = 2;
	private final static double DISTANCIA_MINIMA = 2;
	private final static double DISTANCIA_MAXIMA = 5;
	private final static int CANT_FLECHAS = 20;

	private int cantFlechas;

	public Arquero(Punto posicion) {
		super(posicion);
		this.energiaTopeActual = ENERGIA;
		this.salud = SALUD;
		this.ataque = ATAQUE;
		this.defensa = DEFENSA;
		this.distanciaMinima = DISTANCIA_MINIMA;
		this.distanciaMaxima = DISTANCIA_MAXIMA;
		this.cantFlechas = CANT_FLECHAS;
	}

	@Override
	public void consumirAgua() {

	}

	@Override
	protected void realizarAtaque() {
		this.cantFlechas -= 1;
	}

	@Override
	protected void serAtacado(int daño) {
		
		if (daño > this.defensa) {
			if (this.salud < daño)
				this.salud = 0;
			else
				this.salud -= daño*(1 - this.temple) - this.defensa;
		}
	}

	@Override
	protected boolean puedeRealizarAtaque() {
		return this.cantFlechas >= 1;
	}

	public void recibirPaquete() {
		if(!this.estaMuerto()) {
			if(this.cantFlechas + 6 <= Integer.MAX_VALUE)
				this.cantFlechas += 6;
		}
	}
	
	public int getCantFlechas() {
		return cantFlechas;
	}

}
