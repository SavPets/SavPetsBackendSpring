// =============== MENU ===============
(function activeMenuOnCurrentPage() {
    const page = `/${document.body.classList}`
    const headerListOption = document.querySelector(`.header-content_menu a[href="${page}"]`)

    headerListOption.classList.add('menu-management-active')
})()

const burger = document.querySelector('.burger')
const headerContent = document.querySelector('.header-content')

burger.addEventListener('click', () => openMobileMenu(burger))

function openMobileMenu(burger) {
    burger.classList.toggle('open')
    headerContent.classList.toggle('side-menu--management-active')
}

// =============== QUIT OPTIONS SETTINGS ===============
const quitOption = document.querySelectorAll('.option-quit')

quitOption.forEach(option => {
    option.addEventListener('click', (event) => {
        event.preventDefault()
        Swal.fire({
            title: 'Atenção',
            text: "Você deseja sair da sessão?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#a4cbe0',
            cancelButtonColor: '#ff7575',
            cancelButtonText: 'Cancelar',
            confirmButtonText: 'Sim, sair!'
        }).then((result) => {
            if (result.isConfirmed) {
                const Toast = Swal.mixin({
                    toast: true,
                    position: 'top-end',
                    showConfirmButton: false,
                    timer: 3000,
                    timerProgressBar: true,
                    didOpen: (toast) => {
                        toast.addEventListener('mouseenter', Swal.stopTimer)
                        toast.addEventListener('mouseleave', Swal.resumeTimer)
                    }
                })
                Toast.fire({
                    icon: 'warning',
                    title: 'Saindo da sessão'
                })

                setTimeout(() => window.location.href = "/", 3100)
            }
        })
    })
})

// =============== DATATABLES SETTINGS ===============
$(document).ready(function () {
    $('#example').DataTable({
        responsive: true,
        language: {
            "url": "//cdn.datatables.net/plug-ins/1.10.22/i18n/Portuguese-Brasil.json"
        }
    });
});

// =============== ACTIONS TABLE SETTINGS ===============
function executeDeleteMethod() {
    const deleteBtn = document.querySelectorAll('.column-action_delete a')

    let url = deleteBtn[0].href.split('/')
    url = url.filter(Boolean)[2]  // 0º(http)://1º(host)/2º(objective)/3º(id)
    url = '/' + url

    const id = deleteBtn[0].href.charAt(deleteBtn[0].href.length - 1)

    window.location.href = `${url}/${id}`
}

function showDeleteConfirmationModal() {
    Swal.fire({
        title: 'Tem certeza?',
        text: "Você não poderá reverter isso!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#a4cbe0',
        cancelButtonColor: '#ff7575',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Sim, deletar!'
    }).then((result) => {
        if (result.isConfirmed) {      
            Swal.fire(
                'Deletado!',
                'Registro apagado com sucesso.',
                'success'
            )

            executeDeleteMethod()
        }
    })
}