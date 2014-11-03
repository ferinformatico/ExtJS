
package model;


public class Persona {
    private String nombre;
    private String apellido;
    private String sexo;

    public Persona(String nombre, String apellido, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    
}
