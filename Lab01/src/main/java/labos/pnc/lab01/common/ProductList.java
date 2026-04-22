package labos.pnc.lab01.common;

import labos.pnc.lab01.domain.model.BOW;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component //este es el que lo define como bean
public class ProductList {
    private final List<BOW> products;

    public ProductList() {
        this.products = new ArrayList<>();

        this.products.add(BOW.builder()
                .id(1L)
                .name("Laptop")
                .price(850.50)
                .build());

        this.products.add(BOW.builder()
                .id(2L)
                .name("Mouse")
                .price(19.99)
                .build());

        this.products.add(BOW.builder()
                .id(3L)
                .name("Teclado")
                .price(45.00)
                .build());

        this.products.add(BOW.builder()
                .id(4L)
                .name("Monitor")
                .price(199.90)
                .build());
    }

    public List<BOW> getProducts() {
        return products;
    }
}