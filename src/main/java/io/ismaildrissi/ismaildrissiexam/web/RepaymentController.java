package io.ismaildrissi.ismaildrissiexam.web;

import io.ismaildrissi.ismaildrissiexam.entities.Repayment;
import io.ismaildrissi.ismaildrissiexam.services.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repayments")
public class RepaymentController {

    private final RepaymentService repaymentService;

    @Autowired
    public RepaymentController(RepaymentService repaymentService) {
        this.repaymentService = repaymentService;
    }

    @GetMapping
    public List<Repayment> getAllRepayments() {
        return repaymentService.getAllRepayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Repayment> getRepaymentById(@PathVariable Long id) {
        Repayment repayment = repaymentService.getRepaymentById(id);
        return ResponseEntity.ok(repayment);
    }

    @PostMapping
    public ResponseEntity<Repayment> createRepayment(@RequestBody Repayment repayment) {
        Repayment savedRepayment = repaymentService.saveRepayment(repayment);
        return ResponseEntity.ok(savedRepayment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Repayment> updateRepayment(@PathVariable Long id, @RequestBody Repayment repayment) {
        repayment.setId(id);
        Repayment updatedRepayment = repaymentService.saveRepayment(repayment);
        return ResponseEntity.ok(updatedRepayment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepayment(@PathVariable Long id) {
        repaymentService.deleteRepayment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/credit/{creditId}")
    public List<Repayment> getRepaymentsByCreditId(@PathVariable Long creditId) {
        return repaymentService.getRepaymentsByCreditId(creditId);
    }
}