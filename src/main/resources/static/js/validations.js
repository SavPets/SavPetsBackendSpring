const validator = new JustValidate('.form',
  {
    errorLabelStyle: {
      padding: '1rem 2rem',
      border: 'initials',
      color: 'var(--btn-red-color)',
      fontWeight: '600'
    }
  }
)

// adicione mais regras para cada campo que for necessário
const inputsRules = {
  name: [
    { rule: 'required', errorMessage: 'O campo nome é obrigatório' },
    { rule: 'minLength', value: 4, errorMessage: 'O campo nome deve conter no mínimo 4 caracteres' }
  ],
  initials: [
    { rule: 'required', errorMessage: 'O campo iniciais é obrigatório' },
    { rule: 'minLength', value: 2, errorMessage: 'O campo iniciais deve conter no mínimo 2 caracteres' },
    { rule: 'maxLength', value: 3, errorMessage: 'O campo iniciais deve conter no máximo 3 caracteres' }
  ],
  race: [
    { rule: 'required', errorMessage: 'O campo raça é obrigatório' },
    { rule: 'minLength', value: 3, errorMessage: 'O campo raça deve conter no mínimo 3 caracteres' }
  ],
  gender: [
    { rule: 'required', errorMessage: 'O campo sexo é obrigatório' },
    { rule: 'minLength', value: 3, errorMessage: 'O campo sexo deve conter no mínimo 3 caracteres' },
    { rule: 'maxLength', value: 9, errorMessage: 'O campo sexo deve conter no máximo 9 caracteres' }

  ],
   size: [
    { rule: 'required', errorMessage: 'O campo porte é obrigatório' },
    { rule: 'minLength', value: 1, errorMessage: 'O campo porte deve conter no mínimo 1 caracteres' }
  ],
   peltColor: [
    { rule: 'required', errorMessage: 'O campo cor é obrigatório' },
    { rule: 'minLength', value: 4, errorMessage: 'O campo cor deve conter no mínimo 3 caracteres' }

  ],
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
  	{ rule: 'required', errorMessage: 'O campo bula é obrigatório' }
  ],
  expirationDate:[
  	{ rule: 'required', errorMessage: 'O campo data de validade é obrigatório' }
  ],
  observation:[
  	{ rule: 'required', errorMessage: 'O campo observação é obrigatório' }
  ],
  arrivalDate:[
  	{ rule: 'required', errorMessage: 'O campo data de chegada é obrigatório' }
  ],
  amount:[
  	{ rule: 'required', errorMessage: 'O campo quantidade é obrigatório' }
  ],
  manufacturingDate:[
  	{ rule: 'required', errorMessage: 'O campo data de fabricação é obrigatório' }
  ],
  
}

function addFieldWithRules(fieldToAdd) {
  fieldToAdd.forEach(({ inputId, rules }) => {
    const fieldRules = rules.map(({ rule, value, errorMessage }) => ({
      rule,
      value,
      errorMessage
    }))

    validator.addField(`#${inputId}`, fieldRules)
  })
}

const existingInputsOnTheCurrentPage = document.querySelectorAll('input[id]')
existingInputsOnTheCurrentPage.forEach(input => {
  const inputId = input.getAttribute('id')
  const rulesForThisInput = inputsRules[inputId]

  if (rulesForThisInput)
    addFieldWithRules([{ inputId, rules: rulesForThisInput }])
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