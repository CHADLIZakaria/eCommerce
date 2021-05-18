// Fix height navbar 
let upperNav = document.querySelector(".upper-nav"),
    body = document.body,
    html = document.documentElement,
    windowsHeight = Math.max(html.clientHeight, html.scrollHeight, html.offsetHeight),
    upperNavbar = document.querySelector(".upper-navbar").clientHeight,
    navbar = document.querySelector(".navbar").clientHeight;
upperNav.style.height = (windowsHeight - upperNavbar - navbar) + "px";

//Animation open & close menu
let listItemNavbar = document.querySelectorAll(".upper-nav li span"),
    openMenu = document.querySelector(".open-menu"),
    closeMenu = document.querySelector(".close-menu");

closeMenu.addEventListener("click", function click() {
    for (let i = 1; i < listItemNavbar.length; i++) {
        listItemNavbar[i].style.display = "none";
    }
    this.style.display = "none";
    openMenu.style.display = "inline";
})

openMenu.addEventListener("click", function click() {
    for (let i = 1; i < listItemNavbar.length; i++) {
        listItemNavbar[i].style.display = "inline";
    }
    this.style.display = "none";
    closeMenu.style.display = "flex";
})


//Show Password
let showPassword = document.querySelectorAll(".show-password");
showPassword.forEach(element => {
    element.addEventListener("mouseenter", function () {
        this.previousElementSibling.children[0].type = "text";
    })
    element.addEventListener("mouseleave", function () {
        this.previousElementSibling.children[0].type = "password";
    })
});

// Validation form
let inputNecessary = document.querySelectorAll(".necessary"),
    inputEmail = document.querySelector(".email"),
    inputPassword = document.querySelector(".password"),
    inputConfirmPassword = document.querySelector(".confirm-password");

inputNecessary.forEach(element => {
    element.addEventListener("blur", function () {
        changeBackgroundInput(this, this.value.length > 0, "Username is necessary")

    })
})
inputEmail.addEventListener("blur", function () {
    changeBackgroundInput(this, new RegExp("[a-zA-Z0-9.]+@(gmail|hotmail|live)+.(com|fr)").test(this.value), "email not valid")
})

inputPassword.addEventListener("blur", function () {
    changeBackgroundInput(this, inputPassword.value.length > 4, "password should have at less 5 caractere")
})


inputConfirmPassword.addEventListener("blur", function () {
    changeBackgroundInput(this, inputPassword.value == inputConfirmPassword.value, "password not match password confirm")
})

inputPassword.addEventListener("blur", function () {
    if (inputConfirmPassword.value.length > 0) {
        changeBackgroundInput(inputConfirmPassword, inputPassword.value == inputConfirmPassword.value, "")
    }

})

function changeBackgroundInput(input, condition, message) {
    if (condition == true) {
        input.style.boxShadow = "0 0 2px 2px #9ad3bc";
        input.style.border = "1px solid #9ad3bc";
        input.style.backgroundColor = "#e8f0fe";
        if (input.parentElement.nextElementSibling.tagName == "DIV") input.parentElement.nextElementSibling.innerHTML = "";
        else input.parentElement.nextElementSibling.nextElementSibling.innerHTML = ""
    }

    else {
        input.style.boxShadow = "rgb(234 143 154) 0px 0px 2px 2px";
        input.style.border = "1px solid rgb(234 143 154)";
        input.style.backgroundColor = "#fff";
        if (input.parentElement.nextElementSibling.tagName == "DIV") input.parentElement.nextElementSibling.innerHTML = message;
        else input.parentElement.nextElementSibling.nextElementSibling.innerHTML = message
    }

}