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

    $('#kluby').click(function () {
        window.location.href = 'KlientKluby.html'
    })

    $('#zarezerwujZajecia').click(function () {
        window.location.href = 'KlientZarezerwujZajecia.html'
    })

    $('#zarezerwujSprzet').click(function () {
        window.location.href = 'KlientZarezerwujSprzet.html'
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
            url: "http://localhost:8080/equipment/all1",
        }).then(function (data) {
            lista(data)
        })

        function lista(data) {
            let listaSprzetu = "";
            data.forEach(function (equipment) {
                listaSprzetu += `<option value="${equipment.idequipment}">${equipment.nameEquipment} - ${equipment.name} - ${equipment.status}</option>`;
            });
            tablica = data;
            $("#wybierzSprzet").append(listaSprzetu);
        };


        $("#wybierzSprzet").change(function () {
            const userId = this.value;
            selectedUser = tablica.find(equipment => equipment.idequipment.toString() === userId);
            $("#clubName").val(selectedUser.name);
            $("#pricePerDay").val(selectedUser.pricePerDay);
            $("#note").val(selectedUser.note);
        });

        var $beginDate = $('#beginDate');
        var $endDate = $('#endDate');

        $('#zarezerwujSprzet1').on('click', function () {

            var object = {
                idequipment: selectedUser.idequipment,
                beginDate: $beginDate.val(),
                endDate: $endDate.val(),
            };

            if (selectedUser.status === 'not rented') {

                $.ajax({
                    type: 'POST',
                    url: 'http://localhost:8080/equipment/update1',
                    //  crossDomain: true,
                    //  dataType: 'json',
                    Accept: 'application/json',
                    //  'Content-Type': 'application/json',
                    data: object,
                    success: function () {
                    }
                })
            }
            else{
                window.alert("Sprzęt już zarezerwowany. Wybierz inny!!!")
            }
        });

    });


});