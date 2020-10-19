function searchAjax(link){
    return $.ajax({
        url : link,
        type:'HEAD'
    });
}

