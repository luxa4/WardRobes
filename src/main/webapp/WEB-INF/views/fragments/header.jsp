<header>
    <nav class="navbar navbar-light bg-light">
        <div class="logo">
            <a class="navbar-brand" href="<c:url value="/" />">
                Wardrobes <i class="fas fa-campground dark"></i>
            </a>
        </div>
        <div class="userPanel">
            <c:if test="${user != null}">
                <a href="" class="nav_link">${user.name} (${user.email})</a>
            </c:if>
                <span id="shoppingCartPanel" class="${shopping_cart == null ? 'hidden' : ''}">
                         <a id="shoppingCart" href="/shoppingCart" class="nav_link "><i class="fas fa-shopping-cart dark"></i> Cart (<span class="total-count">${shopping_cart.totalCount}</span>) </a>
                </span>
            <c:choose>
                <c:when test="${user == null}" >
                    <a href="/login" class="nav_link">Log
                        In</a>
                </c:when>
                <c:otherwise>
                    <spring:form action="/logout" method="post" class="userlogout">
                        <button type="submit" class="nav_link btn-link ">LogOut</button>
                    </spring:form>
                </c:otherwise>
            </c:choose>
        </div>
    </nav>
</header>
