let foundDeck;

function getDeck(id) {

    serverRequest("GET", "/decks/"+id, null).then((request) => {
        this.foundDeck= JSON.parse(request.responseText);
        console.log(this.foundDeck);
        return foundDeck;
    });
}