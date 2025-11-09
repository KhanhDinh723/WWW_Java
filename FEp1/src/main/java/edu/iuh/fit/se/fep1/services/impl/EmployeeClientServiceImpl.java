package edu.iuh.fit.se.fep1.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.iuh.fit.se.fep1.dtos.ApiResponse;
import edu.iuh.fit.se.fep1.dtos.Employee;
import edu.iuh.fit.se.fep1.services.IEmployeeClientService;
import edu.iuh.fit.se.fep1.services.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeClientServiceImpl implements IEmployeeClientService {
    private final RestClient client;

    // ✅ ObjectMapper cấu hình chuẩn cho LocalDate & bỏ qua field lạ
    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Value("${be.base-url}")
    private String baseUrl;

    public EmployeeClientServiceImpl(RestClient client) {
        this.client = client;
    }

    @Override
    public List<Employee> findAll() {
        try {
            String url = baseUrl + "/employees";
            ResponseEntity<String> res = client.get(url);

            System.out.println("🟢 [GET] " + url);
            System.out.println("Response body: " + res.getBody());

            ApiResponse<List<Employee>> body = mapper.readValue(
                    res.getBody(), new TypeReference<ApiResponse<List<Employee>>>() {});
            return body.getData() == null ? List.of() : body.getData();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public Employee findById(Integer id) {
        try {
            String url = baseUrl + "/employees/" + id;
            ResponseEntity<String> res = client.get(url);
            ApiResponse<Employee> body = mapper.readValue(
                    res.getBody(), new TypeReference<ApiResponse<Employee>>() {});
            return body.getData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Employee create(Employee e) {
        try {
            String url = baseUrl + "/employees";
            ResponseEntity<String> res = client.post(url, e);
            ApiResponse<Employee> body = mapper.readValue(
                    res.getBody(), new TypeReference<ApiResponse<Employee>>() {});
            return body.getData();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    @Override
    public Employee update(Integer id, Employee e) {
        try {
            String url = baseUrl + "/employees/" + id;
            ResponseEntity<String> res = client.put(url, e);
            ApiResponse<Employee> body = mapper.readValue(
                    res.getBody(), new TypeReference<ApiResponse<Employee>>() {});
            return body.getData();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String url = baseUrl + "/employees/" + id;
            client.delete(url);
            System.out.println("🗑️ Deleted employee id=" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
