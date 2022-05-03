$(document).ready(function() {

    $('#dodajZajecia').click(function () {
        window.location.href = 'TrenerDodajZajęcia.html'
    })

    $('#edytujZajecia').click(function () {
        window.location.href = 'TrenerEdytujZajecia.html'
    })

    $('#usunZajecia').click(function () {
        window.location.href = 'TrenerUsunZajęcia.html'
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
            url: "http://localhost:8080/client/activity1",
        }).then(function (data) {
            lista(data)

        })

        function lista(data) {
            let listaSprzetu1 = "";
            data.forEach(function (activity) {
                listaSprzetu1 += `<option value="${activity.iddateactivity}">${activity.iddateactivity}: ${activity.speciality} - ${activity.firstName} ${activity.lastName} - ${activity.startDate}</option>`;
            });
            tablica = data;
            $("#listaSprzetu1").append(listaSprzetu1);
        };


        $("#listaSprzetu1").change(function () {
            const userId = this.value;
            selectedUser = tablica.find(activity => activity.iddateactivity.toString() === userId);
            $("#speciality").val(selectedUser.speciality);
            $("#firstName").val(selectedUser.lastName);
            $("#startDate").val(selectedUser.startDate);
            $("#endDate").val(selectedUser.endDate);
            $("#nameClub").val(selectedUser.name);

        });


        $('#edytujSprzet1').on('click', function () {

            var object = {
                iddateactivity: selectedUser.iddateactivity,
                clientId: selectedUser.clientId,
                idactivity: selectedUser.idactivity,
                activityId: selectedUser.activityId,
                Idclient: selectedUser.clientId,
                speciality: $('#speciality').val(),
                lastName: $('#firstName').val(),
                startDate: $('#startDate').val(),
                endDate: $('#endDate').val(),
                name: $('#nameClub').val(),
            };

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/activity/update',
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