package unidad;

import org.junit.Assert;
import org.junit.Test;

public class BatallasSinItemsTest {

	@Test
	public void arqueroVsArquero() {
		// unidades
		Arquero arquero1 = new Arquero(new Punto(2, 5));
		Arquero arquero2 = new Arquero(new Punto(4, 6));
		// batalla
		while (!arquero1.estaMuerto() && !arquero2.estaMuerto()) {
			arquero1.atacar(arquero2);
			arquero2.atacar(arquero1);
		}
		// perdedor muerto
		Assert.assertTrue(arquero2.estaMuerto());
		// ganador vivo
		Assert.assertFalse(arquero1.estaMuerto());
		// estado final arquero1
		Assert.assertEquals(2, arquero1.getSalud());
		Assert.assertEquals(5, arquero1.getAtaque());
		Assert.assertEquals(1, arquero1.getDefensa());
		// estado final arquero2
		Assert.assertEquals(0, arquero2.getSalud());
		Assert.assertEquals(5, arquero2.getAtaque());
		Assert.assertEquals(1, arquero2.getDefensa());
	}

	@Test
	public void arqueroVsCaballero() {
		// unidades
		Arquero arquero = new Arquero(new Punto(2, 5));
		Caballero caballero = new Caballero(new Punto(4, 5));
		// batalla
		while (!arquero.estaMuerto() && !caballero.estaMuerto()) {
			arquero.atacar(caballero);
			caballero.atacar(arquero);
		}
		// perdedor muerto
		Assert.assertTrue(arquero.estaMuerto());
		// ganador vivo
		Assert.assertFalse(caballero.estaMuerto());
		// estado final arquero
		Assert.assertEquals(0, arquero.getSalud());
		Assert.assertEquals(5, arquero.getAtaque());
		Assert.assertEquals(1, arquero.getDefensa());
		// estado final caballero
		Assert.assertEquals(198, caballero.getSalud());
		Assert.assertEquals(50, caballero.getAtaque());
		Assert.assertEquals(4, caballero.getDefensa());
	}

	@Test
	public void arqueroVsLancero() {
		// unidades
		Arquero arquero = new Arquero(new Punto(2, 5));
		Lancero lancero = new Lancero(new Punto(4, 6));
		// batalla
		while (!arquero.estaMuerto() && !lancero.estaMuerto()) {
			arquero.atacar(lancero);
			lancero.atacar(arquero);
		}
		// perdedor muerto
		Assert.assertTrue(arquero.estaMuerto());
		// ganador vivo
		Assert.assertFalse(lancero.estaMuerto());
		// estado final arquero
		Assert.assertEquals(0, arquero.getSalud());
		Assert.assertEquals(5, arquero.getAtaque());
		Assert.assertEquals(1, arquero.getDefensa());
		/// estado final lancero
		Assert.assertEquals(141, lancero.getSalud());
		Assert.assertEquals(25, lancero.getAtaque());
		Assert.assertEquals(2, lancero.getDefensa());
	}

	@Test
	public void arqueroVsSoldado() {
		// unidades
		Arquero arquero = new Arquero(new Punto(1, 2));
		Soldado soldado = new Soldado(new Punto(1, 3));
		// batalla
		while (!arquero.estaMuerto() && !soldado.estaMuerto()) {
			soldado.atacar(arquero);
			arquero.atacar(soldado);
		}
		// perdedor muerto
		Assert.assertTrue(arquero.estaMuerto());
		// ganador vivo
		Assert.assertFalse(soldado.estaMuerto());
		// estado final arquero
		Assert.assertEquals(0, arquero.getSalud());
		Assert.assertEquals(5, arquero.getAtaque());
		Assert.assertEquals(1, arquero.getDefensa());
		// estado final soldado
		Assert.assertEquals(200, soldado.getSalud());
		Assert.assertEquals(10, soldado.getAtaque());
		Assert.assertEquals(3, soldado.getDefensa());
	}

	@Test
	public void caballeroVsCaballero() {
		// unidades
		Caballero caballero1 = new Caballero(new Punto(1, 2));
		Caballero caballero2 = new Caballero(new Punto(1, 3));
		// batalla
		while (!caballero1.estaMuerto() && !caballero2.estaMuerto()) {
			caballero2.atacar(caballero1);
			caballero1.atacar(caballero2);
		}
		// perdedor muerto
		Assert.assertTrue(caballero1.estaMuerto());
		// ganador vivo
		Assert.assertFalse(caballero2.estaMuerto());
		// estado final caballero1
		Assert.assertEquals(0, caballero1.getSalud());
		Assert.assertEquals(50, caballero1.getAtaque());
		Assert.assertEquals(4, caballero1.getDefensa());
		// estado final caballero2
		Assert.assertEquals(108, caballero2.getSalud());
		Assert.assertEquals(50, caballero2.getAtaque());
		Assert.assertEquals(4, caballero2.getDefensa());
	}

