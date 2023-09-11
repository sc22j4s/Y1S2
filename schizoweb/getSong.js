function embedSpotify() {
    const link = document.getElementById('spotifyLink').value;
    const match = link.match(/track\/([a-zA-Z0-9]+)/);
    if (match) {
        const trackId = match[1];
        const iframe = `
            <iframe src="https://open.spotify.com/embed/track/${trackId}" width="300" height="380" frameborder="0" allowtransparency="true" allow="encrypted-media"></iframe>
        `;
        document.getElementById('spotifyPlayer').innerHTML = iframe;
    } else {
        alert("Invalid Spotify track link!");
    }
}
