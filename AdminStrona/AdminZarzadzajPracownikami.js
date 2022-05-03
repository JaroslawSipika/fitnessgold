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