package library.factory;

/**
 * Clase encargada de la creación de objetos. Implementa el patrón Factory Method para centralizar la 
 * instanciación de materiales, permitiendo que el sistema crezca sin modificar el código que solicita los objetos.
 */

public class MaterialFactory {
    public LibraryMaterial createMaterial(String type, String title) {
        if (type.equalsIgnoreCase("BOOK")) {
            return new PhysicalBook(title);
        }
        // Aquí podríamos añadir "DIGITAL", "MAGAZINE", etc., en el futuro
        return null;
    }
}