let information;

function getAllUsers() {
    serverRequest("GET", "/users", null).then((request) => {
        this.information = JSON.parse(request.responseText);
        console.log(this.information);
        login();
    });
}

function login() {
    let enteredName = document.getElementById("nameInput").value;
    console.log(this.information)
    for (let user in this.information) {
        console.log(user);
        for (let variable in this.information[user]) {
            console.log(variable);
            if (variable === "name") {
                if (enteredName === this.information[user][variable]) {
                    console.log("User Found: " + enteredName);
                    sessionStorage.setItem('loggedIn', 'true');
                    sessionStorage.setItem('username', enteredName);
                    changePage("/cardGameCollectionWebsite-1.0/");
                }
            }
        }
    }
}