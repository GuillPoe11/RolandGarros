<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Roland Garros</title>
	<link href="bootstrap-3.3.7/dist/css/bootstrap.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
    <link href="css/styles_form.css" rel="stylesheet">

	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

	<link href='http://fonts.googleapis.com/css?family=Lato:100,400,700' rel='stylesheet' type='text/css'> 
</head>
<body>


		<nav id="mainNav" class="navbar navbar-custom navbar-fixed-top">
        <div class="container">
           
			<div id="logo"><img src="img/rg-logo-header.png" alt="logo"></div>
			<div id="headerLogo">
				<span id="title">Roland Garros</span>
				<p>06 juin 2017 - 18 juin 2017</p>
			</div>
			<div id="ariane">fil d'ariane</div>
			<div class="box">
				<div class="container-1">
				    <span class="icon"><i class="fa fa-search"></i></span>
				    <input type="search" id="search" placeholder="Search..." />
				</div>
			</div>
        </div>
        <!-- /.container-fluid -->

         <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-left">
                    <li>
                        <a class="lienNav" href="#">Home</a>
                    </li>
                    <li>
                        <a class="lienNav" href="#">Joueurs</a>
                    </li>
                    <li>
                        <a class="lienNav" href="#">Scores</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                	<li>
                        <a class="lienNav admin" href="#">Admin</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
    </nav>

    <!-- Form -->
    <div class="container_form">  
      <form id="contact" action="" method="post">
        <h3>Colorlib Contact Form</h3>
        <h4>Contact us for custom quote</h4>
        <fieldset>
          <input placeholder="Your name" type="text" tabindex="1" required autofocus>
        </fieldset>
        <fieldset>
          <input placeholder="Your Email Address" type="email" tabindex="2" required>
        </fieldset>
        <fieldset>
          <input placeholder="Your Phone Number (optional)" type="tel" tabindex="3" required>
        </fieldset>
        <fieldset>
          <input placeholder="Your Web Site (optional)" type="url" tabindex="4" required>
        </fieldset>
        <fieldset>
          <textarea placeholder="Type your message here...." tabindex="5" required></textarea>
        </fieldset>
        <fieldset>
          <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
        </fieldset>
      </form>
</div>
    <!--  @end Form -->

    <div class="clear" style="clear:both"></div>
     <footer>
        
            <div class="row">
                <div class="col-md-4">
                   
                </div>
                <div class="col-md-4">
                     <span class="copyright">Copyright &copy; Roland Garros 2017</span>
                </div>
                <div class="col-md-4">
                    
                </div>
            </div>
        
    </footer>




</body>
</html>