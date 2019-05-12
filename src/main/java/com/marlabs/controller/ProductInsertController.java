package com.marlabs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marlabs.dao.ProductDao;
import com.marlabs.dao.impl.ProductDaoImpl;
import com.marlabs.domain.Product;

@WebServlet("/product/register")
public class ProductInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDao productDao = ProductDaoImpl.getInstance();

	public ProductInsertController() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hello anand");
		request.getRequestDispatcher("/").forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String product_Id = request.getParameter("id");
		String product_name = request.getParameter("product_name");
		String product_symbol = request.getParameter("product_symbol");
		

		Product product = new Product(product_name, product_symbol);

		if (product_Id == null || product_Id == "")
			productDao.saveProduct(product);
		else {
			Long id = Long.parseLong(product_Id);
			product.setId(id);
			productDao.updateProduct(product);
		}

		response.sendRedirect(request.getContextPath() + "/");
	}

}
