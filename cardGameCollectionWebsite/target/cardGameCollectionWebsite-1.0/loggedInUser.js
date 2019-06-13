if (sessionStorage.getItem('username') != "" || sessionStorage.getItem('username') != null) {
    console.log("User Found");
    document.getElementById("userNameText").innerHTML = sessionStorage.getItem('username');
} else {
    console.log("no user logged in");
    document.getElementById("userNameText").innerHTML = "";
}