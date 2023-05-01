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
  nome: [
    { rule: 'required', errorMessage: 'O campo nome é obrigatório' },
    { rule: 'minLength', value: 4, errorMessage: 'O campo nome deve conter no mínimo 4 caracteres' }
  ],
  iniciais: [
    { rule: 'required', errorMessage: 'O campo iniciais é obrigatório' },
    { rule: 'minLength', value: 2, errorMessage: 'O campo iniciais deve conter no mínimo 2 caracteres' },
    { rule: 'maxLength', value: 3, errorMessage: 'O campo iniciais deve conter no máximo 3 caracteres' }
  ],
  raca: [
    { rule: 'required', errorMessage: 'O campo raça é obrigatório' },
    { rule: 'minLength', value: 3, errorMessage: 'O campo raça deve conter no mínimo 3 caracteres' }
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