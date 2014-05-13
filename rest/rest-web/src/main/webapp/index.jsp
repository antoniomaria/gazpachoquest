<!DOCTYPE html>
<html>
<head>
  <title>Swagger UI</title>
  <link href='https://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'/>
  <link href='css/highlight.default.css' media='screen' rel='stylesheet' type='text/css'/>
  <link href='css/screen.css' media='screen' rel='stylesheet' type='text/css'/>
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
          if (secret == null){
        	  secret = "12345678";
          }
          this.secret = secret;
          
        }
        CustomAuthorization.prototype.apply = function(obj, authorizations) {
          var now = new Date().toUTCString();
          now = "Tue, 13 May 2014 20:10:38 +0200";
          var resource = obj.url.substring(obj.url.indexOf('api') + 3);
          var stringToSign = obj.method + ' ' + resource + '\n' + now;
          log("stringToSign " + stringToSign);
          var signature = CryptoJS.HmacSHA1(stringToSign, this.secret);
          var signatureBase64 = CryptoJS.enc.Base64.stringify(signature);
          log("signature " + signatureBase64);
          var authToken = "hmac " + this.apiKey + ":" + signature;
      	  // obj.headers["Date"] = "now";
          obj.headers["Authorization"] = authToken;
    	};
    	return CustomAuthorization;
     })();
      
    var secrets = new Array();
    
    secrets["PKCC00D3YH83KEP"] =  "L0LTMJ1XAMEY13FT27MWZMQX1LWK8I1L";
    secrets["TKIETCJZ3V6NOSM"] =  "IQO27YUZO8NJ7RADIK6SJ9BQZNYP4EMO";
    secrets["FGFQM8T6YPVSW4Q"] =  "39JYOYPWYR46R38OAOTVRZJMEXNJ46HL"; 
    secrets["WR7MZM016D4YXN5"] =  "ZBH1QL28VZEE00XHH7N4R16Q8ZRURU5P";
    secrets["HC00N1926K0ZKAF"] =  "EQSV5ARQY1LLHKDLO8EF9RMBKV9T95K5";
    
    $('#input_apiKey').change(function() {
      var key = $('#input_apiKey')[0].value;
      log("key: " + key);
      if(key && key.trim() != "") {
        log("added apiKey " + key);
        //var basicAuthToken = "Basic " + window.btoa("respondent:"+ key);
        //var hash = CryptoJS.HmacSHA1("Message", "Secret Passphrase");
        //alert(hash);
       // window.authorizations.add("key", new ApiKeyAuthorization("Authorization", gzqAuthToken, "header"));
        log("secret " + secrets[key]);
        window.authorizations.add("hmac_authorization", new CustomAuthorization(key, secrets[key]));
        //window.authorizations.add("key", new ApiKeyAuthorization("api_key", key, "query"));
        var now = new Date().toUTCString();
        window.authorizations.add("date", new ApiKeyAuthorization("Date", now, "header"));
      }
    })
    window.swaggerUi.load();
  });

  </script>
</head>

<body>
<div id='header'>
  <div class="swagger-ui-wrap">
    <a id="logo" href="http://swagger.wordnik.com">swagger</a>

    <form id='api_selector'>
      <div class='input icon-btn'>
        <img id="show-pet-store-icon" src="images/pet_store_api.png" title="Gazpacho Quest Apis">
      </div>
      <div class='input icon-btn'>
        <img id="show-wordnik-dev-icon" src="images/wordnik_api.png" title="Gazpacho Quest Apis">
      </div>
      <div class='input'><input placeholder="http://example.com/api" id="input_baseUrl" name="baseUrl" type="text"/></div>
      <div class='input'><input placeholder="api_key" id="input_apiKey" name="apiKey" type="text"/></div>
      <div class='input'><a id="explore" href="#">Explore</a></div>
    </form>
  </div>
</div>

<div id="message-bar" class="swagger-ui-wrap">
  &nbsp;
</div>

<div id="swagger-ui-container" class="swagger-ui-wrap">

</div>

</body>

</html>
