// =============== INITIAL SETTINGS ===============
window.addEventListener('scroll', onScroll)
const bodyElement = document.body

function onScroll() {

    const menu = document.querySelector('#header')
    const AlreadyHaveClass = menu.classList.contains('fixed-menu')

    if((scrollY >= 0) && (!AlreadyHaveClass)) {
        changeColorMenuOnScroll(menu)
    }

    if((scrollY <= 0) && (AlreadyHaveClass)){
        menu.classList.remove('fixed-menu')
    }
}

// =============== MENU ===============
// (function activeMenuOnCurrentPage(){
//     const page = `./${bodyElement.classList}.html`
//
//     const headerListOption = document.querySelector(`.header-list_option[href="${page}"]`)
//     if(headerListOption.textContent == 'Cadastre-se') {
//         headerListOption.classList.add('menu-active-btn')
//     }
//     headerListOption.classList.add('menu-active')
// })()

function changeColorMenuOnScroll(menu) {
    menu.classList.add('fixed-menu')
}

// =============== SCROLL REVEAL SETTINGS ===============
const scrollReveal = ScrollReveal({
    origin: 'left',
    distance: '40px',
    duration: '800',
    delay: 150
})

scrollReveal.reveal(`
    .presentation-container_welcome,
    .optionshelp-container_title,
    .optionshelp-group_card,
    .about-container,
    .difference-container_description,
    .difference-highlights_item,
    .start-container,
    .contact-container
`)

scrollReveal.reveal(`
    .container-main_content,
    .footer-container
`, {origin: 'top'})

const menuBurger = document.querySelector("div.burger.burger-slide")
const menuMobile = document.querySelector("div.menu-mobile")

menuBurger.addEventListener("click", () => {
   menuBurger.classList.toggle("open")
    menuMobile.classList.toggle("active-menu-mobile")
});