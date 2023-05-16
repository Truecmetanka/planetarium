package ru.coursework.Planetarium.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.coursework.Planetarium.security.AuthenticationRequest;
import ru.coursework.Planetarium.security.AuthenticationResponse;
import ru.coursework.Planetarium.security.AuthenticationService;
import ru.coursework.Planetarium.security.RegisterRequest;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    /**
     * POST - "/register"
     * Регистрация
     *
     * @param request - json запрос вида {
     *                "name": "name",
     *                "email": "email",
     *                "tel": "tel",
     *                "password": "pass",
     *                "birthDate": "2003-02-31"
     *                }
     * @return JWT-token вида {
     * "token": токен
     * }
     */

    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody RegisterRequest request) {
        return service.register(request);
    }

    /**
     * POST - "/authenticate"
     * Аутентификация
     *
     * @param request - json запрос вида {
     *                "email": email,
     *                "password" password
     *                }
     * @return JWT-token вида {
     * "token": токен
     * }
     */

    @PostMapping("/login")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request) {
        return service.authenticate(request);
    }


}
