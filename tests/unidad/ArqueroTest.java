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
		Assert.assertEquals(1, this.arquero.getDefensa());
		Assert.assertEquals(20, this.arquero.getCantidadFlechas());
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
		Assert.assertEquals(19, this.arquero.getCantidadFlechas());
	}
	
	@Test
	public void queRecibeFlechas() {
		this.arquero.recibirPaquete();
		Assert.assertEquals(26, this.arquero.getCantidadFlechas());
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
		Assert.assertEquals(46, this.arquero.getSalud());
	}
	
	@Test
	public void equipadoConPunial() {
		UnidadEquipada unidad = new UnidadConPunial(this.arquero);
		Assert.assertEquals(8, unidad.getAtaque());
		Assert.assertEquals(-2, unidad.getDefensa());
	}
	
	@Test
	public void equipadoConCapa() {
		UnidadEquipada unidad = new UnidadConCapa(this.arquero);
		Assert.assertEquals(4, unidad.getAtaque());
	}
	
	@Test
	public void equipadoConEscudo() {
		UnidadEquipada unidad = new UnidadConEscudo(this.arquero);
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(unidad);
		Assert.assertEquals(49, unidad.getSalud());
	}
	
	@Test
	public void equipadoConPunialYCapa() {
		UnidadEquipada unidad = new UnidadConCapa(new UnidadConPunial(this.arquero));
		Assert.assertEquals(7, unidad.getAtaque());
		Assert.assertEquals(-2, unidad.getDefensa());
	}
	
	@Test
	public void equipadoConPunialYEscudo() {
		UnidadEquipada unidad = new UnidadConEscudo(new UnidadConPunial(this.arquero));
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(unidad);
		Assert.assertEquals(48, unidad.getSalud());
		Assert.assertEquals(8, unidad.getAtaque());
		Assert.assertEquals(-2, unidad.getDefensa());
	}
	
	@Test
	public void equipadoConCapaYEscudo() {
		UnidadEquipada unidad = new UnidadConEscudo(new UnidadConCapa(this.arquero));
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(unidad);
		Assert.assertEquals(49, unidad.getSalud());
		Assert.assertEquals(4, unidad.getAtaque());
	}
	
	@Test
	public void equipadoConCapaPunialYEscudo() {
		UnidadEquipada unidad = new UnidadConEscudo(new UnidadConPunial(new UnidadConCapa(this.arquero)));
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(unidad);
		Assert.assertEquals(48, unidad.getSalud());
		Assert.assertEquals(7, unidad.getAtaque());
		Assert.assertEquals(-2, unidad.getDefensa());
	}
}
