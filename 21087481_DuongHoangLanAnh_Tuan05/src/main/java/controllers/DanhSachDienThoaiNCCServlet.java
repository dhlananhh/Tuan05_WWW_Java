package controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import utils.EntityManagerFactoryUtil;

import dao.DienThoaiDAO;
import dao.NhaCungCapDAO;

import daoImpl.DienThoaiDAOImpl;
import daoImpl.NhaCungCapDAOImpl;

import models.DienThoai;
import models.NhaCungCap;


/**
 * Servlet implementation class DanhSachDienThoaiNCCServlet
 */
@WebServlet (name = "DanhSachDienThoaiNCCServlet", urlPatterns = { "/DanhSachDienThoai", "/DanhSachDienThoai*" })
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private EntityManagerFactoryUtil entityManagerFactoryUtil;
	private DienThoaiDAO dienThoaiDAO;
	private NhaCungCapDAO nhaCungCapDAO;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachDienThoaiNCCServlet() {
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
	protected void doGet (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<DienThoai> listPhones = this.dienThoaiDAO.layDanhSachDienThoai();
//		List<NhaCungCap> listSuppliers = this.nhaCungCapDAO.layDanhSachNhaCungCap();
		
		System.out.println(listPhones);
//		System.out.println(listSuppliers);
		
		request.setAttribute("DanhSachDienThoai", listPhones);
//		request.setAttribute("DanhSachNhaCungCap", listSuppliers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/DanhSachDienThoai.jsp");
		dispatcher.forward(request, response);
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
