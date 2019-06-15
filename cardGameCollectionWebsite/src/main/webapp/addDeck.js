let deck = {
    name : "default"
}

function addDeck() {
    setValues();
    let id = sessionStorage.getItem('id');
    let jsonDeck = JSON.stringify(deck);
    console.log(jsonDeck);
    serverRequest("PUT", "/users/decks/add/" + id, jsonDeck).then((request) =>{
            console.log("Added Deck to User");
    })
}

function setValues() {
    if(document.getElementById("nameInput").value != "") {
        deck.name = document.getElementById("nameInput").value;
    }
}