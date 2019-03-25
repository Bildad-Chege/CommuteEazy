function save_operator_data(){
    var name = document.getElementById("operator_name").value;
    var email = document.getElementById("operator_email").value;
    var phone = document.getElementById("operator_phone").value;
    var password = document.getElementById("operator_password").value;
    var formData= {
        "name":name,
        "email":email,
        "phone":phone,
        "password":password
    };
    $.ajax({
        type:"POST",
        url:"../addOperator",
        data:formData,
        dataType:"application/json",
        success:function (response) {
            console.log(response);

        }
    });
}