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
                listaSprzetu += '<td>' + data.pricePerDay + '</td>';
                listaSprzetu += '<td>' + data.name + '</td>';
                listaSprzetu += '<td>' + data.beginDate + '</td>';
                listaSprzetu += '<td>' + data.endDate + '</td>';
                listaSprzetu += '</tr>';
            });
            $('#listaSprzetu').append(listaSprzetu);
        };
    });
});