function getAllCards() {
    fetchData("GET", "", null).then((request) => {
        console.log(request.responseText);
    });

}