package coins.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quality")
@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Quality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quality")
    private String quality;

    @Column(name = "quality_abb")
    private String quality_abb;

    @OneToMany(mappedBy = "quality",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Coin> coins;

    public void add(Coin coin) {
        if (coins == null) {
            coins = new ArrayList<Coin>();
        }
        coins.add(coin);
        coin.setQuality(this);
    }

}
