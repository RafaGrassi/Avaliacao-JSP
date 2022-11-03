function autentificar() {
    sessionStorage.setItem('estado', 'logado');
    alert("Login efetuado com sucesso!");
    window.location.href = './home.jsp'
}


function checarEstado() {
    var data = sessionStorage.getItem('estado');
    if (data == 'logado') {
        console.log("Logado")
        document.getElementById("conteudocomentario").disabled = false;
    } else {
        console.log("Não logado")
    }
}

function administrador() {
    sessionStorage.setItem('admin', 'logado');
    alert("Login do administrador efetuado com sucesso!");
}


function checarAdm() {
    var data = sessionStorage.getItem('admin');
    if (data == 'logado') {
        console.log("Logado")
        document.getElementById("tituloartigo").disabled = false;
        document.getElementById("conteudoartigo").disabled = false;
        document.getElementById("botaocadastrar").disabled = false;

    } else {
        console.log("Não logado")
    }
}