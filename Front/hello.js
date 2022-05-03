$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/users/1"
    }).then(function(data) {
        $('#userId').append(data.id);
        $('#userEmail').append(data.email);
    });
});

$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/users"
    }).then(function(data) {
        data.forEach(function (user) {
          $('#users').append("<p>userEmail"+user.email)
        })
    });

    $('#button').click(function (){
        window.location.href='form.html'
    })






});