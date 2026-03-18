package com.MainApp.Controller;

import com.MainApp.Entity.About;
import com.MainApp.Service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;   // ← ADD THIS
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/about")
@CrossOrigin(origins = "http://localhost:5173")
public class AboutController {

    @Autowired
    private AboutService aboutService;

    // ── PUBLIC ────────────────────────────────────────────

    @GetMapping("/all")
    public ResponseEntity<List<About>> getAll() {
        return ResponseEntity.ok(aboutService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<About> getById(@PathVariable String id) {
        return aboutService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ── ADMIN ONLY ────────────────────────────────────────

    @PreAuthorize("hasRole('ADMIN')")        // ← ADD THIS
    @PostMapping("/add")
    public ResponseEntity<About> create(@RequestBody About about) {
        return ResponseEntity.ok(aboutService.create(about));
    }

    @PreAuthorize("hasRole('ADMIN')")        // ← ADD THIS
    @PutMapping("/update/{id}")
    public ResponseEntity<About> update(@PathVariable String id,
                                        @RequestBody About about) {
        return ResponseEntity.ok(aboutService.update(id, about));
    }

    @PreAuthorize("hasRole('ADMIN')")        // ← ADD THIS
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        aboutService.delete(id);
        return ResponseEntity.ok("About entry deleted successfully.");
    }
}