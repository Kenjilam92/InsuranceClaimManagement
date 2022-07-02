
        const domain = "http://localhost:8080";

        function getRequest (urlString)  {
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

        function claimFormSubmitted (event){
            event.preventDefault()
            const form = $("#claim-form").serializeArray();
            let newClaim = {};
            $.each(form, function () {
                newClaim[this.name] = this.value || "";
            });
            postRequest("/api/v1/claim",newClaim)
                .done(e => addingRowClaimToTable(e));
        }

        function addingRowClaimToTable ( c ){
            $('#claim-table tbody').append(
                `<tr id="ClaimRow${c.id}">
                    <td>
                        <img src="./img/folder_icon.png" alt="" style="width: 2rem">
                    </td>
                    <td value="${c.title}">
                        <p>${c.title}</p>
                    </td>
                    
                    <td>
                        <p>${c.createdDate}</p>
                    </td>
                    <td>
                        <p>${c.updateDate}</p>
                    </td>
                    <td>
                        <p>${c.status}</p>
                    </td>
                    <td>
                        <nav>
                            <button class="btn btn-info" onclick="clickedDetailsButton(this)" value="${c.url}">Detail</button>
                        </nav>
                    </td>
                </tr>`
            );
        }

        function formSubmitDocSubmitted( event ){
            event.preventDefault();
            const form = $("#formSubmitClaimDocument").serializeArray();
            const api = domain+"/api/v1/claim/document";
            let fdata = new FormData();
            let files = $ ('#fileDoc' )[0].files[0]; 
            $.each(form, function () {
                let value = this.name==="ClaimId"? parseInt(this.value) : this.value;
                fdata.append(this.name,value);
            });
            fdata.append('file', files);
            fdata
            postRequestMultiPart(api,fdata).done(e => addingRowDoctoTable(e));
            // .fail( e => console.log(e))
        }

        function clickedDetailsButton( btnDetails ){
            removeClaimDetails();
            const url = domain + btnDetails.value;
            getRequest(url).done( a => renderClaimDetails(a))
               
            ;
        }
        
        function addingRowDoctoTable (doc) {
            $('#doc-table tbody').append(
                `<tr id="ClaimRow${doc.id}">
                    <td>
                        <img src="./img/folder_icon.png" alt="" style="width: 2rem">
                    </td>
                    <td value="${doc.name}">
                        <p>${doc.name}</p>
                    </td>
                    
                    <td>
                        <p>${doc.size}</p>
                    </td>
                    <td>
                        <nav>
                            <a class="btn btn-primary" onclick="clickedDetailsButton(this)" href="${domain+doc.url}">Download</a>
                        </nav>
                    </td>
                </tr>`
            );
        }

        function renderClaimDetails ( json ){
            $('#claim-detail').append(`
                <h2>
                    <img src="./img/folder_icon.png" alt="" style="width: 2rem">
                    This will be place the title
                </h2>
                <div class="row">
                    <div class="col">
                        <p>status:${json.title}</p>
                        <p>size: _________________</p>
                        <form id="formSubmitClaimDocument" enctype="multipart/form-data">
                            <label for="file">Upload Document:</label>
                            <input id="fileDoc" type="file" name="file">
                            <input hidden name="ClaimId" value=${json.id}>
                            <button class="btn btn-success" type="submit">Upload</button>
                        </form>
                    </div>
                    <div class="col">
                        <p>Description:</p>
                        <p>this is the description location</p>
                    </div>
                </div>
                <div class="row pt-3">
                    <table id="doc-table" class="table">
                        <thead>
                            <tr>
                                <th>icon</th>
                                <th>name</th>
                                <th>size</th>
                                <th>action</th>
                            </tr>    
                        </thead>
                        <tbody id="claim-files">
                            
                        </tbody>
                    </table>
                </div>
            `);
            const docs = json.docs;
            if (docs.length !== 0) return addingMultipleDocToTable(docs);
        }

        function addingMultipleDocToTable( docs ){
            docs.map( doc => addingRowDoctoTable(doc));
        }

        function removeClaimDetails (){
            $('#claim-detail').empty();
        }

        const clickedDeleteClaim = e => {
            const row = $(`#ClaimRow${e.value}`);
            // console.log(row);
        }

        $(document).ready( function(){
            /////////// get claim table
            getRequest("/api/v1/claims").done(e => e.map( c => addingRowClaimToTable (c)) );       
            //////////////Form submited
            $(document).on('submit', '#claim-form', function(e) { claimFormSubmitted(e) });

            $(document).on('submit', '#formSubmitClaimDocument', function(e) { formSubmitDocSubmitted(e) });

            $(document).on('click', '.deleteClaim', function(e) { console.log(e) });

        });
    