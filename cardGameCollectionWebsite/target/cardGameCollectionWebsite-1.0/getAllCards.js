function getAllCards() {
    fetchData("GET", "/cards", null).then((request) => {
        let information = JSON.parse(request.responseText);
        console.log(information);
        for (let c in information) {
            console.log("Class =" + c);
            for(let property in information[c]) {
                console.log("Property= " + property);
                    console.log(c+"."+property);
                    if (property != "id" && property != "pictureUrl") {
                        console.log(property + " set.")
                    document.getElementById(c+"."+property).innerHTML = information[c][property];
                    }
            }
        }
    });

}