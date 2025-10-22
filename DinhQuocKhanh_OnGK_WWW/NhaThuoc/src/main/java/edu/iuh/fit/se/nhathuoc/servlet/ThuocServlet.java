package edu.iuh.fit.se.nhathuoc.servlet;

import edu.iuh.fit.se.nhathuoc.dao.LoaiThuocDAO;
import edu.iuh.fit.se.nhathuoc.dao.ThuocDAO;
import edu.iuh.fit.se.nhathuoc.model.LoaiThuoc;
import edu.iuh.fit.se.nhathuoc.model.Thuoc;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Author: Khánh Đinh
 * Date:   9/30/2025
 * Time:   9:21 PM
 */
@WebServlet("/thuoc")
public class ThuocServlet extends HttpServlet {

    private ThuocDAO thuocDAO;
    private LoaiThuocDAO loaiThuocDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        thuocDAO = new ThuocDAO();
        loaiThuocDao = new LoaiThuocDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listLoaiThuoc", loaiThuocDao.findAll());
//Nếu có action thì hiện form
        String action = req.getParameter("action");
        if (action != null && action.equals("CREATE")) {
            req.getRequestDispatcher("thuoc-from.jsp").forward(req, resp);
            return;
        }
// Ko có thì hiện list
        String loaiThuocIdSr = req.getParameter("loaiThuocId");
        if (loaiThuocIdSr != null && !loaiThuocIdSr.equals("ALL")) {
            Long loaiThuocId = Long.parseLong(loaiThuocIdSr);
            req.setAttribute("listThuoc", thuocDAO.findByLoaiThuocId(loaiThuocId));
        } else req.setAttribute("listThuoc", thuocDAO.findAll());

        req.getRequestDispatcher("thuoc-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenThuoc = req.getParameter("tenThuoc");
        double gia = Double.parseDouble(req.getParameter("gia"));
        int namSX = Integer.parseInt(req.getParameter("namSX"));

        String loaiThuocIdSr = req.getParameter("loaiThuocId");
        Long loaiThuocId = Long.parseLong(loaiThuocIdSr);
        LoaiThuoc loaiThuoc = loaiThuocDao.findById(loaiThuocId);
        Thuoc thuoc = new Thuoc(
                null, tenThuoc,gia,namSX,loaiThuoc
        );
        thuocDAO.save(thuoc);
        resp.sendRedirect("thuoc");
    }
}
