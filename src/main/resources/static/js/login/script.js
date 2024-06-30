async function login(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const rememberMe = document.getElementById('rememberMe').checked;

    try {
        const response = await fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, password, rememberMe }),
        });

        if (!response.ok) {
            throw new Error('Failed to login');
        }

        const data = await response.json();
        console.log('Login successful:', data);

        localStorage.setItem('jwtToken', data.token);

        window.location.href = '/';

    } catch (error) {
        console.error('Error logging in:', error);
        const errorMessageElement = document.getElementById('error');
        errorMessageElement.innerText = 'Erro ao fazer login. Verifique suas credenciais e tente novamente.';
        errorMessageElement.style.display = 'block';
    }
}

document.addEventListener('DOMContentLoaded', function () {
    const logoutButton = document.getElementById('logoutButton');
    if (logoutButton) {
        logoutButton.addEventListener('click', function (event) {
            event.preventDefault();
            handleLogout();
        });
    }
    setupUserWelcomeMessage();
});

async function handleLogout() {
    try {
        localStorage.removeItem('jwtToken');

        window.location.href = '/';

    } catch (error) {
        console.error('Failed to logout:', error);
    }
}

async function setupUserWelcomeMessage() {
    const token = localStorage.getItem('jwtToken');
    if (token) {
        try {
            const response = await fetch('/api/user/profile', {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });

            if (response.ok) {
                const user = await response.json();
                document.getElementById('welcome-message').innerText = `Bem-vindo, ${user.username}`;
                document.getElementById('login-menu').style.display = 'none';
                document.getElementById('logout-menu').style.display = 'block';
            } else {
                throw new Error('Failed to fetch user data');
            }
        } catch (error) {
            console.error('Error fetching user data:', error);
        }
    }
}
