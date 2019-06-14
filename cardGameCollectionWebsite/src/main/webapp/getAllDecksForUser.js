let information;

function getAllDecksFromUser(id) {
    serverRequest("GET", "/decks/users/" + id, null).then((request) => {
        this.information = JSON.parse(request.responseText);
        console.log(this.information);

        
        
    })
}