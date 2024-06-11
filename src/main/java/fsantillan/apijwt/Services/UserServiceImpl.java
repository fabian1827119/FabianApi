package fsantillan.apijwt.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import fsantillan.apijwt.Common.Dto.UserDTO;
// import fsantillan.apijwt.Common.Enum.Role;
import fsantillan.apijwt.Common.Models.User;
import fsantillan.apijwt.Common.Models.UserRequest;
import fsantillan.apijwt.Common.Models.UserResponse;
import fsantillan.apijwt.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository; 

    
    @Transactional
    @Override
    public UserResponse updateUser(UserRequest userRequest) {

        User user = userRepository.findById(userRequest.getId()).orElse(null);
              
        if (user == null) return new UserResponse("El usuario no existe");
        user.setUsername(userRequest.getUsername());
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user.setCountry(userRequest.getCountry());
        
        // User user = User.builder()
        // .id(userRequest.getId()) 
        // .firstname(userRequest.getFirstname())
        // .lastname(userRequest.getLastname())
        // .country(userRequest.getCountry()) 
        // .role(Role.USER)
        // .build();
        
        userRepository.updateUser(user.getId(), user.getFirstname(), user.getLastname(), user.getCountry()); // Fix: Use getter methods for id, firstname, lastname, and country fields

        return new UserResponse("El usuario se registró satisfactoriamente");
    }

    @Override
    public UserDTO getUser(Integer id) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            UserDTO userDTO = UserDTO.builder()
                .id(user.getId()) 
                .username(user.getUsername()) 
                .firstname(user.getFirstname())
                .lastname(user.getLastname()) 
                .country(user.getCountry()) 
                .build();
            return userDTO;
        }
        return null;
    }

    @Override
    public List<UserDTO> getUser() {
        List<User> users = userRepository.findAll();

        if (users != null) {
            List<UserDTO> userDTOs = users.stream().map(user -> UserDTO.builder()
                .id(user.getId()) 
                .username(user.getUsername()) 
                .firstname(user.getFirstname())
                .lastname(user.getLastname()) 
                .country(user.getCountry()) 
                .build()).toList();
            return userDTOs;
        }
        return null;
    }
}
