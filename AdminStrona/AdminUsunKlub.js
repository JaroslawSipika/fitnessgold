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


    $(document).ready(function() {
        let selectedClub;
        let tablica =[];
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/club/all",
        }).then(function(data) {
            lista(data)
        })
        function lista(data) {
            var listaKlubow = '';
            data.forEach(function (club) {
                listaKlubow += `<option value="${club.idclub}">${club.name}</option>`;
            });
            tablica = data;
            $('#listaKlubow').append(listaKlubow);

        };

        $("#listaKlubow").change(function () {
            const userId = this.value;
            selectedClub = tablica.find(club => club.idclub.toString() === userId);

        });

        $('#usunKlub1').on('click', function () {

            var object = {
                idclub : selectedClub.idclub
            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/club/delete',
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