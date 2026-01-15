package library.observer;

/**
 * Implementación concreta de un observador. Representa a un usuario de la biblioteca que se suscribe a las alertas 
 * de disponibilidad de un libro específico.
 */

public class Student implements Observer {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }
}