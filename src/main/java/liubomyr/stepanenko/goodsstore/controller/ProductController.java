package liubomyr.stepanenko.goodsstore.controller;

import jakarta.validation.Valid;
import java.util.List;
import liubomyr.stepanenko.goodsstore.dto.CreateProductRequestDto;
import liubomyr.stepanenko.goodsstore.dto.ProductDto;
import liubomyr.stepanenko.goodsstore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductDto createProduct(@Valid @RequestBody CreateProductRequestDto requestDto) {
        return productService.create(requestDto);
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping
    public List<ProductDto> findAllProducts() {
        return productService.findAll();
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id,
                                    @Valid @RequestBody CreateProductRequestDto requestDto) {
        return productService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "Product with id " + id + " is successfully deleted";
    }

    @PostMapping("/{id}")
    public String makeOrder(@PathVariable Long id, @RequestParam Integer quantity) {
        ProductDto soldProduct = productService.makeOrder(id, quantity);
        return "Order of " + soldProduct.getName() + " with quantity "
                + quantity + " was made";
    }
}
