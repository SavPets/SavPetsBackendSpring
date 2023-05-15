// =============== BACK TO TOP ===============
const backToTop = document.querySelector('.back-to-top')
const scrollDown = document.querySelector('.scroll-down')

window.addEventListener('scroll', () => {
    if (scrollY > 600) {
        backToTop.classList.add('activate_scroll-top')
        scrollDown.classList.add('hide_scroll-down')
    } else {
        backToTop.classList.remove('activate_scroll-top')
        scrollDown.classList.remove('hide_scroll-down')
    }
})

// =============== SCROLL REVEAL SETTINGS ===============
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