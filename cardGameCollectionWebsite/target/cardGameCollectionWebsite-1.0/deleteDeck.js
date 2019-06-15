let locatedDeck;

// function deleteDeck() {
//     let id = sessionStorage.getItem('deckId');
//     serverRequest("GET", "/decks/" + id, null).then((request) => {
//         this.locatedDeck = JSON.parse(request.responseText);
//         console.log("Found Deck: " +this.locatedDeck);
//         let jsonDeck = JSON.stringify(this.locatedDeck);
//         console.log("Deck To Send: " +jsonDeck);
//         serverRequest("PUT", "/users/decks/remove/" + id, jsonDeck).then(() => {
//             changePage('/cardGameCollectionWebsite-1.0/userDecks.html');
//         });
//     })
// } 

function deleteDeck() {
    let id = sessionStorage.getItem('deckId');
        let jsonID = JSON.stringify(id);
        console.log("ID To Send: " + jsonID);
        serverRequest("DELETE", "/decks/" + id, jsonID).then(() => {
            changePage('/cardGameCollectionWebsite-1.0/userDecks.html');
        });
}