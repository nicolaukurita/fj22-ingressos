package br.com.caelum.ingresso.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.GerenciadorDeSessao;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessaoTest {
	private Filme rogueOne;
	private Sala sala3D;
	private Sessao sessaoDasDez;
	private Sessao sessaoDasTreze;
	private Sessao sessaoDasDezoito;

	@Before
	public void preparaSessoes() {

		this.rogueOne = new Filme("Rogue	One", Duration.ofMinutes(120),
				"SCI-FI");
		this.sala3D = new Sala("Sala	3D");

		this.sessaoDasDez = new Sessao(LocalTime.parse("10:00:00"), rogueOne,
				sala3D);
		this.sessaoDasTreze = new Sessao(LocalTime.parse("13:00:00"), rogueOne,
				sala3D);
		this.sessaoDasDezoito = new Sessao(LocalTime.parse("18:00:00"),
				rogueOne, sala3D);
	}

	@Test
	public void deveAdicionarSeListaDaSessaoEstiverVazia() {
		List<Sessao> sessoes = Collections.emptyList();
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);

		/*
		 * Filme filme = new Filme("Rogue	One", Duration.ofMinutes(120),
		 * "SCI-FI", BigDecimal.ONE);
		 */
		rogueOne.setDuracao(120);
		LocalTime horario = LocalTime.parse("10:00:00");
		Sala sala = new Sala("");

		Sessao sessao = new Sessao(horario, rogueOne, sala);

		boolean cabe = gerenciador.cabe(sessao);

		Assert.assertTrue(cabe);
	}

}
