<!DOCTYPE html>
<html>
    <head>
        <title>Demo</title>
        <meta charset="utf-8">

        <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/jquery-1.10.2.min.js"><\/script>')</script>
        <script src="http://code.jquery.com/mobile/1.4.0/jquery.mobile-1.4.0.min.js" type="text/javascript"></script>
        <script>$.mobile || document.write('<script src="js/jquery.mobile-1.4.0.min.js"><\/script>')</script>

        <script src="scripts/libs/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <script src="scripts/libs/jquery.steps-1.0.4.js"></script>
        <script src="scripts/libs/jquery.validate-1.11.1.min.js"></script>  

    </head>
    <body>
        <script>

            $(document).ready(function () {
                $("#wizard").steps();

                var wizard = $("#wizard").steps();
                wizard.steps("add", {
                    title: "HTML code", 
                    content: "This is a test"
                });
                wizard.steps("add", {
                    title: "HTML code2", 
                    content: "This is a test2"
                });                 
            });

        </script>
        <div id="wizard"></div>
    </body>
</html>