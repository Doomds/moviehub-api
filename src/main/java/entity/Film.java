package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private long id;

    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "release_year", nullable = true)
    private int releaseYear;

    public Film() {
    }

    public Film(String title, String description, int releaseYear) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", Title='" + title + '\'' +
                ", Description=" + description +
                ", Release Year=" + releaseYear +
                '}';
    }
}
