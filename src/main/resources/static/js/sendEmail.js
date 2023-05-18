const formContact = document.querySelector('.form')

$(document).ready((event) => {
    $(formContact).submit((event) => {
        event.preventDefault()
        // spinnerLoading.classList.add('active-loading')
        // document.body.classList.add('modal-active-body')
        console.log('Please wait...')

        const name = $('#name').val()
        const clientEmail = $('#email').val()
        const subject = $('#topic').val()
        const content = $('#message').val()

        $.ajax({
            url: '/api/v1/cadastros/enviar-email',
            type: 'POST',
            data: { name, clientEmail, subject, content },
            success: () => {
                // spinnerLoading.classList.remove('active-loading')
                // modalContact.classList.add('active-modal')
                alert('Enviado!')

                $('#name').val()
                $('#email').val()
                $('#topic').val()
                $('#message').val()
            }
        })
    })
})