$("#btnid").submit(function (event) {
    event.preventDefault();
    alert("tut");
    $.getJSON("/reviewsJson", function (data) {
        console.log(data);
        for (let i = 0; i <= 5; i = i + 1) {
            $('#results').append($(
                '<div class="card testimonial-card col-4  mb-5">' +
                '<div class="avatar mx-auto white">' +
                '<img src="../../../assets/user/' + data[i]['user_id.image'] +
                'class="rounded-circle img-responsive" alt="woman avatar">' +
                '</div>' +
                '<div class="card-body">' +
                ' <div class="row mb-2">' +
                '<div class="col">' +
                ' <h5 class="text-left font-weight-bold">' +
                data[i]['user_id.first_name'] +
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
// }).done(function () {
//     console.log("second success");
// })
//     .fail(function () {
//         console.log("error");
//     })
//     .always(function () {
//         console.log("complete");
//     });
// $.ajax({
//     url: "/reviewsJson",
//     type: "GET",
//     dataType: "json",
//     success: function () {
//         alert("tut");
//         let result = data['result'];
//         console.log('log');
//         $('#results').html('');
//         result.forEach(function (reviews) {
//             $('#results').append($(
//                 '<div class="card testimonial-card col-4  mb-5">' +
//                 '<div class="avatar mx-auto white">' +
//                 '<img src="../../../assets/user/' + reviews['user_id.image'] +
//                 'class="rounded-circle img-responsive" alt="woman avatar">' +
//                 '</div>' +
//                 '<div class="card-body">' +
//                 ' <div class="row mb-2">' +
//                 '<div class="col">' +
//                 ' <h5 class="text-left font-weight-bold">' +
//                 reviews['user_id.first_name'] +
//                 '</h5>' +
//                 '</div>' +
//                 '<div class="col">' +
//                 ' <h5 class="text-right font-weight-light">' +
//                 reviews['date'] +
//                 '</h5>' +
//                 '</div>' +
//                 '</div>' +
//                 ' <p class="font-small">' +
//                 reviews['text'] +
//                 '</p>' +
//                 '</div>'
//             ))
//         });
//     }
// })
