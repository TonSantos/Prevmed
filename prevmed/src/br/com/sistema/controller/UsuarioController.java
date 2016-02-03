package br.com.sistema.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.sistema.dao.InteracaoDAO;
import br.com.sistema.dao.MedicamentoDAO;
import br.com.sistema.dao.UsuarioDAO;
import br.com.sistema.modelo.Interacao;
import br.com.sistema.modelo.Medicamento;
import br.com.sistema.modelo.Usuario;
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
		//tabela de medicamentos
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
	public void atualizar(String medicamento, Long id){
		
		MedicamentoDAO dao = new MedicamentoDAO();
		Medicamento m = new Medicamento();
		m.setNome(medicamento);
		m.setId(id);
		
		
		if(dao.atualizaMedicamento(m)){
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
	
	@Post("/interacao-atualizado")
	public void atualizarInteracao(Interacao interacao){
		//String grau,Long medicA,Long medicB,String acao, String efeito,String recomendacao, Long id
		//controle de atualizaÁ„o da interaÁ„o
		InteracaoDAO dao = new InteracaoDAO();
		System.out.println("[id]:"+interacao.getId());//id da interac√£o
		System.out.println("[acao]:"+interacao.getAcao());//acao
		System.out.println("[efeito]:"+interacao.getEfeito());//efeito
		System.out.println("[grau]:"+interacao.getGrau());//grau
		System.out.println("[idA]:"+interacao.getId_medicA());//medicaA
		System.out.println("[idB]:"+interacao.getId_medicB());//medicaB
		System.out.println("[recomendacao]:"+interacao.getRecomendacao());//recomendacoes
		
		
		if(dao.atualizarInteracao(interacao)){
			String infor = "Interacao atualizado com sucesso!";
			String status = "alert alert-success";
			String icon = "fa fa-check-circle";
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			
			ArrayList<Interacao> interac = new ArrayList<Interacao>();
			interac = dao.todasInteracoes();			
			
			//carregar medicamentos
			MedicamentoDAO mdao = new MedicamentoDAO();
			ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();			
			medicamentos = mdao.retornaMedicamentos();
			
			result.include("medicamentos", medicamentos);
			result.include("interacoes", interac);
			result.include("user", usuarioWeb.getNome());	
			result.forwardTo(this).resultadoInteracoes();
		}else{
			String infor = "Nao foi possivel atualizar interacao!";
			String status = "alert alert-danger";
			String icon = "fa fa-exclamation-triangle";
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			
			ArrayList<Interacao> interac = new ArrayList<Interacao>();
			interac = dao.todasInteracoes();			
			
			//carregar medicamentos
			MedicamentoDAO mdao = new MedicamentoDAO();
			ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();			
			medicamentos = mdao.retornaMedicamentos();
			
			result.include("medicamentos", medicamentos);
			result.include("interacoes", interac);
			result.include("user", usuarioWeb.getNome());	
			result.forwardTo(this).resultadoInteracoes();
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
			String infor = "N„o foi possivel apagar medicamento!";
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
			String infor = "InteraÁ„o apagado com sucesso!";
			String status = "alert alert-success";
			String icon = "fa fa-check-circle";
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			result.forwardTo(this).analise(listaId);
		}else{
			String infor = "N„o foi possivel apagar interaÁ„o!";
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
		
		System.out.println("DENTRO DO DAO");//id da interac√£o
		System.out.println("[id]:"+interacao.getId());//id da interac√£o
		System.out.println("[acao]:"+interacao.getAcao());//acao
		System.out.println("[efeito]:"+interacao.getEfeito());//efeito
		System.out.println("[grau]:"+interacao.getGrau());//grau
		System.out.println("[idA]:"+interacao.getId_medicA());//medicaA
		System.out.println("[idB]:"+interacao.getId_medicB());//medicaB
		System.out.println("[recomendacao]:"+interacao.getRecomendacao());//recomendacoes
		
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
			String infor = "Nao foi possivel adicionar interaÁ„o!";
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
	
	@Post("/usuarios")
	public void listaUsuarios(){
		
	}
	
	@Post("/adicionar-membro")
	public void addMembro(Usuario usuario, String outro){
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuario.setDataAcesso(Calendar.getInstance());
		UsuarioDAO dao = new UsuarioDAO();
		if(usuario.getSenha().equals(outro)){//se for igual as senhas, blz!
			
			if(dao.inseriUsuario(usuario)){
				String infor = "Membro adicionado com sucesso!";
				String status = "alert alert-success";
				String icon = "fa fa-check-circle";
				
				usuarios = dao.listaUsuarios();
				
				result.include("icon",icon);
				result.include("status",status);
				result.include("infor", infor);
				result.include("user", usuarioWeb.getNome());
				result.include("usuarios", usuarios);
				result.forwardTo(this).listaUsuarios();
			}else{
				String infor = "Nao foi possivel adicinar usuario!";
				String status = "alert alert-danger";
				String icon = "fa fa-exclamation-triangle";
				
				usuarios = dao.listaUsuarios();
				
				result.include("icon",icon);
				result.include("status",status);
				result.include("infor", infor);
				result.include("user", usuarioWeb.getNome());
				result.include("usuarios", usuarios);
				result.forwardTo(this).listaUsuarios();
			}
		}else{
			String infor = "As senhas informadas n„o conferem!";
			String status = "alert alert-danger";
			String icon = "fa fa-exclamation-triangle";
			
			usuarios = dao.listaUsuarios();
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			result.include("user", usuarioWeb.getNome());
			result.include("usuarios", usuarios);
			result.forwardTo(this).listaUsuarios();
		}
		
		
	}
	
	@Post("membro-atualizado")
	public void atualizarMembro(Usuario usuario, String outra){
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuario.setDataAcesso(Calendar.getInstance());
		UsuarioDAO dao = new UsuarioDAO();
		
		if(usuario.getSenha().equals(outra)){//se for igual as senhas, blz!
						
			
			if(dao.atualizaUsuario(usuario)){
				String infor = "Membro atualizado com sucesso!";
				String status = "alert alert-success";
				String icon = "fa fa-check-circle";
				
				usuarios = dao.listaUsuarios();
				
				result.include("icon",icon);
				result.include("status",status);
				result.include("infor", infor);
				result.include("user", usuarioWeb.getNome());
				result.include("usuarios", usuarios);
				result.forwardTo(this).listaUsuarios();
			
			}else{
			
				String infor = "Nao foi possivel atualizar membro!";
				String status = "alert alert-danger";
				String icon = "fa fa-exclamation-triangle";
				
				usuarios = dao.listaUsuarios();
				
				result.include("icon",icon);
				result.include("status",status);
				result.include("infor", infor);
				result.include("user", usuarioWeb.getNome());
				result.include("usuarios", usuarios);
				result.forwardTo(this).listaUsuarios();
			}
		}else{
			
			String infor = "As senhas informadas n„o conferem!";
			String status = "alert alert-danger";
			String icon = "fa fa-exclamation-triangle";
			
			usuarios = dao.listaUsuarios();
			
			result.include("icon",icon);
			result.include("status",status);
			result.include("infor", infor);
			result.include("user", usuarioWeb.getNome());
			result.include("usuarios", usuarios);
			result.forwardTo(this).listaUsuarios();
		}
		
	}
	
	@Post("/membros")
	public void apagarUsuario(Long id){	
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		
		UsuarioDAO dao = new UsuarioDAO();
		
			
			if(dao.deletarUsuario(id)){
				String infor = "Membro excluido com sucesso!";
				String status = "alert alert-success";
				String icon = "fa fa-check-circle";
				
				usuarios = dao.listaUsuarios();
				
				result.include("icon",icon);
				result.include("status",status);
				result.include("infor", infor);
				result.include("user", usuarioWeb.getNome());
				result.include("usuarios", usuarios);
				result.forwardTo(this).listaUsuarios();
				
			}else{
				
				String infor = "Nao foi possivel excluir membro!";
				String status = "alert alert-danger";
				String icon = "fa fa-exclamation-triangle";
				
				usuarios = dao.listaUsuarios();
				
				result.include("icon",icon);
				result.include("status",status);
				result.include("infor", infor);
				result.include("user", usuarioWeb.getNome());
				result.include("usuarios", usuarios);
				result.forwardTo(this).listaUsuarios();
			}
		
		
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
