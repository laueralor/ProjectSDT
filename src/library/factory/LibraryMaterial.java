package library.factory;

/**
 * Interfaz base para todos los materiales de la biblioteca. 
 * Define el contrato común (métodos getDetails y getTitle) que deben seguir tanto libros como revistas o 
 * cualquier otro recurso futuro.
**/
public interface LibraryMaterial {
    String getDetails();
    String getTitle();
}