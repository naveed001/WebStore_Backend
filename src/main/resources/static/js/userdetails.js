


$( document ).ready(function() {
    showUserDetails()
});



function showUserDetails() {
    var id=1;
    $.ajax({
        type: 'POST',
        url: '/getprofile',
        success: function (user) {
            $('#name').append( '<h6>User Name: '+user.userName+'</h6>' );
            $('#mailid').append( '<h6>Email:'+user.email+'</h6>' );
            $('#address').append( '<h6>Address:'+user.address+'</h6>' );
            $('#userid').append(  '<h6>User ID: '+user.userId+'</h6>' );
        }
    });

}