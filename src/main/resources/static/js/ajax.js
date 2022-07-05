const domain = window.location.protocol+"//"+window.location.host;

function getRequest (urlString)  {
    // console.log("a get request to "+domain+urlString);
    return $.ajax({
        type: "GET",
        url: domain+urlString
    });

}

function postRequest (urlString, json){
    return $.ajax({
        type: "POST",
        url: domain+urlString,
        contentType:"application/json; charset=utf-8",
        data: JSON.stringify(json),
        dataType:"json",
        headers: {
            "Access-Control-Allow-Origin": `${domain}`
        }
    });
}

function postRequestMultiPart (urlString, formData){
    return $.ajax({
        type: "POST",
        url: domain+urlString,
        contentType: false,
        processData: false,
        cache: false,
        enctype: 'multipart/form-data',
        data: formData,
        headers: {
            "Access-Control-Allow-Origin": `${domain}`
        }
    });
}
