package com.system.appointment2.service;

import com.system.appointment2.model.Consultant;
import com.system.appointment2.model.LessPerformanceNote;
import com.system.appointment2.repo.ConsultantRepo;
import com.system.appointment2.repo.LessPerformanceNoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessPerformanceNoteService {
    @Autowired
    private ConsultantRepo consultantRepo;

    @Autowired
    private LessPerformanceNoteRepo lessPerformanceNoteRepo;

    public void saveLessPerformance(int id,LessPerformanceNote lessPerformanceNote) {
        Consultant consultant=consultantRepo.findById(id).get();
        String name=consultant.getName();
        LessPerformanceNote lessPerformanceNote1=new LessPerformanceNote(
               name,
               lessPerformanceNote.getFeedback()
        );
        lessPerformanceNoteRepo.save(lessPerformanceNote1);
    }

    public List<LessPerformanceNote> AllPerformance() {
        List<LessPerformanceNote>lessPerformanceNotes=lessPerformanceNoteRepo.findAll();
        return lessPerformanceNotes;
    }

    public Object getFeedbackById(int id) {
        LessPerformanceNote lessPerformanceNote=lessPerformanceNoteRepo.findById(id).get();
        return lessPerformanceNote;
    }

    public void updateFeedback(LessPerformanceNote existFeedback) {
        lessPerformanceNoteRepo.save(existFeedback);
    }

    public void deleteFeedback(int id) {
        lessPerformanceNoteRepo.deleteById(id);
    }
}
