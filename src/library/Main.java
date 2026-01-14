package library;

import library.core.*;
import library.factory.*;
import library.observer.*;
import library.strategy.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== University Library System - Milestone 2 ===\n");

        // 1. Demostración de SINGLETON
        LibraryInventory inventory = LibraryInventory.getInstance();

        // 2. Demostración de FACTORY METHOD
        MaterialFactory factory = new MaterialFactory();
        LibraryMaterial book1 = factory.createMaterial("BOOK", "Design Patterns: Elements of Reusable Object-Oriented Software");
        
        inventory.addMaterial(book1);
        inventory.showInventory();

        // 3. Demostración de OBSERVER
        // Creamos un libro físico y un estudiante interesado
        PhysicalBook physicalBook = (PhysicalBook) book1;
        Student student1 = new Student("Laura");

        System.out.println("\n[Action] Book is currently loaned. Student signs up for notification.");
        physicalBook.setAvailable(false);
        physicalBook.addObserver(student1);

        // 4. Demostración de STRATEGY
        System.out.println("\n[Action] Calculating fine for late return (5 days late)...");
        Loan loan = new Loan();
        
        // Aplicamos estrategia de Estudiante
        loan.setStrategy(new StudentPenalty());
        double studentFine = loan.finalizeReturn(5);
        System.out.println("Student Fine: " + studentFine + " EUR");

        // 5. Finalización (Activa el Observer)
        System.out.println("\n[Action] Returning book to library...");
        physicalBook.setAvailable(true); // Esto activará automáticamente la notificación para 'student1'
    }
}