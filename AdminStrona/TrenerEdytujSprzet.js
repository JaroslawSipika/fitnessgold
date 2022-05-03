$(document).ready(function() {


    $('#dodajSprzet').click(function () {
        window.location.href = 'TrenerDodajSprzet.html'
    })

    $('#edytujSprzet').click(function () {
        window.location.href = 'TrenerEdytujSprzet.html'
    })

    $('#usunSprzet').click(function () {
        window.location.href = 'TrenerUsunSprzet.html'
    })

    $('#powrotDoGlownej').click(function () {
        window.location.href = 'Employee.html'
    })

    $('#wyloguj').click(function () {
        window.location.href = 'logowanie.html'
    })

    $(document).ready(function() {
        let selectedUser
        let tablica = [];
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/equipment/all",
        }).then(function (data) {
            lista(data)

        })

        function lista(data) {
            let listaSprzetu1 = "";
            data.forEach(function (equipment) {
                listaSprzetu1 += `<option value="${equipment.idequipment}">${equipment.idequipment}: ${equipment.nameEquipment} - ${equipment.name}</option>`;
            });
            tablica = data;
            $("#listaSprzetu1").append(listaSprzetu1);
        };


        $("#listaSprzetu1").change(function () {
            const userId = this.value;
            selectedUser = tablica.find(equipment => equipment.idequipment.toString() === userId);
            $("#name").val(selectedUser.nameEquipment);
            $("#note").val(selectedUser.note);
            $("#status").val(selectedUser.status);
            $("#pricePerDay").val(selectedUser.pricePerDay);
            $("#lastConservation").val(selectedUser.lastConservation);
            $("#nameClub").val(selectedUser.name);

        });


        $('#edytujSprzet1').on('click', function () {

            var object = {
                idequipment: selectedUser.idequipment,
                nameEquipment: $('#name').val(),
                note: $('#note').val(),
                status: $('#status').val(),
                pricePerDay: $('#pricePerDay').val(),
                lastConservation: $('#lastConservation').val(),
                name: $('#nameClub').val(),
            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/equipment/update',
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