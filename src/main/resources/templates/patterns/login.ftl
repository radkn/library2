<#macro login path isRegisterForm>
    <form method="post" action="${path}">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Email:</label>
            <div class="col-sm-4">
                <input type="email" name="email"
                       value="<#if user??>${user.email}</#if>"
                       class="form-control  ${(emailError??)?string('is-invalid', '')}"
                       placeholder="email@mail.m"/>
                <#if emailError??>
                    <div class="invalid-feedback">
                        ${emailError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-4">
                <input type="password" name="password"
                       class="form-control ${(passwordError??)?string('is-invalid', '')}"
                       placeholder="Password"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <#if isRegisterForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Repeat password:</label>
                <div class="col-sm-4">
                    <input type="password" name="password2"
                           class="form-control ${(passwordError??)?string('is-invalid', '')}"
                           placeholder="Retype password"/>
                    <#if passwordError??>
                        <div class="invalid-feedback">
                            ${passwordError}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Your first name:</label>
                <div class="col-sm-4">
                    <input type="text"  name="first_name"
                           value="<#if user??>${user.first_name}</#if>"
                           class="form-control ${(first_nameError??)?string('is-invalid', '')}"
                           placeholder="First name"/>
                </div>
                <#if first_nameError??>
                    <div class="invalid-feedback">
                        ${first_nameError}
                    </div>
                </#if>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Surname:</label>
                <div class="col-sm-4">
                    <input type="text"  name="surname"
                           value="<#if user??>${user.surname}</#if>"
                           class="form-control ${(surnameError??)?string('is-invalid', '')}"
                           placeholder="Surname"/>
                </div>
                <#if surnameError??>
                    <div class="invalid-feedback">
                        ${surnameError}
                    </div>
                </#if>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Second name:</label>
                <div class="col-sm-4">
                    <input type="text"  name="second_name"
                           value="<#if user??>${user.second_name}</#if>"
                           class="form-control ${(second_nameError??)?string('is-invalid', '')}"
                           placeholder="Second name"/>
                </div>
                <#if second_nameError??>
                    <div class="invalid-feedback">
                        ${second_nameError}
                    </div>
                </#if>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Phone number:</label>
                <div class="col-sm-4">
                    <input type="tel" name="phone"
                           value="<#if user??>${user.phone}</#if>"
                           class="form-control ${(phoneError??)?string('is-invalid', '')}"
                           placeholder="+380XXXXXXXXX"/>
                </div>
                <#if phoneError??>
                    <div class="invalid-feedback">
                        ${phoneError}
                    </div>
                </#if>
            </div>
        </#if>
        <button class="btn btn-primary" type="submit"><#if isRegisterForm>Create<#else>Sign In</#if></button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <button class="btn btn-primary" type="submit">Sign out</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</#macro>