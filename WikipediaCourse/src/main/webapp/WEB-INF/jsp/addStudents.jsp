<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Add Students Page</title>
    
    <script type='text/javascript' src='//cdnjs.cloudflare.com/ajax/libs/jquery/1.10.2/jquery.js'></script>
    <script type='text/javascript'>
      $(document).ready(function() {
    	  $.getJSON('<spring:url value="activities.json"/>', {
    		  ajax : 'true'
    	  }, function(data) {
    		  var html = '<option value="">--Please select one--</option>';
    		  var len = data.length;
    		  for (var i = 0; i < len; ++i) {
    			  html += '<option value="' + data[i].desc + '">' + data[i].desc + "</option>";
    		  }
    		  
    		  $('#activities').html(html);
    	  });
      });
    </script>
  </head>
  <body>
    <h1>Add Students</h1>
  
    <p>
      Language: 
      <a href='?language=en'>english</a> |
      <a href='?language=zn'>chinese</a>
    </p>
  
    <!-- 
      The `exercise` name here causes this to be wired to an org.chrismaloney.model.Exercise 
      object, which gets bound to a specific instance as called out by the @ModelAttribute 
      annotation in the StudentsController.
    -->
    <form:form commandName="exercise">
      <table>
        <tr>
          <td><spring:message code='goal.text'/>:</td>
          <!-- 
            The `minutes` here is bound to an attribute of the Exercise object, and accessible
            with the getMinutes() getter.
          -->
          <td><form:input path="minutes"/></td>
          <td>
            <form:select id="activities" path="activity"></form:select>
          </td>
        </tr>
        <tr>
          <td colspan='2'>
            <input type='submit' value='Enter minutes'/>
          </td>
        </tr>
      </table>
    </form:form>
    
    <h1>Our goal for the day is ${goal.minutes}</h1>
  </body>
</html>