	@Test
	public void caballeroVsLancero() {
		// unidades
		Caballero caballero = new Caballero(new Punto(1, 2));
		Lancero lancero = new Lancero(new Punto(2, 3));
		// batalla
		while (!caballero.estaMuerto() && !lancero.estaMuerto()) {
			lancero.atacar(caballero);
			caballero.atacar(lancero);
		}
		// perdedor muerto
		Assert.assertTrue(caballero.estaMuerto());
		// ganador vivo
		Assert.assertFalse(lancero.estaMuerto());
		// estado final caballero
		Assert.assertEquals(0, caballero.getSalud());
		Assert.assertEquals(50, caballero.getAtaque());
		Assert.assertEquals(4, caballero.getDefensa());
		// estado final lancero
		Assert.assertEquals(54, lancero.getSalud());
		Assert.assertEquals(25, lancero.getAtaque());
		Assert.assertEquals(2, lancero.getDefensa());
	}

	@Test
	public void caballeroVsSoldado() {
		// unidades
		Caballero caballero = new Caballero(new Punto(1, 5));
		Soldado soldado = new Soldado(new Punto(1, 3));
		// batalla
		while (!caballero.estaMuerto() && !soldado.estaMuerto()) {
			soldado.atacar(caballero);
			caballero.atacar(soldado);
		}
		// ganador vivo
		Assert.assertFalse(caballero.estaMuerto());
		// perdedor muerto
		Assert.assertTrue(soldado.estaMuerto());
		// estado final caballero
		Assert.assertEquals(200, caballero.getSalud());
		Assert.assertEquals(50, caballero.getAtaque());
		Assert.assertEquals(4, caballero.getDefensa());
		// estado final soldado
		Assert.assertEquals(0, soldado.getSalud());
		Assert.assertEquals(10, soldado.getAtaque());
		Assert.assertEquals(3, soldado.getDefensa());
	}

	@Test
	public void lanceroVsLancero() {
		// unidades
		Lancero lancero1 = new Lancero(new Punto(1, 5));
		Lancero lancero2 = new Lancero(new Punto(1, 3));
		// batalla
		while (!lancero1.estaMuerto() && !lancero2.estaMuerto()) {
			lancero2.atacar(lancero1);
			lancero1.atacar(lancero2);
		}
		// perdedor muerto
		Assert.assertTrue(lancero1.estaMuerto());
		// ganador vivo
		Assert.assertFalse(lancero2.estaMuerto());
		// estado final lancero1
		Assert.assertEquals(0, lancero1.getSalud());
		Assert.assertEquals(25, lancero1.getAtaque());
		Assert.assertEquals(2, lancero1.getDefensa());
		// estado final lancero2
		Assert.assertEquals(12, lancero2.getSalud());
		Assert.assertEquals(25, lancero2.getAtaque());
		Assert.assertEquals(2, lancero2.getDefensa());
	}

	@Test
	public void lanceroVsSoldado() {
		// unidades
		Lancero lancero = new Lancero(new Punto(1, 5));
		Soldado soldado = new Soldado(new Punto(1, 4));
		// batalla
		while (!lancero.estaMuerto() && !soldado.estaMuerto()) {
			soldado.atacar(lancero);
			lancero.atacar(soldado);
		}
		// ganador vivo
		Assert.assertFalse(lancero.estaMuerto());
		// perdedor muerto
		Assert.assertTrue(soldado.estaMuerto());
		// estado final lancero
		Assert.assertEquals(78, lancero.getSalud());
		Assert.assertEquals(25, lancero.getAtaque());
		Assert.assertEquals(2, lancero.getDefensa());
		// estado final soldado
		Assert.assertEquals(0, soldado.getSalud());
		Assert.assertEquals(10, soldado.getAtaque());
		Assert.assertEquals(3, soldado.getDefensa());
	}

	@Test
	public void soldadoVsSoldado() {
		// unidades
		Soldado soldado1 = new Soldado(new Punto(0, 3));
		Soldado soldado2 = new Soldado(new Punto(0, 2.3));
		// batalla
		while (!soldado1.estaMuerto() && !soldado2.estaMuerto()) {
			soldado2.atacar(soldado1);
			soldado1.atacar(soldado2);
			// alguno tiene que consumir agua sino se quedan sin energia y nunca termina la batalla
			soldado1.consumirAgua();
		}
		// ganador vivo
		Assert.assertFalse(soldado1.estaMuerto());
		// perdedor muerto
		Assert.assertTrue(soldado2.estaMuerto());
		// estado final soldado1
		Assert.assertEquals(130, soldado1.getSalud());
		Assert.assertEquals(10, soldado1.getAtaque());
		Assert.assertEquals(3, soldado1.getDefensa());
		// estado final soldado2
		Assert.assertEquals(0, soldado2.getSalud());
		Assert.assertEquals(10, soldado2.getAtaque());
		Assert.assertEquals(3, soldado2.getDefensa());
	}

}
