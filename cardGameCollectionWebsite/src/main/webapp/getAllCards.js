function getAllCards() {
    serverRequest("GET", "/cards", null).then((request) => {
        let information = JSON.parse(request.responseText);
        console.log(information);
        for (let c in information) {
            for(let property in information[c]) {
                    if (property != "id" && property != "pictureUrl") {
                    document.getElementById(c+"."+property).innerHTML = information[c][property];
                    }
            }
        }
    });

}