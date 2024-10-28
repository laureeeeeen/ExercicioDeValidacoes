package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Farmacia;
import com.example.demo.services.FarmaciaService;

@RestController
@RequestMapping("/Farmacia")
public class FarmaciaController {

	
	private final FarmaciaService farmaciaservice;
	
	@Autowired
	public FarmaciaController(FarmaciaService farmaciaservice) {
		this.farmaciaservice = farmaciaservice;
	}
	
	@PostMapping("/criar")
	public Farmacia criarMedicamento(@RequestBody Farmacia medicamento) {
		return farmaciaservice.salvarMedicamento(medicamento);
	}
	
	@GetMapping
	public List<Farmacia> buscarTodos() {
		return farmaciaservice.buscarTodosMedicamentos();
	}
	
	@GetMapping("/{id}")
	public Farmacia buscarPorId(@PathVariable Long id) {
		return farmaciaservice.buscarMedicamentoPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletarUsuario(@PathVariable Long id) {
		farmaciaservice.excluirMedicamento(id);
	}
	
	@PutMapping
	public ResponseEntity<Farmacia> atualizarUsuario(@PathVariable Long id, @RequestBody Farmacia medicamento) {
		Farmacia medicamentoAtualizado = farmaciaservice.atualizarMedicamento(id, medicamento);
		if(medicamentoAtualizado != null) {
			return ResponseEntity.ok(medicamentoAtualizado);
		} else {
			return null;
		}
	}
	
}
