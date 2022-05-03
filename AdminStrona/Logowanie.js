$(document).ready(function() {

    var $email = $('#email');
    var $password = $('#password');

    $('#login').on('click', function () {
        var object = {
            email: $email.val(),
            password: $password.val(),
        };

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/auth/login',
            //  crossDomain: true,
            //  dataType: 'json',
            Accept: 'application/json',
            //  'Content-Type': 'application/json',
            data: object,
            success: function (data) {
                console.log(data);
                if (data.type === 'EMPLOYEE'){
                    window.location.href = 'Employee.html'
                }
                else if(data.type === 'CLIENT'){
                    window.location.href = 'Klient.html'
                }
                else if(data.type === 'ADMIN'){
                    window.location.href = 'Admin.html'
                }

            }, error: function () {
                window.alert("Błędne logowowanie!!!")
            }
        });
    });

    $(document).ready(function() {

        var $firstName = $('#firstName');
        var $lastName = $('#lastName');
        var $password1 = $('#password1');
        var $email1 = $('#email1');
        var $phone = $('#phone');
        var $pesel = $('#pesel');



        $('#registration').on('click', function () {
            var object = {

                firstName: $firstName.val(),
                lastName: $lastName.val(),
                password: $password1.val(),
                email: $email1.val(),
                phone: $phone.val(),
                pesel: $pesel.val(),

            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/users/registration',
                //  crossDomain: true,
                //  dataType: 'json',
                Accept: 'application/json',
                //  'Content-Type': 'application/json',
                data: object,
                success: function (data) {
                    window.alert("Brawo! Teraz możesz się zalogować")

                }, error: function () {
                    window.alert("Błędna rejestracja!!!")
                }
            });
        });
    });

















});
