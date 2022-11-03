<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.carrinho.dao.DaoComentario" %>

<%
   String idcomentario =  request.getParameter("idcomentario");
   DaoComentario.aceitar(Integer.parseInt(idcomentario));
   response.sendRedirect("crudblog.jsp");
%>