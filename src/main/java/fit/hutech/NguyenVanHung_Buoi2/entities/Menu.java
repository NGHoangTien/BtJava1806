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
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "url", length = 255)
    private String url;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "menu_id")
    @ToString.Exclude
    private Menu parent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Menu menu = (Menu) o;
        return getMenuId() != null && Objects.equals(getMenuId(), menu.getMenuId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
