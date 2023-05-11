// =============== MENU ===============
function setCurrentPage() {
    const page = `/${document.body.classList}`
    const currentPage = document.querySelector(`.header-content_menu a[href="${page}"]`)

    return currentPage
}

(function activeMenuOnCurrentPage() {
    const headerListOption = setCurrentPage()

    headerListOption.classList.add('menu-management-active')
})()

const burger = document.querySelector('.burger')
const headerContent = document.querySelector('.header-content')

burger.addEventListener('click', () => openMobileMenu(burger))

function openMobileMenu(burger) {
    burger.classList.toggle('open')
    headerContent.classList.toggle('side-menu--management-active')
}

// =============== TOP BAR ===============
(function createBreadCrumb() {
    const topBarPath = document.querySelector('.top-bar_path:first-child')
    const currentPage = setCurrentPage().textContent.trim()
    let newPath

    switch (currentPage) {
        case 'Cargos':
            newPath = '<a class="top-bar_path" href="/cargos">Cargos</a>'
            topBarPath.insertAdjacentHTML('afterend', newPath)
            break
        case 'Departamentos':
            newPath = '<a class="top-bar_path" href="/departamentos">Departamentos</a>'
            topBarPath.insertAdjacentHTML('afterend', newPath)
            break
        case 'Funcionários':
            newPath = '<a class="top-bar_path" href="/funcionarios">Funcionários</a>'
            topBarPath.insertAdjacentHTML('afterend', newPath)
            break
        case 'Clientes':
            newPath = '<a class="top-bar_path" href="/clientes">Clientes</a>'
            topBarPath.insertAdjacentHTML('afterend', newPath)
            break
        case 'Adoções':
            newPath = '<a class="top-bar_path" href="/adocoes">Adoções</a>'
            topBarPath.insertAdjacentHTML('afterend', newPath)
            break
        case 'Campanhas de adoção':
            newPath = '<a class="top-bar_path" href="/campanhas-adocao">Campanhas de adoção</a>'
            topBarPath.insertAdjacentHTML('afterend', newPath)
            break
        case 'Relatórios de animais':
            newPath = '<a class="top-bar_path" href="/relatorios-animais">Relatórios de animais</a>'
            topBarPath.insertAdjacentHTML('afterend', newPath)
            break
        case 'Categorias de animais':
            newPath = '<a class="top-bar_path" href="/categorias-animais">Categorias de animais</a>'
            topBarPath.insertAdjacentHTML('afterend', newPath)
            break
        case 'Medicamentos':
            newPath = '<a class="top-bar_path" href="/medicamentos">Medicamentos</a>'
            topBarPath.insertAdjacentHTML('afterend', newPath)
            break
        case 'Alimentos':
            newPath = '<a class="top-bar_path" href="/alimentos">Alimentos</a>'
            topBarPath.insertAdjacentHTML('afterend', newPath)
            break
        case 'Equipamentos':
            newPath = '<a class="top-bar_path" href="/equipamentos">Equipamentos</a>'
            topBarPath.insertAdjacentHTML('afterend', newPath)
            break
        case 'Fornecedores':
            newPath = '<a class="top-bar_path" href="/fornecedores">Fornecedores</a>'
            topBarPath.insertAdjacentHTML('afterend', newPath)
            break
    }
})()

// =============== SHOW USER SETTINGS =============== 
username.innerText = localStorage.getItem("username")
occupation.innerText = ""

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
				
                setTimeout(() => window.location.href = "/login", 3100)
                localStorage.removeItem("username")
				localStorage.removeItem("occupation")
            }
        })
    })
})

// =============== STATUS PAGE SETTINGS ===============
function showPageStatusModal(icon, title, text) {
    Swal.fire({
        title,
        text,
        icon,
        confirmButtonColor: '#a4cbe0'
    })
}

(function identifyPageStatus() {
    const urlParams = new URLSearchParams(window.location.search)
    const pageStatus = urlParams.get('status')
    let textStatus

    // Texto opcional passado pelo controller
    if (urlParams.has('text'))
        textStatus = urlParams.get('text').replace(/_/g, ' ')

    switch (pageStatus) {
        case 'Cadastrado':
            showPageStatusModal('success', pageStatus, 'Registro cadastrado com sucesso!')
            break
        case 'Atualizado':
            showPageStatusModal('success', pageStatus, 'Registro atualizado com sucesso!')
            break
        case 'Erro':
            showPageStatusModal('error', pageStatus, textStatus)
            break
    }  

    urlParams.delete('status')
    const newUrl = window.location.pathname
    history.replaceState(null, null, newUrl)
})();

// =============== ROUTE ACCESS CONTROLLER ===============
(function routeAccessControl() {
	if (localStorage.getItem("username") == null) {
		window.location.href = "/login?status=Erro&text=Realize_o_login!"
	}
})()