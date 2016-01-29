package br.com.sistema.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.sistema.modelo.Interacao;
import br.com.sistema.modelo.Medicamento;

@Component
@SessionScoped 
public class GenericDAO {
	
	 private Session session; 
	  
	 public GenericDAO() {
		
	}

	public void salvaMedicamento(Medicamento medicamento){
		 session = Sessao.getSessao();//abre sessao
		 System.out.println("salvar medicamento!");
		 Transaction tx = session.beginTransaction();
		 
		//tentar carrega medicamento
			Medicamento verific = (Medicamento) session.createCriteria(Medicamento.class)
		    	      .add(Restrictions.eq("nome", medicamento.getNome()))	 	    	     
		    	      .uniqueResult();	
			
			if(verific==null){//se nao existir no banco
				session.save(medicamento);   //salva o medicamento
				tx.commit();
				System.out.println("medicamento salvo!!");
				
				
				session.disconnect();			
				session.close();					
				System.out.println("fechado sessao!!");
			}
	 }
	
	public void salvaInteracao(Interacao interacao){
			session = Sessao.getSessao();//abre sessao
			System.out.println("salvar interacao!");
			Transaction tx = session.beginTransaction();
		 
		//tentar carrega medicamento
			Interacao verific1 = (Interacao) session.createCriteria(Interacao.class)
			.add(Restrictions.eq("id_medicA", interacao.getId_medicA()))
  	      	.add(Restrictions.eq("id_medicB", interacao.getId_medicB()))   	 	    	     
  	      	.uniqueResult();
			
			Interacao verific2 = (Interacao) session.createCriteria(Interacao.class)
					.add(Restrictions.eq("id_medicA", interacao.getId_medicB()))
		  	      	.add(Restrictions.eq("id_medicB", interacao.getId_medicA()))   	 	    	     
		  	      	.uniqueResult();
			
			if(verific1==null && verific2==null){//se nao existir no banco				
					session.save(interacao);   //salva a interacao
					tx.commit();
					System.out.println("interacao salva!!");				
					
					session.disconnect();			
					session.close();					
					System.out.println("fechado sessao!!");
								
			}
	}
	
	public ArrayList<Medicamento> retornaMedicamentos(){
		 ArrayList<Medicamento> meds = new ArrayList<Medicamento>();
		 
		 session = Sessao.getSessao();
	   	 
	   	
	   	 String query = "select * from medicamentos;"; 
					    			
				SQLQuery sqlQuery = session.createSQLQuery(query); 			
				List<Object[]> resultado = null;   
				
				if(sqlQuery.list().size()!=0){
					resultado = sqlQuery.list();
					for(int i=0;i<resultado.size();i++){
						
						Medicamento med = new Medicamento();
						med.setId(Long.parseLong(String.valueOf(resultado.get(i)[0])));
						med.setDataExibivel(String.valueOf(resultado.get(i)[1]));
						med.setNome(String.valueOf(resultado.get(i)[2]));
						
						meds.add(med);
					}
					
				}else{
					meds = null;
				}
			
			session.close();
			System.out.println("Conexao com mysql fechado");
					
	   	    
		 
		 return meds;
	 }
	 
	public void atualizaMedicamento(){
		 
	 }
	 
	public ArrayList<Interacao> retornaInteracao(List<Long> selecionados){
		ArrayList<Interacao> interacoes = new ArrayList<Interacao>();
		 
		 session = Sessao.getSessao();
	   	 
	   	for(int i=0;i<selecionados.size();i++){//varre o array de medicamentos
	   		for(int j=i+1;j<selecionados.size();j++){//fixa o i e compara com os outros
	   			Long medA = selecionados.get(i),medB = selecionados.get(j);
	   			
	   			//query pra verificar essa combinacao na tabela(A,B ou B,A)
	   			String query = "SELECT * FROM interacoes WHERE (medicamento_a = '"+medA+"' AND medicamento_b = '"+medB+"') OR"
	   													   + " (medicamento_b = '"+medA+"' AND medicamento_a = '"+medB+"')";
	   			
				SQLQuery sqlQuery = session.createSQLQuery(query); 			
				List<Object[]> resultado = null;   
				
				if(sqlQuery.list().size()!=0){
					resultado = sqlQuery.list();					
						
						Interacao aux = new Interacao();
						
						System.out.println("[0]:"+resultado.get(0)[0]);//id da interacão
						System.out.println("[1]:"+resultado.get(0)[1]);//acao
						System.out.println("[2]:"+resultado.get(0)[2]);//efeito
						System.out.println("[3]:"+resultado.get(0)[3]);//grau
						System.out.println("[4]:"+resultado.get(0)[4]);//medicaA
						System.out.println("[5]:"+resultado.get(0)[5]);//medicaB
						System.out.println("[6]:"+resultado.get(0)[5]);//recomendacoes
						
						interacoes.add(aux);

				}else{
					interacoes = null;
				}
	   			
	   		}
	   	}
		 	
			session.close();
			System.out.println("Conexao com mysql fechado");
				  	 
		 return interacoes;
		
		
	}
}
