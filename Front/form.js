




    function createUser(){
        $('#form').onclick(function(e) {

            e.preventDefault(); // avoid to execute the actual submit of the form.

            var form = $(this);

            $.post("http://localhost:8080/users/create",{
                firstName: $('#firstName')
            }, function(Response){

            });



            // {
            //     type: "POST",
            //     url: "http://localhost:8080/users/create",
            //     data: {
            //         firstName: $('#firstName')
            //     }, // serializes the form's elements.
            //     success: function(data)
            //     {
            //         alert(data); // show response from the php script.
            //     }
            // });


        });
    }




