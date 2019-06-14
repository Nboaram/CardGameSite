let information;
getAllDecksFromUser(sessionStorage.getItem('id'));

function getAllDecksFromUser(id) {
    serverRequest("GET", "/decks/users/" + id, null).then((request) => {
        this.information = JSON.parse(request.responseText);
        console.log(this.information);
        let tableRef = document.getElementById("deckTable");
        for (let deck in this.information) {
            let newRow = tableRef.insertRow(-1)
            for (let variable in this.information[deck]) {
                let newCell = newRow.insertCell(-1);
                let newText = document.createTextNode(this.information[deck][variable])
                newCell.appendChild(newText);
            }
            let newerCell = newRow.insertCell(-1);
            let button = document.createElement("button");
            button.innerHTML = "Deck Details";
            button.className = "btn btn-outline-info tableEntry";
            newerCell.appendChild(button);
            button.addEventListener("click" , function() {
            changePage('/cardGameCollectionWebsite-1.0/deckDetails.html')
            }); 
        }
    })
}