$("#btnid").submit(function (event) {
    event.preventDefault();
    $.getJSON("/reviewsJson", function (data) {
        console.log(data);
        for (let i = 0; i <= data.length; i = i + 1) {
            $('#results').append($(
                '<div class="card testimonial-card col-4  mb-5">' +
                '<div class="avatar mx-auto white">' +
                '<img src="../../../assets/data/' + data[i]['user_id']['image']['path'] + '"' +
                'class="rounded-circle img-responsive" alt="avatar">' +
                '</div>' +
                '<div class="card-body">' +
                ' <div class="row mb-2">' +
                '<div class="col">' +
                ' <h5 class="text-left font-weight-bold">' +
                data[i]['user_id']['first_name'] +
                '</h5>' +
                '</div>' +
                '<div class="col">' +
                ' <h5 class="text-right font-weight-light">' +
                data[i]['date'] +
                '</h5>' +
                '</div>' +
                '</div>' +
                ' <p class="font-small">' +
                data[i]['text'] +
                '</p>' +
                '</div>'
            ))
        }
    });
})
;
