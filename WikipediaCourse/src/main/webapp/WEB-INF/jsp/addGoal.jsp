<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Add Goal</title>
    <style type='text/css'>
      .error { color: red; }
      .errorblock { 
          color: black;
          background-color: #FFEEEE;
          border: 3px solid #FF0000;
          padding: 8px;
          margin: 16px;
      }
    </style>
  </head>

  <body>
    <form:form commandName="goal">
      <form:errors path="*" cssClass='errorblock' element='div'/>
      <table>
        <tr>
          <td>Enter minutes:</td>
          <td><form:input path="minutes" cssErrorClass="error"/></td>
          <td><form:errors path="minutes" cssClass="error"/></td>
        </tr>
        <tr>
          <td colspan='3'>
            <input type="submit" value="Enter goal minutes"/>
          </td>
        </tr>
      </table>
    </form:form>
  </body>
</html>