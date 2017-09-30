package unidad;

public class UnidadConPuñal extends UnidadEquipada{

	protected static final int INCREMENTO_ATAQUE = 3;
	protected static final int REDUCCION_DEFENSA = 3;
	
	public UnidadConPuñal(Unidad unidad) {
		super(unidad);
		this.ataque += INCREMENTO_ATAQUE;
		this.defensa -= REDUCCION_DEFENSA;
	}
}