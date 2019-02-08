$(document).ready(function(){
    $("#button").click(function(){
        var u = document.getElementById("username");
        var p = document.getElementById("password");
        var a = document.getElementById("address");
        var e = document.getElementById("email");
       saveuserdetails(u,p,a,e);
    });
});








function saveuserdetails(u,p,a,e) {
    $.ajax({
        type: 'POST',
        url: '/saveuserdetails',
        data: jQuery.param({
            'username': u.value,
            'password': p.value,
            'email':    e.value,
            'address':  a.value
                                }),
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',

        success: function (data) {
            if(data==1){
                alert("Username taken. Please try another username !");
            }
            if(data==0) {
                alert("Sign up successful");
                window.location = "login.html";
            }
        }
        // error: function () {
        //     alert('Username taken. Please try another username !');
        //     window.location="signup.html";
        // }
    });
}