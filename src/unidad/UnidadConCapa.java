package unidad;

public class UnidadConCapa extends UnidadEquipada{

	protected static final double REDUCCION_ATAQUE = 0.9;
	protected static final double INCREMENTO_ENERGIA = 2;
	
	public UnidadConCapa(Unidad unidad) {
		super(unidad);
		this.energiaTopeActual *= INCREMENTO_ENERGIA;
		this.ataque *= REDUCCION_ATAQUE;
	}
}