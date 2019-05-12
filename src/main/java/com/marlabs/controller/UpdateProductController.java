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

@WebServlet("/product/update")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateProductController() {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String product_Id = request.getParameter("product_Id");

		if (product_Id == "" || product_Id == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id = Long.parseLong(product_Id);
			ProductDao productDao = ProductDaoImpl.getInstance();
			Product product = productDao.findProductById(id);

			request.setAttribute("product", product);

			request.getRequestDispatcher("/").forward(request, response);
		}
	}
}
