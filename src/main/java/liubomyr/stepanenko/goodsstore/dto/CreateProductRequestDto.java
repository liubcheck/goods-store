package liubomyr.stepanenko.goodsstore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateProductRequestDto {
    @NotBlank
    private String name;
    private String description;
    @Min(0)
    private BigDecimal price;
    @Min(0)
    private Integer quantity;
}
