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
            url: "http://localhost:8080/employee/all",
        }).then(function (data) {
            buildTable(data)
        })

        function buildTable(data) {
            var listaTrenerow = '';
            data.forEach(function (user) {
                listaTrenerow += '<tr>';
                listaTrenerow += '<td>' + user.firstName + '</td>';
                listaTrenerow += '<td>' + user.lastName + '</td>';
                listaTrenerow += '<td>' + user.speciality + '</td>';
                listaTrenerow += '<td>' + user.nameClub + '</td>';
                listaTrenerow += '<td>' + user.note + '</td>';
                listaTrenerow += '<td>' + user.phone + '</td>';
                listaTrenerow += '</tr>';
            });
            $('#listaTrenerow').append(listaTrenerow);

        };
    });

});