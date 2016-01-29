package br.com.sistema.controller;

import java.util.ArrayList;
import java.util.List;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.sistema.dao.InteracaoDAO;
import br.com.sistema.dao.MedicamentoDAO;
import br.com.sistema.modelo.Interacao;
import br.com.sistema.modelo.Medicamento;
import br.com.sistema.modelo.UsuarioWeb;

@Resource
public class UsuarioController {
	
	private Result result;
	private Validator validator;
	private UsuarioWeb usuarioWeb;
	public static List<Long> listaId;

	public UsuarioController(Result result, Validator validator, UsuarioWeb usuarioWeb) {
		
		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}

	
	@Post("/medicamentos")
	public void adminMedic() {
	
	}
	
	
	@Get("/carregar")
	public void carregar(){
		//carregar medicamentos
		MedicamentoDAO mdao = new MedicamentoDAO();
		ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();			
		medicamentos = mdao.retornaMedicamentos();
		
		result.include("user", usuarioWeb.getNome());			
	 	result.include("medicamentos", medicamentos);	 	
		result.forwardTo(this).adminMedic();
	}
	
	
	@Post("/adicionar-medicamento")
	public void adicionar(String nome){
		Medicamento novo = new Medicamento();
		novo.setNome(nome);
		novo.setDataCriacao();
		
		MedicamentoDAO dao = new MedicamentoDAO();
		if(dao.salvaMedicamento(novo)){
			String infor = "Medicamento adicionado com sucesso!";
			String status = "alert alert-success";
			String icon = "fa fa-check-circle";
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			result.forwardTo(this).carregar();
		}else{
			String infor = "Nao foi possivel salvar medicamento!";
			String status = "alert alert-danger";
			String icon = "fa fa-exclamation-triangle";
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			result.forwardTo(this).carregar();
		}
			
	}
	
	@Post("/medicamento-atualizado")
	public void atualizar(Medicamento medicamentos){
		
		MedicamentoDAO dao = new MedicamentoDAO();
		if(dao.atualizaMedicamento(medicamentos)){
			String infor = "Medicamento atualizado com sucesso!";
			String status = "alert alert-success";
			String icon = "fa fa-check-circle";
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			result.forwardTo(this).carregar();
		}else{
			String infor = "Nao foi possivel atualizar medicamento!";
			String status = "alert alert-danger";
			String icon = "fa fa-exclamation-triangle";
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			result.forwardTo(this).carregar();
		}
	}
	@Post("/medicamento")
	public void apagar(Long id){
		
		MedicamentoDAO dao = new MedicamentoDAO();
		if(dao.deletarMedicamento(id)){
			String infor = "Medicamento apagado com sucesso!";
			String status = "alert alert-success";
			String icon = "fa fa-check-circle";
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			result.forwardTo(this).carregar();
		}else{
			String infor = "Não foi possivel apagar medicamento!";
			String status = "alert alert-danger";
			String icon = "fa fa-exclamation-triangle";
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			result.forwardTo(this).carregar();
		}
			
	}
	
	@Post("/interacao")
	public void apagarInteracao(Long id){
		
		InteracaoDAO dao = new InteracaoDAO();
		MedicamentoDAO mdao = new MedicamentoDAO();
		
		ArrayList<Medicamento> lista = mdao.retornaMedicamentos();
		ArrayList<Long> ids = new ArrayList<Long>();
		for(int i=0;i<lista.size();i++){ //pegando os id dos medicamentos
			ids.add(lista.get(i).getId());
		}
		listaId = ids;
		
		
		if(dao.deletarInteracao(id)){
			String infor = "Interação apagado com sucesso!";
			String status = "alert alert-success";
			String icon = "fa fa-check-circle";
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			result.forwardTo(this).analise(listaId);
		}else{
			String infor = "Não foi possivel apagar interação!";
			String status = "alert alert-danger";
			String icon = "fa fa-exclamation-triangle";
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			result.forwardTo(this).analise(listaId);
		}
			
	}
	@Post("/analise-interacoes")
	public void analise(List<Long> selecionados){
		//realiza a analise de medicamentos e retorna o resultado da interacao
			listaId = selecionados;
				if(selecionados!=null && selecionados.size() > 0){//se existe pelo menos um id de medicamentos
					if(selecionados.size() == 1){//se for apenas um
						InteracaoDAO dao = new InteracaoDAO();
						ArrayList<Interacao> interacoes = new ArrayList<Interacao>();
						interacoes = dao.umInteracao(selecionados.get(0));			
						
						//carregar medicamentos
						MedicamentoDAO mdao = new MedicamentoDAO();
						ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();			
						medicamentos = mdao.retornaMedicamentos();
						
						result.include("medicamentos", medicamentos);
						result.include("interacoes", interacoes);	
						result.include("user", usuarioWeb.getNome());	
						result.forwardTo(this).resultadoInteracoes();
					}else{
						
					InteracaoDAO dao = new InteracaoDAO();
					ArrayList<Interacao> interacoes = new ArrayList<Interacao>();
					interacoes = dao.retornaInteracao(selecionados);			
					
					//carregar medicamentos
					MedicamentoDAO mdao = new MedicamentoDAO();
					ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();			
					medicamentos = mdao.retornaMedicamentos();
					
					result.include("medicamentos", medicamentos);
					result.include("interacoes", interacoes);	
					result.include("user", usuarioWeb.getNome());	
					result.forwardTo(this).resultadoInteracoes();
					}
				}else{
					
					validator.add(new ValidationMessage("Marque pelo menos um medicamentos para analise!", "Atencao!"));
					validator.onErrorRedirectTo(this).carregar();
								
				}
				
	}
	
	@Post("/adicionar-interacao")
	public void adicionarInteracao(Interacao interacao){
		InteracaoDAO dao = new InteracaoDAO();
		MedicamentoDAO mdao = new MedicamentoDAO();
		
		ArrayList<Medicamento> lista = mdao.retornaMedicamentos();
		ArrayList<Long> ids = new ArrayList<Long>();
		for(int i=0;i<lista.size();i++){ //pegando os id dos medicamentos
			ids.add(lista.get(i).getId());
		}
		listaId = ids;
		
		if(dao.salvaInteracao(interacao)){
			String infor = "Interacao adicionado com sucesso!";
			String status = "alert alert-success";
			String icon = "fa fa-check-circle";
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			result.forwardTo(this).analise(listaId);
		}else{
			String infor = "Nao foi possivel adicionar interação!";
			String status = "alert alert-danger";
			String icon = "fa fa-exclamation-triangle";
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			result.forwardTo(this).analise(listaId);
		}
	}
	
	
	@Post("/interacoes")
	public void resultadoInteracoes(){
		
	}

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

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}
	
	
	

}
