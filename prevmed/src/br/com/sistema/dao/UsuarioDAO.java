package br.com.sistema.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.sistema.modelo.Medicamento;
import br.com.sistema.modelo.Usuario;

@Component
@SessionScoped 
public class UsuarioDAO {
	private Session session;
	
	public boolean inseriUsuario(Usuario usuario){
		boolean status = false;
		 session = Sessao.getSessao();//abre sessao
		 System.out.println("salvar usuario!");
		 Transaction tx = session.beginTransaction();
		 
		//tentar carrega usuario
			Usuario verific = (Usuario) session.createCriteria(Usuario.class)
		    	      .add(Restrictions.eq("email", usuario.getEmail()))
		    	      .add(Restrictions.eq("senha", usuario.getSenha()))
		    	      .uniqueResult();	
			
			if(verific==null){//se nao existir no banco
				session.save(usuario);   //salva o usuario
				tx.commit();
				System.out.println("usuario salvo!!");
				
				status = true;
				session.disconnect();			
				session.close();					
				System.out.println("fechado sessao!!");
			}
			
			return status;
	 }
	
	public boolean atualizaUsuario(Usuario usuario){
		boolean status = false; 
		
		session = Sessao.getSessao();//abre sessao
		Transaction tx = session.beginTransaction(); 		
		 	
		 	try{
		 		usuario.setDataAcesso(Calendar.getInstance());
		 		session.update(usuario);
		 		tx.commit();
			 	session.clear();
			 	status = true;
	        }catch(HibernateException he){
	            System.out.println("Exceção em Banco de dados - atualizar Usuario");	           
	        }
		 		
			session.disconnect();			
			session.close();					
			System.out.println("fechado sessao!!");
			
			return status;
			
	}
	
	public boolean deletarUsuario(Long id){
		boolean status = false;
		session = Sessao.getSessao();		
		
		//tentar carrega medicamento
		Usuario verific = (Usuario) session.createCriteria(Usuario.class)
	    	      .add(Restrictions.eq("id", id))	 	    	     
	    	      .uniqueResult();	
		
		if(verific!=null){//se existe esse membro deleta		
			try{
			Transaction tx = session.beginTransaction();  
	        session.delete(verific);  
	        tx.commit();  
		    
		    status = true;
			}catch(HibernateException he){
	            System.out.println("Exceção em Banco de dados - deletar Usuario");	           
	        }
		}
			
		session.close();
		System.out.println("Conexao com mysql fechado");
		
		
		return status;
	}
	
	public Usuario carregarUsuario(Usuario usuario){
		session = Sessao.getSessao();//abre sessao
		
		//tentar carrega usuario
		Usuario u = new Usuario();
		u = (Usuario) session.createCriteria(Usuario.class)
	    	      .add(Restrictions.eq("email", usuario.getEmail()))
	    	      .add(Restrictions.eq("senha", usuario.getSenha()))
	    	      .uniqueResult();
		
		session.disconnect();			
		session.close();					
		System.out.println("fechado sessao!!");
		
		return u;
	}

	public ArrayList<Usuario> listaUsuarios() {
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		 
		 session = Sessao.getSessao();
	   	 
	   	
	   	 String query = "select * from usuario;"; 
					    			
				SQLQuery sqlQuery = session.createSQLQuery(query); 			
				List<Object[]> resultado = null;   
				
				if(sqlQuery.list().size()>1){
					resultado = sqlQuery.list();
					for(int i=1;i<resultado.size();i++){
						
						Usuario user = new Usuario();
						user.setId(Long.parseLong(String.valueOf(resultado.get(i)[0])));
						user.setDataExibivel(String.valueOf(resultado.get(i)[1]));
						user.setEmail(String.valueOf(resultado.get(i)[2]));
						user.setNome(String.valueOf(resultado.get(i)[3]));
						
						System.out.println("[0]:"+resultado.get(i)[0]);
						System.out.println("[1]:"+resultado.get(i)[1]);
						System.out.println("[2]:"+resultado.get(i)[2]);
						System.out.println("[3]:"+resultado.get(i)[3]);
						
						lista.add(user);
					}
					
				}else{
					lista = null;
				}
			
			session.close();
			System.out.println("Conexao com mysql fechado");		   	    
		 
		 
		return lista;
	}
}


