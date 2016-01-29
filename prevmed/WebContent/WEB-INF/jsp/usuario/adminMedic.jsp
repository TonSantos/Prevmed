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
            		<li><a class="logo">${user}</a></li>
                    <li><a class="logout" href="${pageContext.request.contextPath}/login">Sair <i class="fa fa-sign-out"></i></a> </li>
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
						  ${infor}!
						</div>      				      				
			</c:forEach>
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
	                        <div class="pull-left"><h5><i class="fa fa-tasks"></i>  Selecione os medicamentos para análise</h5></div>
	                       <br>
	                        <hr>
	                          <div class=" add-task-row">
                          		 	<a id="id_button_add" class="btn btn-success btn-sm pull-right"  data-toggle="modal" href="#myModalAdd"><i class="fa fa-plus-circle"></i> Adicionar medicamento</a>                    		  	
                          	  </div>
	                        <br>
	                 	</div>
	                 	<form id=form-geral action="${pageContext.request.contextPath}/analise-interacoes" method="post">
                          <div class="panel-body">
                              <div class="task-content">
                                 
                                  <table id="tdinx" class="table table-hover custom-check">                                    
                                    <thead>
        							<tr>          							
           								 <th align="center"><i class="fa fa-medkit"></i> Medicamento</th> 
           								 <th align="center"><i class="fa fa-calendar"></i> Data de cadastro</th>
           								 <th align="center"><i class="fa fa-wrench"></i> manutenção </th>            								          								       							 
        							</tr>
    								</thead>
                                    <tbody>
                                <c:forEach var="medicamentos" items="${medicamentos}" varStatus="loop"> 
                                     <tr class="list-primary">
                                          <td>
                                          <div class="task-title">                                       	  
                                              <input id="checkMed" type="checkbox" name="selecionados[]" value="${medicamentos.id}" class="list-child" />
                                          	  <span class="task-title-sp">${medicamentos.nome}</span> 
                                          </div>                                                 
                                          </td>
                                          
                                          <td>
                                          <div class="task-title">
                                              <span class="task-title-sp">${medicamentos.dataExibivel}</span>                                                
                                          </div>
                                          </td>
                                          
                                           <td>
                                          	<div class="task-title">
                                              <a class="btn btn-warning btn-xs" data-toggle="modal" href="#myModalEditar${loop.index}"><i class="fa fa-pencil-square-o"></i> Editar</a>
                                              <a class="btn btn-danger btn-xs" data-toggle="modal" href="#myModalExluir${loop.index}"><i class="fa fa-times-circle"></i> Excluir</a>                                          
                                          	</div>
                                          </td>
                                      </tr>
                                    </c:forEach>   
                                      </tbody>                           
                                  </table>
                                  
                              </div>
                              <div class=" add-task-row"> 
                                  <button id="id_button" name="id_button" value="Realizar análise" class="btn btn-success btn-sm pull-left"><i class="fa fa-search"></i> Realizar análise</button>                                
                              </div>                             
                          </div>                                    
                          
                          </form>
                          
                          <!-- Modal's -->
              <c:forEach var="medicamentos" items="${medicamentos}" varStatus="loop">     		 
				     <!-- modal editar -->    		 
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalEditar${loop.index}" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title"> Editar Medicamento </h4>
		                      </div>
		                      <form action="${pageContext.request.contextPath}/medicamento-atualizado" method="post">
		                      <div class="modal-body">
		                      	  <p>Edite o nome do medicamento e clique em OK</p>
                            	  <input type="text" name="medicamento" placeholder="${medicamentos.nome}" autocomplete="off" class="form-control placeholder-no-fix" value="${medicamentos.nome}">
                            	  <input type="hidden" name="id" value="${medicamentos.id}">                    	  
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
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalExluir${loop.index}" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title"> Excluir Medicamento </h4>
		                      </div>
		                       <form action="${pageContext.request.contextPath}/medicamento" method="post">
		                      <div class="modal-body">
		                      	  <p>Você tem certeza que deseja excluir o medicamento <b>${medicamentos.nome}</b> ?</p> 
		                      	  <p>Todas as interações de <b>${medicamentos.nome}</b> tambem serão excluidos</p>
		                      	  <input type="hidden" name="id" value="${medicamentos.id}">                          	  
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
		                          <h4 class="modal-title"> Adicionar Medicamento </h4>
		                      </div>
		                      <form action="${pageContext.request.contextPath}/adicionar-medicamento" method="post">
		                      <div class="modal-body">
		                      	  <p>Insira o nome do medicamento:</p>   
		                      	  <input type="text" name="nome" placeholder="medicamento" autocomplete="off" class="form-control placeholder-no-fix">                        	  
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
				  								              		   			 	
 </section>
		   	</div>		      		      	 			  		
	 			                     	
 		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> 
    	<script src="http://malsup.github.com/jquery.form.js"></script> 
    	
 		<script src="<c:url value="/resource/js/jquery.js"/>"></script>
 		<script src="<c:url value="/resource/js/bootstrap.min.js"/>"></script>
 		<script src="<c:url value="/resource/js/jquery.blockUI.js" />" ></script>
 		<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script> 		      	
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
       		 $.backstretch("<c:url value="/resource/images/pill-bg.jpg"/>", {speed: 500});
   		 </script>
						
</body>
</html>