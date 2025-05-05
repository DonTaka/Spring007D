package com.example.Spring007D.Service;

import com.example.Spring007D.Model.Product;
import com.example.Spring007D.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public String getProducts() {
        String output = "";
        for (Product product : productRepository.findAll()) {
            output += "ID Product: " + product.getId() + "\n";
            output += "Name: " + product.getName() + "\n";
            output += "Description: " + product.getDescription() + "\n";
            output += "Price: " + product.getPrice() + "\n";
            output += "Stock: " + product.getStock() + "\n";

        }

        if (output.isEmpty()) {
            return "No hay productos registrados";
        } else {
            return output;
        }


    }

    public String addProduct(Product newProduct) {
        productRepository.save(newProduct);
        return "Producto agregado con exito";
    }

    public String getProduct(int id) {
        String output = "";
        for (Product product : productRepository.findAll()) {
            if (product.getId() == id) {
                output += "ID Product: " + product.getId() + "\n";
                output += "Name: " + product.getName() + "\n";
                output += "Description: " + product.getDescription() + "\n";
                output += "Price: " + product.getPrice() + "\n";
                output += "Stock: " + product.getStock() + "\n";
            }
        }

        if (output.isEmpty()) {
            return "Producto no encontrado";
        } else {
            return output;
        }
    }

    public String deleteProduct(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Producto eliminado con exito";
        } else {
            return "Producto no encontrado";
        }
    }

    public String updateProduct(int id, Product newProduct) {
        if (productRepository.existsById(id)) {
            for (Product product : productRepository.findAll()) {
                if (product.getId() == id) {
                    product.setName(newProduct.getName());
                    product.setDescription(newProduct.getDescription());
                    product.setPrice(newProduct.getPrice());
                    product.setStock(newProduct.getStock());
                    productRepository.save(product);
                }
            }
            return "Producto actualizado con exito";
        } else {
            return "Producto no encontrado";
        }
    }
}
