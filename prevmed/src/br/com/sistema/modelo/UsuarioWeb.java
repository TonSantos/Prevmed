package br.com.sistema.modelo;


import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 *Classe que vai verificar usuario navegando
 **/
@Component
@SessionScoped
public class UsuarioWeb {
	
		
		private Usuario logado;		
		
		public void login(Usuario aluno){
			this.logado = aluno;
		}		
		public String getNome(){
			return logado.getNome();
		}
		public boolean isLogado(){
			return logado !=null;
		}
		public void logout() {
		    this.logado = null;
		}
		public Usuario getUsuario(){
			return logado;
		}
}
