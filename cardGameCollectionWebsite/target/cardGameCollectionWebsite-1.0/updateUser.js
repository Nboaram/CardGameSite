let user = {
    name: "default"
}

function updateUser() {
    let id = document.getElementById("idInput").value;

    setValues();
    let jsonUser = JSON.stringify(user);
    console.log(jsonUser);
    serverRequest("PUT","/users/" + id, jsonUser).then((request) => {
        console.log("Data Sent: " + request.responseText);
    })
}

function setValues() {
    if(document.getElementById("nameInput").value != ""){
        user.name = document.getElementById("nameInput").value;
    }
}