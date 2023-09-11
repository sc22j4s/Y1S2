let score = 0;
// quiz answers - accepts band name or song title
const answers = [
    // accounting for alternate song titles
    ["deftones", "be quiet and drive (far away)", "be quiet and drive"],
    ["my chemical romance", "i'm not okay (i promise)", "i'm not okay"],
    ["pierce the veil", "king for a day"],
    ["slipknot", "wait and bleed"],
    ["system of a down", "aerials"]
];

function checkAnswer(id) {
    // receives form element that user has entered into
    const inputElement = document.getElementById(`input${id}`);

    // remove whitespace and case sensitivity from input
    let input = document.getElementById(`input${id}`).value.trim().toLowerCase();

    // check if input exists in answer sublist
    if (answers[id - 1].includes(input)) {
        // correct guess
        
        // update score on webpage
        score++;
        updateScore();

        // disables button and input
        // can't reuse same question button for points
        document.getElementById(`submit${id}`).disabled = true;
        document.getElementById(`input${id}`).disabled = true;

        // set form color to green
        inputElement.style.backgroundColor = "lightgreen";
        
    } else {
        // incorrect guess
        // set form color to red
        inputElement.style.backgroundColor = "salmon"; // light red
    }
};

function updateScore() {
    
    // calls modifiable score element
    const scoreElement = document.getElementById("score");
    // assigns new score to site text within span tag
    scoreElement.textContent = score;

};

// event listeners for each button
for (let i = 1; i <= 5; i++) {
    document.getElementById(`submit${i}`).addEventListener('click', () => checkAnswer(i));
}
