package br.com.sistema.teste;

import java.util.Calendar;

import br.com.sistema.dao.UsuarioDAO;
import br.com.sistema.modelo.Usuario;

/**CLASSE PARA EFETUAR TESTES**/
public class testeDados {
	public static void main(String[] args) {
	/***
		Medicamento a = new Medicamento();
		Medicamento b = new Medicamento();
		Medicamento c = new Medicamento();
		Medicamento d = new Medicamento();
		Medicamento e = new Medicamento();
		Medicamento f = new Medicamento();
		Medicamento g = new Medicamento();
		
		a.setNome("Aciclovir");
		b.setNome("Tenofovir");
		c.setNome("Zidovudina");
		d.setNome("Acido epsilon aminocaproico");
		e.setNome("Acido folico");
		f.setNome("Tretinoina ");
		g.setNome("Capecitabina");
		
		a.setDataCriacao();
		b.setDataCriacao();
		c.setDataCriacao();
		d.setDataCriacao();
		e.setDataCriacao();
		f.setDataCriacao();
		g.setDataCriacao();
		
		ArrayList<Medicamento> meds = new ArrayList<Medicamento>();
		meds.add(a);
		meds.add(b);
		meds.add(c);
		meds.add(d);
		meds.add(e);
		meds.add(f);
		meds.add(g); ***/
		
		//MedicamentoDAO dao = new MedicamentoDAO();
		//dao.salvaMedicamento(g);
	/***	
		Interacao inte1 = new Interacao();
		inte1.setId_medicA(5);
		inte1.setId_medicB(7);
		inte1.setEfeito("Ocorr�ncia de anorexia, ulcera��o da boca, diarr�ia com sangue, sangramento vaginal.");
		inte1.setGrau("Grave");
		inte1.setAcao("nao-especificado");
		inte1.setRecomendacao("O uso concomitante deve ser evitado. Os doentes devem "
				+ "ser monitorizados atentamente quanto a toxicidade "
				+ "potencial da capecitabina, como neutropenia, "
				+ "trombocitopenia, estomatite, hemorragia "
				+ "gastrointestinal, diarr�ia grave, v�mito, rea��es cut�neas, "
				+ "e neuropatia. Monitorar paciente via hemograma.");
		GenericDAO dao = new GenericDAO();
		dao.salvaInteracao(inte1); ***/
		
	/*	for(int i=0;i<meds.size();i++){
		
			GenericDAO dao = new GenericDAO();
			dao.salvaMedicamento(meds.get(i));
			
		}*/
	/*	Interacao inte2 = new Interacao();
		inte2.setId_medicA(1);
		inte2.setId_medicB(2);
		inte2.setEfeito("Tontura;diarreia;vomito;neuropatia");
		inte2.setGrau("Moderada");
		inte2.setAcao("nao-especificado");
		inte2.setRecomendacao("Monitorar aumento dos efeitos toxicos do tenofovir");	
		dao.salvaInteracao(inte2);
		
		
		Interacao inte3 = new Interacao();
		inte3.setId_medicA(1);
		inte3.setId_medicB(3);
		inte3.setEfeito("Letargia e fadiga grave");
		inte3.setGrau("Moderada");
		inte3.setAcao("Rapido");
		inte3.setRecomendacao("Observar a ocorrencia de letargia e fadiga");
		dao.salvaInteracao(inte3);*/
				
		/*GenericDAO dao = new GenericDAO();
		ArrayList<Long> selecionados = new ArrayList<Long>();
		long ida = 1;long idb = 2; long idc = 3;
		selecionados.add(ida);
		selecionados.add(idb);
		selecionados.add(idc);
		
		ArrayList<Interacao> lista = new ArrayList<Interacao>();
		lista = dao.retornaInteracao(selecionados);*/  
		
		
		/*****************************************************************/
		
		Usuario admin = new Usuario();
		admin.setNome("Admin");
		admin.setEmail("prevmed@prevmed");
		admin.setSenha("prevmed");
		admin.setDataAcesso(Calendar.getInstance());
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.inseriUsuario(admin);
		/*
		UsuarioDAO dao = new UsuarioDAO();
		Usuario aux = new Usuario();
		aux.setEmail("prevmed@prevmed");
		aux.setSenha("prevmed");
		
		aux = dao.carregarUsuario(aux);
		
		System.out.println("Nome:"+aux.getNome());
		System.out.println("ID:"+aux.getId());*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}