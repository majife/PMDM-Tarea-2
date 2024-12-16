package jimenez.fernandez.manueljesus.pmdmtarea2;

public class GameData {

    private final String image;
    private final String name;
    private final String description;
    private final String abilities;

    public GameData(String image, String name, String description, String abilities) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.abilities = abilities;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAbilities() {
        return abilities;
    }
}