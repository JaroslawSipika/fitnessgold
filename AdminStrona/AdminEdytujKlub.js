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
        let selectedUser
        let tablica = [];
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/club/all",
        }).then(function (data) {
            lista(data)

        })

        function lista(data) {
            let listaKlubow1 = "";
            data.forEach(function (club) {
                listaKlubow1 += `<option value="${club.idclub}">${club.name}</option>`;
            });
            tablica = data;
            $("#listaKlubow1").append(listaKlubow1);
        };


        $("#listaKlubow1").change(function () {
            const userId = this.value;
            selectedUser = tablica.find(club => club.idclub.toString() === userId);
            $("#name").val(selectedUser.name);
            $("#country").val(selectedUser.country);
            $("#city").val(selectedUser.city);
            $("#street").val(selectedUser.street);
            $("#houseNumber").val(selectedUser.houseNumber);
            $("#postalCode").val(selectedUser.postalCode);

        });


        $('#edytujKlub1').on('click', function () {

            var object = {
                idclub: selectedUser.idclub,
                country: $('#country').val(),
                city: $('#city').val(),
                postalCode: $('#postalCode').val(),
                street: $('#street').val(),
                houseNumber: $('#houseNumber').val(),
                name: $('#name').val(),
            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/club/update',
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