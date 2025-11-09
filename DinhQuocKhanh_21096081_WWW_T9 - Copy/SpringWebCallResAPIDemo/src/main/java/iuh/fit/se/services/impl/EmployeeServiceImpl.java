package iuh.fit.se.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import iuh.fit.se.utils.ApiResponse;
import iuh.fit.se.utils.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;
    private static final String ENDPOINT = "http://localhost:8081/api";

    @Autowired
    public EmployeeServiceImpl(RestClient restClient, ObjectMapper objectMapper) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public ApiResponse findById(int id) {
        return restClient.get()
                .uri(ENDPOINT + "/employees/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0)
                            return ApiResponse.noContent();

                        JsonNode root = objectMapper.readTree(body);
                        int status = root.path("status").asInt();
                        String message = root.path("message").asText(null);
                        JsonNode dataNode = root.path("data");

                        Employee employee = objectMapper.convertValue(
                                dataNode, new TypeReference<Employee>() {}
                        );

                        return new ApiResponse(status, null, employee, message);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return ApiResponse.error("Failed to read employee: " + e.getMessage());
                    }
                });
    }

    @Override
    public ApiResponse findAll() {
        return restClient.get()
                .uri(ENDPOINT + "/employees")
                .accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0) {
                            System.out.println("⚠️ Empty response body from API 8081");
                            return ApiResponse.noContent();
                        }

                        JsonNode root = objectMapper.readTree(body);
                        int status = root.path("status").asInt();
                        String message = root.path("message").asText(null);
                        JsonNode dataNode = root.path("data");

                        List<Employee> employees = objectMapper.convertValue(
                                dataNode, new TypeReference<List<Employee>>() {}
                        );

                        System.out.println("✅ Received " + employees.size() + " employees from 8081");
                        return new ApiResponse(status, null, employees, message);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return ApiResponse.error("Failed to read employee list: " + e.getMessage());
                    }
                });
    }

    @Override
    public ApiResponse save(Employee employee) {
        return restClient.post()
                .uri(ENDPOINT + "/employees")
                .accept(MediaType.APPLICATION_JSON)
                .body(employee)
                .exchange((request, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0)
                            return ApiResponse.noContent();

                        JsonNode root = objectMapper.readTree(body);
                        int status = root.path("status").asInt();
                        String message = root.path("message").asText(null);
                        JsonNode dataNode = root.path("data");

                        Employee saved = objectMapper.convertValue(
                                dataNode, new TypeReference<Employee>() {}
                        );

                        return new ApiResponse(status, null, saved, message);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return ApiResponse.error("Failed to save employee: " + e.getMessage());
                    }
                });
    }

    @Override
    public ApiResponse update(int id, Employee employee) {
        return restClient.put()
                .uri(ENDPOINT + "/employees/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .body(employee)
                .exchange((request, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0)
                            return ApiResponse.noContent();

                        JsonNode root = objectMapper.readTree(body);
                        int status = root.path("status").asInt();
                        String message = root.path("message").asText(null);
                        JsonNode dataNode = root.path("data");

                        Employee updated = objectMapper.convertValue(
                                dataNode, new TypeReference<Employee>() {}
                        );

                        return new ApiResponse(status, null, updated, message);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return ApiResponse.error("Failed to update employee: " + e.getMessage());
                    }
                });
    }

    @Override
    public ApiResponse delete(int id) {
        return restClient.delete()
                .uri(ENDPOINT + "/employees/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0)
                            return ApiResponse.noContent();

                        JsonNode root = objectMapper.readTree(body);
                        int status = root.path("status").asInt();
                        String message = root.path("message").asText(null);

                        return new ApiResponse(status, null, null, message);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return ApiResponse.error("Failed to delete employee: " + e.getMessage());
                    }
                });
    }

    @Override
    public ApiResponse search(String keyword) {
        return restClient.get()
                .uri(ENDPOINT + "/employees?keyword={keyword}", keyword)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0)
                            return ApiResponse.noContent();

                        JsonNode root = objectMapper.readTree(body);
                        int status = root.path("status").asInt();
                        String message = root.path("message").asText(null);
                        JsonNode dataNode = root.path("data");

                        List<Employee> employees = objectMapper.convertValue(
                                dataNode, new TypeReference<List<Employee>>() {}
                        );

                        return new ApiResponse(status, null, employees, message);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return ApiResponse.error("Failed to search employees: " + e.getMessage());
                    }
                });
    }

    @Override
    public PageResponse<Employee> findAllWithPaging(int page, int size, String sort) {
        String url = UriComponentsBuilder.fromHttpUrl(ENDPOINT + "/employeesHasPage")
                .queryParam("page", page)
                .queryParam("size", size)
                .queryParam("sort", sort)
                .toUriString();

        return restClient.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    try (InputStream is = response.getBody()) {
                        JsonNode root = objectMapper.readTree(is);
                        JsonNode dataNode = root.path("data");
                        return objectMapper.convertValue(dataNode, new TypeReference<PageResponse<Employee>>() {});
                    }
                });
    }
}
