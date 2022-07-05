function searchInOneClaim(claim, str){
    const categories = ["title","description","status","createdDate","updateDate"];
    for (const [key,value] of Object.entries(claim)){
        if (categories.includes(key) && value.toLowerCase().includes(str.toLowerCase())) return true
    }
    return false;
}

async function filterClaims(claims, str){
    return claims.filter(claim => searchInOneClaim(claim,str))
}