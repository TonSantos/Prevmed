package br.com.sistema.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.sistema.modelo.Medicamento;

@Component
@SessionScoped 
public class MedicamentoDAO {
	
	 private Session session;

	public MedicamentoDAO(){} 
	 
	public boolean salvaMedicamento(Medicamento medicamento){
		boolean status = false;
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
				status = true;
				
				session.disconnect();			
				session.close();					
				System.out.println("fechado sessao!!");
				
			}
			
			return status;
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
	
	public boolean atualizaMedicamento(Medicamento medicamento){
		boolean status = false;
			
		session = Sessao.getSessao();//abre sessao
		Transaction tx = session.beginTransaction(); 		
		 	
		 	try{
		 		medicamento.setDataCriacao();
		 		session.update(medicamento);
		 		tx.commit();
			 	session.clear();
			 	 status = true;
	        }catch(HibernateException he){
	            System.out.println("Exceção em Banco de dados - atualizar Medicamento");	           
	        }
		 		
			session.disconnect();			
			session.close();					
			System.out.println("fechado sessao!!");
			return status;
	}
	
	public boolean deletarMedicamento(Long idMedicamento){
		session = Sessao.getSessao();
		boolean status = false;
		
		
		
		//tentar carrega medicamento
		Medicamento verific = (Medicamento) session.createCriteria(Medicamento.class)
	    	      .add(Restrictions.eq("id", idMedicamento))	 	    	     
	    	      .uniqueResult();
		
		
		
		if(verific!=null){//se existe esse medicamento deleta
			
			//apagar as interações em que ele participa
			InteracaoDAO idao = new InteracaoDAO();
			idao.deletarArrayInteracao(idMedicamento);
			
			Transaction tx = session.beginTransaction();  
	        session.delete(verific);  
	        tx.commit();  
		    
		    status = true;
		}
			
		session.close();
		System.out.println("Conexao com mysql fechado");
		return status;
	}
	
	public String nomeMedicamento(Long id){
		 session = Sessao.getSessao();//abre sessao
		 
		Medicamento med = (Medicamento) session.createCriteria(Medicamento.class)
	    	      .add(Restrictions.eq("id", id))	    	       	    	     
	    	      .uniqueResult();
	    	      
		return med.getNome();
	}
}
