package library;
import java.util.ArrayList;
import java.util.List;

public class PhysicalBook implements LibraryMaterial {
    private String title;
    private boolean isAvailable;
    private List<Observer> waitingList = new ArrayList<>();

    public PhysicalBook(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public String getDetails() {
        return "Physical Book: " + title + " | Available: " + isAvailable;
    }

    public void addObserver(Observer observer) {
        waitingList.add(observer);
    }

    public void setAvailable(boolean status) {
        this.isAvailable = status;
        if (status) {
            notifyObservers();
        }
    }

    private void notifyObservers() {
        for (Observer obs : waitingList) {
            obs.update("The book '" + title + "' is now available for loan!");
        }
        waitingList.clear(); // Una vez avisados, limpiamos la lista
    }
}