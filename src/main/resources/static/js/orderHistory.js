$(document).ready(function(){
    fetchProducts();
});
function fetchProducts(){
    $.ajax({
        type: 'GET',
        url: '/orderHistory',
        success: function (orders) {

            for (var order in orders) {
                 $('#table tbody').append("<tr><td class='text-center' style='margin-top: 100px' ><b><u>"+(order)+"</u></b></td><td></td><td></td><td></td><td></td><td class='text-center'><b><u>"+orders[order].amount+"</td><td class='text-center'><b><u>"+orders[order].user.address+"</u></b></td></tr>");
                for (var cart in orders[order].cartItems) {
                    $('#table tbody').append('<tr><td></td><td class=\'text-center\'>'+orders[order].cartItems[cart].product.productName+'</td><td class=\'text-center\'>'+orders[order].cartItems[cart].product.price+'</td><td class=\'text-center\'>'+orders[order].cartItems[cart].quantity+'</td><td class=\'text-center\'>'+(orders[order].cartItems[cart].quantity * orders[order].cartItems[cart].product.price)+'</td></tr><tr><td></td></tr><tr></tr>');
                }
            }
        }
    });
}