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

import utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import dao.DienThoaiDAO;
import dao.NhaCungCapDAO;

import daoImpl.DienThoaiDAOImpl;
import daoImpl.NhaCungCapDAOImpl;

import models.DienThoai;
import models.NhaCungCap;


/**
 * Servlet implementation class DienThoaiFormServlet
 */
@WebServlet(name = "DienThoaiFormServlet", urlPatterns = { "/DienThoaiForm", "/DienThoaiForm*" })
public class DienThoaiFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private EntityManagerFactoryUtil entityManagerFactoryUtil;
	private DienThoaiDAO dienThoaiDAO;
	private NhaCungCapDAO nhaCungCapDAO;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DienThoaiFormServlet() {
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
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		
		switch (action) {
			case "insert":
				showAddForm(request, response);
				break;
			default:
				listPhones(request, response);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		
		switch (action) {
			case "insert":
				insertPhone(request, response);
				break;
			default:
				listPhones(request, response);
				break;
		}
	}

	
	/**
	 * Insert a new phone
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void insertPhone (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String tenDienThoai = request.getParameter("tenDienThoai");		
        int namSanXuat = Integer.parseInt(request.getParameter("namSanXuat"));
        String cauHinh = request.getParameter("cauHinh");
        String hinhAnh = request.getParameter("hinhAnh");
        int maNhaCungCap = Integer.parseInt(request.getParameter("maNhaCungCap"));
        
        NhaCungCap ncc = this.nhaCungCapDAO.timNhaCungCapTheoMa(maNhaCungCap);
        
        DienThoai dienThoai = new DienThoai();
        dienThoai.setTenDienThoai(tenDienThoai);
        dienThoai.setNamSanXuat(namSanXuat);
        dienThoai.setCauHinh(cauHinh);
        dienThoai.setHinhAnh(hinhAnh);
        dienThoai.setNhaCungCap(ncc);
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<DienThoai>> violations = validator.validate(dienThoai);
		
		if (violations.isEmpty()) {
			this.dienThoaiDAO.themDienThoai(dienThoai);
			response.sendRedirect("DanhSachDienThoai");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/DienThoaiForm.jsp");
			
			StringBuilder stringBuilder = new StringBuilder();
			violations.forEach(violation -> {
				stringBuilder.append(violation.getPropertyPath() + ": " + violation.getMessage());
				stringBuilder.append("<br>");
			});
			
			request.setAttribute("phone", dienThoai);
			request.setAttribute("errors", stringBuilder);
			dispatcher.forward(request, response);
		}
	}
	
	
	/**
	 * Display list of phones
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listPhones (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<DienThoai> listPhones = this.dienThoaiDAO.layDanhSachDienThoai();
		List<NhaCungCap> listSuppliers = this.nhaCungCapDAO.layDanhSachNhaCungCap();
		
		System.out.println(listPhones);
		System.out.println(listSuppliers);
		
		request.setAttribute("DanhSachDienThoai", listPhones);
		request.setAttribute("DanhSachNhaCungCap", listSuppliers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/DienThoaiForm.jsp");
		dispatcher.forward(request, response);
	}
	
	
	/**
	 * Show add new phone form
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showAddForm (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/DienThoaiForm.jsp");
		dispatcher.forward(request, response);
	}
	
	
}
