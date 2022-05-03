$(document).ready(function() {

    $('#edytujDane').click(function () {
        window.location.href = 'KlientEdytujDane.html'
    })

    $('#mojeZajecia').click(function () {
        window.location.href = 'KlientMojeZajecia.html'
    })

    $('#mojSprzet').click(function () {
        window.location.href = 'KlientMojSprzet.html'
    })

    $('#mojeStatystyki').click(function () {
        window.location.href = 'KlientMojeStatystyki.html'
    })

    $('#wiadomosci').click(function () {
        window.location.href = 'KlientZarzadzajWiadomosciami.html'
    })

    $('#stronaGlowna').click(function () {
        window.location.href = 'Klient.html'
    })

    $('#wyloguj').click(function () {
        window.location.href = 'Logowanie.html'
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