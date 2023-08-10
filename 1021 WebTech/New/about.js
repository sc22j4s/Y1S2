// 
document.addEventListener('DOMContentLoaded', function() {
    const faqItems = document.querySelectorAll('.row');

    faqItems.forEach(item => {
        const question = item.querySelector('.question');
        const answer = item.querySelector('.answer');

        [question, answer].forEach(element => {
            element.addEventListener('click', () => {
                answer.classList.toggle('show');
            });
        });
    });
});
