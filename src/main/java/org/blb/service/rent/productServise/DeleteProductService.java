package org.blb.service.rent.productServise;

import org.blb.exeption.NotFoundException;
import org.blb.repository.rent.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class DeleteProductService {

    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
        } else{
            throw new NotFoundException("Product not found with id: " + id);
        }
    }
}
