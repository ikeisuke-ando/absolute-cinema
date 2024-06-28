function redirectToReview() {
    const serieRevIdDiv = document.getElementById('serieRevId');
    const seriesId = serieRevIdDiv.querySelector('span').innerText;
    location.href = 'http://localhost:8080/review/' + seriesId;
}