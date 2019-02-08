function addProduct() {
    var pname = document.getElementById("productname").value;
    var pcat  = document.getElementById("productcategory").value;
    var price  = document.getElementById("productprice").value;

    $.ajax({
        type: 'POST',
        url: '/product/add?productname='+pname+'&category='+pcat+'&price='+price,
        success: function () {
          alert("Product added to Product list");
          window.location="adminpage.html";
        },
        error: function () {
            alert("Product already exists !");
        }
    });

}