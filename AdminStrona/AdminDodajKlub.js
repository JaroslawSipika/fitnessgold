$(document).ready(function() {


    $('#dodajKlub').click(function () {
        window.location.href = 'AdminDodajKlub.html'
    })

    $('#edytujKlub').click(function () {
        window.location.href = 'AdminEdytujKlub.html'
    })

    $('#usunKlub').click(function () {
        window.location.href = 'AdminUsunKlub.html'
    })

    $('#powrotDoGlownej').click(function () {
        window.location.href = 'Admin.html'
    })

    $('#wyloguj').click(function () {
        window.location.href = 'logowanie.html'
    })



    $(document).ready(function () {

        var $country = $('#country');
        var $city = $('#city');
        var $postalCode = $('#postalCode');
        var $street = $('#street');
        var $houseNumber = $('#houseNumber');
        var $name = $('#name');

        $('#dodajKlub1').on('click', function () {

            var object = {
                country: $country.val(),
                city: $city.val(),
                postalCode: $postalCode.val(),
                street: $street.val(),
                houseNumber: $houseNumber.val(),
                name: $name.val()
            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/club/create',
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