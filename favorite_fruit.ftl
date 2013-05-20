<html>
	<head>
		<title>Favorite fruit</title>
	</head>
	<body>
		<h1>Choose your favorite fruit:</h1>
		<br>
		
		<form action="/favorite_fruit" method="POST">
			<#list fruits as fruit>
				<input type="radio" name="fruit" value="#{fruit}">#{fruit}</input>
			</#list>
			
			<input type="submit" value="Submit"/>
		</form>
	</body>
</html>