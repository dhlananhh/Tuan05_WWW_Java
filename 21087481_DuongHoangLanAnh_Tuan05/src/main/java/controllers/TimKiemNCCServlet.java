package controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.NhaCungCap;

import java.io.IOException;
import java.util.List;

import utils.EntityManagerFactoryUtil;

import dao.DienThoaiDAO;
import dao.NhaCungCapDAO;

import daoImpl.DienThoaiDAOImpl;
import daoImpl.NhaCungCapDAOImpl;


/**
 * Servlet implementation class TimKiemNCCServlet
 */
@WebServlet(name = "TimKiemNCCServlet", urlPatterns = { "/TimKiemNCC", "/TimKiemNCC*" })
public class TimKiemNCCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private EntityManagerFactoryUtil entityManagerFactoryUtil;
	private DienThoaiDAO dienThoaiDAO;
	private NhaCungCapDAO nhaCungCapDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiemNCCServlet() {
        super();
    }

    
    /**
     * @see HttpServlet#init(ServletConfig)
     * * This method is called by the servlet container to perform initialization of the servlet.
     */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.entityManagerFactoryUtil = new EntityManagerFactoryUtil();
		this.dienThoaiDAO = new DienThoaiDAOImpl(this.entityManagerFactoryUtil.getEntityManager());
		this.nhaCungCapDAO = new NhaCungCapDAOImpl(this.entityManagerFactoryUtil.getEntityManager());
	}


	/**
	 * @see HttpServlet#destroy()
	 * This method is called by the servlet container to perform cleanup before the servlet instance is destroyed.
	 */
	@Override
	public void destroy() {
		this.entityManagerFactoryUtil.close();
		super.destroy();
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");

	    // Kiểm tra nếu keyword là null hoặc rỗng
	    if (keyword == null || keyword.trim().isEmpty()) {
	        keyword = ""; // Gán giá trị mặc định nếu keyword là null hoặc rỗng
	    }

	    List<NhaCungCap> listSuppliers = this.nhaCungCapDAO.timKiemNhaCungCap(keyword);
	    request.setAttribute("listSuppliers", listSuppliers);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("views/TimKiemNCC.jsp");
	    dispatcher.forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
