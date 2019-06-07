<?xml  version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
          xmlns="http://www.w3.org/1999/xhtml"
          xmlns:s="/struts-tags"
          xmlns:c="http://java.sun.com/jsp/jstl/core"
          version="2.0">
    <jsp:directive.page  contentType="text/html; charset=UTF-8"/>
    <html>
    <head>
        <title><s:text name="title.cart" /></title>
    </head>
    <body>
    	<a  href="${pageContext.request.contextPath}/do_logout">
    		<s:submit key="label.logout" />
    	</a>
    	<a href="${pageContext.request.contextPath}/shop/home">
    		<s:submit key="label.goHome" />
    	</a>
    	<a href="${pageContext.request.contextPath}/shop/cart">
    		<s:submit key="label.goCart" />
    	</a>
    	
    	<h1>Checkout works</h1>
    	<s:actionmessage />
    	<s:actionerror />
    	<a href="${pageContext.request.contextPath}/shop/do_checkout">
    		<s:submit key="label.pay" />
    	</a>
    </body>
    </html>
</jsp:root>
