package com.system.appointment2.controller;

import com.system.appointment2.model.Consultant;
import com.system.appointment2.model.LessPerformanceNote;
import com.system.appointment2.service.LessPerformanceNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LessPerformanceNoteController {
    @Autowired
    private LessPerformanceNoteService service;

    int newId;

    @GetMapping("/save-less-performance/{id}")
    public String saveLessPerformanceForm(@PathVariable(value = "id")int id,Model model){
        newId=id;
        LessPerformanceNote lessPerformanceNote = new LessPerformanceNote();
        model.addAttribute("lessPerformanceNote",lessPerformanceNote);
        return "performance-template";
    }

    @PostMapping("/save-performance")
    public String saveLessPerformance(@ModelAttribute("lessPerformanceNote") LessPerformanceNote lessPerformanceNote){
        service.saveLessPerformance(newId,lessPerformanceNote);
        return "redirect:/appointments-by-consultant";
    }

    @GetMapping("/get-performance")
    public String performanceList(Model model){
        List<LessPerformanceNote> lessPerformanceNote=service.AllPerformance();
        model.addAttribute("lessPerformanceNote",lessPerformanceNote);
        return "all-performance";
    }

    @GetMapping("/feedback/edit/{id}")
    public String editFeedback(@PathVariable(value = "id") int id,Model model){
        model.addAttribute("lessPerformanceNote",service.getFeedbackById(id));
        return "edit_feedback";
    }

    @PostMapping("/feedback/{id}")
    public String updateFeedback(@PathVariable int id,
                                   @ModelAttribute("lessPerformanceNote") LessPerformanceNote lessPerformanceNote,
                                   Model model){
        LessPerformanceNote existFeedback= (LessPerformanceNote) service.getFeedbackById(id);
        existFeedback.setFeedback(lessPerformanceNote.getFeedback());

        service.updateFeedback(existFeedback);
        return "redirect:/get-performance";
    }

    @GetMapping("/delete-feedback/{id}")
    public String deleteFeedback(@PathVariable int id){
        service.deleteFeedback(id);
        return "redirect:/get-performance";
    }
}
