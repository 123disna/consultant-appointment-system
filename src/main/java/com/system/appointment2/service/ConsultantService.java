package com.system.appointment2.service;

import com.system.appointment2.model.Consultant;
import com.system.appointment2.repo.ConsultantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultantService {
    @Autowired
    private ConsultantRepo consultantRepo;
    public void addConsultant(Consultant consultant) {
        consultantRepo.save(consultant);
    }

    public List<Consultant> allConsultants() {
        List<Consultant>consultants=consultantRepo.findAll();
        return consultants;
    }

    public Object getConsultantById(int id) {
        Consultant consultant=consultantRepo.findById(id).get();
        return consultant;
    }

    public void updateConsultant(Consultant existConsultant) {
        consultantRepo.save(existConsultant);
    }

    public void deleteConsultant(int id) {
        consultantRepo.deleteById(id);
    }

    public Consultant findById(int consultant) {
        Consultant consultant1=consultantRepo.findById(consultant).get();
        return consultant1;
    }

    public void save(Consultant consultant) {
        consultantRepo.save(consultant);
    }
}
