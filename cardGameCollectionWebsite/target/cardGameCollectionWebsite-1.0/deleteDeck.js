let locatedDeck;

function deleteDeck() {
    let id = sessionStorage.getItem('deckId');
        let jsonID = JSON.stringify(id);
        console.log("ID To Send: " + jsonID);
        serverRequest("DELETE", "/decks/" + id, jsonID).then(() => {
            changePage('/cardGameCollectionWebsite-1.0/userDecks.html');
        });
}