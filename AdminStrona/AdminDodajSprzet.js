$(document).ready(function() {


    $('#dodajSprzet').click(function () {
        window.location.href = 'AdminDodajSprzet.html'
    })

    $('#edytujSprzet').click(function () {
        window.location.href = 'AdminEdytujSprzet.html'
    })

    $('#usunSprzet').click(function () {
        window.location.href = 'AdminUsunSprzet.html'
    })

    $('#powrotDoGlownej').click(function () {
        window.location.href = 'Admin.html'
    })

    $('#wyloguj').click(function () {
        window.location.href = 'logowanie.html'
    })



    $(document).ready(function () {

        var $nameEquipment = $('#nameEquipment');
        var $status = $('#status');
        var $note = $('#note');
        var $pricePerDay = $('#pricePerDay');
        var $name = $('#nameClub');

        $('#dodajSprzet1').on('click', function () {

            var object = {
                nameEquipment: $nameEquipment.val(),
                status: $status.val(),
                note: $note.val(),
                pricePerDay: $pricePerDay.val(),
                name: $name.val(),

            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/equipment/create',
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