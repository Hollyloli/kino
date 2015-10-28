<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>


<!--Edit Main Content Area here-->
<div class="row" id="divMain">

	<form class="form-signin" role="form" action="/PracaInz/login"
		method="POST">
		<h2 class="form-signin-heading">Logowanie</h2>
		<input type="text" name='username' class="form-control"
			placeholder="login" required autofocus> <input
			type="password" name='password' class="form-control"
			placeholder="hasło" required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
	</form>


</div>
<!--End Main Content-->
