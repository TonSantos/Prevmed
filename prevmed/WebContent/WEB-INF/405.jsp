<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PREVMED | Interações Medicamentosas</title>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
<script src="<c:url value="/resource/js/chart-master/Chart.js"/>"></script>	
<!-- Bootstrap core CSS -->
    <link href="<c:url value="/resource/css/bootstrap.css" />" rel="stylesheet">
    
    <!--external css-->
    <link href="<c:url value="/resource/font-awesome/css/font-awesome.css"/>" rel="stylesheet" />
    <link href="<c:url value="/resource/css/zabuto_calendar.css"/>" rel="stylesheet" type="text/css" >
    <link href="<c:url value="/resource/js/gritter/css/jquery.gritter.css"/>" rel="stylesheet" type="text/css"  />
	<link href="<c:url value="/resource/css/style.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resource/lineicons/style.css"/>"  rel="stylesheet" type="text/css" >
	<!--webfonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
<link href="assets/css/style-responsive.css" rel="stylesheet">
</head>
<body>
	<!--main content start-->
	<!--header start-->
      <header class="header black-bg">
            <!--logo start-->   
            <div align="left">               
            <a class="top-menu" ><img src="<c:url value="/resource/images/logo-drug.png"/>" alt="" /></a>           
            <a class="logo" href="${pageContext.request.contextPath}/"><b>PREVMED</b></a>                                              
            </div> 
              
            <!--logo end-->              
       </header>
      <!--header end-->
         <br><br>
         <div align="center" class="container">
        <img src="<c:url value="/resource/images/drugs405.png"/>" alt="" />       
         </div>
         
      <!--header end-->       
	<!-- <script src="<c:url value="/resource/js/chart-master/Chart.js"/>"></script>	 -->
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="<c:url value="/resource/js/jquery.js"/>"></script>
    <script src="<c:url value="/resource/js/jjquery-1.8.3.min.js"/>"></script>
    <script src="<c:url value="/resource/js/bootstrap.min.js"/>"></script>
    <script class="include" type="text/javascript" src="<c:url value="/resource/js/jquery.dcjqaccordion.2.7.js"/>"></script>
    <script src="<c:url value="/resource/js/jquery.scrollTo.min.js"/>"></script>
    <script src="<c:url value="/resource/js/jquery.nicescroll.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resource/js/controler.js" />" charset="UTF-8"></script>
	 
		
  
    
</body>
</html>