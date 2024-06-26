package fit.hutech.NguyenVanHung_Buoi2.services;

import fit.hutech.NguyenVanHung_Buoi2.entities.Menu;
import fit.hutech.NguyenVanHung_Buoi2.repositories.IMenuRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = {Exception.class, Throwable.class})
public class MenuService {

    private final IMenuRepository menuRepository;

    public List<Menu> getAllMenus(Integer pageNo, Integer pageSize, String sortBy) {
        return menuRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by(sortBy))).getContent();
    }

    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }

    public void addMenu(Menu menu) {
        menuRepository.save(menu);
    }

    public void updateMenu(@NotNull Menu menu) {
        Menu existingMenu = menuRepository.findById(menu.getMenuId()).orElse(null);
        Objects.requireNonNull(existingMenu).setName(menu.getName());
        existingMenu.setUrl(menu.getUrl());
        existingMenu.setEnabled(menu.getEnabled());
        existingMenu.setParent(menu.getParent());
        menuRepository.save(existingMenu);
    }

    public void deleteMenuById(Long id) {
        menuRepository.deleteById(id);
    }
}
