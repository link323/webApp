<html>
<form name="form" method="post" action="bmp.jsp">
<pre>
Enter Weight: <input type="text" name="weight">
Enter Height: <input type="text" name="height">
              <input type="submit" value="Find BMI">
</pre>
</form>
<%
String wt=request.getParameter("weight");
String ht=request.getParameter("height");

//double weight=Double.parseDouble(wt);;
//double height=Double.parseDouble(wt);

 // double w=weight*703;
  //double h=height*height;
  //double bmi = w/h;
  //out.println("BMI of weight "+weight+" and height "+height+" is: "+bmi);
  out.println("BMI of weight "+wt+" and height "+ht);
  %>
</html>