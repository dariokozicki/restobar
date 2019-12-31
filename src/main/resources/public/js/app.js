function loadHTML($param){
    $("#header").load("/header.html");
    $("#footer").load("/footer.html");
}

$(document).ready(function() {
    loadHTML();
  });
