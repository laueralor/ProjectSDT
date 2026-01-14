package library.factory;

public class MaterialFactory {
    public LibraryMaterial createMaterial(String type, String title) {
        if (type.equalsIgnoreCase("BOOK")) {
            return new PhysicalBook(title);
        }
        // Aquí podríamos añadir "DIGITAL", "MAGAZINE", etc., en el futuro
        return null;
    }
}