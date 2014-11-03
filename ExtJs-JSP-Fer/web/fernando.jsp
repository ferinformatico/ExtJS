<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Persona"%>
<%
    List<Persona> personas=new ArrayList();
    Persona p1=new Persona("maria","gonzales", "femenino");
    Persona p2=new Persona("juana","rodriguez", "palomino");
    personas.add(p1);
    personas.add(p2);
    Gson gson=new Gson();
    out.print(gson.toJson(personas));
    
    %>
