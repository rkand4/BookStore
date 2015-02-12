<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./bootstrap/css/override.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

.searchbar {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="../assets/ico/favicon.png">
</head>

<body class="bodyCss">

	<div class="centered">
		<div class="row-fluid">

			<form id="loginForm" name="loginForm"
				action="${pageContext.request.contextPath}/j_spring_security_check"
				method="POST" class="form-horizontal form-signin">
				<c:if test="${not empty param.error}">
					<div class="alert alert-error">
						${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</div>
				</c:if>
				<fieldset>
					<div class="legendLogin">
							<h2>Book Store - Login</h2>
					</div>
					<div class="control-group">
						<label for="userName" class="control-label">Username</label>
						<div class="controls">
							<input type="text" class="form-control" id="userName"
								name="j_username" value="" placeholder="Enter User Name"
								required="" />
						</div>
					</div>
					<div class="control-group">
						<label for="password" class="control-label">Password</label>
						<div class="controls">
							<input type="password" class="form-control" id="password"
								name="j_password" value="" placeholder="Enter Password"
								required="" />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<label class="checkbox"> <input type="checkbox"
								value="remember-me" id="inlineCheckbox1" /> Remember me
							</label>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn btn-success btn-large">Login</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>

	<!-- /container -->
	<!--/.fluid-container-->

	<!-- Le javascript
    ================================================== -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.0/js/bootstrap.min.js">
		
	</script>
	<!--   <script src="bootstrap/js/bootstrap-alert.js">
	
	</script>
	<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap-modal.js"></script>
	<script src="bootstrap/js/bootstrap-dropdown.js"></script>
	<script src="bootstrap/js/bootstrap-scrollspy.js"></script>
	<script src="bootstrap/js/bootstrap-tab.js"></script>
	<script src="bootstrap/js/bootstrap-tooltip.js"></script>
	<script src="bootstrap/js/bootstrap-popover.js"></script>
	<script src="bootstrap/js/bootstrap-button.js"></script>
	<script src="bootstrap/assets/js/bootstrap-collapse.js"></script>
	<script src="bootstrap/assets/js/bootstrap-carousel.js"></script>
	<script src="bootstrap/assets/js/bootstrap-typeahead.js"></script>
	-->
</body>
</html>
