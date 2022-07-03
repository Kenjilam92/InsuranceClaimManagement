$(document).ready( function(){
    /////////// get claim table
    getRequest("http://localhost:8080/api/v1/claims").done(e => addingMultipleClaimToTable(e) );       
    //////////////Form submited
    $(document).on('submit', '#claim-form', function(e) { claimFormSubmitted(e) });

    $(document).on('submit', '#formSubmitClaimDocument', function(e) { formSubmitDocSubmitted(e) });

    $(document).on('click', '.claimDetailsButton', function(e) { clickedDetailsButton(e) });
    // $("a .claimDetailsButton").click(e => {
    //     e.preventDefault();
    // })

    // $(document).on('click', 'a .deleteClaim', function(e) { console.log(e) });

});
    