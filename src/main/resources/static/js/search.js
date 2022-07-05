function searchInOneClaim(claim, str){
    const categories = ["title","description","status","createdDate","updateDate"];
    for (const [key,value] of Object.entries(claim)){
        if (categories.includes(key) && value.includes(str)) return true
    }
    return false;
}

async function filterClaims(claims, str){
    return claims.filter(claim => searchInOneClaim(claim,str))
}