const movies = {
    "Movie 1": "images/posters/movies/a-paixao-segundo-gh-poster-desktop-5733c.png",
    "Movie 2": "images/posters/movies/a-primeira-profecia-poster-desktop-5641c.jpg",
    "Movie 3": "images/posters/movies/abigail-poster-desktop-5654c.jpg",
    "Movie 4": "images/posters/movies/aespa-world-tour-in-cinemas-poster-desktop-5754c.jpg",
    "Movie 5": "images/posters/movies/evidencias-do-amor-poster-desktop-5556c.jpg",
};

const series = {
    "Movie 1": "images/posters/series/arcane.png",
    "Movie 2": "images/posters/series/ripley.jpg",
    "Movie 3": "images/posters/series/invencivel.jpg",
    "Movie 4": "images/posters/series/oproblemados3corpos.jpg",
    "Movie 5": "images/posters/series/gameofthrones.jpg",
};

function addMoviesToHTML() {
    const movieListContainer= document.getElementById("movies-list");
    const entries = Object.entries(movies);

    entries.forEach(entry => {
        const [movieName, movieSrc] = entry;
        const movieElement = document.createElement("img");

        movieElement.src = movieSrc;
        movieElement.alt = movieName;
        movieElement.height = 300;
        movieElement.style.marginRight = "2rem"

        movieListContainer.appendChild(movieElement);
    });
}

function addSeriesToHTML() {
    const serieListContainer = document.getElementById("series-list");
    const entries = Object.entries(series);

    entries.forEach(entry => {
        const [serieName, serieSrc] = entry;
        const serieElement = document.createElement("img");

        serieElement.src = serieSrc;
        serieElement.alt = serieName;
        serieElement.height = 300;
        serieElement.style.marginRight = "2rem"

        serieListContainer.appendChild(serieElement);
    });
}

document.addEventListener('DOMContentLoaded', function() {
    addMoviesToHTML();
    addSeriesToHTML();
});

