package dev.yonk.frontend.models;

import dev.yonk.backend.enums.ProductStatus;
import dev.yonk.backend.models.Product;
import dev.yonk.backend.services.ProductService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ProductModel {

    @Inject
    private ProductService productService;

    @Inject
    public ProductModel(ProductService productService) {
        this.productService = productService;
    }

    public void getProductList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Product> productList = productService.getAllProduct();
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("product.jsp").forward(req,res);
    }

    public Product addProduct(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String unit = req.getParameter("unit");
        String manufacture = req.getParameter("manufacture");

        Product product = new Product(name, description, unit, manufacture, ProductStatus.ONGOING);
        productService.addProduct(product);

        return product;
    }

    public void deleteProduct(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        long id = Long.parseLong(req.getParameter("id"));
        productService.deleteProduct(id);
    }
}
