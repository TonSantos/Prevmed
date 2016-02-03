<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">   

    <title>PREVMED - Acesso</title>
	
		
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resource/css/bootstrap.css" />" rel="stylesheet"> 
    <!--external css-->
    <link href="<c:url value="/resource/font-awesome/css/font-awesome.css"/>" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resource/css/style.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resource/css/style-responsive.css"/>" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" action="${pageContext.request.contextPath}/painel-admistrativo" method="post">
		        <h2 class="form-login-heading">ACESSAR</h2>
		        <div class="alert-danger" align="center">
					<c:forEach var="error" items="${errors}"><br/>${error.message}<br/></c:forEach>
				</div>
		        <div class="login-wrap">
		            <input type="email" class="form-control" placeholder="Email" autofocus name=usuario.email required="required">
		            <br>
		            <input type="password" class="form-control" placeholder="Senha" name=usuario.senha required="required">
		            <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.jsp#myModal"> Esqueceu a senha?</a>
		
		                </span>
		            </label>
		            <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> ENTRAR</button>
		            <hr>
		            		        
		
		        </div>
		
		          <!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Esqueceu a senha?</h4>
		                      </div>
		                      <div class="modal-body">
		                          <p>Insira o email cadastrado para recuperar acesso.</p>
		                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
		
		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
		                          <button class="btn btn-theme" type="button">Enviar</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		
		      </form>	  	
	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
      
    <script type="text/javascript" src="<c:url value="/resource/js/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resource/js/bootstrap.min.js" />" ></script>	
 	
    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript"  src="<c:url value="/resource/js/jquery.backstretch.min.js"/>"></script>
    <script>
        $.backstretch("<c:url value="/resource/images/pill-bg.jpg"/>", {speed: 500});
    </script>


  </body>
</html>
