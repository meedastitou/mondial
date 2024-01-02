package com.example.demo.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.EntraineurService;
import com.example.demo.model.Entraineur;
import com.example.demo.model.Equipe;
import com.example.demo.repository.EntraineurRepository;
import com.example.demo.repository.EquipeRepository;
import com.example.demo.response.EntraineurResponse;

import jakarta.validation.Valid;

@Service
public class EntraineurServiceImpl implements EntraineurService {


    @Autowired
    private EntraineurRepository entraineurRepository;

    @Autowired
    private EquipeRepository equipeRepository; 

    @Override
    public String save(@Valid Entraineur entraineur) {
        Entraineur savedEntraineur = entraineurRepository.save(entraineur);

        
        if (savedEntraineur.getEquipe() != null && savedEntraineur.getEquipe().getEquipe_id() != null) {
            Optional<Equipe> equipeOptional = equipeRepository.findById(savedEntraineur.getEquipe().getEquipe_id());
        
            if (equipeOptional.isPresent()) {
                Equipe equipe = equipeOptional.get();
                equipe.addEntraineur(savedEntraineur);
                equipeRepository.save(equipe);
                savedEntraineur.setEquipe(equipe);
            } 
        }
        
        
        return savedEntraineur.getId();
    }

    @Override
    public List<EntraineurResponse> getAll() {
        List<Entraineur> entraineurs = entraineurRepository.findAll();
        List<EntraineurResponse> coachInfoList = new ArrayList<>();

        for (Entraineur entraineur : entraineurs) {
            EntraineurResponse coachInfo = new EntraineurResponse();
            coachInfo.setNomComplet(entraineur.getNomComplet());
            coachInfo.setAge(entraineur.getAge());
            coachInfo.setPhoto(entraineur.getPhoto());

            if (entraineur.getEquipe() != null) {
                coachInfo.setEquipePays(entraineur.getEquipe().getPays()); 
            }

            coachInfoList.add(coachInfo);
        }

        return coachInfoList;
    }

    @Override
    public EntraineurResponse getOne(String id) throws Exception {
        Optional<Entraineur> entraineurOptional = entraineurRepository.findById(id);
    
        if (entraineurOptional.isPresent()) {
            Entraineur entraineur = entraineurOptional.get();
            EntraineurResponse coachInfo = new EntraineurResponse();
    
            coachInfo.setNomComplet(entraineur.getNomComplet());
            coachInfo.setAge(entraineur.getAge());
            coachInfo.setPhoto(entraineur.getPhoto());

            if (entraineur.getEquipe() != null) {
                coachInfo.setEquipePays(entraineur.getEquipe().getPays()); 
            }
    
            return coachInfo;
        } else {
            throw new Exception("entraineur with id " + id + " not found");
        }
    }

    @Override
    public void delete(String id) {
        entraineurRepository.deleteById(id);
    }

    @Override
    public Entraineur getByNomComplet(String nom) {
        return entraineurRepository.findByNomComplet(nom)
        .orElseThrow(() -> new RuntimeException("Error: Entraineur is not found."));
    }
    
}
