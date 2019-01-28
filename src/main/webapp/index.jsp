<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="menu.get" method="get">
    <input type="hidden" name="start" value="0"/>
    Выбрать парсер
    <select name="parser">
        <option>dom</option>
        <option>sax</option>
        <option>stax</option>
    </select><br/><br/>
    Выбрать язык
    <select name="SessionLocale">
        <option>ru_RU</option>
        <option>en_US</option>
    </select><br/>
<input type="submit" value="Открыть меню">
</form>
</body>
</html>
