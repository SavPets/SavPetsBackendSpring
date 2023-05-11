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
(function activeMenuOnCurrentPage(){
    const page = `/${bodyElement.classList}`

    const headerListOption = document.querySelector(`.header-list_option[href="${page}"]`)
    if(headerListOption.textContent === 'Cadastre-se') {
        headerListOption.classList.add('menu-active-btn')
    }
    headerListOption.classList.add('menu-active')
})()

function changeColorMenuOnScroll(menu) {
    menu.classList.add('fixed-menu')
}