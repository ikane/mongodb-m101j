<html>
	<head>
		<title>Favorite fruit</title>
	</head>
	<body>
		<h1>Choose your favorite fruit:</h1>
		<br>
		
		<form action="/favorite_fruit" method="POST">
			<#list fruits as fruit>
				<p>
					<input type="radio" name="fruit" value="${fruit}">${fruit}</input>
				</p>
			</#list>
			
			<input type="submit" value="Submit"/>
		</form>
	</body>
</html>