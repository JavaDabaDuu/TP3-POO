package unidad;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LanceroTest {

	private Lancero lancero;
	
	@Before
	public void seInstancia() {
		 this.lancero = new Lancero(new Punto(1,1));
	}
	
	@Test
	public void queTengaAtributosCorrectos() {
		Assert.assertEquals(150, this.lancero.getSalud());
		Assert.assertEquals(25, this.lancero.getAtaque());
		Assert.assertEquals(2, this.lancero.getDefensa());
		Assert.assertEquals(3, this.lancero.getDistanciaMaxima(), 0.0000001);
		Assert.assertEquals(1, this.lancero.getDistanciaMinima(), 0.0000001);
	}
	
	@Test
	public void queAtaque() {
		Assert.assertTrue(this.lancero.atacar(new Soldado(new Punto(3,3))));
	}
	
	@Test
	public void queNoAtaqueSiEstaLejos() {
		Assert.assertFalse(this.lancero.atacar(new Soldado(new Punto(20,20))));
	}
	
	@Test
	public void queNoAtaqueSiEstaCerca() {
		Assert.assertFalse(this.lancero.atacar(new Soldado(new Punto(1.5,1.5))));
	}
	
	@Test
	public void queSeaAtacado() {
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(this.lancero);
		Assert.assertEquals(147, this.lancero.getSalud());
	}
	
}

