package fit.iuh.controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fit.iuh.dao.DienThoaiDAO;
import fit.iuh.daoImpl.DienThoaiDAOImpl;
import fit.iuh.utills.EntityManagerFactoryUtil;

/**
 * Servlet implementation class DanhSachDT
 */
public class DanhSachDT extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactoryUtil entityManagerFactoryUtil;
	private DienThoaiDAO dienThoaiDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachDT() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	entityManagerFactoryUtil = new EntityManagerFactoryUtil();
    	this.dienThoaiDAO = new DienThoaiDAOImpl(this.entityManagerFactoryUtil.getEnManager());
    	
    }
    
    @Override
    public void destroy() {
    	entityManagerFactoryUtil.close();
    	super.destroy();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dienThoai", dienThoaiDAO.findAll());
		request.getRequestDispatcher("views/DanhSachDT.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
