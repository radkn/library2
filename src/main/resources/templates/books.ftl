<#import "patterns/common.ftl" as c>

<@c.commonspage>
    <h1>Book list</h1>
    <form action="/addbook" method="get">
        <button class="btn btn-primary" type="submit">New Book</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>

    <div class="card-deck">
        <#list books as book>
            <div class="col-sm-4">
                <div class="card m-2 text-primary border-primary">
                    <div class="card-header"><i>${book.title}</i></div>
                    <div>
                        <#if book.title??>
                            <img class="card-img-top" src="/img/${book.title}">
                        </#if>
                    </div>
                    <div class="card-footer text-muted">
                        <div class="text-right">
                            <#list book.authors as author>
                                ${author.name} ${author.surname} <#if author.second_name??>${author.second_name}</#if>
                            <#else >
                                [Any tag]
                            </#list>
                        </div>
                        <div class="text-left">
                            <span class="card-text ml-3">
                            <#list book.tags as tag>
                                ${tag.tag.toUpperCase()}
                            <#else >
                                [Any tag]
                            </#list>
                        </span>
                        </div>
                    </div>
                </div>
            </div>
        <#else >

            No Message
        </#list>
    </div>

</@c.commonspage>