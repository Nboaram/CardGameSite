let id;

function deleteCard() {
    id = document.getElementById("idInput").value;
    let cardId = JSON.stringify(id);
    serverRequest("DELETE", "/cards/" + id, cardId).then((request) =>{
            console.log("Id:" + request.responseText);
        })
}

