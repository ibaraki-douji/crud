package fr.ibaraki.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.ibaraki.crud.entity.Apprenti;
import fr.ibaraki.crud.service.ApprentiService;
import io.swagger.annotations.Api;

@Api(tags = "Apprentis")
@RestController
@RequestMapping("/apprentis")
public class ApprentiController {

    @Autowired
    private ApprentiService apprentiService;
    
    @GetMapping
    public List<Apprenti> getAllApprentis(@RequestParam(required = false) String orderBy) {
        return apprentiService.getAllSortedApprentis(orderBy);
    }
    
    @GetMapping("/promotions/{name}")
    public List<Apprenti> getAllApprentisByPromotion(@PathVariable String name) {
        return apprentiService.getAllByPromotion(name);
    }
    
    @GetMapping("/promotions/{name}/absenteisme")
    public double getAbscentByPromotion(@PathVariable String name) {
        return apprentiService.getAbscentByPromotion(name);
    }

    @GetMapping("/{id}")
    public Apprenti getApprentiById(@PathVariable int id) {
        return apprentiService.getApprentiById(id);
    }

    @PostMapping
    public Apprenti createApprenti(@RequestBody Apprenti apprenti) {
        return apprentiService.createApprenti(apprenti);
    }

    @PutMapping("/{id}")
    public Apprenti updateApprenti(@PathVariable int id, @RequestBody Apprenti apprenti) {
        return apprentiService.updateApprenti(id, apprenti);
    }

    @DeleteMapping("/{id}")
    public void deleteApprenti(@PathVariable int id) {
        apprentiService.deleteApprenti(id);
    }
}
