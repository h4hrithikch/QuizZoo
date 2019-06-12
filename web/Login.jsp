<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts1/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css1/style.css">
</head>
<body>

    <div class="main">

        <section class="signup">
            <!-- <img src="images1/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <form action="UserLogin" method="POST" >
                        <h2 class="form-title">Login</h2>
                        
                        <div class="form-group">
                            <input type="email" class="form-input" name="email" id="email" placeholder="Your Email"/>
                        </div>
                        
                        <div class="form-group">
                            <input type="password" class="form-input" name="upassword" id="upassword" placeholder="Password"/>
                        </div>
                        
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Login"/>
                        </div>
                    </form>
                         
                    <p class="loginhere">
                        Don't have Account ? <a href="Registration.jsp" class="loginhere-link">Register here</a>
                    </p>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="vendor1/jquery/jquery.min.js"></script>
    <script src="js1/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>