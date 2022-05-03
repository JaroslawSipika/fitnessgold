$(document).ready(function() {

    $('#wprowadzStatystyki').click(function () {
        window.location.href = 'TrenerWprowadzStatystyki.html'
    })

    $('#stronaGlowna').click(function () {
        window.location.href = 'Employee.html'
    })

    $('#wyloguj').click(function () {
        window.location.href = 'logowanie.html'
    })
    $(document).ready(function () {
        var myArray = [];
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/statistics/all1",
        }).then(function (data) {
            buildTable(data)
        })

        function buildTable(data) {
            var listaSprzetu = '';
            data.forEach(function (data) {
                listaSprzetu += '<tr>';
                listaSprzetu += '<td>' + data.firstName + '</td>';
                listaSprzetu += '<td>' + data.lastName + '</td>';
                listaSprzetu += '<td>' + data.speciality + '</td>';
                listaSprzetu += '<td>' + data.startDate + '</td>';
                listaSprzetu += '<td>' + data.endDate + '</td>';
                listaSprzetu += '</tr>';
            });
            $('#listaSprzetu').append(listaSprzetu);
        };
    });
});