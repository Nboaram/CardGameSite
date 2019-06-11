function fetchData(requestType, extension, dataToSend) {

    return new Promise((resolve, reject) => {
        const request = new XMLHttpRequest();

        request.onreadystatechange = () => {
            if (request.readyState === 4) {
                    console.log("I was done");
                if (request.status >= 200 && request.status <300){
                    resolve(request);
                    console.log("request successful")
                } else {
                    console.log(request.status);
                    reject("Failed");
                }
            }
        };
        request.open(requestType, "http://localhost:8080/cardGameCollectionWebsite-1.0/api" + extension);
        request.send(dataToSend);
    })
}