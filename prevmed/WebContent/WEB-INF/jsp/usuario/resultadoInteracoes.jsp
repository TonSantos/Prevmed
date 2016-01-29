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
             <div class="top-menu">
            	<ul class="nav pull-right top-menu">
            		<li><a class="logo">${user}</a></li>
                    <li><a class="logout" href="${pageContext.request.contextPath}/login">Sair <i class="fa fa-sign-out"></i> </a></li>
            	</ul>
            </div>
            <!--logo start-->   
            <div align="left">               
            <a class="top-menu" ><img src="<c:url value="/resource/images/logo-drug.png"/>" alt="" /></a>           
            <a class="logo" href="${pageContext.request.contextPath}/painel"><b>PREVMED</b></a>                                              
            </div> 
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
						  ${infor}
						</div>      				      				
			</c:forEach>
			</div>   
            
            
                          
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
	                        <div class="pull-left"><h5><i class="fa fa-tasks"></i>  Clique em Diagnóstico para análise completa.</h5></div>
	                        
	                        <br>
	                        <hr>
	                        <div class=" add-task-row">
                          		 	<a id="id_button_add" class="btn btn-success btn-sm pull-right"  data-toggle="modal" href="#myModalAdd"><i class="fa fa-plus-circle"></i> Adicionar interação</a>                    		  	
                          	  </div>
	                        <br>
	                 	</div>
	                 	
                          <div class="panel-body">
                              <div class="task-content">
                              <form>
    							<table id="td" class="table table-hover custom-check">
				             	<thead>
        							<tr>          							
           								 <th align="center"><i class="fa fa-medkit"></i> Medicamento</th> 
           								 <th align="center"><i class="fa fa-medkit"></i> Interage com</th>            								 
           								 <th align="center"><i class="fa fa-tag"></i> Grau da interação</th>
           								 <th align="center"></th>        							 
        							</tr>
    							</thead>
				              <tbody>
				               <c:forEach var="interacoes" items="${interacoes}" varStatus="loop"> 
				                <tr>
				           			<td>${interacoes.medicamentoA}</td>
				           			<td>${interacoes.medicamentoB}</td>
				           			<td><i class="fa fa-exclamation-triangle" style="color:${interacoes.corGrau}"></i> ${interacoes.grau}</td>
				           			<td>
				           			<a class="btn btn-primary btn-xs" data-toggle="modal" href="#myModal${loop.index}"><i class="fa fa-file-text-o "></i> Diagnóstico</a>
				           			<a class="btn btn-warning btn-xs" data-toggle="modal" href="#myModalEditar${loop.index}"><i class="fa fa-pencil-square-o"></i> Editar</a>
				           			<a class="btn btn-danger  btn-xs" data-toggle="modal" href="#myModalExcluir${loop.index}"><i class="fa fa-times-circle"></i> Excluir</a>
				           			</td>
				                </tr>	
				                </c:forEach>			                
				              </tbody>
				         		 </table>
				         		</form> 
				    
				    <!-- Modal's -->     		 
			<c:forEach var="interacoes" items="${interacoes}" varStatus="loop">     		 
				    <!-- modal de diagnostico -->     		 
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal${loop.index}" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title"> Diagnóstico </h4>
		                      </div>
		                      <div class="modal-body">
		                      	  <h5 align="center"><i class="fa fa-exclamation-triangle" style="color:${interacoes.corGrau}"></i><b> ${interacoes.grau}</b></h5>
		                          <hr>
		                          <p><i class="fa fa-caret-right"></i><b> Medicamentos: </b>${interacoes.medicamentoA}, ${interacoes.medicamentoB}</p>
		                          <p><i class="fa fa-caret-right"></i><b> Efeito Clínico: </b>${interacoes.efeito}</p>
		                          <p><i class="fa fa-caret-right"></i><b> Início de ação: </b>${interacoes.acao}</p>
		                          <p><i class="fa fa-caret-right"></i><b> Recomendação: </b>${interacoes.recomendacao}</p>
		
		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-theme" type="button">Ok</button>		                          
		                      </div>
		                  </div>
		              </div>
		          </div>
		           <!-- modal de editar -->   
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalEditar${loop.index}" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title"> Editar </h4>
		                      </div>
		                      <div class="form-panel">
		                      <h4 class="mb">Edite as informacoes da interacao dos medicamentos e clique em OK</h4>
		                       <p><i class="fa fa-caret-right"></i><b> Grau da interação: </b>
		                      	  <div class="btn-group">		                      	 
						 			 <button type="button" class="btn btn-default dropdown-toggle btn-sm" data-toggle="dropdown"><i class="fa fa-exclamation-triangle"></i>
						   				 Grau da interacao <span class="caret"></span>
						 			 </button>
						 			 <ul class="dropdown-menu" role="menu">
						 			 	<li><a href="#" data-value="Nao-especificado"><i class="fa fa-exclamation-triangle" style="color:#B2B2B2"></i> Não-especificado</a></li>
						   		 		<li><a href="#" data-value="Leve"><i class="fa fa-exclamation-triangle" style="color:#428BCA"></i> Leve</a></li>
						    	 		<li><a href="#" data-value="Moderada"><i class="fa fa-exclamation-triangle" style="color:#FFD561"></i> Moderada</a></li>
						    		 	<li><a href="#" data-value="Grave"><i class="fa fa-exclamation-triangle" style="color:#E54444"></i> Grave</a></li>						    	 		
						  			</ul>
								</div>
								<hr>										                         
		                          <p><i class="fa fa-caret-right"></i><b> Medicamentos: </b><div class="btn-group">
						 			 <button type="button" class="btn btn-default dropdown-toggle btn-sm" data-toggle="dropdown">
						   				 ${interacoes.medicamentoA} <span class="caret"></span>
						 			 </button>
						 			 <ul class="dropdown-menu" role="menu">
						 			 	<c:forEach var="medicamentos" items="${medicamentos}" varStatus="loop2">
						 			 		<li><a href="#" data-value="${medicamentos.nome}"> ${medicamentos.nome}</a></li>
				    	 				</c:forEach>
						  			</ul>
								</div> <i class="fa fa-arrows-h"></i> <div class="btn-group">
						 			 <button type="button" class="btn btn-default dropdown-toggle btn-sm" data-toggle="dropdown">
						   				 ${interacoes.medicamentoB} <span class="caret"></span>
						 			 </button>
						 			 <ul class="dropdown-menu" role="menu">
						 			 	<c:forEach var="medicamentos" items="${medicamentos}" varStatus="loop3">
						 			 		<li><a href="#" data-value="${medicamentos.nome}"> ${medicamentos.nome}</a></li>
				    	 				</c:forEach>
						  			</ul>
								</div>
								<hr>	
		                          <div><i class="fa fa-caret-right"></i><b> Efeito Clínico: </b><textarea rows="3" cols="50" class="form-control">${interacoes.efeito}</textarea></div>
		                        <hr>  
		                          <p><i class="fa fa-caret-right"></i><b> Início de ação: </b><div class="btn-group">
						 			 <button type="button" class="btn btn-default dropdown-toggle btn-sm" data-toggle="dropdown">
						   				 ${interacoes.acao} <span class="caret"></span>
						 			 </button>
						 			 <ul class="dropdown-menu" role="menu">
						 			 	<li><a href="#" data-value="Nao-especificado"> Nao-especificado</a></li>
						   		 		<li><a href="#" data-value="Demorado"> Demorado</a></li>
						    	 		<li><a href="#" data-value="Rapido"> Rapido</a></li>						    							    	 		
						  			</ul>
								</div>
		                        <hr>
		                          <p><i class="fa fa-caret-right"></i><b> Recomendação: </b>
		                           <textarea rows="4" cols="50" class="form-control">${interacoes.recomendacao}</textarea> 
		                          
		
		                      </div>
		                      <div class="modal-footer">
		                      	  <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
		                          <button data-dismiss="modal" class="btn btn-theme" type="button">Ok</button>		                          
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- fim modal editar -->
		          
		          <!-- modal excluir -->    		 
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalExcluir${loop.index}" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title"> Excluir Interação Medicamentosa </h4>
		                      </div>
		                      <form action="${pageContext.request.contextPath}/interacao" method="post">
		                      <div class="modal-body">
		                      	  <p>Você tem certeza que deseja excluir essa interação ?</p>
		                      	  <h5><b>:: ${interacoes.medicamentoA} <i class="fa fa-arrows-h"></i> ${interacoes.medicamentoB} </b></h5>
		                      	  <input type="hidden" name="id" value="${interacoes.id}">                           	  
		                      </div>
		                      <div class="modal-footer">
		                      	  <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
		                          <button class="btn btn-danger" type="submit">Excluir</button>		                          
		                      </div>
		                      </form>
		                  </div>
		              </div>
		          </div>
		          <!-- modal's -->
		      </c:forEach>   
                      	<!-- modal de add interacao -->
                      <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalAdd" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title"> Adicionar Interação </h4>
		                      </div>
		                      <form action="${pageContext.request.contextPath}/adicionar-interacao" method="post">
		                      <div class="form-panel">
		                      <h4 class="mb">Adicione as informacoes da interacao dos medicamentos::</h4>
		                      									                         
		                          <i class="fa fa-caret-right"></i><b> Medicamentos: </b>
		                          <input type="hidden" name="interacao.id_medicA" id="grauMedA">
		                          <input type="hidden" name="interacao.id_medicB" id="grauMedB">
		                          <div class="btn-group">
						 			 <button type="button" class="btn btn-default dropdown-toggle btn-sm" data-toggle="dropdown">
						   				 Medicamento 1 <span class="caret"></span>
						 			 </button>
						 			 <ul class="dropdown-menu" role="menu">
						 			 	<c:forEach var="medicamentos" items="${medicamentos}" varStatus="loop2">
						 			 		<li onclick="$('#grauMedA').val('${medicamentos.id}');">
						 			 			<a href="#" data-value="${medicamentos.id}"> ${medicamentos.nome}</a>
						 			 			
						 			 		</li>
				    	 				</c:forEach>
						  			</ul>
								</div> <i class="fa fa-arrows-h"></i> <div class="btn-group">
						 			 <button type="button" class="btn btn-default dropdown-toggle btn-sm" data-toggle="dropdown">
						   				 Medicamento 2 <span class="caret"></span>
						 			 </button>
						 			 <ul class="dropdown-menu" role="menu">
						 			 	<c:forEach var="medicamentos" items="${medicamentos}" varStatus="loop3">
						 			 		<li onclick="$('#grauMedB').val('${medicamentos.id}');">
						 			 			<a href="#" data-value="${medicamentos.id}"> ${medicamentos.nome}</a>
						 			 			
						 			 		</li>
				    	 				</c:forEach>
						  			</ul>
								</div>
								<hr>
								<p><i class="fa fa-caret-right"></i><b> Grau da interação: </b>
		                      <input type="hidden" name="interacao.grau" id="grauId">
		                      	  <div class="btn-group">		                      	  
						 			 <button type="button" class="btn btn-default dropdown-toggle btn-sm" data-toggle="dropdown"><i class="fa fa-exclamation-triangle"></i>
						   				 Grau da interacao <span class="caret"></span>
						 			 </button>
						 			 <ul class="dropdown-menu" role="menu">
						 			 	<li onclick="$('#grauId').val('Não-especificado');">
						 			 		<a href="#" data-value="Não-especificado" ><i class="fa fa-exclamation-triangle" style="color:#B2B2B2"></i> Não-especificado</a>
						 			 	</li>
						   		 		<li onclick="$('#grauId').val('Leve');">
						   		 			<a href="#" data-value="Leve" ><i class="fa fa-exclamation-triangle" style="color:#428BCA"></i> Leve</a>
						   		 			
						   		 		</li>
						    	 		<li onclick="$('#grauId').val('Moderada');">
						    	 			<a href="#" data-value="Moderada" ><i class="fa fa-exclamation-triangle" style="color:#FFD561"></i> Moderada</a>
						    	 			
						    	 		</li>
						    		 	<li onclick="$('#grauId').val('Grave');">
						    		 		<a href="#" data-value="Grave" ><i class="fa fa-exclamation-triangle" style="color:#E54444"></i> Grave</a>
						    		 		
						    		 	</li>						    	 		
						  			</ul>
								</div>
								<hr>		
		                          <div><i class="fa fa-caret-right"></i><b> Efeito Clínico: </b>
		                         <!-- <input type="text" class="form-control" name="interacao.efeito" required="required"/>  --> 
		                          <textarea rows="3" cols="50" class="form-control" required="required" name="interacao.efeito"></textarea>
		                          </div>
		                        <hr>  
		                          <p><i class="fa fa-caret-right"></i><b> Início de ação: </b>
		                          <input type="hidden" name="interacao.acao" id="medAcao">
		                          <div class="btn-group">
						 			 <button type="button" class="btn btn-default dropdown-toggle btn-sm" data-toggle="dropdown">
						   				 Ação <span class="caret"></span>
						 			 </button>
						 			 <ul class="dropdown-menu" role="menu">
						 			 	<li onclick="$('#medAcao').val('Nao-especificado');">
						 			 		<a href="#" data-value="Nao-especificado"> Nao-especificado</a>
						 			 		
						 			 	</li>
						   		 		<li onclick="$('#medAcao').val('Demorado');">
						   		 			<a href="#" data-value="Demorado"> Demorado</a>
						   		 			
						   		 		</li>
						    	 		<li onclick="$('#medAcao').val('Rapido');">
						    	 			<a href="#" data-value="Rapido"> Rapido</a>
						    	 			
						    	 		</li>
						    	 								    							    	 		
						  			</ul>
								</div>
		                        <hr>
		                          <p><i class="fa fa-caret-right"></i><b> Recomendação: </b>
		                          <!-- <input type="text" class="form-control" name="interacao.recomendacao" required="required"/>  -->
		                          <textarea rows="4" cols="50" class="form-control" required="required" name="interacao.recomendacao"></textarea>
		                          </p>
												
		                      </div>
		                      <div class="modal-footer">
		                      	  <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
		                          <button class="btn btn-theme" type="submit">Adicionar</button>		                          
		                      </div>
		                      </form>		                      
		                      
		                  </div>
		              </div>
		          </div>    
		          <!-- fim do modal add -->       
                              </div>
                              
                          </div>                                    
                          
                          
                      </section>
                  </div><!--/col-md-12 -->
              </div><!-- /row -->
				  								              		   			 	
 </section>
		   			      		      	 			  		
	 	</div>		 
        
            	 		
 		<script src="<c:url value="/resource/js/jquery.js"/>"></script>
 		<script src="<c:url value="/resource/js/bootstrap.min.js"/>"></script>
 		<script src="<c:url value="/resource/js/jquery.blockUI.js" />" ></script>
 		<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script> 		      	
 		<script src="<c:url value="/resource/js/jquery-table.js" />" ></script> 	
 			
 			
 		<script type="text/javascript" src="<c:url value="/resource/js/jquery.quick.search.js" />" ></script>	
 		<script type="text/javascript"  src="<c:url value="/resource/js/jquery.backstretch.min.js"/>"></script>
 		 		   
 		
 		
 		<script type="text/javascript">
			$(document).ready(function(){
			$("#td").DataTable();
			});

		</script>
 		  	
 		
 		<script>
      		jQuery(document).ready(function() {
         	 TaskList.initTaskWidget();
     		 });

      		$(function() {
          		$( "#sortable" ).sortable();
          		$( "#sortable" ).disableSelection();
     		 });
    </script>
    
    
  <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>
 		
 		<script type="text/javascript">
 		$(".dropdown-menu li a").click(function(){
 			  $(this).parents(".btn-group").find('.btn').html($(this).text() + ' <span class="caret"></span>');
 			  $(this).parents(".btn-group").find('.btn').val($(this).data('value'));
 			  
 			});
 		
 		</script>
		<script>
       		 $.backstretch("<c:url value="/resource/images/pill-bg.jpg"/>", {speed: 500});
    	</script>
						
</body>
</html>