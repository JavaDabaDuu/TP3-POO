package unidad;

// Decorator

public abstract class UnidadEquipada extends Unidad{
	
	public UnidadEquipada(Unidad unidad) {
		super(unidad);
	}

	@Override
	public void consumirAgua() {
		this.consumirAgua();
	}

	@Override
	protected boolean puedeRealizarAtaque() {
		return this.puedeRealizarAtaque();
	}

	@Override
	protected void realizarAtaque() {
		this.realizarAtaque();
	}

	@Override
	protected void serAtacado(int daño) {
		this.serAtacado(daño);
	}
	
}