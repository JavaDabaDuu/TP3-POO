package unidad;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaballeroTest {

	private Caballero caballero;
	
	@Before
	public void seInstancia() {
		 this.caballero = new Caballero(new Punto(1,1));
	}
	
	@Test
	public void queTengaAtributosCorrectos() {
		Assert.assertEquals(200, this.caballero.getSalud());
		Assert.assertEquals(50, this.caballero.getAtaque());
		Assert.assertEquals(4, this.caballero.getDefensa());
		Assert.assertEquals(false, this.caballero.isCaballoRebelde());
		Assert.assertEquals(0, this.caballero.getAtaquesRecibidos());
		Assert.assertEquals(2, this.caballero.getDistanciaMaxima(), 0.0000001);
		Assert.assertEquals(1, this.caballero.getDistanciaMinima(), 0.0000001);
	}
	
	@Test
	public void queAtaque() {
		Assert.assertTrue(this.caballero.atacar(new Soldado(new Punto(2,2))));
	}
	
	@Test
	public void queNoAtaqueSiEstaLejos() {
		Assert.assertFalse(this.caballero.atacar(new Soldado(new Punto(20,20))));
	}
	
	@Test
	public void queNoAtaqueSiEstaCerca() {
		Assert.assertFalse(this.caballero.atacar(new Soldado(new Punto(1.5,1.5))));
	}
	
	@Test
	public void queRecibaAtaque() {
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(this.caballero);
		Assert.assertEquals(1, this.caballero.getAtaquesRecibidos());
	}
	
	@Test
	public void queSePoneRebelde() {
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(this.caballero);
		atacante.atacar(this.caballero);
		atacante.atacar(this.caballero);
		Assert.assertTrue(this.caballero.isCaballoRebelde());
	}
	
	@Test
	public void queSeCalma() {
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(this.caballero);
		atacante.atacar(this.caballero);
		atacante.atacar(this.caballero);
		this.caballero.consumirAgua();
		Assert.assertFalse(this.caballero.isCaballoRebelde());
	}
	
	@Test
	public void queSeaAtacado() {
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(this.caballero);
		Assert.assertEquals(199, this.caballero.getSalud());
	}
	
	@Test
	public void queNoPuedaAtacarSiEstaRebelde() {
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(this.caballero);
		atacante.atacar(this.caballero);
		atacante.atacar(this.caballero);
		Assert.assertFalse(this.caballero.atacar(atacante));
	}
	
}
