document.addEventListener("DOMContentLoaded", function() {
    var loginForm = document.getElementById("login-form");

    loginForm.addEventListener("submit", function(event) {
        alert("Login enviado!");
    });
});
