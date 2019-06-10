function fetchData(requestType, extension, dataToSend) {

    return new Promise((resolve, reject) => {
        const request = new XMLHttpRequest();

        request.onreadystatechange = () => {
            if (request.readyState === 4) {
                if (request.status === 200){
                    resolve(request);
                    console.log("request successful")
                } else {
                    reject("Failed");
                }
            }
        };
        request.open(requestType, "http://localhost:8080/api/cards" + extension);
        request.setRequestHeader("Content-Type", "application/json");
        request.send(dataToSend);
    })
}