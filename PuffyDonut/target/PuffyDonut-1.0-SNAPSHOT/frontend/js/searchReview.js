function searchReview() {
    $.ajax({
        url: "/search",
        type: "GET",
        data: {
            'input': $("#inputSearch").val(),
            'filter': $('input[name=filter]:checked').val()
        },
        dataType: "json",
        success: function (data) {
            result = data['result'];
            $('#results').html('');
            result.forEach(function (review) {
                $('#results').append($(
                    '<div class="card testimonial-card col-4  mb-5">' +
                    '<div class="avatar mx-auto white">' +
                    '<img src="https://mdbootstrap.com/img/Photos/Avatars/img%20%2831%29.jpg class="rounded-circle img-responsive" alt="woman avatar">' +
                    '</div>' +
                    '<div class="card-body ">' +
                    '<div class="row mb-2">' +
                    '<div class="col">' +
                    '<h5 class="text-left font-weight-bold">Martha Smith</h5>' +
                    '</div>' +
                    '<div class="col">' +
                    '<h5 class="text-right font-weight-light">' +
                    review['date'] +
                    '</h5>' +
                    '</div>' +
                    '</div>' +
                    '<p class="font-small">' + review['text'] + '</p>' +
                    '</div>' +
                    '</div>'))
            });
        }
    })
};