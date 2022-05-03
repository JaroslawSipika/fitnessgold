$(document).ready(function() {

    $('#dodajZajecia').click(function () {
        window.location.href = 'AdminDodajZajęcia.html'
    })

    $('#edytujZajecia').click(function () {
        window.location.href = 'AdminEdytujZajecia.html'
    })

    $('#usunZajecia').click(function () {
        window.location.href = 'AdminUsunZajęcia.html'
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
            url: "http://localhost:8080/client/activity1",
        }).then(function(data) {
            lista(data)
        })
        function lista(data) {
            var listaSprzetu1 = '';
            data.forEach(function (activity) {
                listaSprzetu1 += `<option value="${activity.idactivity}">${activity.idactivity}: ${activity.speciality} - ${activity.firstName} ${activity.lastName} - ${activity.startDate}</option>`;
            });
            tablica = data;
            $('#listaSprzetu1').append(listaSprzetu1);

        };

        $("#listaSprzetu1").change(function () {
            const userId = this.value;
            selectedClub = tablica.find(activity => activity.idactivity.toString() === userId);

        });

        $('#usunSprzet1').on('click', function () {

            var object = {
                iddateactivity : selectedClub.iddateactivity,
                idactivity : selectedClub.idactivity,
            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/activity/delete',
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