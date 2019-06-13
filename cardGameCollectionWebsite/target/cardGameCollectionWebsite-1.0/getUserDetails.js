let userId = sessionStorage.getItem('id');
console.log(userId);
getUser(userId);


function getUser(id) {
    serverRequest("GET", "/users/" + id, null).then((request) => {
        let information = JSON.parse(request.responseText);
        console.log(information);

        document.getElementById("usersName").innerText = information.name;
        document.getElementById("usersId").innerText = information.id;
    })
}