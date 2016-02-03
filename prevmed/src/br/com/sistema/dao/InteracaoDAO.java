package br.com.sistema.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
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
public class InteracaoDAO {
	
	private Session session;

	public InteracaoDAO() {} 
	
	public boolean salvaInteracao(Interacao interacao){
		boolean status = false;
		session = Sessao.getSessao();//abre sessao
		System.out.println("salvar interacao!");
		
		
	 
	//tentar carrega interacao
		Interacao verific1 = (Interacao) session.createCriteria(Interacao.class)
		.add(Restrictions.eq("id_medicA", interacao.getId_medicA()))
	      	.add(Restrictions.eq("id_medicB", interacao.getId_medicB()))   	 	    	     
	      	.uniqueResult();
		
		Interacao verific2 = (Interacao) session.createCriteria(Interacao.class)
				.add(Restrictions.eq("id_medicA", interacao.getId_medicB()))
	  	      	.add(Restrictions.eq("id_medicB", interacao.getId_medicA()))   	 	    	     
	  	      	.uniqueResult();
		
		if(verific1==null && verific2==null){//se nao existir no banco
				if(interacao.getId_medicA()!=interacao.getId_medicB()){// e forem diferentes deles mesmo		
					try{
						Transaction tx = session.beginTransaction();
						session.save(interacao);//salva a interacao
						tx.commit();
						System.out.println("interacao salva!!");						
						status = true;
					}catch(HibernateException he){
						 System.out.println("Exceção em Banco de dados - salvar Medicamento");
					}
				
				}
				
		}
		session.disconnect();			
		session.close();					
		System.out.println("fechado sessao!!");
		
		return status;
		
}
	
	public ArrayList<Interacao> todasInteracoes(){
		//retorna todas as interações no banco
		ArrayList<Interacao> interacoes = new ArrayList<Interacao>();
		 
		 session = Sessao.getSessao();
		 
			
			//query pra retornar 
			String query = "SELECT * FROM interacoes";
			
			SQLQuery sqlQuery = session.createSQLQuery(query); 			
			List<Object[]> resultado = null;   
			
			if(sqlQuery.list().size()!=0){
				resultado = sqlQuery.list();					
					for(int i=0;i<resultado.size();i++){
					Interacao aux = new Interacao();
					
					aux.setId(Long.parseLong(String.valueOf(resultado.get(i)[0])));
					aux.setAcao(String.valueOf(resultado.get(i)[1]));
					aux.setEfeito(String.valueOf(resultado.get(i)[2]));
					aux.setGrau(String.valueOf(resultado.get(i)[3]));
					aux.setId_medicA(Long.parseLong(String.valueOf(resultado.get(i)[4])));
					aux.setId_medicB(Long.parseLong(String.valueOf(resultado.get(i)[5])));
					aux.setRecomendacao(String.valueOf(resultado.get(i)[6]));
					
					
					MedicamentoDAO dao = new MedicamentoDAO();
					String nomeA = dao.nomeMedicamento(Long.parseLong(String.valueOf(resultado.get(i)[4])));
					String nomeB = dao.nomeMedicamento(Long.parseLong(String.valueOf(resultado.get(i)[5])));
					
					aux.setMedicamentoA(nomeA);
					aux.setMedicamentoB(nomeB);
					
					if(aux.getGrau().equals("Moderada")){
						aux.setCorGrau("#FFD561");		//amarelo				
					}else if(aux.getGrau().equals("Grave")){
						aux.setCorGrau("#E54444");		//vermelho
					}else if(aux.getGrau().equals("Leve")){					
						aux.setCorGrau("#428BCA"); 	   //azul
					}else{
						aux.setCorGrau("#B2B2B2"); 		//cinza
					}
					
					interacoes.add(aux);
					}
			}

			session.close();
			System.out.println("Conexao com mysql fechado");    
		 
		 return interacoes;
		
	}
	
