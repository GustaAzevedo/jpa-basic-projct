package br.com.ghazz.louja.vo;

import java.time.LocalDate;

public class OrderTotalReportVo {
	private String nomePedido;
	private Long totalPedido;
	private LocalDate lastPedido;
	
	public OrderTotalReportVo(String nomePedido, Long totalPedido, LocalDate lastPedido) {
		super();
		this.nomePedido = nomePedido;
		this.totalPedido = totalPedido;
		this.lastPedido = lastPedido;
	}
	
	@Override
	public String toString() {
		return "OrderTotalReportVo [nomePedido=" + nomePedido + ", totalPedido=" + totalPedido + ", lastPedido="
				+ lastPedido + "]";
	}

	public String getNomePedido() {
		return nomePedido;
	}
	public void setNomePedido(String nomePedido) {
		this.nomePedido = nomePedido;
	}
	public Long getTotalPedido() {
		return totalPedido;
	}
	public void setTotalPedido(Long totalPedido) {
		this.totalPedido = totalPedido;
	}
	public LocalDate getLastPedido() {
		return lastPedido;
	}
	public void setLastPedido(LocalDate lastPedido) {
		this.lastPedido = lastPedido;
	}
	
}
