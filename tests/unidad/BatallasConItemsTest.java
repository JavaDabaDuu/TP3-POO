package unidad;

import org.junit.Assert;
import org.junit.Test;

public class BatallasConItemsTest {

	@Test
	public void CaballeroConCapaVsArqueroConDoblePunial() {
		UnidadEquipada caballero = new UnidadConCapa(new Caballero(new Punto(1, 1)));
		UnidadEquipada arquero = new UnidadConPunial(new UnidadConPunial(new Arquero(new Punto(1, 3))));
		// Le doy un golpe de ventaja al arquero porque es debil como un gatito.
		arquero.atacar(caballero);
		while (!caballero.estaMuerto() && !arquero.estaMuerto()) {
			arquero.atacar(caballero);
			caballero.atacar(arquero);
		}
		// Perdedor muerto y ganador vivo.
		Assert.assertTrue(arquero.estaMuerto());
		Assert.assertFalse(caballero.estaMuerto());
		// Estado final del Caballero.
		Assert.assertEquals(45, caballero.getAtaque());
		Assert.assertEquals(4, caballero.getDefensa());
		Assert.assertEquals(186, caballero.getSalud());
		// Estado final del Arquero.
		Assert.assertEquals(11, arquero.getAtaque());
		Assert.assertEquals(-5, arquero.getDefensa());
		Assert.assertEquals(0, arquero.getSalud());
	}

	@Test
	public void LanceroConEscudoVsLanceroConPunial() {
		UnidadEquipada lanceroEscudo = new UnidadConEscudo(new Lancero(new Punto(1, 1)));
		UnidadEquipada lanceroPunial = new UnidadConPunial(new Lancero(new Punto(1, 2)));

		while (!lanceroEscudo.estaMuerto() && !lanceroPunial.estaMuerto()) {
			lanceroEscudo.atacar(lanceroPunial);
			lanceroPunial.atacar(lanceroEscudo);
		}

		// Perdedor muerto y ganador vivo.
		Assert.assertTrue(lanceroPunial.estaMuerto());
		Assert.assertFalse(lanceroEscudo.estaMuerto());
		// Estado final del Lancero con escudo.
		Assert.assertEquals(25, lanceroEscudo.getAtaque());
		Assert.assertEquals(2, lanceroEscudo.getDefensa());
		Assert.assertEquals(66, lanceroEscudo.getSalud());
		// Estado final del Lancero con punial.
		Assert.assertEquals(28, lanceroPunial.getAtaque());
		Assert.assertEquals(-1, lanceroPunial.getDefensa());
		Assert.assertEquals(0, lanceroPunial.getSalud());
	}

	@Test
	public void SoldadoConPunialYCapaVsCaballeroConEscudo() {
		UnidadEquipada soldado = new UnidadConPunial(new UnidadConCapa(new Soldado(new Punto(1, 1))));
		UnidadEquipada caballero = new UnidadConEscudo(new Caballero(new Punto(1, 2)));

		while (!soldado.estaMuerto() && !caballero.estaMuerto()) {
			soldado.atacar(caballero);
			caballero.atacar(soldado);
			caballero.consumirAgua();
		}
		// Perdedor muerto y ganador vivo.
		Assert.assertTrue(soldado.estaMuerto());
		Assert.assertFalse(caballero.estaMuerto());
		// Estado final del Caballero.
		Assert.assertEquals(50, caballero.getAtaque());
		Assert.assertEquals(4, caballero.getDefensa());
		Assert.assertEquals(179, caballero.getSalud());
		// Estado final del Soldado.
		Assert.assertEquals(12, soldado.getAtaque());
		Assert.assertEquals(0, soldado.getDefensa());
		Assert.assertEquals(0, soldado.getSalud());
	}

	@Test
	public void ArqueroConTripleEscudoVsLanceroConQuintuplePunial() {
		UnidadEquipada lancero = new UnidadConPunial(new UnidadConPunial(
				new UnidadConPunial(new UnidadConPunial(new UnidadConPunial(new Lancero(new Punto(1, 1)))))));
		UnidadEquipada arquero = new UnidadConEscudo(
				new UnidadConEscudo(new UnidadConEscudo(new Arquero(new Punto(1, 2)))));

		while (!lancero.estaMuerto() && !arquero.estaMuerto()) {
			arquero.atacar(lancero);
			lancero.atacar(arquero);
		}
		// Perdedor muerto y ganador vivo.
		Assert.assertTrue(arquero.estaMuerto());
		Assert.assertFalse(lancero.estaMuerto());
		// Estado final del lancero.
		Assert.assertEquals(40, lancero.getAtaque());
		Assert.assertEquals(-13, lancero.getDefensa());
		Assert.assertEquals(150, lancero.getSalud());
		// Estado final del arquero.
		Assert.assertEquals(5, arquero.getAtaque());
		Assert.assertEquals(1, arquero.getDefensa());
		Assert.assertEquals(0, arquero.getSalud());

	}
	
	@Test
	public void ArqueroConCapaVsCaballeroConTriplePunialYEscudo() {
		UnidadEquipada caballero = new UnidadConPunial(new UnidadConPunial(new UnidadConPunial(new UnidadConEscudo(new Caballero(new Punto(1, 1))))));
		UnidadEquipada arquero = new UnidadConCapa(new Arquero(new Punto(1, 3)));
		
		while (arquero.getCantidadFlechas() > 0) {
			arquero.atacar(caballero);
		}
		// El arquero se queda sin flechas, y el caballero no esta muerto. Entonces le doy un paquete de flechas para que siga peleando.
		Assert.assertFalse(caballero.estaMuerto());
		Assert.assertEquals(0, arquero.getCantidadFlechas());
		arquero.recibirPaquete();
		Assert.assertEquals(6, arquero.getCantidadFlechas());
		// El caballero consume agua ya que su caballo se puso rebelde al recibir tantos flechazos.
		caballero.consumirAgua();
		while (!caballero.estaMuerto() && !arquero.estaMuerto()) {
			arquero.atacar(caballero);
			caballero.atacar(arquero);
		}
		// Perdedor muerto y ganador vivo.
		Assert.assertTrue(arquero.estaMuerto());
		Assert.assertFalse(caballero.estaMuerto());
		// Estado final del lancero.
		Assert.assertEquals(59, caballero.getAtaque());
		Assert.assertEquals(-5, caballero.getDefensa());
		Assert.assertEquals(158, caballero.getSalud());
		// Estado final del arquero.
		Assert.assertEquals(4, arquero.getAtaque());
		Assert.assertEquals(1, arquero.getDefensa());
		Assert.assertEquals(0, arquero.getSalud());
	}
}
