package br.com.sistema.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**CLASSE ENTIDADE INTERACOES**/
@Entity
@Table(name="interacoes")
public class Interacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="medicamento_a")  
	private long id_medicA;
	
	@Column(name="medicamento_b") 
	private long id_medicB;
	
	@Column(name="efeito_clinico") 
	private String efeito;
	
	@Column(name="grau_da_interacao") 
	private String grau;
	
	@Column(name="inicio_de_acao") 
	private String acao;
	
	private String recomendacao;
	
	@Transient
	private String medicamentoA;
	@Transient
	private String medicamentoB;
	@Transient
	private String corGrau;
	
	
	public long getId_medicA() {
		return id_medicA;
	}
	public void setId_medicA(long id_medicA) {
		this.id_medicA = id_medicA;
	}
	public long getId_medicB() {
		return id_medicB;
	}
	public void setId_medicB(long id_medicB) {
		this.id_medicB = id_medicB;
	}
	public String getEfeito() {
		return efeito;
	}
	public void setEfeito(String efeito) {
		this.efeito = efeito;
	}
	public String getGrau() {
		return grau;
	}
	public void setGrau(String grau) {
		this.grau = grau;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public String getRecomendacao() {
		return recomendacao;
	}
	public void setRecomendacao(String recomendacao) {
		this.recomendacao = recomendacao;
	}
	public String getMedicamentoA() {
		return medicamentoA;
	}
	public void setMedicamentoA(String medicamentoA) {
		this.medicamentoA = medicamentoA;
	}
	public String getMedicamentoB() {
		return medicamentoB;
	}
	public void setMedicamentoB(String medicamentoB) {
		this.medicamentoB = medicamentoB;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCorGrau() {
		return corGrau;
	}
	public void setCorGrau(String corGrau) {
		this.corGrau = corGrau;
	}
	
	
	
}
