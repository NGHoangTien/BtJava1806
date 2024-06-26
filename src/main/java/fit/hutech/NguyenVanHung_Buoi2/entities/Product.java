package fit.hutech.NguyenVanHung_Buoi2.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "ROM", nullable = false)
    private Integer rom;

    @Column(name = "RAM", nullable = false)
    private Integer ram;

    @Column(name = "CPU", length = 100, nullable = false)
    private String cpu;

    @Column(name = "GPU", length = 100)
    private String gpu;

    @Column(name = "brand", length = 50, nullable = false)
    private String brand;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ToString.Exclude
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return getId() != null && Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
