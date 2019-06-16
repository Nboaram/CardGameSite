let deckCard = {
    cardID : 0,
    deckID : 0
}

function addCardToDeck(cardID, deckID) {

    deckCard.cardID = cardID;
    deckCard.deckID = deckID;
    let jsonDeckCard = JSON.stringify(deckCard);

    // serverRequest("PUT", "/cardsdecks/"+ cardID, jsonDeckCard).then((request) => {
    //         console.log("Also Done");
    //         console.log(request.requestText);
    // })
    serverRequest("PUT", "/decks/cards/add/"+ deckID+"/"+cardID, jsonDeckCard).then((request) => {
            console.log("Done");
    })


}
