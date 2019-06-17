package MsLibreria.co.ud.libreria.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import MsLibreria.co.ud.libreria.dto.RolResponse;
import MsLibreria.co.ud.libreria.dto.UsuarioRequest;
import MsLibreria.co.ud.libreria.dto.UsuarioResponse;
import MsLibreria.co.ud.libreria.modelo.Rol;
import MsLibreria.co.ud.libreria.modelo.Usuario;
import MsLibreria.co.ud.libreria.servicios.UsuarioServicio;
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

	@Autowired
	UsuarioServicio usuarioServicio;

//    @RequestMapping(method = RequestMethod.POST, value = "ping/")
//    @ApiOperation(value = "ping", nickname = "ping", response = UsuarioRequest.class)
//    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
//            @ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad Request"),
//            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
//            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
//    public Boolean ping(
//            @ApiParam(value = "request", required = true) @RequestBody(required = true) UsuarioRequest request) {
//
//        logger.debug("--> ping received");
//        logger.debug("--> id: {}", request.getId());
//        logger.debug("--> nombre: {}", request.getNombreUsuario());
//
//        return true;
//    }

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Consultar usuario", tags = "Usuarios")
	public ResponseEntity<UsuarioResponse> consultarUsuario(@PathVariable String id) {

		Long idUsuario = Long.valueOf(id);
		UsuarioResponse respuesta = usuarioServicio.consultarPorId(idUsuario);

		return ResponseEntity.ok(respuesta);
	}

	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ApiOperation(value = "Consultar todos los usuarios", tags = "Usuarios")
	public ResponseEntity<List<UsuarioResponse>> consultarUsuarios() {

		List<UsuarioResponse> usuarios = usuarioServicio.consultarUsuarios();

		return ResponseEntity.ok(usuarios);
	}

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation(value = "Agrega nuevo usuario o usuario uno existente", tags = "Usuarios", nickname = "usuario", response = Usuario.class)
	public ResponseEntity<Boolean> agregarUsuario(
			@ApiParam(value = "usuario", required = true) @RequestBody(required = true) Usuario usuario) {

		Boolean respuesta;
		respuesta = usuarioServicio.guardarUsuario(usuario);

		return ResponseEntity.ok(respuesta);
	}

	@ResponseBody
	@RequestMapping(value = "/rol/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Consultar Rol", tags = "Roles")
	public ResponseEntity<RolResponse> consultarRol(@PathVariable String id) {

		Long idRol = Long.valueOf(id);
		RolResponse respuesta = usuarioServicio.consultarRol(idRol);

		return ResponseEntity.ok(respuesta);
	}

	@ResponseBody
	@RequestMapping(value = "/rol/all", method = RequestMethod.GET)
	@ApiOperation(value = "Consultar Roles", tags = "Roles")
	public ResponseEntity<List<RolResponse>> consultarRoles() {

		List<RolResponse> respuesta = usuarioServicio.consultarRoles();

		return ResponseEntity.ok(respuesta);
	}

}