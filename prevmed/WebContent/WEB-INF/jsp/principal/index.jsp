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
                    <li><a class="logout" href="${pageContext.request.contextPath}/login"><i class="fa fa-user"></i> Entrar</a> </li>
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
	                        <div class="pull-left"><h5><i class="fa fa-tasks"></i>  Selecione os medicamentos para análise</h5></div>
	                       <br>
	                        <hr>
	                        <div align="center">
            <c:forEach var="error" items="${errors}">
						<div class="alert alert-danger"><i class="fa fa-exclamation-triangle"></i>
						  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						  <strong>Atenção! </strong>${error.message}
						</div>      				      				
			</c:forEach>
			</div>  
	                        <br>
	                 	</div>
	                 	<form id=form-geral action="${pageContext.request.contextPath}/resultado" method="post">
                          <div class="panel-body">
                              <div class="task-content">
                                 
                                  <table id="tdinx" class="table table-hover custom-check">                                    
                                    <thead>
        							<tr> 
        								       							
           								 <th ><input type="checkbox" id="marcarTodos"> - <i class="fa fa-medkit"></i> Medicamento</th> 
           								 <th ><i class="fa fa-calendar"></i> Data de cadastro</th>            								          								       							 
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
 	    	  jQuery(this).parents("tr td").css('background-color', '#5cb85c');	    	   	 
 	 	       }else{
 	 	      jQuery(this).parents("tr td").css('background-color', '#fff');    
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
		
		<script type="text/javascript">
		$("#marcarTodos").click(toggleMarcarTodos);

		function toggleMarcarTodos(event) {
		    var $tabela = $("#tdinx");
		    var check = $("#marcarTodos", $tabela).is(':checked');
		    var $checks = $('.list-child', $tabela);
		    
		    // Se a sua coluna tiver ordenacao, tem que prevenir de ordenar ao clicar no checkbox! 
		    event && event.stopPropagation();
		    
		    $checks.each(function () {
		        $(this).prop("checked", check);
		    });
		}
		

		$(document).ready(function() {
		    $('#tdinx').dataTable({"sPaginationType": "full_numbers"});
		    
		    // Ao ordernar e paginar, tem que corrigir o estado dos checkboxe's
		    $('#tdinx').on('page.dt, order.dt', function () {
		        setTimeout(toggleMarcarTodos, 1);
		    });
		});
		</script>
		
	<script>
        $.backstretch("<c:url value="/resource/images/pill-bg.jpg"/>", {speed: 500});
    </script>
						
</body>
</html>