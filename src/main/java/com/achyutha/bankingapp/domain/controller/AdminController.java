package com.achyutha.bankingapp.domain.controller;

import com.achyutha.bankingapp.auth.dto.SignUpRequest;
import com.achyutha.bankingapp.auth.jwt.UserDetailsServiceImpl;
import com.achyutha.bankingapp.domain.model.User;
import com.achyutha.bankingapp.domain.service.user.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Admin Controller.
 */
@RestController
@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    private final UserDetailsServiceImpl userDetailsService;

    /**
     * Compares whether the current user is equal to the logged in user.
     *
     * @param user The user.
     */
    private void compareUserName(String user) {
        if (!user.equals(userDetailsService.getCurrentLoggedInUser())) {
            log.error("Logged in user does not match with requesting user.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "logged in user trying to alter other user.");
        }
    }

    /**
     * To get information of an admin.
     *
     * @param user The user matching id.
     * @return The User object.
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public User getAdmin(@PathVariable("id") User user) {
        log.debug("User fetched: {}", user);
        compareUserName(user.getUsername());
        return user;
    }

    /**
     * To add a new employee.
     *
     * @param signUpRequest The employee signUpRequest object.
     * @return The response, with newly created employee username.
     */
    @PostMapping("/employees/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addEmployee(@RequestBody SignUpRequest signUpRequest) {
        log.debug("Adding new employee with email: {}", signUpRequest.getEmail());
        return adminService.addEmployee(signUpRequest);
    }

    /**
     * Fetch all users having EMPLOYEE as the role.
     *
     * @return List of users.
     */
    @GetMapping("/employees")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllEmployeeUsers() {
        log.debug("Fetching all employees.");
        return adminService.getAllEmployees();
    }

    /**
     * To add a new employee.
     *
     * @param user The employee signupRequest object.
     * @return The response, with newly created employee username.
     */
    @DeleteMapping("/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") User user) {
        log.debug("Deleting employee with username: {}", user.getUsername());
        return adminService.deleteEmployee(user);
    }

    /**
     * To reactivate an inactive user.
     * @param user The user.
     * @return Response.
     */
    @PutMapping("/employees/reactivate/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> reactiveEmployee(@PathVariable("id") User user){
        log.debug("Reactivating employee with username: {}", user.getUsername());
        return adminService.reactivate(user);
    }
}
