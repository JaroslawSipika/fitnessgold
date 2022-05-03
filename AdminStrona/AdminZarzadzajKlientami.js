$(document).ready(function() {


    $('#edytujKlienta').click(function () {
        window.location.href = 'AdminEdytujKlienta.html'
    })

    $('#usunKlienta').click(function () {
        window.location.href = 'AdminUsunKlienta.html'
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
            url: "http://localhost:8080/client/allList",
        }).then(function (data) {
            buildTable(data)
        })

        function buildTable(data) {
            var listaTrenerow = '';
            data.forEach(function (user) {
                listaTrenerow += '<tr>';
                listaTrenerow += '<td>' + user.firstName + '</td>';
                listaTrenerow += '<td>' + user.lastName + '</td>';
                listaTrenerow += '<td>' + user.email + '</td>';
                listaTrenerow += '<td>' + user.phone + '</td>';
                listaTrenerow += '</tr>';
            });
            $('#listaKlientow').append(listaTrenerow);

        };
    });











});