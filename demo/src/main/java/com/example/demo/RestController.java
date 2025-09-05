package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/calculos")
public class RestController {

    // Área del círculo: recibe {"radio": 5}
    @PostMapping("/area/circulo")
    public ResponseEntity<Double> areaCirculo(@RequestBody Map<String, Double> body) {
        Double radio = body.get("radio");
        if (radio == null || radio < 0) {
            return ResponseEntity.badRequest().build();
        }
        double area = Math.PI * radio * radio;
        return ResponseEntity.ok(area);
    }

    // Área del triángulo: recibe {"base": 4, "altura": 3}
    @PostMapping("/area/triangulo")
    public ResponseEntity<Double> areaTriangulo(@RequestBody Map<String, Double> body) {
        Double base = body.get("base");
        Double altura = body.get("altura");
        if (base == null || base < 0 || altura == null || altura < 0) {
            return ResponseEntity.badRequest().build();
        }
        double area = (base * altura) / 2;
        return ResponseEntity.ok(area);
    }

    // Área del rectángulo: recibe {"base": 5, "altura": 7}
    @PostMapping("/area/rectangulo")
    public ResponseEntity<Double> areaRectangulo(@RequestBody Map<String, Double> body) {
        Double base = body.get("base");
        Double altura = body.get("altura");
        if (base == null || base < 0 || altura == null || altura < 0) {
            return ResponseEntity.badRequest().build();
        }
        double area = base * altura;
        return ResponseEntity.ok(area);
    }

    // Área del cuadrado: recibe {"lado": 6}
    @PostMapping("/area/cuadrado")
    public ResponseEntity<Double> areaCuadrado(@RequestBody Map<String, Double> body) {
        Double lado = body.get("lado");
        if (lado == null || lado < 0) {
            return ResponseEntity.badRequest().build();
        }
        double area = lado * lado;
        return ResponseEntity.ok(area);
    }

    // Promedio de 5 cantidades: recibe {"valores": [1,2,3,4,5]}
    @PostMapping("/promedio")
    public ResponseEntity<Double> promedio(@RequestBody Map<String, List<Double>> body) {
        List<Double> valores = body.get("valores");
        if (valores == null || valores.size() != 5) {
            return ResponseEntity.badRequest().build();
        }
        double suma = valores.stream().mapToDouble(Double::doubleValue).sum();
        double promedio = suma / 5;
        return ResponseEntity.ok(promedio);
    }

    // Raíz cuadrada: recibe {"numero": 9}
    @PostMapping("/raizcuadrada")
    public ResponseEntity<Double> raizCuadrada(@RequestBody Map<String, Double> body) {
        Double numero = body.get("numero");
        if (numero == null || numero < 0) {
            return ResponseEntity.badRequest().build();
        }
        double resultado = Math.sqrt(numero);
        return ResponseEntity.ok(resultado);
    }
}
