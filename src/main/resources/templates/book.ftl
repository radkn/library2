<#import "patterns/common.ftl" as c>

<@c.commonspage>
    <h1>Book</h1>
    <div class="form-group mt-3">
        <form action="/addbook" method="post">
            <div class="form-group">
                <input type="text" class="form-control mr-2 ${(titleError??)?string('is-invalid', '')}"
                            value="<#if book??>${book.title}</#if>" name="title" placeholder="Введите название книги"/>
                    <#if titleError??>
                        <div class="invalid-feedback">
                            ${titleError}
                        </div>
                    </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control mr-2 ${(descriptionError??)?string('is-invalid', '')}"
                       value="<#if book??>${book.description}</#if>" name="description" placeholder="Введите описание книги"/>
                <#if descriptionError??>
                    <div class="invalid-feedback">
                        ${descriptionError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control mr-2 ${(nameError??)?string('is-invalid', '')}"
                       value="<#if author??>${author.name}</#if>" name="name" placeholder="Введите имя автора"/>
                <#if nameError??>
                    <div class="invalid-feedback">
                        ${nameError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control mr-2 ${(surnameError??)?string('is-invalid', '')}"
                       value="<#if author??>${author.surname}</#if>" name="surname" placeholder="Введите фамилию автора"/>
                <#if surnameError??>
                    <div class="invalid-feedback">
                        ${surnameError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control mr-2 ${(second_nameError??)?string('is-invalid', '')}"
                       value="<#if author??>${author.second_name}</#if>" name="second_name" placeholder="Введите отчестрво автора"/>
                <#if second_nameError??>
                    <div class="invalid-feedback">
                        ${second_nameError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control mr-2 ${(tagError??)?string('is-invalid', '')}"
                       value="<#if tag??>${tag.second_name}</#if>" name="tag" placeholder="Введите отчестрво автора"/>
                <#if tagError??>
                    <div class="invalid-feedback">
                        ${tagError}
                    </div>
                </#if>
            </div>
            <input class="btn btn-primary" type="submit" value="Add book">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        </form>
    </div>
</@c.commonspage>