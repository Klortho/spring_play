<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Add Goal</title>
  </head>

  <body>
    <form:form commandName="goal">
      <table>
        <tr>
          <td>Enter minutes:</td>
          <td><form:input path="minutes"/></td>
        </tr>
        <tr>
          <td colspan='2'>
            <input type="submit" value="Enter goal minutes"/>
          </td>
        </tr>
      </table>
    </form:form>
  </body>
</html>