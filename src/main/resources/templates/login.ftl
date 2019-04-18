<#import "patterns/common.ftl" as c>
<#import "patterns/login.ftl" as l>

<@c.commonspage>
    ${message!}
    <@l.login "/login" false/>
    <a href="registration">Add User</a>
</@c.commonspage>