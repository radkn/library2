<#--<#include "security.ftl">-->
<#import "login.ftl" as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Library</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedcontent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/books">Books</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user">User List</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="profile">Edit Profile</a>
            </li>

        </ul>
        <@l.logout/>
    </div>
</nav>