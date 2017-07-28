public class Persona {

    //FIELDS
    int edad;
    boolean genero;
    final static int numOfEyes = 2;

    //METHODS
    public Persona (int edad, boolean genero) {
       this.edad = edad;
       this.genero = genero;
    }

    public Persona (int edad) {
       this.edad = edad;
       this.genero = true;
    }

    public void eat (String comida) {
       Sytem.out.println("que rica " + comida + "que comi cuando tenia " + edad + "anios");
    }

    public int getAge () { return this.age; }

}
