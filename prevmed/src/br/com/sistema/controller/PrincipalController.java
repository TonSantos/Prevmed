package br.com.sistema.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.sistema.annotation.Public;
import br.com.sistema.dao.InteracaoDAO;
import br.com.sistema.dao.MedicamentoDAO;
import br.com.sistema.modelo.Interacao;
import br.com.sistema.modelo.Medicamento;
import br.com.sistema.modelo.UsuarioWeb;

/*todas as classes controladoras devem conter @Resource*/
@Resource
public class PrincipalController {
	
	private Result result;
	private Validator validator;
	UsuarioWeb usuarioWeb;
	
	public PrincipalController(Result result, Validator validator, UsuarioWeb usuarioWeb) {
		
		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}
	
	@Public
	@Post("/")
	public void index(){}
	
	@Public
	@Get("/")
	public void inicio(){
		if(usuarioWeb.isLogado()){
			result.include("user", usuarioWeb.getNome());	
			result.forwardTo(LoginController.class).setores();
		}else{
		//metodo que carrega todos os medicamentos no banco
		MedicamentoDAO dao = new MedicamentoDAO();
		ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
		
		medicamentos = dao.retornaMedicamentos();
		
		result.include("medicamentos", medicamentos);	
		result.forwardTo(this).index();
		}
	}
	
	@Public
	@Post("/resultado")
	public void analise(List<Long> selecionados){
		//realiza a analise de medicamentos e retorna o resultado da interacao
		if(selecionados!=null && selecionados.size() > 0){//se existe pelo menos um id de medicamentos
			
			if(selecionados.size() == 1){//se for apenas um
				
				InteracaoDAO dao = new InteracaoDAO();
				ArrayList<Interacao> interacoes = new ArrayList<Interacao>();
				interacoes = dao.umInteracao(selecionados.get(0));			
				
				result.include("interacoes", interacoes);			
				result.forwardTo(this).interacoes();
			}else{
				InteracaoDAO dao = new InteracaoDAO();
				ArrayList<Interacao> interacoes = new ArrayList<Interacao>();
				interacoes = dao.retornaInteracao(selecionados);			
				
				result.include("interacoes", interacoes);			
				result.forwardTo(this).interacoes();
			}
		}else{
			
			validator.add(new ValidationMessage("Marque pelo menos um medicamento para analise!", "Atencao!"));
			validator.onErrorRedirectTo(this).inicio();
						
		}
		
	}
	@Public
	@Post("/resultado-interacoes")
	public void interacoes(){}
	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public Validator getValidator() {
		return validator;
	}
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	
}
