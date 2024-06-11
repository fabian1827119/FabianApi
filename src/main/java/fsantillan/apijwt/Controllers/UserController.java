package fsantillan.apijwt.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fsantillan.apijwt.Common.Dto.UserDTO;
import fsantillan.apijwt.Common.Models.UserRequest;
import fsantillan.apijwt.Common.Models.UserResponse;
import fsantillan.apijwt.Services.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserController {
    private final UserService userService;
    
    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id)
    {
        UserDTO userDTO = userService.getUser(id);
        if (userDTO==null)
        {
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTO);
    }

    // @RequestMapping(value="{id}", method = RequestMethod.PUT)
    @PutMapping(value = "{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable int id,@RequestBody UserRequest userRequest)
    {
        userRequest.setId(id);
        return ResponseEntity.ok(userService.updateUser(userRequest));
    }

    @PostMapping(value = "demo")
    public String Welcome(){
        return "Welcome to the User Controller";
    }

    @GetMapping(value = "allusers")
    public ResponseEntity<List<UserDTO>> getUser()
    {
       List<UserDTO> usersDTO = userService.getUser();
       return ResponseEntity.ok(usersDTO);
    }
}