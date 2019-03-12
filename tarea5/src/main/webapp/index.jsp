<html>
<body>
<h2>Tarea 5!</h2>
<h3>Sending dynamic parameters</h3>
<div>
    <label for="new_param_name"><h3>Nombre del parametro</h3></label>
    <input type="text" id="new_param_name">
    <button type="button" id="btn_add">Agregar parametro</button>
</div>
<div><hr></div>
<form action="ShowParams" method="post" id="myForm">
    <div id="form_body"></div>
    <div><input type='submit' value='Enviar'>
</form>
<script>
    var form_body = document.getElementById("form_body");
    var txt_param = document.getElementById("new_param_name");
    var btn_add = document.getElementById("btn_add");
    var no_items = 0;
    btn_add.addEventListener('click', function (ev) {
        form_body.innerHTML += "<div><label>" + txt_param.value + ": </label><input onkeyup='updateValue(this)' type='text' name='" + txt_param.value +"' id='" + txt_param.value + '_' + no_items.toString() +"' /></div><br>";
        no_items++;
    });
    function updateValue(ev) {
        document.getElementById(ev.id).setAttribute('value',ev.value);
    }
</script>
</body>
</html>
