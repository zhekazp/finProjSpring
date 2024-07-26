package org.blb.service.rent.productServise;

import org.blb.DTO.appDTO.OneMessageDTO;
import org.blb.exeption.NotFoundException;
import org.blb.repository.rent.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class DeleteProductService {

    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<OneMessageDTO> deleteProduct(Long id) {

        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new ResponseEntity<>(new OneMessageDTO("Product deleted successfully"), HttpStatus.OK);
        } else {
            throw new NotFoundException("Product not found with id: " + id);
        }
    }
}
