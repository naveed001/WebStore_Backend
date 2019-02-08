
$( document ).ready(function() {
    $("#button1").click(function(){
        $('#orders').empty();
        var book = "Books";
        fetchProductsbycategory(book);
    });
});


$( document ).ready(function() {
    $("#button2").click(function(){
        $('#orders').empty();
        var fruit = "Fruits";
        fetchProductsbycategory(fruit);
    });
});

$( document ).ready(function() {
    $("#button3").click(function(){

        var x = document.getElementById("minprice").value;
        var y = document.getElementById("maxprice").value;
        var category = document.getElementById("category").value;
        fetchProductsbyPrice(x,y,category);
    });
});


$( document ).ready(function() {
    $("#button4").click(function(){
        var name = document.getElementById("name").value;
        fetchProductsbynamelike(name);
    });
});




function fetchProductsbyPrice(x,y,category) {

    $.ajax({
        type: 'GET',
        url: '/product/byPrice?minprice='+x+'&maxprice='+y+'&category='+category,
        success: function (orders) {

            if(orders==null||orders==""){
                alert("No product available in this range ! .");
            }
            else {

                $('#orders').empty();

                for (var order in orders) {
                    $('#orders').append('<div id="product' + orders[order].productid + '" class="col-sm-3 ' + orders[order].category +
                        '<p >Product Id: <b id="productid">' + orders[order].productid + '</b></p>' +
                        '<p>Name: ' + orders[order].productName + '</p>' +
                        '<p>Price: ' + orders[order].price + '</p>' +
                        '<p><button onclick="addtocart(' + orders[order].productid + ',1)">Add to Cart</button></p><br><br>' +
                        '</div>');
                }
            }
        },
        error: function (err) {
            console.log(err);
        }
    });

}


function fetchProductsbycategory(category){
    $.ajax({
        type: 'GET',
        url: '/product/bycategory?category='+category,
        success: function (orders) {

            if(orders==null||orders==""){
                alert("No product available in this range ! .");
            }
            else {

                for (var order in orders) {
                    $('#orders').append('<div id="product' + orders[order].productid + '" class="col-sm-3 ' + orders[order].category +
                        '<p >Product Id: <b id="productid">' + orders[order].productid + '</b></p>' +
                        '<p>Name: ' + orders[order].productName + '</p>' +
                        '<p>Price: ' + orders[order].price + '</p>' +
                        '<p><button onclick="addtocart(' + orders[order].productid + ',1)">Add to Cart</button></p><br><br>' +
                        '</div>');
                }
            }
        }
    });
}



function fetchProductsbynamelike(name){
    $.ajax({
        type: 'GET',
        url: '/product/bynamelike?namelike='+name,
        success: function (orders) {

            if(orders==null||orders==""){
                alert("No product available with this name .");
            }
            else{
                $('#orders').empty();

                for (var order in orders) {
                    $('#orders').append('<div id="product' + orders[order].productid + '" class="col-sm-3 ' + orders[order].category +
                        '<p >Product Id: <b id="productid">' + orders[order].productid + '</b></p>' +
                        '<p>Name: ' + orders[order].productName + '</p>' +
                        '<p>Price: ' + orders[order].price + '</p>' +
                        '<p><button onclick="addtocart('+orders[order].productid+',1)">Add to Cart</button></p><br><br>'+
                        '</div>');
                }
            }


        },
        error: function () {
            alert("No product with specified Name !");
        }
    });
}
