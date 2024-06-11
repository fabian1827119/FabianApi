package fsantillan.apijwt.Services;

import java.util.List;

import fsantillan.apijwt.Common.Dto.UserDTO;
import fsantillan.apijwt.Common.Models.UserRequest;
import fsantillan.apijwt.Common.Models.UserResponse;

public interface UserService {
    UserResponse updateUser(UserRequest userRequest);
    UserDTO getUser(Integer id);
    List<UserDTO> getUser();
}
