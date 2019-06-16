let foundDeck;

loadDeck();

function loadDeck () {
    let id = sessionStorage.getItem('deckId');
    
    //Find Deck Name
    serverRequest("GET", "/decks/"+id, null).then((request) => {
        this.foundDeck = JSON.parse(request.responseText);
        console.log(this.foundDeck);
        document.getElementById("deckNameText").innerHTML = this.foundDeck[name];
        
        serverRequest("GET", "/deckscards/", null).then((secondRequest) => {
            let cardIdsInDeck = JSON.parse(secondRequest.responseText);
            console.log(cardIdsInDeck);

        })
    });
    
    //Find Each Card ID that matches that Deck Name
    //Put them in a list of card id's
    //Get each card where id matches something in that list

    }