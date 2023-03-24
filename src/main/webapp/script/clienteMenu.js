function aparecerSaque() {
	
	removerDeposito();
	removerTrans();
	
	let operacao = document.getElementById("operacao");
	
	let divSaque = document.createElement("div");
	divSaque.id = "divSaque";
	
	let formSaque = document.createElement("form");
	formSaque.action = "../ServletClienteSacar";
	formSaque.method = "post";
	
	let labelSaque = document.createElement("label");
	labelSaque.innerHTML = "Insira o valor do saque:";
	
	let boxSaque = document.createElement("input");
	boxSaque.type = "number";
	boxSaque.id = "valorSaque";
	boxSaque.name = "valorSaque";
	boxSaque.placeholder = "Valor do Saque";
	
	let botaoSaque = document.createElement("input");
	botaoSaque.type = "submit";
	
	operacao.body.appendChild(divSaque);
	
	divSaque.appendChild(formSaque);
	
	formSaque.appendChild(labelSaque + document.createElement("br"));
	formSaque.appendChild(boxSaque + document.createElement("br"));
	formSaque.appendChild(botaoSaque + document.createElement("br"));
}

function aparecerDeposito() {
	
	removerSaque();
	removerTrans();
	
	let operacao = document.getElementById("operacao");
	
	let divDeposito = document.createElement("div");
	divDeposito.id = "divDeposito";
	
	let formDeposito = document.createElement("form");
	formDeposito.action = "../ServletClienteDepositar";
	formDeposito.method = "post";
	
	let labelDeposito = document.createElement("label");
	labelDeposito.innerHTML = "Insira o valor do Deposito:";
	
	let boxDeposito = document.createElement("input");
	boxDeposito.type = "number";
	boxDeposito.id = "valorDeposito";
	boxDeposito.name = "valorDeposito";
	boxDeposito.placeholder = "Valor do Deposito";
	
	let botaoDeposito = document.createElement("input");
	botaoDeposito.type = "submit";
	
	operacao.body.appendChild(divDeposito);
	divDeposito.appendChild(formDeposito)
	formSaque.appendChild(labelDeposito + document.createElement("br"));
	formSaque.appendChild(boxDeposito + document.createElement("br"));
	formSaque.appendChild(botaoDeposito + document.createElement("br"));
}

function aparecerTranferencia() {
	
	removerSaque();
	removerDeposito();
	
	let operacao = document.getElementById("operacao");
	
	let divTrans = document.createElement("div");
	divTrans.id = "divTrans";
	
	let formTrans = document.createElement("form");
	formTrans.action = "../ServletClienteTransferir";
	formTrans.method = "post";
	
	let labelConta = document.createElement("label");
	labelConta.innerHTML = "Insira a conta:";
	
	let boxConta = document.createElement("input");
	boxConta.id = "numConta";
	boxConta.name = "numConta";
	boxConta.placeholder = "Número da Conta";
	
	let labelValor = document.createElement("label");
	labelValor.innerHTML = "Insira o valor da Transferência:";
	
	let boxValor = document.createElement("input");
	boxValor.type = "number";
	boxValor.id = "valorDeposito";
	boxValor.name = "valorDeposito";
	boxValor.placeholder = "Valor da Transferência";
	
	let botaoTrans = document.createElement("input");
	botaoTrans.type = "submit";
	
	operacao.body.appendChild(divTrans);
	divTrans.appendChild(formTrans);
	formTrans.appendChild(labelConta);
	formTrans.appendChild(boxConta + document.createElement("br"));
	formTrans.appendChild(labelValor);
	formTrans.appendChild(boxValor + document.createElement("br"));
	formTrans.appendChild(botaoTrans);
}

function removerSaque() {
	if (document.getElementById("divSaque")) {
		document.body.removeChild(document.getElementById("divSaque"));
	}
}

function removerDeposito() {
	if (document.getElementById("divDeposito")) {
		document.body.removeChild(document.getElementById("divDeposito"));
	}
}

function removerTrans() {
	if (document.getElementById("divTrans")) {
		document.body.removeChild(document.getElementById("divTrans"));
	}
}
