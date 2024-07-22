<%-- Created by IntelliJ IDEA. User: Abdul Moeed Date: 7/22/2024 Time: 9:37 AM --%>
<html>
<head>
    <title>Login Form</title>
    <style>
    .form-container {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        gap: 20px;
        padding: 20px;
    }
    form {
        display: flex;
        flex-direction: row;
        gap: 10px;
    }
    label, input, button {
        padding: 10px;
        margin: 5px;
        border-radius: 5px;
    }
    input, button {
        border: 1px solid #ccc;
    }
    .sub-button {
        background-color: green;
        color: white;
        cursor: pointer;
    }
    .sub-button:hover {
        background-color: #0056b3;
    }
    </style>
</head>
<body>
<div class="form-container">
    <form action="${createLink(controller: 'auth', action: 'signIn')}" method="post">
        <div>
            <label for="username">Username :</label>
            <g:textField name="username" id="username" required=""/>
        </div>
        <div>
            <label for="password">Password :</label>
            <g:passwordField name="password" id="password" required=""/>
        </div>
        <div>
            <g:submitButton class="sub-button" name="login" value="Login"/>
        </div>
    </form>
</div>
</body>
</html>