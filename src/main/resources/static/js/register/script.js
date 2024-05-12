var loggedIn = false;

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('register-form').addEventListener('submit', function(event) {
        var fields = [
            'name',
            'login',
            'email',
            'password',
            'confirm-password',
        ];

        var formIsValid = true;
        var errorElement = document.getElementById('form-error');

        fields.forEach(function(field) {
            var value = document.getElementById(field).value.trim();

            if (!value) {
                event.preventDefault();
                formIsValid = false;
                errorElement.classList.remove('d-none');
                document.getElementById(field).classList.add('is-invalid');
            } else {
                errorElement.classList.add('d-none');
                document.getElementById(field).classList.remove('is-invalid');
            }
        });

        if (!formIsValid) {
            var generalErrorElement = document.getElementById('form-error');
            generalErrorElement.classList.remove('d-none');
        }

        if (formIsValid) {
            loggedIn = true;
        }

    });
});

function validateEmail(email) {
    var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('register-form').addEventListener('submit', function(event) {
        var email = document.getElementById('email').value;
        var emailError = document.getElementById('email-error');

        if (!validateEmail(email)) {
            event.preventDefault();
            emailError.classList.remove('d-none');
        }
    });
});

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('register-form').addEventListener('submit', function(event) {
        var password = document.getElementById('password').value;
        var confirmPassword = document.getElementById('confirm-password').value;
        var passwordError = document.getElementById('password-error');

        if (password !== confirmPassword) {
            event.preventDefault();
            passwordError.classList.remove('d-none');
        }
    });
});

