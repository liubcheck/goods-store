package liubomyr.stepanenko.goodsstore.service;

import java.util.List;
import liubomyr.stepanenko.goodsstore.dto.CreateProductRequestDto;
import liubomyr.stepanenko.goodsstore.dto.ProductDto;

public interface ProductService {
    ProductDto create(CreateProductRequestDto requestDto);

    ProductDto findById(Long id);

    List<ProductDto> findAll();

    ProductDto update(Long id, CreateProductRequestDto requestDto);

    void delete(Long id);

    ProductDto makeOrder(Long id, Integer quantity);
}
