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
        var myArray = [];
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/club/all",
        }).then(function (data) {
            buildTable(data)
        })

        function buildTable(data) {
            var listaKlubow = '';
            data.forEach(function (data) {
                listaKlubow += '<tr>';
                listaKlubow += '<td>' + data.name + '</td>';
                listaKlubow += '<td>' + data.country + '</td>';
                listaKlubow += '<td>' + data.city + '</td>';
                listaKlubow += '<td>' + data.street + '</td>';
                listaKlubow += '<td>' + data.houseNumber + '</td>';
                listaKlubow += '</tr>';
            });
            $('#listaKlubow').append(listaKlubow);

        };
    });







});