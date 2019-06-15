let deck = {
    name: "default"
}

function updateDeck() {
    let id = sessionStorage.getItem('deckId');

    setValues();
    let jsonDeck = JSON.stringify(deck);
    console.log(jsonDeck);
    serverRequest("PUT","/decks/" + id, jsonDeck).then((request) => {
        console.log("Data Sent: " + request.responseText);
        changePage('/cardGameCollectionWebsite-1.0/deckDetails.html');
    })
}

function setValues() {
    if(document.getElementById("nameInput").value != ""){
        deck.name = document.getElementById("nameInput").value;
    }
}