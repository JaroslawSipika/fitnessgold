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
    let selectedEmployee;
    let tablica =[];
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/employee/edit",
    }).then(function(data) {
        lista(data)
    })
    function lista(data) {
        var listaPracownikow = '';
        data.forEach(function (employee) {
            listaPracownikow += `<option value="${employee.idemployee}">${employee.firstName} ${employee.lastName}</option>`;
        });
        tablica = data;
        $('#listaPracownikow').append(listaPracownikow);

    };

    $("#listaPracownikow").change(function () {
        const userId = this.value;
        selectedEmployee = tablica.find(employee => employee.idemployee.toString() === userId);

    });

    $('#usunTrenera1').on('click', function () {

        var object = {
            idemployee : selectedEmployee.idemployee
        };

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/employee/delete',
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



