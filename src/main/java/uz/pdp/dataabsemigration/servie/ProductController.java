package uz.pdp.dataabsemigration.servie;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/excel")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public void get(){
        productService.getExcel();
    }
}
