$(document).ready(function() {

    $('#dodajZajecia').click(function () {
        window.location.href = 'TrenerDodajZajęcia.html'
    })

    $('#edytujZajecia').click(function () {
        window.location.href = 'TrenerEdytujZajecia.html'
    })

    $('#usunZajecia').click(function () {
        window.location.href = 'TrenerUsunZajęcia.html'
    })

    $('#stronaGlowna').click(function () {
        window.location.href = 'Employee.html'
    })

    $('#wyloguj').click(function () {
        window.location.href = 'logowanie.html'
    })


    $(document).ready(function () {

        var $speciality = $('#speciality');
        var $lastName = $('#lastName');
        var $beginDate = $('#beginDate');
        var $endDate = $('#endDate');
        var $clubName = $('#clubName');

        $('#dodajZajecia1').on('click', function () {

            var object = {
                speciality: $speciality.val(),
                lastName: $lastName.val(),
                startDate: $beginDate.val(),
                endDate: $endDate.val(),
                name: $clubName.val(),
            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/dateactivity/create',
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