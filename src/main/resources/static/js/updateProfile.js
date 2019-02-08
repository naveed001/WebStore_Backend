
$(document).ready(function(){
   fetchuserDetails();
});


function fetchuserDetails() {

    $.ajax({
        type: 'POST',
        url: '/getprofile',
        success: function ( user) {

            $('#updateprofile').append( '<div style="margin: auto"><div style="color: aliceblue; width: 400px">UserName : <b><input type="text" id="username" value='+user.userName+' ></b></div>' +
                '<div style="color: aliceblue; width: 400px">Address : <input type="text" id="address" value='+user.address+' ></div>' +
                '<div style="color: aliceblue; width: 400px">Email Id : <input type="text" id="email" value='+user.email+' ></div>' +
                '<div style="color: aliceblue; width: 400px"><input type="button" value="update user details" onclick="updateUserDetails()"></div></div>');
        }
    });
}


function updateUserDetails() {
    var address = document.getElementById("address").value;
    var email = document.getElementById("email").value;

    $.ajax({
        type: 'POST',
        url: '/updateuserprofile?address='+address+'&email='+email,
        success: function () {
            alert("Details updated !");
            window.location="bootstrap.html";
        }
    });


}
