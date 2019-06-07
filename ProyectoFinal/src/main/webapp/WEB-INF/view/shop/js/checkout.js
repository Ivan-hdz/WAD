Conekta.setPublicKey('key_GMQzrqrTG4sKiqZ6vvN3Gqw');
			
  let conektaSuccessResponseHandler = function(token) {
    let $form = $("#card-form");
    //Add the token_id in the form
     $form.append($('<input type="hidden" name="conektaTokenId" id="conektaTokenId">').val(token.id));
    $form.get(0).submit(); //Submit
  };
  let conektaErrorResponseHandler = function(response) {
    let $form = $("#card-form");
    $form.find(".card-errors").text(response.message_to_purchaser);
    $form.find("button").prop("disabled", false);
  };

  //jQuery generate the token on submit.
  $(function () {
    $("#card-form").submit(function(event) {
      let $form = $(this);
      // Prevents double clic
      $form.find("button").prop("disabled", true);
      Conekta.Token.create($form, conektaSuccessResponseHandler, conektaErrorResponseHandler);
      return false;
    });
  });