package br.com.sistema.controller;

import java.util.ArrayList;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.sistema.annotation.Public;
import br.com.sistema.dao.InteracaoDAO;
import br.com.sistema.dao.MedicamentoDAO;
import br.com.sistema.dao.UsuarioDAO;
import br.com.sistema.modelo.Interacao;
import br.com.sistema.modelo.Medicamento;
import br.com.sistema.modelo.Usuario;
import br.com.sistema.modelo.UsuarioWeb;


/*todas as classes controladoras devem conter @Resource*/
//controller de login's
@Resource
public class LoginController {
	
	private Result result;
	private Validator validator;
	private UsuarioWeb usuarioWeb;
	
	
	public LoginController(Result result, Validator validator, UsuarioWeb usuarioWeb) {		
		
		this.setResult(result);
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
		
	}
	@Post("/setores")
	public void setores() {
	
	}	
	@Public
	@Post("/setor-adminstrativo")
	public void opcao(int esc){	
		if(esc==1){
			//carregar medicamentos
			MedicamentoDAO mdao = new MedicamentoDAO();
			ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();			
			medicamentos = mdao.retornaMedicamentos();
						 			
		 	result.include("medicamentos", medicamentos);	
		 	result.include("user", usuarioWeb.getNome());	
			result.forwardTo(UsuarioController.class).adminMedic();
		}else if(esc==2){
			//carregar interacoes
			InteracaoDAO dao = new InteracaoDAO();
			ArrayList<Interacao> interacoes = new ArrayList<Interacao>();
			interacoes = dao.todasInteracoes();			
			
			//carregar medicamentos
			MedicamentoDAO mdao = new MedicamentoDAO();
			ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();			
			medicamentos = mdao.retornaMedicamentos();
			
			result.include("medicamentos", medicamentos);
			result.include("interacoes", interacoes);
			result.include("user", usuarioWeb.getNome());	
			result.forwardTo(UsuarioController.class).resultadoInteracoes();
		}else if(esc==3){
			//...carregar usuarios do sistema
		}else{
			result.include("user", usuarioWeb.getNome());	
		 	result.forwardTo(this).setores();
		}
			 
		 }		
		 				
	
	
	@Public
	@Path("/login")
	public void login(){
		usuarioWeb.logout();
	}
	
	@Public
	@Post("/painel-admistrativo")
	public void autenticarUsuario(Usuario usuario){	

		//verificar no banco
		 UsuarioDAO dao = new UsuarioDAO();
		 usuario = dao.carregarUsuario(usuario);
		 
		 if(usuario==null){
			 //nao tem registro no banco
			 validator.add(new ValidationMessage("Email ou senha incorretos.", "Erro"));
			 validator.onErrorRedirectTo(this).login();
	 
		 }else{
			/** //carregar medicamentos
				MedicamentoDAO mdao = new MedicamentoDAO();
				ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();			
				medicamentos = mdao.retornaMedicamentos();**/
				
			 	usuarioWeb.login(usuario);			
			 //	result.include("medicamentos", medicamentos);	
			//	result.forwardTo(UsuarioController.class).adminMedic();
			 	result.include("user", usuario.getNome());	
			 	result.forwardTo(this).setores();
		 }
		
		 				
	}
	@Public
	@Path("/painel")
	public void direcionar(){
		if(usuarioWeb.isLogado()){
			result.include("user", usuarioWeb.getNome());	
			result.forwardTo(this).setores();
		}else{
			result.forwardTo(this).login();
		}
	}
	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
}
