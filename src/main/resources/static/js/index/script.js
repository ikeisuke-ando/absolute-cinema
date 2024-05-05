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