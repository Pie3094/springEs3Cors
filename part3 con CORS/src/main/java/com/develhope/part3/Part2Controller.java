package com.develhope.part3;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class Part2Controller {

    @GetMapping(path = "/nome") //Request con rotta così /nome?nome=Pietro
    public String getNome(@RequestParam String nome) {
        return "Ciao, il mio nome è " + nome;
    }
    @GetMapping(path = "/nome/{nome}") //PathVariable con rotta così: /nome/Pietro
    public String getNome1(@PathVariable String nome) {
        return "Ciao, il mio nome è " + nome;
    }

    @PostMapping(path = "/nome/{nome}")
    @Operation(description = "Dentro con \"description\"", summary = "Sopra con \"summary\"")
    @ApiResponses(
            {@ApiResponse(responseCode = "404", description = "Descrizione 404"),
                    @ApiResponse(responseCode = "200", description = "Tutto ok")} // ARRAY DI COSE CON LE GRAFFE
    )
    public String nomeAlContrario(@PathVariable String nome) {
        StringBuilder stringBuilder = new StringBuilder(nome);
        return "Ciao il mio nome al contrario è " + stringBuilder.reverse();
    }
    //localhost:8080/swagger-ui/index.html#/ OK
}
