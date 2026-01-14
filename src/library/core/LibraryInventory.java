package library.core;

import java.util.ArrayList;
import java.util.List;
import library.factory.LibraryMaterial;

/**
 * Singleton Pattern: Ensures there's only one inventory instance 
 * for the entire university library.
 */
public class LibraryInventory {
    // La instancia única y estática
    private static LibraryInventory instance;
    private List<LibraryMaterial> materials;

    // El constructor es PRIVADO para que nadie pueda hacer "new LibraryInventory()"
    private LibraryInventory() {
        materials = new ArrayList<>();
    }

    // El método global para obtener la única instancia que existe
    public static LibraryInventory getInstance() {
        if (instance == null) {
            instance = new LibraryInventory();
        }
        return instance;
    }

    public void addMaterial(LibraryMaterial material) {
        materials.add(material);
        System.out.println("Added to inventory: " + material.getTitle());
    }

    public void showInventory() {
        System.out.println("\n--- Current Library Inventory ---");
        for (LibraryMaterial m : materials) {
            System.out.println(m.getDetails());
        }
    }
}