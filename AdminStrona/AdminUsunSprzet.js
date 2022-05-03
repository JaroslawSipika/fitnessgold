$(document).ready(function() {


    $('#dodajSprzet').click(function () {
        window.location.href = 'AdminDodajSprzet.html'
    })

    $('#edytujSprzet').click(function () {
        window.location.href = 'AdminEdytujSprzet.html'
    })

    $('#usunSprzet').click(function () {
        window.location.href = 'AdminUsunSprzet.html'
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
            url: "http://localhost:8080/equipment/all2",
        }).then(function(data) {
            lista(data)
        })
        function lista(data) {
            var listaKlubow = '';
            data.forEach(function (equipment) {
                listaKlubow += `<option value="${equipment.idequipment}">${equipment.idequipment} - ${equipment.nameEquipment} - ${equipment.name} </option>`;
            });
            tablica = data;
            $('#listaSprzetu').append(listaKlubow);

        };

        $("#listaSprzetu").change(function () {
            const userId = this.value;
            selectedClub = tablica.find(equipment => equipment.idequipment.toString() === userId);

        });

        $('#usunSprzet1').on('click', function () {

            var object = {
                idequipment : selectedClub.idequipment,
                reservationId : selectedClub.reservationId,
            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/equipment/delete',
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