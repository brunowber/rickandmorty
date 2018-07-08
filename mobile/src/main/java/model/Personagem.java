package model;

public class Personagem {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String gender;
    private String image;
    private String origin;
    private String type;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin;}

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String toString(){
        return "Nome: "+ getName()
                +"\nCondição: "+getStatus()
                +"\nEspécie: "+getSpecies()
                +"\nGênero: "+getGender()
                +"\nOrigem: "+getOrigin()
                +"\nTipo: "+getType();
    }
}
