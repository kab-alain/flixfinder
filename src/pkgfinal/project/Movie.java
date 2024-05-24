package pkgfinal.project;

public class Movie {
    private String name;
    private int releaseYear;
    private double rate;
    private String description;
    private byte[] image;

    public Movie(String name, int releaseYear, double rate, String description, byte[] image) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.rate = rate;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRate() {
        return rate;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getImage() {
        return image;
    }
}