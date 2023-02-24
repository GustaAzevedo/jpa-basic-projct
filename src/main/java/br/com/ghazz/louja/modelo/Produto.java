package br.com.ghazz.louja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome")
	private String name;
	@Column(name = "descricao")
	private String desc;
	@Column(name = "preco")
	private BigDecimal price;
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro = LocalDate.now();
	@ManyToOne
	private Categoria categoria;
	
	public Produto() {
		super();
	}

	public Produto(String name, String desc, BigDecimal price, Categoria categoria) {
		super();
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.categoria = categoria;
	}
	
	public Long getId() {
		return id;
	}
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
