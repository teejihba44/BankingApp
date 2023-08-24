package com.achyutha.bankingapp.domain.service.user;

import com.achyutha.bankingapp.auth.dto.SignUpRequest;
import com.achyutha.bankingapp.domain.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {

    /**
     * To add a new employee (By an admin).
     * @param signupRequest  The details (DOB, password - random, must be changed on first login.)
     * @return The response with newly created employee username.
     */
    ResponseEntity<?> addEmployee(SignUpRequest signupRequest);

    /**
     * Fetch all employees.
     * @return List of employees.
     */
    List<User> getAllEmployees();

    /**
     * To delete an existing employee.
     * @param user The user to be deleted.
     * @return The response.
     */
    ResponseEntity<?> deleteEmployee(User user);

    ResponseEntity<?> reactivate(User user);
}
