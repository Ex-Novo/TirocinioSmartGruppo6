$(document).ready(function(){ 
  $.get("navbar.html", function(data) {
    $("#barra").html(data);
  });
}); 