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
