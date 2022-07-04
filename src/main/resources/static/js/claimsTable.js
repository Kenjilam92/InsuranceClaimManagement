// const domain = window.location.host;

function claimFormSubmitted (event){
    event.preventDefault()
    const form = $("#claim-form").serializeArray();
    let newClaim = {};
    $.each(form, function () {
        newClaim[this.name] = this.value || "";
    });
    postRequest("/api/v1/claim",newClaim)
        .done(e => {addingRowClaimToTable(e)
            clearForm("#claim-form");
        });
}

function addingMultipleClaimToTable (claims){
    $('#claim-table tbody').empty();
    claims.map(c => addingRowClaimToTable(c));
}

function addingRowClaimToTable ( c ){
    $('#claim-table tbody').append(
        `<tr id="ClaimRow${c.id}">
            <td>
                <img class="ml-2" 
                    src="./img/folder_icon.png" 
                    alt="folder_icon" 
                    style="width: 2rem"
                >
            </td>
            <td value="${c.title}">
                <a  class="claimDetailsButton"
                    value="${c.url}"
                    href=""
                > ${c.title}</a>
            </td>
            <td>
                <p>${c.status}</p>
            </td>
            <td>
                <p>${c.createdDate}</p>
            </td>
            <td>
                <p>${c.updateDate}</p>
            </td>
        </tr>`
    );
}

function addingMultipleDocToTable( docs ){
    $('#doc-table tbody').empty();
    docs.map( doc => addingRowDoctoTable(doc));
}

function addingRowDoctoTable (doc) {
    $('#doc-table tbody').append(
        `<tr id="ClaimRow${doc.id}">
            <td>
                <img 
                    class="doc-icon"
                    src="./img/document_icon.png" 
                    alt="document_icon" 
                >
            </td>
            <td value="${doc.name}">
                ${doc.name}                
            </td>
            
            <td>
                <p>${byteConverter(doc.size)}</p>
            </td>
            <td>
                <p>${doc.createdDate}</p>
            </td>
            <td>
                <nav>
                    <a class="btn btn-primary m-1 p-1"  href="${doc.url}">Download</a>
                </nav>
            </td>
        </tr>`
    );
}

function formSubmitDocSubmitted( event ){
    event.preventDefault();
    const form = $("#formSubmitClaimDocument").serializeArray();
    const api = "/api/v1/claim/document";
    let fdata = new FormData();
    let files = $ ('#fileDoc' )[0].files[0]; 
    $.each(form, function () {
        let value = this.name==="ClaimId"? parseInt(this.value) : this.value;
        fdata.append(this.name,value);
    });
    fdata.append('file', files);
    fdata
    postRequestMultiPart(api,fdata).done(doc => {
        getRequest(doc.claim).done( claim => 
            renderClaimDetails(claim)
            // addingMultipleDocToTable(claim.docs)
        );
        getRequest("/api/v1/claims")
            .done(e => addingMultipleClaimToTable(e) );
    });
        
    // .fail( e => console.log(e))
}

function clickedDetailsButton( e ){
    e.preventDefault();
    const url = $(e.target).attr("value");
    getRequest(url).done( a => renderClaimDetails(a))
    ;
}


function renderClaimDetails ( json ){

    $('#fileDoc').val('');

    $('#claim-title-detail').empty().append(`
        <img src="./img/folder_icon.png" alt="" style="width: 2rem">
        ${json.title}
    `);

    $('#claim-status').empty().append(`
        ${json.status}
    `)
    .addClass(json.status==="Submitted"?["bg-success"]:null)
    .removeClass(json.status==="Submitted"?["bg-warning","text-dark"]:null) ;

    $('#claim-description').empty().append(`
        ${json.description}
    `);

    $('#claim-id').attr("value",json.id);

    const docs = json.docs;
    if (docs.length !== 0) return addingMultipleDocToTable(docs)
    else $('#doc-table tbody').empty().append(
        `<tr> <td class="text-center" colspan = 4> No Document to show </td> </tr>`
    );
}

function clearForm (text){
    $(':input',text)
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .prop('checked', false)
        .prop('selected', false);
}



// function removeClaimDetails (){
//     $('#claim-detail').empty();
// }

// const clickedDeleteClaim = e => {
//     const row = $(`#ClaimRow${e.value}`);
//     // console.log(row);
// }
