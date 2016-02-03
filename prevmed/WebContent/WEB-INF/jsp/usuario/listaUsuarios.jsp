<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PREVMED | Interações Medicamentosas</title>
<meta charset="utf-8">
<!-- Bootstrap core CSS -->
    <link href="<c:url value="/resource/css/bootstrap.css" />" rel="stylesheet">  
    <!--external css-->
    <link href="<c:url value="/resource/font-awesome/css/font-awesome.css"/>" rel="stylesheet" />
	<link href="<c:url value="/resource/css/style.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resource/css/style-responsive.css"/>" rel="stylesheet">	
	<link href="//cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
	<link href="<c:url value="/resource/css/to-do.css"/>" rel="stylesheet">
</head>
<body>
	<!--header start-->
      <header class="header black-bg">
       <!-- LOGIN -->
             <div class="top-menu" align="right">
            	<ul class="nav pull-right top-menu">
            		<li><a class="logo"><i class="fa fa-user"></i>
            		 ${user}</a></li>
                    <li><a class="logout" href="${pageContext.request.contextPath}/login">Sair <i class="fa fa-sign-out"></i></a> </li>
            	</ul>
            </div>  
            <!--logo start-->   
            <div align="left">               
            <a class="top-menu" ><img src="<c:url value="/resource/images/logo-drug.png"/>" alt="" /></a>           
            <a class="logo" href="${pageContext.request.contextPath}/"><b>PREVMED</b></a>                                                       
            </div> 
            
            <!--logo end-->   
            
                              
       </header>
      <!--header end-->
      <br>
		      		      
		      <br>
		       <div class="container"> 
          		<section class="wrapper">          		  		  
		        	        		             			  		         				                	
	                 	<div class="row mt mb">
                  <div class="col-md-12">
                      <section class="task-panel tasks-widget">
	                	<div class="panel-heading">
	                        <div class="pull-left"><h5><i class="fa fa-tasks"></i>  Lista de membros no sistema</h5></div>
	                       <br>
	                        <hr>
	                        <div align="center">
            <c:forEach var="error" items="${errors}">
						<div class="alert alert-danger"><i class="fa fa-exclamation-triangle"></i>
						  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						  <strong>Atenção! </strong>${error.message}
						</div>      				      				
			</c:forEach>
			<c:forEach var="infor" items="${infor}">
						<div class="${status}"><i class="${icon}"></i>
						  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						  ${infor}!
						</div>      				      				
			</c:forEach>
			</div>  
	                          <div class=" add-task-row">
                          		 	<a id="id_button_add" class="btn btn-success btn-sm pull-right"  data-toggle="modal" href="#myModalAdd"><i class="fa fa-plus-circle"></i> Adicionar membro</a>                    		  	
                          	  </div>
	                        <br>
	                 	</div>	                 	
                          <div class="panel-body">
                              <div class="task-content">
                                 
                                  <table id="tdinx" class="table table-hover custom-check">                                    
                                    <thead>
        							<tr>          							
           								 <th align="center"><i class="fa fa-medkit"></i> Usuario</th> 
           								 <th align="center"><i class="fa fa-calendar"></i> Email</th>
           								 <th align="center"><i class="fa fa-wrench"></i> Data de Ultimo acesso </th> 
           								 <th align="center"></th>             								          								       							 
        							</tr>
    								</thead>
                                    <tbody>
                                <c:forEach var="usuarios" items="${usuarios}" varStatus="loop"> 
                                     <tr class="list-primary">
                                          <td>
                                          <div class="task-title">                                       	                      
                                          	  <span class="task-title-sp">${usuarios.nome}</span> 
                                          </div>                                                 
                                          </td>
                                          
                                          <td>
                                          <div class="task-title">
                                              <span class="task-title-sp">${usuarios.email}</span>                                                
                                          </div>
                                          </td>
                                          
                                          <td>
                                          <div class="task-title">
                                              <span class="task-title-sp">${usuarios.dataExibivel}</span>                                                
                                          </div>
                                          </td>
                                          
                                           <td>
                                          	<div class="task-title">
                                              <a class="btn btn-warning btn-xs" data-toggle="modal" href="#myModalEditar${loop.index}"><i class="fa fa-pencil-square-o"></i> Editar</a>
                                              <a class="btn btn-danger btn-xs" data-toggle="modal" href="#myModalExcluir${loop.index}"><i class="fa fa-times-circle"></i> Excluir</a>                                          
                                          	</div>
                                          </td>
                                      </tr>
                                    </c:forEach>   
                                      </tbody>                           
                                  </table>
                                  
                              </div>                            
                          </div>                                    
                          
                          
                          
                          <!-- Modal's -->
              <c:forEach var="usuarios" items="${usuarios}" varStatus="loop">     		 
				     <!-- modal editar -->    		 
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalEditar${loop.index}" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title"> Editar Usuario </h4>
		                      </div>
		                      <form action="${pageContext.request.contextPath}/membro-atualizado" method="post">
		                      <div class="form-panel">
		                      <h4 class="mb">Edite as informacoes do usuario e clique em OK::</h4>
		                      	 
		                      	  
		                      	  <p><i class="fa fa-caret-right"></i><b> Nome: </b>
                            	  <input type="text" name="usuario.nome" placeholder="${usuarios.nome}" autocomplete="off" class="form-control placeholder-no-fix" value="${usuarios.nome}">
                            	  <input type="hidden" name="usuario.id" value="${usuarios.id}"> 
                            	  <hr> 
                            	  <p><i class="fa fa-caret-right"></i><b> Email: </b>
                            	  <input type="email" name="usuario.email" placeholder="${usuarios.email}" autocomplete="off" class="form-control placeholder-no-fix" value="${usuarios.email}">                           	                     	  
		                      	  <hr>
		                      	  <p><i class="fa fa-caret-right"></i><b> Senha: </b>
		                      	  <input type="password" name="usuario.senha" placeholder="nova senha" autocomplete="off" class="form-control placeholder-no-fix" value="${usuarios.senha}"> 
		                      	  <br>
		                      	  <input type="password" name="outra" placeholder="confirmar senha" autocomplete="off" class="form-control placeholder-no-fix" value="${usuarios.senha}">
		                      </div>
		                      <div class="modal-footer">
		                      	  <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
		                          <button class="btn btn-theme" type="submit">OK</button>		                          
		                      </div>
		                      </form>
		                  </div>
		              </div>
		          </div>
		          <!-- modal editar fim -->  
		           <!-- modal excluir -->    		 
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalExcluir${loop.index}" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title"> Remover Usuario </h4>
		                      </div>
		                       <form action="${pageContext.request.contextPath}/membros" method="post">
		                      <div class="modal-body">
		                      	  <p>Você tem certeza que deseja remover <b>${usuarios.nome}</b> ?</p> 
		                      	  <p><b>${medicamentos.nome}</b> não poderá mais acessar ao sistema</p>
		                      	  <input type="hidden" name="id" value="${usuarios.id}">                          	  
		                      </div>
		                      <div class="modal-footer">
		                      	  <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
		                          <button class="btn btn-danger" type="submit">Excluir</button>		                          
		                      </div>
		                      </form>
		                  </div>
		              </div>
		          </div>
		          <!-- modal exclui fim -->    	
		        </c:forEach>  
		           <!-- modal add -->	
		           <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalAdd" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title"> Adicionar Membro </h4>
		                      </div>
		                      <form action="${pageContext.request.contextPath}/adicionar-membro" method="post">
		                      <div class="form-panel">
		                      	  <p>Insira o nome do usuario:</p>   
		                      	  <input type="text" name="usuario.nome" placeholder="nome do usuario" autocomplete="off" class="form-control placeholder-no-fix" required="required">  
		                      	  <hr>
		                      	  <p>Email:</p>   
		                      	  <input type="text" name="usuario.email" placeholder="usuario@email" autocomplete="off" class="form-control placeholder-no-fix" required="required">
		                      	  <hr>
		                      	  <p>Senha:</p>   
		                      	  <input type="password" name="usuario.senha" placeholder="senha" autocomplete="off" class="form-control placeholder-no-fix" required="required">  
		                      	  <br>
		                      	  <p>Confirmar Senha:</p>   
		                      	  <input type="password" name="outro" placeholder="confirmar senha" autocomplete="off" class="form-control placeholder-no-fix" required="required">                       	  
		                      </div>
		                      <div class="modal-footer">
		                      	  <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
		                          <button class="btn btn-theme" type="submit">Adicionar</button>		                          
		                      </div>
		                      </form>
		                  </div>
		              </div>
		          </div>
		          <!-- modal add fim -->	
                      </section>
                  </div><!--/col-md-12 -->
              </div><!-- /row -->
				<footer class="site-footer">
          <div class="text-center">
              2016 - Ton Santos
              <a href="#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>  								              		   			 	
 </section>
		   	</div>		      		      	 			  		
	 			                     	
 		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> 
    	<script src="http://malsup.github.com/jquery.form.js"></script> 
    	
 		<script src="<c:url value="/resource/js/jquery.js"/>"></script>
 		<script src="<c:url value="/resource/js/bootstrap.min.js"/>"></script>	
 		<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script> 	
 		<script src="<c:url value="/resource/js/jquery.blockUI.js" />" ></script>	      	
 		<script src="<c:url value="/resource/js/jquery-table.js" />" ></script>

 		<script type="text/javascript" src="<c:url value="/resource/js/jquery.quick.search.js" />" ></script>	
 		<script type="text/javascript"  src="<c:url value="/resource/js/jquery.backstretch.min.js"/>"></script>
 		
 		
 		  	
 		<script type="text/javascript">
			$(document).ready(function(){
			$("#tdinx").DataTable();
			});

		</script> 		
 		
 		<script>
 		jQuery('#tdinx input:checkbox').change(function() {
 	       if(this.checked){
 	    	  jQuery(this).parents("tr").css('background-color', '#5cb85c');	    	   	 
 	 	       }else{
 	 	      jQuery(this).parents("tr").css('background-color', '#fff');    
 	 	 	       }  // check if checkbox checked then change color of row
 	    });
 		</script>
 		
    
    
  <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>
 		
 		
 		<script>
			var btBlock = $("#id_button");
	
			btBlock.click(function () {
			$.blockUI({ message: '<h1><img src="<c:url value="/resource/images/load.gif"/>" /> <br>Realizando Análise...</h1>'});
			window.setTimeout(function () {
			$.unblockUI();
			}, 3000);	

			});
		</script>
 		
 		<script type="text/javascript">    
 		$('#id_button').click(function(){
 		    var checked_courses = courses.$('input[name="selecionados[]"]:checked').serialize();
 		    
 		        $('#checkMed').val(checked_courses);
 		        $('form').submit();
 		    
 		});
		</script> 
		<script>
       		 $.backstretch("<c:url value='/resource/images/pill-bg.jpg'/>", {speed: 500});
   		 </script>
						
</body>
</html>