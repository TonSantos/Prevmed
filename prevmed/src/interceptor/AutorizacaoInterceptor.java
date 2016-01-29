package interceptor;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.sistema.annotation.Public;
import br.com.sistema.controller.LoginController;
import br.com.sistema.modelo.UsuarioWeb;
/**CLASSE QUE FAZ INSTERCEPTAÇÃO DE QUEM NÃO ESTIVER ONLINE NO SISTEMA**/
@Intercepts
public class AutorizacaoInterceptor implements Interceptor{
	
	private final UsuarioWeb usuarioWeb;	
	private final Result result;
	
	public AutorizacaoInterceptor(UsuarioWeb alunoWeb, Result result) {
		this.usuarioWeb = alunoWeb;		
		this.result = result;
	}
	
	public boolean accepts(ResourceMethod method) {
		 return  !(method.getMethod().isAnnotationPresent(Public.class) ||
		           method.getResource().getType().isAnnotationPresent(Public.class));
	}

	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
		if (usuarioWeb.isLogado()) {
            stack.next(method, resourceInstance);
        } else {
            result.redirectTo(LoginController.class).login();
        }
		
	}
}
