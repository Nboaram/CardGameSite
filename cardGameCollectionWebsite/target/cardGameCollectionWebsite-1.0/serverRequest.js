function serverRequest(requestType, extension, dataToSend) {

    return new Promise((resolve, reject) => {
        console.log(requestType);
        console.log(extension);
        console.log(dataToSend);
        const request = new XMLHttpRequest();
        console.log("http://"+window.location.host+"/cardGameCollectionWebsite-1.0/api" + extension);
        request.open(requestType, "http://"+window.location.host+"/cardGameCollectionWebsite-1.0/api" + extension);
        request.setRequestHeader("Content-Type", "application/json");
        request.onreadystatechange = () => {
            if (request.readyState === 4) {
                if (request.status >= 200 && request.status <300){
                    resolve(request);
                    console.log("request successful")
                } else {
                    console.log(request.status);
                    reject("Failed");
                }
            }
        };
        request.send(dataToSend);
    })
}