package br.com.sistema.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import br.com.sistema.modelo.Interacao;
import br.com.sistema.modelo.Medicamento;
import br.com.sistema.modelo.Usuario;
/**CLASSE QUE CRIA SESSION COM BANCO MYSQL**/
public class Sessao {
	
	private static SessionFactory Sessao;
	
	static {  
        try {     
        	//CONFIGURACAO DO ARQUIVO DO HIBERNATE
        	//ADICIONADO ANOTACAO DE CLASSES ENTIDADES
         Configuration configuration = new Configuration();
       	 configuration.configure();       
       	 
       	 configuration.addAnnotatedClass(Medicamento.class);
       	 configuration.addAnnotatedClass(Interacao.class);
       	 configuration.addAnnotatedClass(Usuario.class);
       	 Sessao = configuration.buildSessionFactory();
       	 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static Session getSessao() {  
        return Sessao.openSession(); //ABRE SESSAO   
    }  
}
