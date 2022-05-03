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

    $(document).ready(function() {
        let selectedEmployee;
        let tablica =[];
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/client/allList",
        }).then(function(data) {
            lista(data)
        })
        function lista(data) {
            var listaPracownikow = '';
            data.forEach(function (client) {
                listaPracownikow += `<option value="${client.idclient}">${client.firstName} ${client.lastName}</option>`;
            });
            tablica = data;
            $('#listaPracownikow').append(listaPracownikow);

        };

        $("#listaPracownikow").change(function () {
            const userId = this.value;
            selectedEmployee = tablica.find(client => client.idclient.toString() === userId);

        });

        $('#usunKlienta1').on('click', function () {

            var object = {
                idclient : selectedEmployee.idclient
            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/client/delete',
                //  crossDomain: true,
                //  dataType: 'json',
                Accept: 'application/json',
                //  'Content-Type': 'application/json',
                data: object,
                success: function () {
                }
            })
        });

    });

});