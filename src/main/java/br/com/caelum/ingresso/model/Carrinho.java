package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Carrinho {

	private List<Ingresso> ingressos = new ArrayList<>();

	public void add(Ingresso ingresso) {
		ingressos.add(ingresso);
	}

	public boolean isSelecionado(Lugar lugar) {
		return ingressos.stream().map(Ingresso::getLugar)
				.anyMatch(l -> l.equals(lugar));
	}

	public BigDecimal getTotal() {
		return ingressos.stream().map(Ingresso::getPreco)
				.reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
	}

	public Compra toCompra() {
		return new Compra(ingressos);
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ingressos == null) ? 0 : ingressos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrinho other = (Carrinho) obj;
		if (ingressos == null) {
			if (other.ingressos != null)
				return false;
		} else if (!ingressos.equals(other.ingressos))
			return false;
		return true;
	}

}
