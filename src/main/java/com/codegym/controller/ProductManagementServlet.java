package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductManagementServlet", urlPatterns = "/products")

public class ProductManagementServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "find":
                findProduct(request,response);
                break;
            default:
                listProducts(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                showViewForm(request,response);
                break;
            default:
                listProducts(request, response);
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = ((ProductServiceImpl) productService).getId();
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String type = request.getParameter("type");
        String date = request.getParameter("dateproduction");

        String status = "", message = "";
        boolean isNameEqualsNull = name.equals("") ? true : false;
        boolean isdesEqualsNull = description.equals("") ? true : false;
        boolean isTypeEqualsNull = type.equals("") ? true : false;
        boolean isDateEqualsNull = date.equals("") ? true : false;
        if (!isDateEqualsNull && !isdesEqualsNull &&
                !isNameEqualsNull && !isTypeEqualsNull) {
            status = "success";
            message = "Success!! This product was added to list!! ";

            this.productService.save(new Product(id, name, description, type, date));

        } else {
            status = "danger";
            message = "Can't add this product to list, please try again later!! ";
        }
        request.setAttribute("status", status);
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        String status = "", message = "", path = "";
        RequestDispatcher dispatcher;
        request.setAttribute("product", product);
        dispatcher = request.getRequestDispatcher("product/edit.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String type = request.getParameter("type");
        String date = request.getParameter("dateproduction");

        String status = "", message = "";
        boolean isNameEqualsNull = name.equals("") ? true : false;
        boolean isdesEqualsNull = description.equals("") ? true : false;
        boolean isTypeEqualsNull = type.equals("") ? true : false;
        boolean isDateEqualsNull = date.equals("") ? true : false;
        if (!isDateEqualsNull && !isdesEqualsNull &&
                !isNameEqualsNull && !isTypeEqualsNull) {
            status = "success";
            message = "Success!! This product was edited!! ";
            this.productService.update(id, name, description, type, date);

        } else {
            status = "danger";
            message = "Can't edit this product, please try again later!! ";
        }
        request.setAttribute("status", status);
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);

        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/delete.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String message = "", status = "";
        if(this.productService.findById(id)!=null){
            message = "Success!! This product was deleted!";
            status = "success";
            request.setAttribute("message",message);
            request.setAttribute("status",status);
            this.productService.remove(id);
        }else{
            message = "Can not delete this product, please try again later!";
            status = "danger";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/delete.jsp");
        dispatcher.forward(request, response);
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/view.jsp");
        dispatcher.forward(request,response);
    }

    private void findProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String search = request.getParameter("search");
        String status = "", message = "";
        RequestDispatcher dispatcher;
        int id = -1;
        for(Product product:productService.findAll()){
            if(product.getName().toLowerCase().equals(search.toLowerCase())){
                status = "success";
                message = "This product has found!!";
                id = product.getId();
                break;
            }
        }

        if(id==-1){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            request.setAttribute("status",status);
            request.setAttribute("message", message);
            request.setAttribute("product",this.productService.findById(id));

            dispatcher = request.getRequestDispatcher("product/view.jsp");
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
