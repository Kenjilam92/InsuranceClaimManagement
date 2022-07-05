$(document).ready( function(){
    let currentSection = "#Home";
    showElement(currentSection);
    /////////// get claim table
    let claims = []

    getRequest("/api/v1/claims").done(e => { claims = e;
        addingMultipleClaimToTable(e)
    } );       
    //////////////Form submited
    
    $(document).on('submit', '#claim-form', function(e) { claimFormSubmitted(e).done( c => {
        addingRowClaimToTable(c);
        claims.push(c);
        console.log(claims);
        clearForm("#claim-form");
    } ) });

    $(document).on('submit', '#formSubmitClaimDocument', function(e) { 
        formSubmitDocSubmitted(e).done(doc => {
            getRequest(doc.claim).done( claim => {
                renderClaimDetails(claim)
                // addingMultipleDocToTable(claim.docs)
                getRequest("/api/v1/claims").done(c => {
                    addingMultipleClaimToTable(c)
                    claims = c;
                });
            });
        
        });
        
    });


    /////////Switching pages

    $(document).on('click', '.claimDetailsButton', function(e) { 
        clickedDetailsButton(e) 
        swithElement(currentSection,"#claim-detail").then(res => currentSection = res);
    });

    $(document).on('click', '#goBack', function(e) { 
        e.preventDefault();
        console.log("current section: " + currentSection)
        swithElement(currentSection,"#claimFormAndTable").then(res => currentSection = res)
        
    });
    $(document).on('click', '#instructionButton', function() { 
        currenSection = swithElement(currentSection,"#welcomeSite").then(res => currentSection = res)
    });
    $(document).on('click', '#instructionNewClams', function() { 
        currenSection = swithElement(currentSection,"#claimFormAndTable").then(res => currentSection = res)
    });
    $(document).on('click', '#homeButtonOnMenu', function() { 
        currenSection = swithElement(currentSection,"#Home").then(res => currentSection = res);
    });
    $(document).on('click', '#viewClaimsButtonOnMenu', function() { 
        currenSection = swithElement(currentSection,"#claimFormAndTable").then(res => currentSection = res)
    });

    ////////Sorting Claims Table

    $(document).on('click', '#claim-table th',function(e){
        // console.log(e.target.innerText);
        switch(e.target.innerText){
            case"Title": 
                addingMultipleClaimToTable(
                    sortingClaimByName(claims)
                );
                break;
            case"Created Date": 
                addingMultipleClaimToTable(
                    sortingClaimByCreatedDate(claims)
                );
                break;
            case"Updated Date": 
                addingMultipleClaimToTable(
                    sortingClaimByUpdateDate(claims)
                );
                break;
            case"Status": 
                addingMultipleClaimToTable(
                    sortingClaimByStatus(claims)
                );
                break;
        }
    });

    ///////Searching Claims
    $(document).on('submit', '#searchForm', function (e){
        e.preventDefault();
        const str = $("#searchForm").serializeArray()[0].value;
        // const str = $('#seachContent').val();
        filterClaims(claims,str).then(e => {
            console.log(e);
            addingMultipleClaimToTable(e)
            clearForm('#searchForm');
        });
        
    });
});
    