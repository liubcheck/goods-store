package liubomyr.stepanenko.goodsstore.mapper;

import liubomyr.stepanenko.goodsstore.dto.CreateProductRequestDto;
import liubomyr.stepanenko.goodsstore.dto.ProductDto;
import liubomyr.stepanenko.goodsstore.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toModel(CreateProductRequestDto dto) {
        Product product = new Product();
        setModelValues(product, dto);
        return product;
    }

    public void updateProductFromDto(CreateProductRequestDto dto, Product product) {
       setModelValues(product, dto);
    }

    public ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        return dto;
    }

    private void setModelValues(Product product, CreateProductRequestDto dto) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
    }
}
