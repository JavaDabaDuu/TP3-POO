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
	
	@Test
	public void equipadoConPunial() {
		UnidadEquipada unidad = new UnidadConPunial(this.lancero);
		Assert.assertEquals(28, unidad.getAtaque());
		Assert.assertEquals(-1, unidad.getDefensa());
	}
	
	@Test
	public void equipadoConCapa() {
		UnidadEquipada unidad = new UnidadConCapa(this.lancero);
		Assert.assertEquals(22, unidad.getAtaque());
	}
	
	@Test
	public void equipadoConEscudo() {
		UnidadEquipada unidad = new UnidadConEscudo(this.lancero);
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(unidad);
		Assert.assertEquals(149, unidad.getSalud());
	}
	
	@Test
	public void equipadoConPunialYCapa() {
		UnidadEquipada unidad = new UnidadConCapa(new UnidadConPunial(this.lancero));
		Assert.assertEquals(25, unidad.getAtaque());
		Assert.assertEquals(-1, unidad.getDefensa());
	}
	
	@Test
	public void equipadoConPunialYEscudo() {
		UnidadEquipada unidad = new UnidadConEscudo(new UnidadConPunial(this.lancero));
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(unidad);
		Assert.assertEquals(149, unidad.getSalud());
		Assert.assertEquals(28, unidad.getAtaque());
		Assert.assertEquals(-1, unidad.getDefensa());
	}
	
	@Test
	public void equipadoConCapaYEscudo() {
		UnidadEquipada unidad = new UnidadConEscudo(new UnidadConCapa(this.lancero));
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(unidad);
		Assert.assertEquals(149, unidad.getSalud());
		Assert.assertEquals(22, unidad.getAtaque());
	}
	
	@Test
	public void equipadoConCapaPunialYEscudo() {
		UnidadEquipada unidad = new UnidadConEscudo(new UnidadConPunial(new UnidadConCapa(this.lancero)));
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(unidad);
		Assert.assertEquals(149, unidad.getSalud());
		Assert.assertEquals(25, unidad.getAtaque());
		Assert.assertEquals(-1, unidad.getDefensa());
	}
}

