<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.carrinho.dao.DaoArtigo" %>

<%
   String idartigo =  request.getParameter("idartigo");
   DaoArtigo.excluir(Integer.parseInt(idartigo));
   response.sendRedirect("crudblog.jsp");
%>