<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.carrinho.entidades.Artigo" %>
<%@ page import="com.carrinho.entidades.Comentario" %>
<%@ page import="com.carrinho.dao.DaoArtigo" %>
<%@ page import="com.carrinho.dao.DaoComentario" %>
<%@ page import="java.util.List" %>

<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.104.2">
  <script src="script.js"></script>
  <title>Artigo</title>

  <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/blog/">

  <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }

    .b-example-divider {
      height: 3rem;
      background-color: rgba(0, 0, 0, .1);
      border: solid rgba(0, 0, 0, .15);
      border-width: 1px 0;
      box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
    }

    .b-example-vr {
      flex-shrink: 0;
      width: 1.5rem;
      height: 100vh;
    }

    .bi {
      vertical-align: -.125em;
      fill: currentColor;
    }

    .nav-scroller {
      position: relative;
      z-index: 2;
      height: 2.75rem;
      overflow-y: hidden;
    }

    .nav-scroller .nav {
      display: flex;
      flex-wrap: nowrap;
      padding-bottom: 1rem;
      margin-top: -1px;
      overflow-x: auto;
      text-align: center;
      white-space: nowrap;
      -webkit-overflow-scrolling: touch;
    }

    .corpo {
         display: block;
         overflow: hidden;
         text-overflow: ellipsis;
         max-height: 25px;
         max-width: 150px;
    }

  </style>

  <!-- Custom styles for this template -->
  <link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="blog.css" rel="stylesheet">
</head>

<body onload="checarEstado()">

  <div class="container">
    <header class="blog-header lh-1 py-3">
      <div class="row flex-nowrap justify-content-between align-items-center">
        <div class="col-4 pt-1">
        </div>
        <div class="col-4 text-center">
          <a class="blog-header-logo text-dark" href="./home.jsp">Blog de Artigos e Comentários</a>
        </div>
        <div class="col-4 d-flex justify-content-end align-items-center">
          <a class="link-secondary" href="#" aria-label="Search">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor"
              stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="mx-3" role="img"
              viewBox="0 0 24 24">
              <title>Search</title>
              <circle cx="10.5" cy="10.5" r="7.5" />
              <path d="M21 21l-5.2-5.2" />
            </svg>
          </a>
          <a class="btn btn-sm btn-outline-secondary" href="./login.jsp">Login</a>
        </div>
      </div>
    </header>

    <div class="nav-scroller py-1 mb-2">
      <nav class="nav d-flex justify-content-between">
        <a class="p-2 link-secondary" href="./home.jsp">Home</a>
        <a class="p-2 link-secondary" href="./login.jsp">Login</a>
        <a class="p-2 link-secondary" href="./cadastrar.jsp">Cadastrar</a>
        <a class="p-2 link-secondary" href="./crudblog.jsp">Parte do Administrador</a>
      </nav>
    </div>
  </div>

  <main class="container">

    <%
        String idartigo = request.getParameter("idartigo");
        Artigo p = DaoArtigo.consultar(Integer.parseInt(idartigo));
    %>

    <div class="row g-5">
      <div class="col-md-12">
        <hr>
        <div class="col-12 text-center">
            <h1 class="blog-post-title mb-1">Artigo escolhido</h1>
        </div>
        <hr>

        <article class="blog-post">
          <%
            out.write("<h2>"+p.getTituloartigo()+"</h2>");
            out.write("<p class='card-text mb-auto'>"+p.getConteudoartigo()+"</p>");
          %>
          <hr>
          <h2>Comentários</h2>
          <%
              List<Comentario> lista2 = DaoComentario.consultarPorArtigo(p.getIdartigo());
              for(Comentario arti : lista2){
                if (arti.getAceito() != 0) {
                    out.write("<p class='card-text mb-auto'><hr>"+arti.getConteudocomentario()+"</p>");
                }
              }
          %>
        </article>
      </div>
    </div>

    <div class="col-12 text-center">
      <h2>Cadastro de Artigos</h2>
      <%
        out.write("<form class='mb-3 text-start' action='comentario.jsp?idartigo="+p.getIdartigo()+"' method='POST'>");
      %>
        <div class="mb-3">
          <label for="exampleFormControlTextarea1" class="form-label">Comentario</label>
          <textarea class="form-control" id="conteudocomentario" name="conteudocomentario" rows="3" disabled></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Comentar</button>
      </form>
    </div>

    <hr>
    <button class="btn btn-primary" onclick="checarEstado()">Checar se usuario está logado</button>
    <hr>

  </main>

  <footer class="blog-footer">
    <p>Rafa &copy; 2022</p>
    <p>
      <a href="#">Devolta para cima</a>
    </p>
  </footer>

  <%
         String conteudocomentario = request.getParameter("conteudocomentario");

         if(conteudocomentario != null){
              Comentario c = new Comentario(conteudocomentario, p.getIdartigo());
              String retorno = DaoComentario.salvar(c);
              response.sendRedirect("comentario.jsp?idartigo="+p.getIdartigo());
         }
  %>

</body>

</html>