package unidad;

public class UnidadConEscudo extends UnidadEquipada {

	protected final static double PORCENTAJE_REDUCCION = 0.6;
	
	public UnidadConEscudo(Unidad unidad) {
		super(unidad);
	}

	@Override
	protected void serAtacado(int daño) {
		if (daño > this.defensa) {
			if (this.salud < (int)(daño*PORCENTAJE_REDUCCION))
				this.salud = 0;
			else
				this.salud -= (int)((daño - this.defensa)*PORCENTAJE_REDUCCION);
		}
	}
}