$.ajax({
    url: "/reviews",
    type: "GET",
    data: {
        'page': $("#page"),
        'offset': $('#offset')
    },
    dataType: "json",
    success: function (data) {
        result = data['result'];
        $('#results').html('');
        result.forEach(function (reviews) {
            $('#results').append($(
                '<div class="card testimonial-card col-4  mb-5">' +
                '<div class="avatar mx-auto white">' +
                '<img src="../../../assets/user/' + reviews['user_id.image'] +
                'class="rounded-circle img-responsive" alt="woman avatar">' +
                '</div>' +
                '<div class="card-body">' +
                ' <div class="row mb-2">' +
                '<div class="col">' +
                ' <h5 class="text-left font-weight-bold">' +
                reviews['user_id.first_name'] +
                '</h5>' +
                '</div>' +
                '<div class="col">' +
                ' <h5 class="text-right font-weight-light">' +
                reviews['date'] +
                '</h5>' +
                '</div>' +
                '</div>' +
                ' <p class="font-small">' +
                reviews['text'] +
                '</p>' +
                '</div>'
            ))
        });
    }
});