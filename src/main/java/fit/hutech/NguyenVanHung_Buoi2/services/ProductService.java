package fit.hutech.NguyenVanHung_Buoi2.services;

import fit.hutech.NguyenVanHung_Buoi2.entities.Product;
import fit.hutech.NguyenVanHung_Buoi2.repositories.IProductRepository;
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
public class ProductService {

    private final IProductRepository productRepository;

    public List<Product> getAllProducts(Integer pageNo, Integer pageSize, String sortBy) {
        return productRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by(sortBy))).getContent();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(@NotNull Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        Objects.requireNonNull(existingProduct).setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setRom(product.getRom());
        existingProduct.setRam(product.getRam());
        existingProduct.setCpu(product.getCpu());
        existingProduct.setGpu(product.getGpu());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setEnabled(product.getEnabled());
        existingProduct.setCategory(product.getCategory());
        productRepository.save(existingProduct);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
