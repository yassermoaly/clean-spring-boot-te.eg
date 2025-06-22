package data.layer.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NameEnglish", nullable = false, length = 100)
    private String nameEnglish;

    @Column(name = "NameArabic", nullable = false, length = 100)
    private String nameArabic;

    @Column(name = "Visible", nullable = false)
    private boolean visible;

    // Constructors
    public City() {
    }

    public City(String nameEnglish, String nameArabic, boolean visible) {
        this.nameEnglish = nameEnglish;
        this.nameArabic = nameArabic;
        this.visible = visible;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getNameArabic() {
        return nameArabic;
    }

    public void setNameArabic(String nameArabic) {
        this.nameArabic = nameArabic;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
