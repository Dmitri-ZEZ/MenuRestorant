package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Integer fat;
    private Integer calories;
    private Integer carbohydrates;
    private Integer protein;

    //@ManyToOne
    //@JoinColumn(name = "menu_id")
    //private Menu menu;

    public MenuItem(String name, Double price, Integer fat, Integer calories, Integer carbohydrates, Integer protein) {
        this.name = name;
        this.price = price;
        this.fat = fat;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
    }
}
