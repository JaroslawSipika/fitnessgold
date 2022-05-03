$(document).ready(function() {


    $('#edytujDane').click(function () {
        window.location.href = 'TrenerEdytujDane.html'
    })

    $('#zarzadzajSprzetem').click(function () {
        window.location.href = 'TrenerZarzadzajSprzetem.html'
    })

    $('#zarzadzajKlientami').click(function () {
        window.location.href = 'TrenerZarzadzajKlientami.html'
    })

    $('#zarzadzajZajeciami').click(function () {
        window.location.href = 'TrenerZarzadzajZajeciami.html'
    })

    $('#wiadomosci').click(function () {
        window.location.href = 'TrenerZarzadzajWiadomosciami.html'
    })

    $('#wyloguj').click(function () {
        window.location.href = 'logowanie.html'
    })

    $('#kluby').click(function () {
        window.location.href = 'Employee.html'
    })

    $('#zajecia').click(function () {
        window.location.href = 'TrenerZarzadzajZajeciami.html'
    })

    $('#sprzet').click(function () {
        window.location.href = 'TrenerZarzadzajSprzetem.html'
    })

    $('#klienci').click(function () {
        window.location.href = 'TrenerZarzadzajKlientami.html'
    })

    $('#wiadomosci').click(function () {
        window.location.href = 'TrenerZarzadzajWiadomosciami.html'
    })


    $(document).ready(function() {
        let selectedUser;
        let tablica = [];
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/employee/all1",
        }).then(function (data) {
            lista(data)

        })

        function lista(data) {
            let name = "";
            data.forEach(function (employee) {
                name += `<option value="${employee.idemployee}">${employee.firstName} ${employee.lastName}</option>`;
            });
            tablica = data;
            $("#firstName").append(name);

        };


        $("#firstName").change(function () {
            const userId = this.value;
            selectedUser = tablica.find(employee => employee.idemployee.toString() === userId);
            $("#lastName").val(selectedUser.lastName);
            $("#email").val(selectedUser.email);
            $("#password").val(selectedUser.password);
            $("#phone").val(selectedUser.phone);
            $("#speciality").val(selectedUser.speciality);
            $("#note").val(selectedUser.note);
            $("#name").val(selectedUser.name);
        });

        $('#edytujDane1').on('click', function () {

            var object = {
                idemployee: selectedUser.idemployee,
                iduser: selectedUser.iduser,
                firstName: selectedUser.firstName,
                lastName: selectedUser.lastName,
                email: $('#email').val(),
                password: $('#password').val(),
                phone: $('#phone').val(),
                speciality: $('#speciality').val(),
                note: $('#note').val(),
                name: $('#name').val(),
            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/employee/update',
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