package MsLibreria.co.ud.libreria.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import MsLibreria.co.ud.libreria.controladores.request.UsuarioRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping("usuario/")
public class UsuarioControlador {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.POST, value = "ping/")
    @ApiOperation(value = "ping", nickname = "ping", response = UsuarioRequest.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    public Boolean ping(
            @ApiParam(value = "request", required = true) @RequestBody(required = true) UsuarioRequest request) {

        logger.debug("--> ping received");
        logger.debug("--> id: {}", request.getId());
        logger.debug("--> nombre: {}", request.getNombreUsuario());

        return true;
    }
}