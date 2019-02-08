$( document ).ready(function() {
    fetchProducts();
    checkUsers();
    checkRole();

});

function fetchProducts(){

$.ajax({
    type: 'GET',
    url: '/product/productlist',
    success: function (orders) {


        for (var order in orders) {
            $('#orders').append('<div id="product' + orders[order].productid + '" class="col-sm-3 ' + orders[order].category + '" xmlns="http://www.w3.org/1999/html">' +
                '<p >Product Id: <b id="productid">' + orders[order].productid + '</b></p>' +
                '<p>Name: ' + orders[order].productName + '</p>' +
                '<p>Price: ' + orders[order].price + '</p>' +
                '<p><button onclick="addtocart('+orders[order].productid+',1)">Add to Cart</button></p><br><br>'+
                '</div>');
        }
    }
});
}



function addtocart(x,y) {

    $.ajax({
        type: 'GET',
        url: '/cart/addtocart?productid='+x+'&quantity=1',
        success: function () {
            alert("Item Added to cart.");
        },
        error: function () {
            alert("Please signin to Proceed !");
            window.location="login.html";
        }
    });
}



function checkUsers() {

    $.ajax({
        type: 'GET',
        url: '/checkUser',
        success: function () {
            $('#button6').hide();
            $('#button7').hide();
        },
        error: function () {
            $('#button8').hide();

        }
    });
}


function checkRole() {
    $.ajax({
        type: 'GET',
        url: '/checkUserRole',
        success: function (role) {
            if(role == 'USER')
            $('#button9').hide();
            else {
                window.open("adminpage.html");
            }
        },
        error: function () {
            $('#button9').hide();

        }
    });
}