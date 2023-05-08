const validator = new JustValidate('.form',
  {
    errorLabelStyle: {
      padding: '1rem 2rem',
      border: 'initials',
      color: 'var(--btn-red-color)',
      fontWeight: '600'
    },
    validateBeforeSubmitting: true,
  }
)

// adicione mais regras para cada campo que for necessário
const fieldsRules = {

  // REGRA PARA CAMPOS
  necessaryToSelect: [
    { rule: 'required', errorMessage: 'Selecione alguma opção' },
  ],
  necessaryToSelect2: [ // Para quando tiver mais de 1 select obrigatório na mesma página (provisório)
    { rule: 'required', errorMessage: 'Selecione alguma opção' },
  ],
	
  // REGRAS DE FORMULARIOS GERAIS
  name: [
    { rule: 'required', errorMessage: 'O campo nome é obrigatório' },
    { rule: 'minLength', value: 4, errorMessage: 'O campo nome deve conter no mínimo 4 caracteres' }
  ],
  cpf: [
    { rule: 'required', errorMessage: 'O campo CPF é obrigatório' },
    { rule: 'minLength', value: 14, errorMessage: 'O Campo CPF deve possuir todos os caracteres' },
    { rule: 'maxLength', value: 14, errorMessage: 'O Campo CPF deve possuir todos os caracteres' },
  ],
  firstName: [
    { rule: 'required', errorMessage: 'O campo de primeiro nome é obrigatório' },
    { rule: 'minLength', value: 2, errorMessage:  'O campo primeiro nome deve possuir no mínimo 2 caracteres' }
  ],
  lastName: [
    { rule: 'required', errorMessage: 'O campo de último nome é obrigatório' },
    { rule: 'minLength', value: 2, errorMessage:  'O campo último nome deve possuir no mínimo 2 caracteres' }
  ],
  cep: [
    { rule: 'required', errorMessage: 'O campo CEP é obrigatório' },
    { rule: 'minLength', value: 9, errorMessage: 'O campo CEP deve possuir todos os caracteres' },
    { rule: 'maxLength', value: 9, errorMessage: 'O campo CEP deve possuir todos os caracteres' },
  ],
  rua: [
    { rule: 'required', errorMessage: 'O campo endereço é obrigatório' },
    { rule: 'minLength', value: 5, errorMessage: 'O campo endereço deve possuir ao menos 5 caracteres'}
  ],
  locationNumber: [
    { rule: 'required', errorMessage: 'O campo número da residência é obrigatório' },
    { rule: 'minNumber', value: 1, errorMessage: 'Digite apenas o(s) número(s) da residência' }
  ],
  email: [
    { rule: 'required', errorMessage: 'O campo e-mail é obrigatório' },
    { rule: 'email', errorMessage: 'O campo e-mail deve possuir um e-mail válido' }
  ],
  	
  // REGRAS DO FORMULARIO DEPARTAMENTO
 
  initials: [
    { rule: 'required', errorMessage: 'O campo iniciais é obrigatório' },
    { rule: 'minLength', value: 2, errorMessage: 'O campo iniciais deve conter no mínimo 2 caracteres' },
    { rule: 'maxLength', value: 3, errorMessage: 'O campo iniciais deve conter no máximo 3 caracteres' }
  ],
  
  // REGRAS DO FORMULARIO CATEGORIA ANIMAL
  race: [
    { rule: 'required', errorMessage: 'O campo raça é obrigatório' },
    { rule: 'minLength', value: 3, errorMessage: 'O campo raça deve conter no mínimo 3 caracteres' }
  ],
  gender: [
    { rule: 'required', errorMessage: 'O campo gênero é obrigatório' },
    { rule: 'minLength', value: 3, errorMessage: 'O campo gênero deve conter no mínimo 3 caracteres' },
    { rule: 'maxLength', value: 9, errorMessage: 'O campo gênero deve conter no máximo 9 caracteres' }

  ],
   size: [
    { rule: 'required', errorMessage: 'O campo porte é obrigatório' },
    { rule: 'minLength', value: 1, errorMessage: 'O campo porte deve conter no mínimo 1 caracteres' }
  ],
   peltColor: [
    { rule: 'required', errorMessage: 'O campo cor é obrigatório' },
    { rule: 'minLength', value: 4, errorMessage: 'O campo cor deve conter no mínimo 3 caracteres' }
  ],
  
  // REGRAS DO FORMULARIO MEDICAMENTO
  description: [
 	{ rule: 'required', errorMessage: 'O campo descrição é obrigatório' },
 	{ rule: 'minLength', value: 10, errorMessage: 'O campo descrição deve conter no mínimo 10 caracteres' }
  ],
  utility: [
  	{ rule: 'required', errorMessage: 'O campo utilidade é obrigatório' }
  ],
  medicineName:[
  	{ rule: 'required', errorMessage: 'O campo nome do medicamento é obrigatório' }
  ],
  leaflet:[
  	{ rule: 'required', errorMessage: 'O campo bula é obrigatório' },
    { rule: 'minLength', value: 10, errorMessage: 'O campo bula deve conter no mínimo 10 caracteres' }
  ],
  expirationDate:[
  	{ rule: 'required', errorMessage: 'O campo data de validade é obrigatório' }
  ],
  arrivalDate:[
  	{ rule: 'required', errorMessage: 'O campo data de chegada é obrigatório' }
  ],
  amount:[
  	{ rule: 'required', errorMessage: 'O campo quantidade é obrigatório' },
  	{ rule: 'minNumber', value: 1, errorMessage: 'Digite apenas números para a quantidade' }
  ],
  manufacturingDate:[
  	{ rule: 'required', errorMessage: 'O campo data de fabricação é obrigatório' }
  ],
  
  // REGRAS DO FORMULARIO CAMPANHAS ADOCAO
  campaignDate:[
	  { rule: 'required', errorMessage: 'O campo data é obrigatório' }
  ],
  time: [
	  { rule: 'required', errorMessage: 'O campo horário é obrigatório' }
  ],
  duration: [
	  { rule: 'required', errorMessage: 'O campo duração é obrigatório' }
  ],
  
  // REGRAS DO FORMULARIO FUNCIONARIO
  accountNumber: [
	  { rule: 'required', errorMessage: 'O campo número da conta é obrigatório' },
	  { rule: 'minNumber', value: 1, errorMessage: 'Digite apenas os números da conta' }
  ],
  
  // REGRAS DO FORMULARIO RELATORIO ANIMAL
  local: [
    { rule: 'required', errorMessage: 'O campo local é obrigatório' },
    { rule: 'minLength', value: 5, errorMessage: 'O campo local deve possuir no mínimo 5 caracteres'}
  ],
  
  // REGRAS DO FORMULARIO CLIENTE
  telefone: [
    { rule: 'required', errorMessage: 'O campo telefone é obrigatório' },
    { rule: 'minLength', value: 14, errorMessage: 'O campo telefone deve possuir todos caracteres'},
    { rule: 'maxLength', value: 14, errorMessage: 'O campo telefone deve possuir todos caracteres'},
  ],
  surname: [
    { rule: 'required', errorMessage: 'O campo sobrenome é obrigatório' },
    { rule: 'minLength', value: 3, errorMessage: 'O campo sobrenome deve possuir no mínimo 3 caracteres' }
  ],
  
  // REGRAS DO FORMULARIO CADASTRO
  password: [
	{ rule: 'required', errorMessage: 'O campo senha é obrigatório' },
	{ rule: 'strongPassword', errorMessage: 'A senha deve conter pelo menos 8 dígitos, uma letra maiúscula, uma minúscula, um caractere especial e um número' }
  ],
  repeatPassword: [
	{ rule: 'required', errorMessage: 'O campo repetir senha é obrigatório' },
	{ rule: 'strongPassword', errorMessage: 'A senha deve conter pelo menos 8 dígitos, uma letra maiúscula, uma minúscula, um caractere especial e um número' }
  ],
  
  // REGRAS DO FORMULARIO FORNECEDOR
  provider: [
    { rule: 'required', errorMessage: 'O campo fornecedor é obrigatório' }
  ],
  cnpj: [
    { rule: 'required', errorMessage: 'O campo CNPJ é obrigatório' },
    { rule: 'minLength', value: 18, errorMessage: 'O campo CNPJ deve possuir todos os caracteres' },
    { rule: 'maxLength', value: 18, errorMessage: 'O campo CNPJ deve possuir todos os caracteres' },
  ]
}

function addFieldWithRules(fieldToAdd) {
  fieldToAdd.forEach(({ fieldId, rules }) => {
    const fieldRules = rules.map(({ rule, value, errorMessage }) => ({
      rule,
      value,
      errorMessage
    }))

    validator.addField(`#${fieldId}`, fieldRules)
  })
}

const existingFieldsOnTheCurrentPage = document.querySelectorAll('input[id], select[id]')
existingFieldsOnTheCurrentPage.forEach(field => {
  const fieldId = field.getAttribute('id')
  const rulesForThisField = fieldsRules[fieldId]

  if (rulesForThisField)
    addFieldWithRules([{ fieldId, rules: rulesForThisField }])
})

validator.onSuccess((event) => {
  const inputSubmit = document.querySelector('input.btn')
  const numFields = Object.values(validator.fields).length
  let validFields = 0

  for (let fieldName in validator.fields) {
    const fieldsHasContent = validator.fields[fieldName].elem.value != ''
    const inputSubmitHasAttribute = inputSubmit.hasAttribute('data-just-validate-fallback-disabled')

    if (fieldsHasContent && inputSubmitHasAttribute)
      validFields++
  }

  if (numFields === validFields)
    event.target.submit()
})