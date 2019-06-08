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
    	<h1><s:text name="title.checkout"></s:text></h1>
    	<!--  a href="${pageContext.request.contextPath}/shop/do_checkout">
    		<s:submit key="label.pay" />
    	</a -->
    </body>
    </html>
</jsp:root>
