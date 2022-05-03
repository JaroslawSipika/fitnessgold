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
        var myArray = [];
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/equipment/all",
        }).then(function (data) {
            buildTable(data)
        })

        function buildTable(data) {
            var listaSprzetu = '';
            data.forEach(function (data) {
                listaSprzetu += '<tr>';
                listaSprzetu += '<td>' + data.nameEquipment + '</td>';
                listaSprzetu += '<td>' + data.note + '</td>';
                listaSprzetu += '<td>' + data.status + '</td>';
                listaSprzetu += '<td>' + data.pricePerDay + '</td>';
                listaSprzetu += '<td>' + data.name + '</td>';
                listaSprzetu += '<td>' + data.buyDate + '</td>';
                listaSprzetu += '<td>' + data.lastConservation + '</td>';
                listaSprzetu += '<td>' + data.nextConservation + '</td>';
                listaSprzetu += '<td>' + data.beginDate + '</td>';
                listaSprzetu += '<td>' + data.endDate + '</td>';
                listaSprzetu += '<td>' + data.firstName + " "+ data.lastName +'</td>';
                listaSprzetu += '</tr>';
            });
            $('#listaSprzetu').append(listaSprzetu);
        };
    });






});