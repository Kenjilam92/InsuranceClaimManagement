

function getRequest (urlString)  {
    console.log("a get request to "+urlString);
    return $.ajax({
        type: "GET",
        url: urlString
    });

}

function postRequest (urlString, json){
    return $.ajax({
        type: "POST",
        url: urlString,
        contentType:"application/json; charset=utf-8",
        data: JSON.stringify(json),
        dataType:"json",
        headers: {
            "Access-Control-Allow-Origin": "http://localhost:8080"
        }
    });
}

function postRequestMultiPart (urlString, formData){
    return $.ajax({
        type: "POST",
        url: urlString,
        contentType: false,
        processData: false,
        cache: false,
        enctype: 'multipart/form-data',
        data: formData,
        headers: {
            "Access-Control-Allow-Origin": "http://localhost:8080"
        }
    });
}
