package unidad;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PuntoTest {

	private Punto punto;
	
	@Before
	public void queSeInstancia() {
		this.punto = new Punto(3, 4);
	}
	
	@Test
	public void queCoordenadasCorrectas() {
		Assert.assertEquals(3, this.punto.getX(), 0.000001);
		Assert.assertEquals(4, this.punto.getY(), 0.000001);
	}
	
	@Test
	public void queCalculaBienDistancia() {
		Assert.assertEquals(1, this.punto.distanciaCon(new Punto(3, 3)), 0.000001);
	}
}
