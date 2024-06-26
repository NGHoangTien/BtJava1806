package fit.hutech.NguyenVanHung_Buoi2.repositories;

import fit.hutech.NguyenVanHung_Buoi2.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMenuRepository extends JpaRepository<Menu, Long> {

}
