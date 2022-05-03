$(document).ready(function() {

    $('#stronaGlowna').click(function () {
        window.location.href = 'Employee.html'
    })

    $('#wyloguj').click(function () {
        window.location.href = 'logowanie.html'
    })


    $(document).ready(function () {
        let selectedUser
        let tablica = [];
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/statistics/all1",
        }).then(function (data) {
            lista(data)

        })

        function lista(data) {
            let listaSprzetu1 = "";
            data.forEach(function (iddateactivity) {
                listaSprzetu1 += `<option value="${iddateactivity.iddateactivity}">${iddateactivity.speciality}/${iddateactivity.startDate}/${iddateactivity.endDate} ${iddateactivity.firstName} ${iddateactivity.lastName}</option>`;
            });
            tablica = data;
            $("#listaSprzetu1").append(listaSprzetu1);
        };


        $("#listaSprzetu1").change(function () {
            const userId = this.value;
            selectedUser = tablica.find(iddateactivity => iddateactivity.iddateactivity.toString() === userId);
            $("#weight").val(selectedUser.weight);
            $("#heartBeat").val(selectedUser.heartbeatStats);
            $("#fatBodyLevel").val(selectedUser.bodyFatLevel);
            $("#note").val(selectedUser.note);
        });


        $('#edytujSprzet1').on('click', function () {

            var object = {
                dateactivityId: selectedUser.iddateactivity,
                clientId: selectedUser.idclient,
                note: $('#note').val(),
                weight: $('#weight').val(),
                heartbeatStats: $('#heartBeat').val(),
                bodyFatLevel: $('#fatBodyLevel').val(),

            };
            if (selectedUser.idstatistics === null) {


                $.ajax({
                    type: 'POST',
                    url: 'http://localhost:8080/statistics/create',
                    //  crossDomain: true,
                    //  dataType: 'json',
                    Accept: 'application/json',
                    //  'Content-Type': 'application/json',
                    data: object,
                    success: function () {
                    }
                })
            } else {
                window.alert("Statystyka już została wprowadzona wczesniej!!!")
            }
        });

    });
});