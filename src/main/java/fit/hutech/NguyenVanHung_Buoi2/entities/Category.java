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
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private Long cateId;

    @Column(name = "cate_name", length = 100, nullable = false)
    private String cateName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return getCateId() != null && Objects.equals(getCateId(), category.getCateId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
