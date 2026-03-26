package in.himanshu.billingsoftware.service;

import in.himanshu.billingsoftware.io.UserRequest;
import in.himanshu.billingsoftware.io.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    String getUserRole(String email);

    List<UserResponse> readUsers();

    void deleteUser(String id);
}
