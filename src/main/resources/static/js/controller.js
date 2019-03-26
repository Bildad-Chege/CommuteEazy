function save_operator_data(){
    var name = document.getElementById("operator_name").value;
    var email = document.getElementById("operator_email").value;
    var phone = document.getElementById("operator_phone").value;
    var password = document.getElementById("operator_password").value;
    var formData= '{"operatorName":"'+name+'","email":"'+email+'","phone":'+parseInt(phone)+',"password":"'+password+'"}';
    console.log(formData);
    var d = JSON.parse(formData);

    console.log(d   );

    $.ajax({
        type:"POST",
        url:"../addOperator",
        data:JSON.stringify({
            name:name,
            email:email,
            phone:parseInt(phone),
            password:password
        }),
        contentType:"application/json",
        dataType:"json",
        success:function (response) {
            console.log(response);

        },
        error:function(error,response){
            console.log(response);
        }
    });
}