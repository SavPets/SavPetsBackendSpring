// Regex CPF
const inputCPF = document.getElementById("cpf");

inputCPF.addEventListener("keypress", () => {
	const inputLength = inputCPF.value.length;
	
	if (inputLength === 3 || inputLength === 7)
		inputCPF.value += ".";
		
	if (inputLength === 11)
		inputCPF.value += "-";
})

// Regex Telefone
const inputTelefone = document.getElementById("telefone");

inputTelefone.addEventListener("keypress", () => {
	const inputLength = inputTelefone.value.length;
	
	if (inputLength === 0)
		inputTelefone.value += "(";
		
	if (inputLength === 3)
		inputTelefone.value += ")";
		
	if (inputLength === 4)
		inputTelefone.value += " ";
		
	if (inputLength === 9)
		inputTelefone.value += "-";
})

// Regex CEP
const inputCEP = document.getElementById("cep");

inputCEP.addEventListener("keypress", () => {
	const inputLength = inputTelefone.value.length;
	
	if (inputLength === 6)
		inputCEP.value += "-"
})
