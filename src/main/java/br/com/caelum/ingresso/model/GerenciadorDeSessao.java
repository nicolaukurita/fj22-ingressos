package br.com.caelum.ingresso.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class GerenciadorDeSessao {

	private List<Sessao> sessoesDaSala;

	public GerenciadorDeSessao(List<Sessao> sessoesDaSala) {
		this.sessoesDaSala = sessoesDaSala;
	}

	public boolean cabe(Sessao sessaoNova) {
		/*
		 * for (Sessao sessaoDoCinema : sessoesDaSala) { if
		 * (horarioIsConflitante(sessaoDoCinema, sessaoNova)) { return false; }
		 * }
		 */

		return sessoesDaSala.stream().noneMatch(
				sessaoExistente -> horarioIsConflitante(sessaoExistente,
						sessaoNova));
	}

	private boolean horarioIsConflitante(Sessao sessaoExistente,
			Sessao sessaoNova) {

		LocalDate hoje = LocalDate.now();

		LocalTime horarioSessaoExistente = sessaoExistente.getHorario()
				.atDate(hoje).toLocalTime();
		LocalTime horarioSessaoNova = sessaoNova.getHorario().atDate(hoje)
				.toLocalTime();

		boolean terminaAntes = sessaoNova.getHorarioTermino()
				.isBefore(horarioSessaoExistente);

		boolean comecaDepois = sessaoExistente.getHorarioTermino()
				.isBefore(horarioSessaoNova);
		if (terminaAntes || comecaDepois) {
			return false;
		}
		return true;
	}
}
