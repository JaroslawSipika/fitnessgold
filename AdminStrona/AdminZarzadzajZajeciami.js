$(document).ready(function() {

    $('#dodajZajecia').click(function () {
        window.location.href = 'AdminDodajZajęcia.html'
    })

    $('#edytujZajecia').click(function () {
        window.location.href = 'AdminEdytujZajecia.html'
    })

    $('#usunZajecia').click(function () {
        window.location.href = 'AdminUsunZajęcia.html'
    })

    $('#powrotDoGlownej').click(function () {
        window.location.href = 'Admin.html'
    })

    $('#wyloguj').click(function () {
        window.location.href = 'logowanie.html'
    })



    $(document).ready(function () {
        var myArray = [];
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/client/activity",
        }).then(function (data) {
            buildTable(data)
        })

        function buildTable(data) {
            var listaSprzetu = '';
            data.forEach(function (data) {
                listaSprzetu += '<tr>';
                listaSprzetu += '<td>' + data.speciality + '</td>';
                listaSprzetu += '<td>' + data.firstName + " " + data.lastName + '</td>';
                listaSprzetu += '<td>' + data.startDate + '</td>';
                listaSprzetu += '<td>' + data.endDate + '</td>';
                listaSprzetu += '</tr>';
            });
            $('#listaZajec').append(listaSprzetu);
        };
    });



});