<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Список сотрудников:Вход</title>
        <link href="css_styles/style_index.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <div class="main">

            <div class="content">
                <p class="title"><span class="text"><img src="images/lib.jpg" width="330" height="185" hspace="10" vspace="10" align="middle"></span></p>
                <p class="title">Список сотрудников "ИТЦ Молнет"</p>              
                <p>&nbsp;</p>
            </div>

            <div class="login_div">
                <p class="title">Для входа введит логин и пароль:</p>
                <form class="login_form" name="username" action="Autentification" method="POST">
                    <table>
                        <tr>
                            <td>Логин:</td>
                            <td><input type="text" name="username" value="" size="20" /></td> 
                        </tr>
                        <tr>
                            <td>Пароль:</td>
                            <td><input type="password" name="password" value="" size="20" /><br/></td>
                        </tr>                                           
                    </table>
                    <input type="submit" value="Войти" /> 
                </form>

            </div>

            <div class="footer">
                Разработчик: Макаров К.Г.
            </div>
        </div>


    </body>
</html>
