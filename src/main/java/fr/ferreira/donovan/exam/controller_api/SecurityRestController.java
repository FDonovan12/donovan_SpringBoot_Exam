//package fr.ferreira.donovan.exam.controller_api;
//
//import com.fasterxml.jackson.annotation.JsonView;
//import fr.ferreira.donovan.exam.custom_response.CustomResponse;
//import fr.ferreira.donovan.exam.custom_response.JwtTokenResponse;
//import fr.ferreira.donovan.exam.dto.UserDTO;
//import fr.ferreira.donovan.exam.dto.UserLoginDTO;
//import fr.ferreira.donovan.exam.entity.User;
//import fr.ferreira.donovan.exam.json_views.JsonViews;
//import fr.ferreira.donovan.exam.mapping.UrlRoute;
//import fr.ferreira.donovan.exam.security.JwtAuthenticationService;
//import fr.ferreira.donovan.exam.service.UserService;
//import jakarta.validation.Valid;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping
//@AllArgsConstructor
//public class SecurityRestController {
//
//    private UserService userService;
//
//    private JwtAuthenticationService jwtAuthenticationService;
//
//    @PostMapping(path = UrlRoute.URL_REGISTER)
//    @JsonView(JsonViews.UserShowJsonViews.class)
//    User create(@Valid @RequestBody UserDTO userDTO) {
//        return userService.persist(userDTO);
//    }
//
//    @GetMapping(path = UrlRoute.URL_ACCOUNT_ACTIVATION + "/{code}")
//    @JsonView(JsonViews.UserShowJsonViews.class)
//    public CustomResponse<User> accountActivation(@PathVariable String code) {
//        return new CustomResponse<>(HttpStatus.OK.value(), "UserControllerApi - accountActivation("+code+")", "User", this.userService.accountActivation(code));
//    }
//
//    @PostMapping(path = UrlRoute.URL_LOGIN)
//    ResponseEntity<JwtTokenResponse> login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
//        return jwtAuthenticationService.authenticate(userLoginDTO);
//    }
//
//}