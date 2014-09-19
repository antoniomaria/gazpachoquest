<!DOCTYPE html>
<html>
<head>
   <title>Swagger UI</title>
  <link href='https://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'/>
  <link href='css/reset.css' media='screen' rel='stylesheet' type='text/css'/>
  <link href='css/screen.css' media='screen' rel='stylesheet' type='text/css'/>
  <link href='css/reset.css' media='print' rel='stylesheet' type='text/css'/>
  <link href='css/screen.css' media='print' rel='stylesheet' type='text/css'/>
  <script type="text/javascript" src="lib/shred.bundle.js"></script>
  <script src='lib/jquery-1.8.0.min.js' type='text/javascript'></script>
  <script src='lib/jquery.slideto.min.js' type='text/javascript'></script>
  <script src='lib/jquery.wiggle.min.js' type='text/javascript'></script>
  <script src='lib/jquery.ba-bbq.min.js' type='text/javascript'></script>
  <script src='lib/handlebars-1.0.0.js' type='text/javascript'></script>
  <script src='lib/underscore-min.js' type='text/javascript'></script>
  <script src='lib/backbone-min.js' type='text/javascript'></script>
  <script src='lib/swagger.js' type='text/javascript'></script>
  <script src='swagger-ui.js' type='text/javascript'></script>
  <script src='lib/highlight.7.3.pack.js' type='text/javascript'></script>

  <!-- enabling this will enable oauth2 implicit scope support 
  <script src='lib/swagger-oauth.js' type='text/javascript'></script>
  -->
  
  <script src="crypto-js/rollups/hmac-sha1.js"></script>
  <script src="crypto-js/components/core-min.js"></script>
  <script src="crypto-js/components/enc-utf16-min.js"></script>
  <script src="crypto-js/components/enc-base64-min.js"></script>
  
  
  <script type="text/javascript">
  // http://localhost:8080/gazpachoquest-rest-web/api/api-docs
    $(function () {
      window.swaggerUi = new SwaggerUi({
      url: "<%= application.getAttribute("basePath").toString()%>/api/api-docs",
      dom_id: "swagger-ui-container",
      supportedSubmitMethods: ['get', 'post', 'put', 'delete'],
      onComplete: function(swaggerApi, swaggerUi){
        log("Loaded SwaggerUI")
        $('pre code').each(function(i, e) {hljs.highlightBlock(e)});
      },
      onFailure: function(data) {
        log("Unable to Load SwaggerUI");
      },
      docExpansion: "none"
    });

    CustomAuthorization = (function() {
      CustomAuthorization.prototype.apiKey = null;
      CustomAuthorization.prototype.secret = null;

        function CustomAuthorization(apiKey,secret) {
          this.apiKey = apiKey;
          this.secret = secret;
          
        }
        CustomAuthorization.prototype.apply = function(obj, authorizations) {
          var now = new Date().toUTCString();
          var resource = obj.url.substring(obj.url.indexOf('api') + 3);
          var stringToSign = obj.method + ' ' + resource;
          log("stringToSign " + stringToSign);
          var signature = CryptoJS.HmacSHA1(stringToSign, this.secret);
          var signatureBase64 = CryptoJS.enc.Base64.stringify(signature);
          log("signature " + signatureBase64);
          var authToken = "hmac " + this.apiKey + ":" + signatureBase64;
      	  // obj.headers["Date"] = "now"; // Date-Header can not be produced by XMLAjaxRequest 
          obj.headers["Authorization"] = authToken;
    	};
    	return CustomAuthorization;
     })();
      
    $('#input_apiKey').change(function() {
      var key = $('#input_apiKey')[0].value;
      log("key: " + key);
      if(key && key.trim() != "") {
        log("added apiKey " + key);
        var secret = "XXXX";
        var apiKey = "AAAAAA";
        if (key.split(':').length == 2){
        	secret = key.split(':')[1];
        	apiKey = key.split(':')[0];
        }
        log("apiKey" + apiKey);
        log("secret " + secret);
        window.authorizations.add("hmac_authorization", new CustomAuthorization(apiKey, secret));
        var now = new Date().toUTCString();
        window.authorizations.add("date", new ApiKeyAuthorization("Date", now, "header"));
      }
    })
    window.swaggerUi.load();
  });

  </script>
</head>

<body class="swagger-section">
<div id='header'>
  <div class="swagger-ui-wrap">
    <a id="logo" href="http://swagger.wordnik.com">swagger</a>
    <form id='api_selector'>
      <div class='input icon-btn'>
        <img id="show-pet-store-icon" src="images/pet_store_api.png" title="Show Swagger Petstore Example Apis">
      </div>
      <div class='input icon-btn'>
        <img id="show-wordnik-dev-icon" src="images/wordnik_api.png" title="Show Wordnik Developer Apis">
      </div>
      <div class='input'><input placeholder="http://example.com/api" id="input_baseUrl" name="baseUrl" type="text"/></div>
      <div class='input'><input placeholder="api_key:api_secret" id="input_apiKey" name="apiKey" type="text"/></div>
      <div class='input'><a id="explore" href="#">Explore</a></div>
    </form>
  </div>
</div>

<div id="message-bar" class="swagger-ui-wrap">&nbsp;</div>
<div id="swagger-ui-container" class="swagger-ui-wrap"></div>
</body>
</html>
