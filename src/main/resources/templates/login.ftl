<#import "patterns/common.ftl" as c>
<#import "patterns/login.ftl" as l>

<@c.commonspage>
    <@l.login "/login"/>
    <a href="registration.ftl">Add User</a>
</@c.commonspage>