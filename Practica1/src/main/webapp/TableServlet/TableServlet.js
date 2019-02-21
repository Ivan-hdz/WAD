
var btn_save = document.getElementById("btn_save");

document.getElementById("confPassword").addEventListener('keyup', function (evt) {
    var pass = document.getElementById("password").value;
    var cPass = document.getElementById("confPassword").value;
    if(pass !== cPass) {
        btn_save.disabled = true;
    } else {
        btn_save.disabled = false
    }
});