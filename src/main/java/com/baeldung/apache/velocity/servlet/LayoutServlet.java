package com.baeldung.apache.velocity.servlet;

import com.baeldung.apache.velocity.model.Product;
import com.baeldung.apache.velocity.service.ProductService;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityLayoutServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LayoutServlet extends VelocityLayoutServlet {
	ProductService service = new ProductService();

	@Override
	public Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context context) {

        Logger logger= Logger.getLogger(LayoutServlet.class.getName());

		List<Product> products = service.getProducts();

		context.put("products", products);

		Template template = null;

		try {
			template = getTemplate("templates/layoutdemo.vm");

			response.setHeader("Template Returned", "Success");
		} catch (Exception e) {
			logger.log(Level.WARNING, "Error while reading the template ",e);
		}

		return template;

	}

}
