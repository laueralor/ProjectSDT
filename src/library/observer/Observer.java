package library.observer;

/**
 * Interfaz que define el comportamiento de los observadores. Obliga a cualquier clase interesada en recibir notificaciones 
 * (como Student) a implementar el método update.
 */

public interface Observer {
    void update(String message);
}