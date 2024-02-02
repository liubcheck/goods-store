package liubomyr.stepanenko.goodsstore.service.impl;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import liubomyr.stepanenko.goodsstore.dto.CreateProductRequestDto;
import liubomyr.stepanenko.goodsstore.dto.ProductDto;
import liubomyr.stepanenko.goodsstore.exception.ProductQuantityException;
import liubomyr.stepanenko.goodsstore.mapper.ProductMapper;
import liubomyr.stepanenko.goodsstore.model.Product;
import liubomyr.stepanenko.goodsstore.repository.ProductRepository;
import liubomyr.stepanenko.goodsstore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto create(CreateProductRequestDto requestDto) {
        Product product = productMapper.toModel(requestDto);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find the product by ID = " + id)
        );
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductDto update(Long id, CreateProductRequestDto requestDto) {
        Product productForUpdate = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find the category with id = " + id)
        );
        productMapper.updateProductFromDto(requestDto, productForUpdate);
        Product updatedProduct = productRepository.save(productForUpdate);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto makeOrder(Long id, Integer quantity) {
        if (quantity < 0) {
            throw new ProductQuantityException("Negative quantity is invalid: " + quantity);
        }
        Product productForOrder = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find the category with id = " + id)
        );
        int productQuantity = productForOrder.getQuantity();
        int finalQuantity = productQuantity - quantity;
        if (productQuantity == 0 || finalQuantity < 0) {
            throw new ProductQuantityException("There's no product available for your quantity: "
                    + quantity);
        }
        productForOrder.setQuantity(finalQuantity);
        return productMapper.toDto(productRepository.save(productForOrder));
    }
}
