<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="../css_styles/style_addemployee.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
    function validate_form( )
    {
        valid = true;

        if (document.addemployee.FIO.value == "" ||
                document.addemployee.Age.value == "" ||
                document.addemployee.Adress.value == "" ||
                document.addemployee.District.selectedIndex == 0 ||
                document.addemployee.Okrug.selectedIndex == 0 ||
                document.addemployee.Begin.value == "" ||
                document.addemployee.end.value == ""
                )
        {
            alert("Пожалуйста заполните все поля.");
            valid = false;
        }

        return valid;
    }
</script>
<%request.setCharacterEncoding("UTF-8");%>
<div class="sidebar1">
    <form action="main.jsp">
        <button class="add_button" type="submit" name="currentPage" value="1" >Назад к списку</button>
    </form> 
</div>



<div class="add">

    <div class ="head">
        <b>Введите данные нового сотрудника</b>
    </div>

    <form class="add_form" name="addemployee" action="newemployee.jsp" onsubmit="return validate_form( );" method="POST">
        <strong>Ф.И.О.:</strong> <input type="text" name="FIO" size="60" /> <br/>
        <strong>Возраст:</strong> <input type="text" name="Age" size="5" /><br/>
        <strong>Адрес:</strong> <input type="text" name="Adress" size="40"/> <br/>
        <strong>Район:</strong><select name="District">
            <option value="">Выберете</option>
            <option value="Мира">Мира</option>
            <option value="Октябрьский">Октябрьский</option>
            <option value="Вэй Ху Бина">Вэй Ху Бина</option>
        </select>
        <strong>Округ:</strong> <select name="Okrug">
            <option value="">Выберите</option>
            <option value="Затулинский">Затулинский</option>
            <option value="Зюзино">Зюзино</option>
            <option value="Лю Син">Лю Син</option>
        </select><br/>
        Время начала работы: <input type="time" name="Begin" /> <br/>
        Время окончания работы: <input type="time" name="end" /> <br/>

        <input class="add_button" type="submit" value="Добавить" />               
    </form>



</div>



