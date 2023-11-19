package uz.pdp.dataabsemigration.servie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public void getExcel(){
        List<Product> productList = repository.findAll();
                String filePath = "D:/Work/DataabseMigration/src/main/file.xlsx";
        try {
            ExcelWriter.writeProductsToExcel(productList, filePath);
            System.out.println("Excel file created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to Excel file: " + e.getMessage());
        }
    }


}
