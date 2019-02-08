
$(document).ready(function(){
    $("#button10").click(function(){

        changePassword();
    });
});



function changePassword(){
    var password = document.getElementById("password").value;
    var confirmP = document.getElementById("confirm_password").value;
    var username = document.getElementById("username").value;

    if(password === confirmP){
     updatePassword(username,confirmP);
    }
    else {
        alert("Password not matched.");
        window.location="resetPassword.html";
    }
}

function updatePassword(x,y) {

    $.ajax({
        type: 'POST',
        url: '/updateuserpassword',
        data: jQuery.param({
            'username': x,
            'password': y
        }),
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',


        success: function (data) {
            if(data == 0) {
                alert("Password changed successfully !");
                window.location = "index.html";
            }
            if(data == 1)
             {
                alert("Username is incorrect !");
            }

        }
    });

}

