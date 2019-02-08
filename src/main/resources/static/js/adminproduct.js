$( document ).ready(function() {
    fetchProductlists();
});




function fetchProductlists(){

    $.ajax({
        type: 'GET',
        url: '/product/productlist',
        success: function (orders) {

            for (var order in orders) {
                $('#orders').append('<div id="product' + orders[order].productid + '" class="col-sm-3 ' + orders[order].category + '" xmlns="http://www.w3.org/1999/html">' +
                    '<p >Product Id: <b id="productid">' + orders[order].productid + '</b></p>' +
                    '<p>Name: ' + orders[order].productName + '</p>' +
                    '<p>Price: ' + orders[order].price + '</p>' +
                    '<p><button onclick="removeProduct('+orders[order].productid+')">Remove Product</button></p><br><br>'+
                    '</div>');
            }
        }
    });
}


function removeProduct(x) {

    $.ajax({
        type: 'POST',
        url: '/product/remove?productid='+x,
        success: function () {
            alert("Product Remove from cart !");
            window.location="adminpage.html";
        }
    });

}