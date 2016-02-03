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
<!--header start-->
      <header class="header black-bg">
        <div class="top-menu" align="right" id="user">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logo"><i class="fa fa-user"></i>
                     ${user}</a></li>
                    <li><a class="logout" href="${pageContext.request.contextPath}/login">Sair <i class="fa fa-sign-out"></i></a> </li>
            	</ul>
            </div> 
            <!--logo start-->   
            <div align="left">               
            <a class="top-menu" ><img src="<c:url value="/resource/images/logo-drug.png"/>" alt="" /></a>           
            <a class="logo"><b>PREVMED</b></a>                                                       
            </div> 
              
            <!--logo end-->   
            
                              
       </header>
      <!--header end-->
      <br>
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  
	  <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" action="${pageContext.request.contextPath}/setor-adminstrativo" method="post">
		        <h2 class="form-login-heading">SELECIONE UMA OPÇÃO</h2>
		        <div class="login-wrap">
		            <button class="btn btn-theme btn-lg btn-block" name=esc value=1><i class="fa fa-medkit"></i> MEDICAMENTOS</button>
		            <hr>
		            
		            <button class="btn btn-theme btn-lg btn-block" name=esc value=2><i class="fa fa-clipboard"></i> INTERAÇÕES</button>
		            <hr>
		            		        
		
		        </div>
		
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
