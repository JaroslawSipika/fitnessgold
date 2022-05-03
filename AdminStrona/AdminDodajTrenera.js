$(document).ready(function() {


    $('#dodajTrenera').click(function () {
        window.location.href = 'AdminDodajTrenera.html'
    })

    $('#edytujTrenera').click(function () {
        window.location.href = 'AdminEdytujTrenera.html'
    })

    $('#usunTrenera').click(function () {
        window.location.href = 'AdminUsunTrenera.html'
    })

    $('#powrotDoGlownej').click(function () {
        window.location.href = 'Admin.html'
    })

    $('#wyloguj').click(function () {
        window.location.href = 'logowanie.html'
    })


    $(document).ready(function () {

        var $firstName = $('#firstName');
        var $lastName = $('#lastName');
        var $email = $('#email');
        var $password = $('#password');
        var $phone = $('#phone');
        var $speciality = $('#speciality');
        var $note = $('#note');
        var $nameClub = $('#nameClub');

        $('#wyslijTrenera').on('click', function () {

            var object = {
                firstName: $firstName.val(),
                lastName: $lastName.val(),
                email: $email.val(),
                password: $password.val(),
                phone: $phone.val(),
                speciality: $speciality.val(),
                note: $note.val(),
                nameClub: $nameClub.val()
            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/employee/create',
              //  crossDomain: true,
              //  dataType: 'json',
                Accept: 'application/json',
              //  'Content-Type': 'application/json',
                data:object,
                success: function () {
                }
            })
        });
    });
});


