<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Bootstrap 4 Login/Register Form</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link rel="stylesheet" href="css/login.css">
    </head>
    <style>
        

.form-container {
    max-width: 400px; /* Maximum size of the container */
    margin: 0 auto; /* Center align the container */
    padding: 20px;
    border: 1px solid #ccc; /* Border for the container */
    border-radius: 5px; /* Rounded corners for the container */
}

.form-signup {
    text-align: center; /* Center align the content inside the form */
}

    </style>
    <body>

        <div class="form-container">
            <h1 >${requestScope.error}</h1>
            <form class="form-signup" action="signup" method="post">
                <h1 class="h3 mb-3 font-weight-normal">Sign up</h1>
                <input type="text" name="name" id="user-name" class="form-control" placeholder="Full name" required="" autofocus="">
                <input type="text" name="phone" id="phone_number" class="form-control" placeholder="Phone number" required="" autofocus="">
                <input type="text" name="address" id="address" class="form-control" placeholder="Address" required="" autofocus="">
                <input type="email" name="email" id="user-email" class="form-control" placeholder="Email address" required autofocus="">
                <input type="password" name="pass" id="user-pass" class="form-control" placeholder="Password" required autofocus="">
<!--                <input type="password" name="repeatname" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required autofocus="">-->
                <hr>
                <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Sign Up</button>
                <a href="login" id="cancel_signup"><i class="fas fa-angle-left"></i> Back</a>
                
            </form>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/login.js"></script>
    </body>
</html>
