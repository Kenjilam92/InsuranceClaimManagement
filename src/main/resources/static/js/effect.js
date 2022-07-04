async function swithElement(currentSection, elementName){
    hideElement(currentSection)
    showElement(elementName);
    return elementName;
}

// function showClaimDetail(){
//     hideElement("#claimFormAndTable");
//     showElement("#claim-detail");
//     // hideAndThenShow("#claimFormAndTable","#claim-detail",500);
// }

// function showClaimFormAndTable(){
//     const a = showElement("#claimFormAndTable");
//     hideElement2("#claim-detail",a);
//     // hideAndThenShow("#claim-detail","#claimFormAndTable",500);
// }


function toggleHidden(name){
    $(`${name}`).toggleClass("hidden");
}

function toggleFadeInAndOut(name){
    $(`${name}`).toggleClass("m-fadeIn");
    $(`${name}`).toggleClass("m-fadeOut");
    console.log("toggled "+name);
}

function hideElement (elementName) {
    toggleFadeInAndOut(elementName);
    setTimeout(toggleHidden(elementName),600);
}


function showElement (elementName) {
    toggleHidden(elementName);
    setTimeout(toggleFadeInAndOut(elementName),500);
}


function removeClass (elementName,className){
    const e = $(elementName);
    if (e.hasClass(className)) 
        e.removeClass(className);
}
function addClass (elementName,className){
    const e = $(elementName);
    if (!e.hasClass(className)) 
        e.addClass(className);
}