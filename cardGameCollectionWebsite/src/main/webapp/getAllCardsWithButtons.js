

getAllCards();


function getAllCards() {
    serverRequest("GET", "/cards", null).then((request) => {
        let information = JSON.parse(request.responseText);
        console.log(information);
        
       
        let collectionRef = document.getElementById("cardCollection");
        rowRef = document.createElement("div");
        rowRef.className="row";
        collectionRef.appendChild(rowRef);
        let counter = 0;
        for (let card in information) { 
            let startDiv = document.createElement("div");
            startDiv.className = "col-1";
            rowRef.appendChild(startDiv);
               
            let cardDiv = document.createElement("div");
            cardDiv.className = "col-3 bg-dark";
            rowRef.appendChild(cardDiv);
            let cardTable = document.createElement("table");
            cardTable.className="text-light cardTable"
            cardDiv.appendChild(cardTable);
            let newRow = cardTable.insertRow(-1);
            let newCell = newRow.insertCell(-1);
            newCell.id = card+".cost";
            newCell.align="center";
            newCell = newRow.insertCell(-1);
            newCell = newRow.insertCell(-1);
            newCell = newRow.insertCell(-1);
            newCell.id = card+".name";
            newCell.align="center";
            newCell = newRow.insertCell(-1);
            //New Row
            for (i = 0; i < 5; i++){
                //Blank Row
                newRow = cardTable.insertRow(-1); 
                newCell = newRow.insertCell(-1);
                newCell.colSpan="5";
                let newParagraph = document.createElement("p");
                newParagraph.innerHTML = "<br/>";
                newCell.appendChild(newParagraph); 
            }
            //New Row
            newRow = cardTable.insertRow(-1);
            newCell = newRow.insertCell(-1);
            newCell = newRow.insertCell(-1);
            newCell = newRow.insertCell(-1);
            newCell = newRow.insertCell(-1);  
            newCell.id = card+".type";
            newCell.align="center";
            newCell = newRow.insertCell(-1); 
            //New Row
            newRow = cardTable.insertRow(-1);
            newCell = newRow.insertCell(-1);
            newCell.colSpan="5";
            newCell.id = card+".cardText";
            newCell.align="center";
            //New Row
            newRow = cardTable.insertRow(-1);
            newCell = newRow.insertCell(-1); 
            newCell.id = card+".damage";
            newCell.align="center";
            newCell = newRow.insertCell(-1);
            newCell = newRow.insertCell(-1);
            newCell = newRow.insertCell(-1);
            newCell = newRow.insertCell(-1); 
            newCell.id = card+".health";
            newCell.align="center";
            //New Row 
            newRow = cardTable.insertRow(-1);
            newCell = newRow.insertCell(-1);
            newCell.colSpan="5";
            newCell.align="center";
            newButton = document.createElement("button");
            newButton.className="btn btn-outline-info";
            newButton.innerHTML = "Add To Deck";
            newCell.appendChild(newButton);

            newButton.addEventListener("click", function() {
                sessionStorage.setItem('cardSent', sessionStorage.getItem(card+'.id'))
                addCardToDeck(sessionStorage.getItem('cardSent'), sessionStorage.getItem('cardId'));
            })

            for(let property in information[card]) {
                    if (property != "id" && property != "pictureUrl") {
                    document.getElementById(card+"."+property).innerHTML = information[card][property];
                    }
                    if (property == "id") {
                        sessionStorage.setItem(card+'.id', information[card][property]);
                    }
            }
            counter = counter+1;
            if (counter == 3)   {
                //New Row with a Space
                let spareRow = document.createElement("div");
                spareRow.className="row";
                newParagraph = document.createElement("p");
                newParagraph.innerHTML = "<br/>";
                spareRow.appendChild(newParagraph); 
                collectionRef.appendChild(spareRow);
                //New Row 
                
                rowRef = document.createElement("div");
                rowRef.className="row";
                collectionRef.appendChild(rowRef);
                counter = 0;
            }          
        }
    });

}