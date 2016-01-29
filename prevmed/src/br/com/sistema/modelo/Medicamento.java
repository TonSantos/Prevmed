package br.com.sistema.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;;

/**CLASSE ENTIDADE MEDICAMENTO**/
@Entity
@Table(name="medicamentos")
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@PrimaryKeyJoinColumn
	private String nome;
	private Calendar dataCriacao;
	
	@Transient
	private String dataExibivel;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao() {
		this.dataCriacao = Calendar.getInstance();
	}  
	public void setDataCriacao(Calendar data) {
		this.dataCriacao = data;
	}
	public String getDataExibivel() {
		return dataExibivel;
	}
	public void setDataExibivel(String dataExibivel) {
		this.dataExibivel = dataExibivel;
	}
	
}
