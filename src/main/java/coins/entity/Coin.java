package coins.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "coins")
@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "year")
    private int year;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "series_id")
    private Series series;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "metal_id")
    private Metal metal;

    @Column(name = "par")
    private int par;

    @Column(name = "mass")
    private int mass;

    @Column(name = "diametr")
    private int diametr;

    @Column(name = "rib")
    private String rib;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "quality_id")
    private Quality quality;

    @Column(name = "artist")
    private String artist;

    @Column(name = "sculptor")
    private String sculptor;

    @Column(name = "circulation")
    private int circulation;

    @Column(name = "price")
    private int price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private Details details;
}
