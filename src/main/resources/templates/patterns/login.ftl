<#macro login path>
    <form method="post" action="${path}">
        <input type="text" name="username"/>
        <input type="password" name="password"/>
        <input type="submit" name="Sign In" value="Sign In"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <button class="btn btn-primary" type="submit">Sign out</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</#macro>