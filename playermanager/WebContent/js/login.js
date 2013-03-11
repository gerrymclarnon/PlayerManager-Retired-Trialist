window.username = '';
window.password = '';

function secureSignIn()
{
	window.username=document.getElementById('j_username').value;
	window.password=document.getElementById('j_password').value;
	 
	//document.location.href='home';
	app.navigate('home', true);

	return false;
}
