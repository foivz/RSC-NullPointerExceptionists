<?php
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/style-form.css">
</head>
<body>

<form name="login" id="login" action="../Controller/registracija.php" method="POST">
    <div class="label-input">
        <label for="name">Ime:</label>
        <input class="input" type="text" id="name" name="name" size="30" maxlength="15" placeholder="Upiši ime"><span id="nameError" class="error" ></span>
    </div>
    <div class="label-input">
        <label for="surname">Prezime:</label>
        <input class="input" type="text" id="surname" name="surname" size="30" maxlength="30" placeholder="Upiši prezime"><span id="surnameError" class="error"></span>
    </div>
    <div class="label-input">
        <label for="email">E-mail:</label>
        <input class="input" type="email" id="email" name="email" size="30" maxlength="30" placeholder="Napiši email adresu"><span id="emailError" class="error"></span><br>
    </div>
    <div class="label-input">
        <label for="username">Korisničko ime:</label>
        <input class="input" type="text" id="username" name="username" size="30" maxlength="30" placeholder="Upiši korisničko ime"><span id="usernameError" class="error"></span>
    </div>
    <div class="label-input">
        <label for="password1">Lozinka:</label>
        <input class="input" type="password" name="password1" id="password1" size="30" maxlength="20" placeholder="Barem 6 znakova"><br>
    </div>
    <div class="label-input">
        <label for="password2">Potvrdi lozinku:</label>
        <input class="input" type="password" name="password2" id="password2" size="30" maxlength="20" placeholder="Ponovi lozinku"><br>
    </div>
    <div class="label-input">
        <label for="date_of_birth">Datum rođenja:</label>
        <input class="input" type="date" name="date_of_birth" placeholder="DD.MM.GGGG" id="date_of_birth">
    </div>
    <div class="label-input">
        <label for="weight">Težina</label>
        <input class="input" type="number" id="weight" name="weight" size="30" maxlength="15" placeholder="Upiši težinu">
    </div>
    <div class="label-input">
        Izaberite spol:
        <input type="radio" name="gender"> Muški
        <input type="radio" name="gender"> Ženski
    </div>
    <div class="label-input">
        <label for="city">Grad</label>
        <input class="input" type="text" id="city" name="city" size="30" maxlength="15" placeholder="Upiši grad">
    </div>
    <div class="label-input">
        <label for="oib">OIB</label>
        <input class="input" type="number" id="oib" name="oib" placeholder="Upiši OIB">
    </div>
    <div class="label-input">
        <label for="blood_type">Krvna grupa</label>
        <input class="input" type="number" id="blood_type" name="blood_type" placeholder="Upiši krvnu grupu">
    </div>
    <div class="label-input">
        <label for="institution">Institucija</label>
        <input class="input" type="text" id="institution" name="institution" placeholder="Upiši ime institucije">
    </div>

    <div class="label-input">
        <input class="Button" name="submit" type="submit" value="Registriraj se">
        </div>
</form>

</body>
</html>