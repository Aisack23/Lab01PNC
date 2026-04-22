package labos.pnc.lab01.repository;

import labos.pnc.lab01.common.ProductList;
import labos.pnc.lab01.domain.model.BOW;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //es la capa de acceso a datos
@RequiredArgsConstructor
public class ProductRepository {
    private final ProductList productList;

    public List<BOW> findAll() {
        return productList.getProducts();  // Llama a getProducts()
    }
}