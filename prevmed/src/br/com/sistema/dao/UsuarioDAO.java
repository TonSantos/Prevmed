package br.com.sistema.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.sistema.modelo.Usuario;

@Component
@SessionScoped 
public class UsuarioDAO {
	private Session session;
	
	public void inseriUsuario(Usuario usuario){
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
				
				
				session.disconnect();			
				session.close();					
				System.out.println("fechado sessao!!");
			}
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
}


