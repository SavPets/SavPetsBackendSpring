// Regex CEP
const inputCEP = document.getElementById("cep");

inputCEP.addEventListener("keypress", () => {
	const inputLength = inputCEP.value.length;
	
	if (inputLength === 5)
		inputCEP.value += "-";
})

// Regex CNPJ
const inputCNPJ = document.getElementById("cnpj");

inputCNPJ.addEventListener("keypress", () => {
	const inputLength = inputCNPJ.value.length;
	
	if (inputLength === 2)
		inputCNPJ.value += ".";
	if (inputLength === 6)
		inputCNPJ.value += ".";
	if (inputLength === 10)
		inputCNPJ.value += "/";	
	if (inputLength === 15)
		inputCNPJ.value += "-";	
})