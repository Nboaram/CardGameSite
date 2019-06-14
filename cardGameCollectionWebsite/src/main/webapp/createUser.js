let user = {
    name: "default"
}

function createUser() {
    setValues();
    let jsonUser = JSON.stringify(user);
    console.log(jsonUser);
    serverRequest("POST", "/users", jsonUser).then((request) => {
        console.log("Data User: " + request.responseText);
         changePage('/cardGameCollectionWebsite-1.0/loginPage.html');
    })

}

function setValues() {
    if (document.getElementById("nameInput").value != "") {
        user.name =document.getElementById("nameInput").value;
    }
}