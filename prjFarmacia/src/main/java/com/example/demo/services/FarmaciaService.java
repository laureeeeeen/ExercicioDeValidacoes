package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Farmacia;
import com.example.demo.repositories.FarmaciaRepository;

@Service
public class FarmaciaService {
	
	private final FarmaciaRepository farmaciaRepository;
	
	@Autowired
	public FarmaciaService(FarmaciaRepository farmaciaRepository) {
		this.farmaciaRepository = farmaciaRepository;
	}
	
	public Farmacia salvarMedicamento(Farmacia farmacia) {
		return farmaciaRepository.save(farmacia);
	}
	
	public Farmacia buscarMedicamentoPorId(Long id) {
		return farmaciaRepository.findById(id).orElse(null);
	}
	
	public List<Farmacia> buscarTodosMedicamentos() {
		return farmaciaRepository.findAll();
	}

	public void excluirMedicamento(Long id) {
		farmaciaRepository.deleteById(id);
	}
	
	public Farmacia atualizarMedicamento(Long id, Farmacia medicamentoAtualizado) {
		Optional<Farmacia> medicamentoExistente = farmaciaRepository.findById(id);
		if(medicamentoExistente.isPresent()) {
			Farmacia medicamento = medicamentoExistente.get();
			medicamento.setNome(medicamentoAtualizado.getNome());
			medicamento.setBula(medicamentoAtualizado.getBula());
			medicamento.setDataValidade(medicamentoAtualizado.getDataValidade());
			medicamento.setIdFornecedor(medicamentoAtualizado.getIdFornecedor());
			return farmaciaRepository.save(medicamento);
			} 
		else {
		return null;
		}
	}
}
