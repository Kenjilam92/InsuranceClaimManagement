$(document).ready( function(){
    let currentSection = "#claimFormAndTable";
    showElement(currentSection);
    /////////// get claim table
    getRequest("/api/v1/claims").done(e => addingMultipleClaimToTable(e) );       
    //////////////Form submited
    $(document).on('submit', '#claim-form', function(e) { claimFormSubmitted(e) });

    $(document).on('submit', '#formSubmitClaimDocument', function(e) { formSubmitDocSubmitted(e) });

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

});
    