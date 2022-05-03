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

    $(document).ready(function() {
        let selectedUser;
        let tablica = [];
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/client/all",
        }).then(function (data) {
            lista(data)

        })

        function lista(data) {
            let name = "";
            data.forEach(function (client) {
                name += `<option value="${client.idclient}">${client.firstName} ${client.lastName}</option>`;
            });
            tablica = data;
            $("#firstName").append(name);

        };


        $("#firstName").change(function () {
            const userId = this.value;
            selectedUser = tablica.find(client => client.idclient.toString() === userId);
            $("#lastName").val(selectedUser.lastName);
            $("#email").val(selectedUser.email);
            $("#password").val(selectedUser.password);
            $("#phone").val(selectedUser.phone);
            $("#birthDate").val(selectedUser.birthDate);
            $("#pesel").val(selectedUser.pesel);
            $("#city").val(selectedUser.city);
            $("#street").val(selectedUser.street);
            $("#houseNumber").val(selectedUser.houseNumber);
            $("#postalCode").val(selectedUser.postalCode);
        });

        $('#wyslijKlienta2').on('click', function () {

            var object = {
                idclient: selectedUser.idclient,
                iduser: selectedUser.iduser,
                email: $('#email').val(),
                password: $('#password').val(),
                phone: $('#phone').val(),
                birthDate: $('#birthDate').val(),
                pesel: $('#pesel').val(),
                city: $('#city').val(),
                street: $('#street').val(),
                houseNumber: $('#houseNumber').val(),
                postalCode: $('#postalCode').val(),
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

