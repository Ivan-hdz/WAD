<html>
<body>
<h2>Login!</h2>
<div id="alert" style="color: darkred">

</div>
<form action="Welcome" method="post">
    <div>
        <label for="username">Username: </label>
        <input type="text" id="username" name="username">
    </div>
    <div>
        <label for="password">Password: </label>
        <input type="password" id="password" name="password">
    </div>
    <button id="btn_send">Send</button>
</form>
<script>
    function findGetParameter(parameterName) {
        var result = null,
            tmp = [];
        location.search
            .substr(1)
            .split("&")
            .forEach(function (item) {
                tmp = item.split("=");
                if (tmp[0] === parameterName) result = decodeURIComponent(tmp[1]);
            });
        return result;
    }
    var alertDiv = document.getElementById('alert');
    alertDiv.innerHTML = findGetParameter('txt_alert');
</script>
</body>
</html>
