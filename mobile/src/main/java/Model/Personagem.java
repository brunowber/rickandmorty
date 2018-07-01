package Model;

public class Personagem {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String gender;

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

    public String toString(){
        return "Nome: "+ getName()
                +"\nCondição: "+getStatus()
                +"\nEspécie: "+getSpecies()
                +"\nGênero: "+getGender();
    }
}