	public ArrayList<Interacao> retornaInteracao(List<Long> selecionados){
		
		//para dois ou mais medicamentos
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
						
						aux.setId(Long.parseLong(String.valueOf(resultado.get(0)[0])));
						aux.setAcao(String.valueOf(resultado.get(0)[1]));
						aux.setEfeito(String.valueOf(resultado.get(0)[2]));
						aux.setGrau(String.valueOf(resultado.get(0)[3]));
						aux.setId_medicA(Long.parseLong(String.valueOf(resultado.get(0)[4])));
						aux.setId_medicB(Long.parseLong(String.valueOf(resultado.get(0)[5])));
						aux.setRecomendacao(String.valueOf(resultado.get(0)[6]));
						
						MedicamentoDAO dao = new MedicamentoDAO();
						String nomeA = dao.nomeMedicamento(Long.parseLong(String.valueOf(resultado.get(0)[4])));
						String nomeB = dao.nomeMedicamento(Long.parseLong(String.valueOf(resultado.get(0)[5])));
						
						aux.setMedicamentoA(nomeA);
						aux.setMedicamentoB(nomeB);
						
						if(aux.getGrau().equals("Moderada")){
							aux.setCorGrau("#FFD561");		//amarelo				
						}else if(aux.getGrau().equals("Grave")){
							aux.setCorGrau("#E54444");		//vermelho
						}else if(aux.getGrau().equals("Leve")){					
							aux.setCorGrau("#428BCA"); 	   //azul
						}else{
							aux.setCorGrau("#B2B2B2"); 		//cinza
						}
						
						interacoes.add(aux);
					}	
	   			}
	   		}
		 
				session.close();
				System.out.println("Conexao com mysql fechado");
				return interacoes;

	}
	
	public ArrayList<Interacao> umInteracao(Long selecionado){
		
		//todas as interações de um determinado medicamento
		ArrayList<Interacao> interacoes = new ArrayList<Interacao>();
		 
		 session = Sessao.getSessao();
	   	 
	   			
	   			//query pra verificar essa combinacao na tabela
	   			String query = "SELECT * FROM interacoes WHERE medicamento_a = "+selecionado+" OR medicamento_b = "+selecionado+";";
	   			
				SQLQuery sqlQuery = session.createSQLQuery(query); 			
				List<Object[]> resultado = null;   
				
				if(sqlQuery.list().size()!=0){
					resultado = sqlQuery.list();					
						
					for(int i=0;i<resultado.size();i++){
						Interacao aux = new Interacao();
						
						aux.setId(Long.parseLong(String.valueOf(resultado.get(i)[0])));
						aux.setAcao(String.valueOf(resultado.get(i)[1]));
						aux.setEfeito(String.valueOf(resultado.get(i)[2]));
						aux.setGrau(String.valueOf(resultado.get(i)[3]));
						aux.setId_medicA(Long.parseLong(String.valueOf(resultado.get(i)[4])));
						aux.setId_medicB(Long.parseLong(String.valueOf(resultado.get(i)[5])));
						aux.setRecomendacao(String.valueOf(resultado.get(i)[6]));
						
						MedicamentoDAO dao = new MedicamentoDAO();
						String nomeA = dao.nomeMedicamento(Long.parseLong(String.valueOf(resultado.get(i)[4])));
						String nomeB = dao.nomeMedicamento(Long.parseLong(String.valueOf(resultado.get(i)[5])));
						
						aux.setMedicamentoA(nomeA);
						aux.setMedicamentoB(nomeB);
						
						if(aux.getGrau().equals("Moderada")){
							aux.setCorGrau("#FFD561");		//amarelo				
						}else if(aux.getGrau().equals("Grave")){
							aux.setCorGrau("#E54444");		//vermelho
						}else if(aux.getGrau().equals("Leve")){					
							aux.setCorGrau("#428BCA"); 	   //azul
						}else{
							aux.setCorGrau("#B2B2B2"); 		//cinza
						}
						
						interacoes.add(aux);
						}
					}	
	   		
		 
				session.close();
				System.out.println("Conexao com mysql fechado");
				return interacoes;

	}
	
	public boolean atualizarInteracao(Interacao interacao){
		boolean status = false;
		
		session = Sessao.getSessao();//abre sessao
		Transaction tx = session.beginTransaction(); 		
		 	if(interacao.getId_medicA()!=interacao.getId_medicB()){
		 		try{
		 		
		 			session.update(interacao);
		 			tx.commit();
		 			session.clear();
		 			status = true;
		 		}catch(HibernateException he){
	            System.out.println("Exceção em Banco de dados - atualizar Medicamento");
	           
		 		}
		 	
		 	}
			session.disconnect();			
			session.close();					
			System.out.println("fechado sessao!!");
			return status;
	}
	
	public boolean deletarInteracao(Long idInteracao){
		session = Sessao.getSessao();
		boolean status = false;
		
		
		//tentar carrega interacao
		Interacao verific = (Interacao) session.createCriteria(Interacao.class)
	    	      .add(Restrictions.eq("id", idInteracao))	 	    	     
	    	      .uniqueResult();
		
		if(verific!=null){//se existe esse interacao deleta
			try{
				Transaction tx = session.beginTransaction();  
		        session.delete(verific);  
		        tx.commit();  
			    
			    status = true;
			}catch(HibernateException he){
				 System.out.println("Exceção em Banco de dados - apagar Medicamento");
			}
			
		}
			
		session.close();
		System.out.println("Conexao com mysql fechado");
		return status;
	}

	public void deletarArrayInteracao(Long idMed){
		
		ArrayList<Interacao> list = umInteracao(idMed);//carrega todas as interações q esse medicamento participa
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				deletarInteracao(list.get(i).getId());//apaga as interaçoes pelos id
			}
		}
		
	}

}
