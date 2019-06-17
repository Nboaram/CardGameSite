    let card = {
        name: "Peasant",
        pictureUrl: "blank",
        cost: 1,
        type: "Commoner",
        cardText: "He works in the fields",
        damage: 1,
        health: 1
    }

function updateCard() {
        let id = document.getElementById("idInput").value;
        
        setValues();
        let jsonCard = JSON.stringify(card);
        console.log(jsonCard);
        serverRequest("PUT","/cards/" + id, jsonCard).then((request) =>{
            console.log("Data Sent:" + request.responseText);
        })
}

function setValues() {
    if(document.getElementById("nameInput").value != ""){
        card.name = document.getElementById("nameInput").value;
    }
        if(document.getElementById("costInput").value != ""){
        card.cost = document.getElementById("costInput").value;
    }
        if(document.getElementById("typeInput").value != ""){
        card.type = document.getElementById("typeInput").value;
    }
        if(document.getElementById("cardTextInput").value != ""){
        card.cardText = document.getElementById("cardTextInput").value;
    }
        if(document.getElementById("damageInput").value != ""){
        card.damage = document.getElementById("damageInput").value;
    }
        if(document.getElementById("healthInput").value != ""){
        card.health = document.getElementById("healthInput").value;
    }
        if(document.getElementById("pictureInput").value != ""){
        card.pictureUrl = document.getElementById("pictureInput").value;
    }
}