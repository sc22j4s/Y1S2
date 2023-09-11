// adds event listener for each row div
document.addEventListener('DOMContentLoaded', function() {
    
    // accesses row elements and assigns them to a list 
    const faqItems = document.querySelectorAll('.row');

    // iterate through each row element 
    faqItems.forEach(item => {
        // assigns subclass row elements 
        const question = item.querySelector('.question');
        const answer = item.querySelector('.answer');

        // allows for the question or answer to be clicked
        [question, answer].forEach(element => {
            // adds click event listener for each row
            element.addEventListener('click', () => {
                // to show answer text
                answer.classList.toggle('show');
            });
        });
    });
});
