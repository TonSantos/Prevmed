package br.com.sistema.modelo;


import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**CLASSE ENTIDADE Usuario**/
@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private long id;
	
	@PrimaryKeyJoinColumn	
	private String nome;
	private String email;	
	private String senha;
	private Calendar dataAcesso;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Calendar getDataAcesso() {
		return dataAcesso;
	}
	public void setDataAcesso(Calendar dataAcesso) {
		this.dataAcesso = dataAcesso;
	}
	
		
	


}
