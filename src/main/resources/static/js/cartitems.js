var sum = 0;

$( document ).ready(function() {
    fetchcartitems()
});




$( document ).ready(function() {
    $("#button4").click(function(){
        placeOrder();
    });
});




function fetchcartitems(){
    $.ajax({
        type: 'GET',
        url: '/cart/getcartforauser',
        success: function (carts) {
             sum = 0;
            for (var cart in carts) {

                $('#table tbody').append("<tr><td>"+(cart)+"</td>" +
                    "<td id='asdf'>"+carts[cart].product.productid+"</td>" +
                    "<td>"+carts[cart].product.productName+"</td>" +
                    "<td>"+carts[cart].product.price+"</td>" +
                    "<td>"+carts[cart].quantity+"</td>" +
                    "<td>"+(carts[cart].product.price)*carts[cart].quantity+"</td>" +
                    "<td><button onclick='REMOVEITEM("+carts[cart].product.productid+")'><i class=\"fas fa-trash\"></i></button></td>" +
                    "<td><input style='width:40%' id="+carts[cart].product.productid+" type='number' min='1' value="+carts[cart].quantity+"><button  onclick=' updateQuantity("+carts[cart].product.productid+")'><i class=\"fas fa-check-double\"></i></td>" +
                    "</tr>");

                sum = sum + (carts[cart].product.price)*carts[cart].quantity;
            }
            $('#sumtotal').append('<b id="sum">Total cart value :' + sum +'</b>');
        }
    });
}


function REMOVEITEM(x) {
    $.ajax({
        type: 'POST',
        url: '/cart/removefromcart?productid='+x,
       success: function () {
          alert("Item removed from cart");
          window.location="mycart.html";
}
    });
}



function placeOrder(){
    $.ajax({
        type: 'POST',
        url: '/placeOrder',
       success: function () {
            if( sum != 0 ){
           alert("order placd successfully.");
           window.location="mycart.html";
        }
        else {
            alert('Cart empty.');
            }}
    });
}


function updateQuantity(x) {
    var y = document.getElementById(x).value;
    if(y <= 0){
        y = 1 ;
    }

    $.ajax({
        type: 'POST',
        url: '/cart/changequantity?productid='+x+'&quantity='+y,
        success: function () {
            alert("Quantity Updated");
            window.location="mycart.html";
        }
    });
}