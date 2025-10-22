package edu.iuh.fit.se.nhathuoc.servlet;

import edu.iuh.fit.se.nhathuoc.dao.LoaiThuocDAO;
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
 * Time:   6:32 PM
 */
@WebServlet("/loaithuoc")
public class LoaiThuocServlet extends HttpServlet {
private LoaiThuocDAO loaiThuocDAO;
    @Override
    public void init(ServletConfig config) throws ServletException {
    loaiThuocDAO = new LoaiThuocDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("listLoaiThuoc",loaiThuocDAO.findAll());
        req.getRequestDispatcher("loaithuoc-list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
