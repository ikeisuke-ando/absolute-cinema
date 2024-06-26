async function loadTopSeries() {
    try {
        const response = await fetch('/api/series/listByRating');
        if (!response.ok) {
            throw new Error('Erro ao carregar séries');
        }
        const seriesList = await response.json();
        const seriesListElement = document.getElementById('series-list');

        seriesListElement.innerHTML = '';

        seriesList.forEach(series => {
            const seriesElement = document.createElement('div');
            seriesElement.classList.add('serie-item');
            seriesElement.innerHTML = `
                 <a href="/series/${series.id}" class="serie-link">
                    <h3>${series.title}</h3>
                </a>
            `;
            seriesListElement.appendChild(seriesElement);
        });
    } catch (error) {
        console.error('Erro ao carregar séries:', error);
    }
}

window.onload = loadTopSeries;