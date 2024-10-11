package fr.ferreira.donovan.exam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ferreira.donovan.exam.entity.User;
import fr.ferreira.donovan.exam.DTO.UserDTO;
import fr.ferreira.donovan.exam.service.UserService;
import fr.ferreira.donovan.exam.json_views.JsonViews;
import fr.ferreira.donovan.exam.mapping.UrlRoute;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(UrlRoute.URL_API)
public class UserRestController {

    private UserService userService;

    @GetMapping(path = UrlRoute.URL_USER + "/me")
    @JsonView(JsonViews.UserShowJsonViews.class)
    public User show(Principal principal) {
        return this.userService.getUserFromPrincipal(principal);
    }
}