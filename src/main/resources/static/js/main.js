// =============== INITIAL SETTINGS ===============
window.addEventListener('scroll', onScroll)
const bodyElement = document.body

function onScroll() {

    const menu = document.querySelector('#header')
    const AlreadyHaveClass = menu.classList.contains('fixed-menu')

    const accessibilityBar = document.querySelector('.accessibility.content')

    if((scrollY >= 0) && (!AlreadyHaveClass)) {
        changeColorMenuOnScroll(menu, accessibilityBar)
    }

    if((scrollY <= 0) && (AlreadyHaveClass)){
        menu.classList.remove('fixed-menu')
        accessibilityBar.classList.remove('to-hide')
    }
}

// =============== MENU ===============
(function activeMenuOnCurrentPage(){
    let page = `/${bodyElement.classList}`
    page = page.replace('contrast', '')

    const headerListOption = document.querySelector(`.header-list_option[href="${page}"]`)
    if(headerListOption.textContent === 'Cadastre-se') {
        headerListOption.classList.add('menu-active-btn')
    }
    headerListOption.classList.add('menu-active')
})()

function changeColorMenuOnScroll(menu, accessibilityBar) {
    menu.classList.add('fixed-menu')
    accessibilityBar.classList.add('to-hide')
}