package com.MainApp.Controller;

import com.MainApp.Entity.Footer;
import com.MainApp.Service.FooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/footer")
@CrossOrigin(origins = "http://localhost:5173")
public class FooterController {

    @Autowired
    private FooterService footerService;

    // ── PUBLIC ────────────────────────────────────────────

    @GetMapping("/all")
    public ResponseEntity<List<Footer>> getAll() {
        return ResponseEntity.ok(footerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Footer> getById(@PathVariable String id) {
        return footerService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ── ADMIN ONLY ────────────────────────────────────────

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Footer> create(@RequestBody Footer footer) {
        return ResponseEntity.ok(footerService.create(footer));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<Footer> update(@PathVariable String id,
                                         @RequestBody Footer footer) {
        return ResponseEntity.ok(footerService.update(id, footer));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        footerService.delete(id);
        return ResponseEntity.ok("Footer entry deleted successfully.");
    }
}