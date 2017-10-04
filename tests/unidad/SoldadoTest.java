package unidad;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoldadoTest {

	private Soldado soldado;
	
	@Before
	public void seInstancia() {
		 this.soldado = new Soldado(new Punto(1,1));
	}
	
	@Test
	public void queTengaAtributosCorrectos() {
		Assert.assertEquals(200, this.soldado.getSalud());
		Assert.assertEquals(10, this.soldado.getAtaque());
		Assert.assertEquals(3, this.soldado.getDefensa());
		Assert.assertEquals(100, this.soldado.getEnergia());
		Assert.assertEquals(1, this.soldado.getDistanciaMaxima(), 0.0000001);
		Assert.assertEquals(0.5, this.soldado.getDistanciaMinima(), 0.0000001);
	}
	
	@Test
	public void queAtaque() {
		Assert.assertTrue(this.soldado.atacar(new Soldado(new Punto(1.5,1.5))));
	}
	
	@Test
	public void queNoAtaqueSiEstaLejos() {
		Assert.assertFalse(this.soldado.atacar(new Soldado(new Punto(20,20))));
	}
	
	@Test
	public void queNoAtaqueSiEstaCerca() {
		Assert.assertFalse(this.soldado.atacar(new Soldado(new Punto(1,1))));
	}
	
	@Test
	public void quePierdeEnergia() {
		this.soldado.atacar(new Soldado(new Punto(1.5,1.5)));
		Assert.assertEquals(90, this.soldado.getEnergia());
	}
	
	@Test
	public void queConsumeAgua() {
		this.soldado.atacar(new Soldado(new Punto(1.5,1.5)));
		this.soldado.consumirAgua();
		Assert.assertEquals(100, this.soldado.getEnergia());
	}
	
	@Test
	public void queNoAtaqueSiNoTieneEnergia() {
		for(int i = 0 ; i < 10 ; i++) {
			this.soldado.atacar(new Caballero(new Punto(1.5,1.5)));
		}
		Assert.assertFalse(this.soldado.atacar(new Soldado(new Punto(3,3))));
	}
	
	@Test
	public void queSeaAtacado() {
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(this.soldado);
		Assert.assertEquals(198, this.soldado.getSalud());
	}
	
	@Test
	public void equipadoConPunial() {
		UnidadEquipada unidad = new UnidadConPunial(this.soldado);
		Assert.assertEquals(13, unidad.getAtaque());
		Assert.assertEquals(0, unidad.getDefensa());
	}
	
	@Test
	public void equipadoConCapa() {
		UnidadEquipada unidad = new UnidadConCapa(this.soldado);
		Assert.assertEquals(9, unidad.getAtaque());
	}
	
	@Test
	public void equipadoConEscudo() {
		UnidadEquipada unidad = new UnidadConEscudo(this.soldado);
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(unidad);
		Assert.assertEquals(200, unidad.getSalud());
	}
	
	@Test
	public void equipadoConPunialYCapa() {
		UnidadEquipada unidad = new UnidadConCapa(new UnidadConPunial(this.soldado));
		Assert.assertEquals(11, unidad.getAtaque());
		Assert.assertEquals(0, unidad.getDefensa());
	}
	
	@Test
	public void equipadoConPunialYEscudo() {
		UnidadEquipada unidad = new UnidadConEscudo(new UnidadConPunial(this.soldado));
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(unidad);
		Assert.assertEquals(200, unidad.getSalud());
		Assert.assertEquals(13, unidad.getAtaque());
		Assert.assertEquals(0, unidad.getDefensa());
	}
	
	@Test
	public void equipadoConCapaYEscudo() {
		UnidadEquipada unidad = new UnidadConEscudo(new UnidadConCapa(this.soldado));
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(unidad);
		Assert.assertEquals(200, unidad.getSalud());
		Assert.assertEquals(9, unidad.getAtaque());
	}
	
	@Test
	public void equipadoConCapaPunialYEscudo() {
		UnidadEquipada unidad = new UnidadConEscudo(new UnidadConPunial(new UnidadConCapa(this.soldado)));
		Arquero atacante = new Arquero(new Punto(3,3));
		atacante.atacar(unidad);
		Assert.assertEquals(200, unidad.getSalud());
		Assert.assertEquals(12, unidad.getAtaque());
		Assert.assertEquals(0, unidad.getDefensa());
	}
}
