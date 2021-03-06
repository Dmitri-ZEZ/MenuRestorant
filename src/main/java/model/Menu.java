package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "menu")
@ToString
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL)
    @OrderColumn
    @JoinColumn(name = "menu_id")
    private List<MenuItem> items = new ArrayList<>();

    public Menu(String title){
        this.title = title;
        this.date = LocalDate.now();

    }

    public void addItem(MenuItem item){
        items.add(item);
        //item.setMenu(this);
    }





}
