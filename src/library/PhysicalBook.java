package library;

public class PhysicalBook implements LibraryMaterial {
    private String title;
    private boolean isAvailable;

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

    public void setAvailable(boolean status) {
        this.isAvailable = status;
    }
}