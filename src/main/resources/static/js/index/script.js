import()
importScripts(<script src="/static/js/register/script.js"></script>)
// modo noturno
document.addEventListener('DOMContentLoaded', function() {
    const toggleButton = document.getElementById('toggle-mode-link');

    toggleButton.addEventListener('click', function(event) {
        event.preventDefault(); // Evitar o comportamento padrão do link

        const body = document.body;

        // Alternar a classe dark-mode
        body.classList.toggle('dark-mode');
    });
});

var usLogged = loggedIn;

// autenticar usuario

function statusChangeCallback(response, usLogged) {
    if (usLogged){
        console.log("teste");
    }
    if (response.status === 'connected') {
        setElements(true);
        console.log('Logged in');
        instaInfo();
    } else {
        setElements(false);
        console.log('not logged in');
    }
}

function checkLoginState() {
    FB.getLoginStatus(function(response) {
        statusChangeCallback(response);
    });
}

function setElements(isLoggedIn) {
    if (isLoggedIn) {
        document.querySelector('#fb-btn').style.display = 'none';
        document.querySelector('.logout').style.display = 'block';
        document.querySelector('.navigation').style.display = 'block';
        document.querySelector('.nav-main').style.visibility = 'visible';
        document.querySelector('#container').style.display = 'block';
    } else {
        document.querySelector('#fb-btn').style.display = 'block';
        document.querySelector('.logout').style.display = 'none';
        document.querySelector('.navigation').style.display = 'none';
        document.querySelector('.nav-main').style.visibility = 'hidden';
        document.querySelector('#container').style.display = 'none';
    }
}

document.querySelector('.logout').addEventListener('click', () => {
    FB.logout(function() {
        setElements(false);
        console.log('Logged Out!');
    });
});