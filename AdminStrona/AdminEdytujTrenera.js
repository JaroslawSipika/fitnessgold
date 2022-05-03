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


$(document).ready(function() {
    let tablica = [];
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/employee/edit",
    }).then(function (data) {
        lista(data)

    })

    function lista(data) {
        let listaPracownikow = "";
        data.forEach(function (employee) {
            listaPracownikow += `<option value="${employee.idemployee}">${employee.firstName} ${employee.lastName}</option>`;
        });
        tablica = data;
        $("#listaPracownikow1").append(listaPracownikow);

    };


    $("#listaPracownikow1").change(function () {
        const userId = this.value;
        const selectedUser = tablica.find(employee => employee.idemployee.toString() === userId);
        $("#firstName").val(selectedUser.firstName);
        $("#lastName").val(selectedUser.lastName);
        $("#email").val(selectedUser.email);
        $("#password").val(selectedUser.password);
        $("#phone").val(selectedUser.phone);
        $("#speciality").val(selectedUser.speciality);
        $("#note").val(selectedUser.note);
        $("#clubName").val(selectedUser.nameClub);

    });



        $('#wyslijTrenera2').on('click', function () {

            var object = {
                firstName: $('#firstName').val(),
                lastName: $('#lastName').val(),
                email: $('#email').val(),
                password: $('#password').val(),
                phone: $('#phone').val(),
                speciality: $('#speciality').val(),
                note: $('#note').val(),
                nameClub: $('#nameClub').val(),
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


