<?php
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/style-index.css">
</head>
<body>

<form name="login" id="login" action="../Controller/registracija.php" method="POST">
    <div class="labels" style="float: left;">
        <label for="name">Ime:</label><br />
        <label for="surname">Prezime:</label><br />
        <label for="email">E-mail:</label><br />
        <label for="username">Korisničko ime:</label><br />
        <label for="password1">Lozinka:</label><br />
        <label for="password2">Potvrdi lozinku:</label><br />
        <label for="date_of_birth">Datum rođenja:</label><br />
        <label for="weight">Težina</label><br />
        Izaberite spol:<br/>
        <input type="radio" name="gender"> Muški<br/>
        <input type="radio" name="gender"> Ženski<br/>
        <label for="city">Grad</label><br />
        <label for="oib">OIB</label><br />
        <label for="blood_type">Krvna grupa</label><br />
        <label for="institution">Institucija</label><br />
    </div>
    <div class="registration" style="float: left;">
        <input class="input" type="text" id="name" name="name" size="30" maxlength="15" placeholder="Upiši ime"><span id="nameError" class="error" ></span><br/>
        <input class="input" type="text" id="surname" name="surname" size="30" maxlength="30" placeholder="Upiši prezime"><span id="surnameError" class="error"></span><br/>
        <input class="input" type="email" id="email" name="email" size="30" maxlength="30" placeholder="Napiši email adresu"><span id="emailError" class="error"></span><br>
        <input class="input" type="text" id="username" name="username" size="30" maxlength="30" placeholder="Upiši korisničko ime"><span id="usernameError" class="error"></span><br/>
        <input class="input" type="password" name="password1" id="password1" size="30" maxlength="20" placeholder="Barem 6 znakova"><br>
        <input class="input" type="password" name="password2" id="password2" size="30" maxlength="20" placeholder="Ponovi lozinku"><br>
        <input class="input" type="date" name="date_of_birth" placeholder="DD.MM.GGGG" id="date_of_birth"><br /><br />
        <input class="input" type="number" id="weight" name="weight" size="30" maxlength="15" placeholder="Upiši težinu"><br/>
        <input class="input" type="text" id="city" name="city" size="30" maxlength="15" placeholder="Upiši grad"><br/>
        <input class="input" type="number" id="oib" name="oib" placeholder="Upiši OIB"><br/>
        <input class="input" type="number" id="blood_type" name="blood_type" placeholder="Upiši krvnu grupu"><br/>
        <input class="input" type="text" id="institution" name="institution" placeholder="Upiši ime institucije"><br/>
        <br /><input class="Button" name="submit" type="submit" value="Registriraj se">
    </div>
</form>

</body>
</html>