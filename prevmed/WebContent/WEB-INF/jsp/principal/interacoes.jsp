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
                    <li><a class="logout" href="${pageContext.request.contextPath}/login"><i class="fa fa-user"></i> Entrar</a></li>
            	</ul>
            </div>
            <!--logo start-->   
            <div align="left">               
            <a class="top-menu" ><img src="<c:url value="/resource/images/logo-drug.png"/>" alt="" /></a>           
            <a class="logo" href="${pageContext.request.contextPath}/"><b>PREVMED</b></a>                                              
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
				           			<td><a class="btn btn-primary btn-xs" data-toggle="modal" href="#myModal${loop.index}"><i class="fa fa-file-text-o "></i> Diagnóstico</a></td>
				                </tr>	
				                </c:forEach>			                
				              </tbody>
				         		 </table>
				         		</form> 
				         		 
				      <c:forEach var="interacoes" items="${interacoes}" varStatus="loop">     		 
				         		 <!-- Modal -->
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
		          <!-- modal -->	
		          </c:forEach>   
                                 
                              </div>
                              
                          </div>                                    
                          
                          
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
 		
 	<script>
        $.backstretch("<c:url value="/resource/images/pill-bg.jpg"/>", {speed: 500});
    </script>	
		
						
</body>
</html>