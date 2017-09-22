package unidad;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArqueroTest {

	private Arquero arquero;
	
	@Before
	public void seInstancia() {
		 this.arquero = new Arquero(new Punto(1,1));
	}
	
	@Test
	public void queTengaAtributosCorrectos() {
		Assert.assertEquals(50, this.arquero.getSalud());
		Assert.assertEquals(5, this.arquero.getAtaque());
		Assert.assertEquals(2, this.arquero.getDefensa());
		Assert.assertEquals(20, this.arquero.getCantFlechas());
		Assert.assertEquals(5, this.arquero.getDistanciaMaxima(), 0.0000001);
		Assert.assertEquals(2, this.arquero.getDistanciaMinima(), 0.0000001);
	}
	
	@Test
	public void queAtaque() {
		Assert.assertTrue(this.arquero.atacar(new Soldado(new Punto(3,3))));
	}
	
	@Test
	public void queNoAtaqueSiEstaLejos() {
		Assert.assertFalse(this.arquero.atacar(new Soldado(new Punto(20,20))));
	}
	
	@Test
	public void queNoAtaqueSiEstaCerca() {
		Assert.assertFalse(this.arquero.atacar(new Soldado(new Punto(2,2))));
	}
	
	@Test
	public void queTireFlecha() {
		this.arquero.atacar(new Soldado(new Punto(3,3)));
		Assert.assertEquals(19, this.arquero.getCantFlechas());
	}
	
	@Test
	public void queRecibeFlechas() {
		this.arquero.recibirPaquete();
		Assert.assertEquals(26, this.arquero.getCantFlechas());
	}
	
	@Test
	public void queNoAtaqueSiNoTieneFlechas() {
		for(int i = 0 ; i < 20 ; i++) {
			this.arquero.atacar(new Caballero(new Punto(3,3)));
		}
		Assert.assertFalse(this.arquero.atacar(new Soldado(new Punto(3,3))));
	}
	
	@Test
	public void queSeaAtacado() {
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(this.arquero);
		Assert.assertEquals(47, this.arquero.getSalud());
	}
	
}
