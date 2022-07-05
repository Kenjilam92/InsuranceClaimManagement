function sortingClaimByName(claims){
    return claims.sort( (a,b)=> {
        const nameA= a.title.toUpperCase();
        const nameB= b.title.toUpperCase()

        if(nameA < nameB)
            return -1;
        else if(nameA > nameB)
            return 1;
        else 
            return 0;

    })
}

function sortingClaimByCreatedDate(claims){
    return claims.sort( (a,b)=> {
        const valueA= Date.parse(a.createdDate);
        const valueB= Date.parse(b.createdDate)

        if(valueA < valueB)
            return -1;
        else if(valueA > valueB)
            return 1;
        else 
            return 0;

    })
}

function sortingClaimByUpdateDate(claims){
    return claims.sort( (a,b)=> {
        const valueA= Date.parse(a.updateDate);
        const valueB= Date.parse(b.updateDate)

        if(valueA < valueB)
            return -1;
        else if(valueA > valueB)
            return 1;
        else 
            return 0;

    })
}

function sortingClaimByStatus(claims){
    return claims.sort( (a,b)=> {
        const valueA= a.status;
        const valueB= b.status;

        if(valueA < valueB)
            return -1;
        else if(valueA > valueB)
            return 1;
        else 
            return 0;

    })
}