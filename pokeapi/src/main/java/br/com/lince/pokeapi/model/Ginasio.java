package br.com.lince.pokeapi.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ginasios")
public class Ginasio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 100, unique = true)
    private String  trainer;
    @Column(nullable = false, length = 50)
    private String pokemon;
    @Column(nullable = false, length = 50)
    private String badge;
    
    public String getTrainer() {
        return trainer;
    }
    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }
    public String getPokemon() {
        return pokemon;
    }
    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }
    public String getBadge() {
        return badge;
    }
    public void setBadge(String badge) {
        this.badge = badge;
    }

}
