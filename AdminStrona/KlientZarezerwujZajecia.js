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
            url: "http://localhost:8080/dateactivity/all",
        }).then(function (data) {
            lista(data)
        })

        function lista(data) {
            let listaAktywnosci = "";
            data.forEach(function (dateactivity) {
                listaAktywnosci += `<option value="${dateactivity.iddateactivity}">${dateactivity.speciality} - ${dateactivity.startDate} - ${dateactivity.name} - ${dateactivity.status}</option>`;
            });
            tablica = data;
            $("#dateActivity").append(listaAktywnosci);
        };


        $("#dateActivity").change(function () {
            const userId = this.value;
            selectedUser = tablica.find(dateactivity => dateactivity.iddateactivity.toString() === userId);
            $("#speciality").val(selectedUser.speciality);
            $("#employee").val(selectedUser.lastName + " " + selectedUser.firstName);
            $("#startDate").val(selectedUser.startDate);
            $("#endDate").val(selectedUser.endDate);
            $("#clubName").val(selectedUser.name);
        });



        $('#zarezerwujZajecia1').on('click', function () {

            var object = {
                iddateactivity: selectedUser.iddateactivity,
                status: selectedUser.status,
            };

            if (selectedUser.status === 'not reserved') {

                $.ajax({
                    type: 'POST',
                    url: 'http://localhost:8080/dateactivity/update',
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
                window.alert("Zajęcia już zarezerwowane. Wybierz dostępne!!!")
            }
        });

    });

});