package fit.iuh.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fit.iuh.dao.NhanVienDAO;
import fit.iuh.daoImpl.NhanVienDAOImpl;
import fit.iuh.models.NhanVien;
import fit.iuh.utils.EntityManagerFactoryUtil;

/**
 * Servlet implementation class DanhSachServlet
 */
@WebServlet(urlPatterns = "/list")
public class DanhSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactoryUtil entityManagerFactoryUtil;
    private NhanVienDAO nhanVienDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	entityManagerFactoryUtil = new EntityManagerFactoryUtil();
    	nhanVienDAO = new NhanVienDAOImpl(this.entityManagerFactoryUtil.getEnManager());
    }
    
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	this.entityManagerFactoryUtil.close();
    	super.destroy();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("nhanVien", nhanVienDAO.findAll());
		request.getRequestDispatcher("views/DanhSachNhanVien.jsp").forward(request, response);
	}
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch(action) {
		case "remove":
			remove(request, response);
			break;
		default:
			doGet(request, response);
		}	}
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maNV = request.getParameter("maNhanVien");
		if(maNV !=null && !maNV.isEmpty()) {
			nhanVienDAO.xoaNhanVien(Integer.parseInt(maNV));
		}
		response.sendRedirect(request.getContextPath() + "/list");
	}
}
