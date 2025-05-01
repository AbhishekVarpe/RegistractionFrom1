<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="reg" method="post">
		Name:<input type="text" name="name1" placeholder="Enter the name" /><br/> <br/>
		Email:<input type="text" name="email1" placeholder="Enter the Email" /><br/><br/> 
		Password:<input type="password" name="pass1" placeholder="Enter the Password" /> <br/> <br/>
			gender: <label><input type="radio" name="gender1" value="male" > Male</input></label><br/>
    <label><input type="radio" name="gender1" value="female" > Female</input></label><br/><br/>
	 City:<select name="city1">
		<option value="maharashtra">Select city</option>
		<option value="Pune">Pune</option>
		<option value="mumbai">mumbai</option>
		<option value="Nagpur">Nagpur</option>
		<option value="Aurangabad">Aurangabad</option>
		</select><br/><br/>
		
		<input type="submit" value="Register" />




	</form>
</body>
</html>

