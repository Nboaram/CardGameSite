loadDeck();

function loadDeck () {
    let id = sessionStorage.getItem('deckId');
    getDeck(id);
    }