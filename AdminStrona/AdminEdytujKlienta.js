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
        let selectedUser;
        let tablica = [];
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/client/allList",
        }).then(function (data) {
            lista(data)

        })

        function lista(data) {
            let listaPracownikow = "";
            data.forEach(function (client) {
                listaPracownikow += `<option value="${client.idclient}">${client.firstName} ${client.lastName}</option>`;
            });
            tablica = data;
            $("#listaKlientow1").append(listaPracownikow);

        };


        $("#listaKlientow1").change(function () {
            const userId = this.value;
            selectedUser = tablica.find(client => client.idclient.toString() === userId);
            $("#firstName").val(selectedUser.firstName);
            $("#lastName").val(selectedUser.lastName);
            $("#email").val(selectedUser.email);
            $("#password").val(selectedUser.password);
            $("#phone").val(selectedUser.phone);
            $("#birthDate").val(selectedUser.birthDate);
            $("#pesel").val(selectedUser.pesel);
            $("#street").val(selectedUser.street);
            $("#houseNumber").val(selectedUser.houseNumber);
            $("#postalCode").val(selectedUser.postalCode);
            $("#city").val(selectedUser.city);

        });



        $('#edytujKlienta1').on('click', function () {

            var object = {
                idclient: selectedUser.idclient,
                iduser: selectedUser.iduser,
                firstName: $('#firstName').val(),
                lastName: $('#lastName').val(),
                email: $('#email').val(),
                password: $('#password').val(),
                phone: $('#phone').val(),
                birthDate: $('#birthDate').val(),
                pesel: $('#pesel').val(),
                street: $('#street').val(),
                houseNumber: $('#houseNumber').val(),
                postalCode: $('#postalCode').val(),
                city: $('#city').val(),
            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/client/update',
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