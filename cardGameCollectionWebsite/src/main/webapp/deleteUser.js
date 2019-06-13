let deleteId = sessionStorage.getItem('id');

function deleteUser() {
    console.log("Id: " + deleteId);
    let userId = JSON.stringify(deleteId);
    serverRequest("DELETE", "/users/" + deleteId, userId);
}