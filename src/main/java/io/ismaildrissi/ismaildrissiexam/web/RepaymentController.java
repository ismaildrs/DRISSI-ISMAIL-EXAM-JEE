package io.ismaildrissi.ismaildrissiexam.web;

import io.ismaildrissi.ismaildrissiexam.dtos.RepaymentDTO;
import io.ismaildrissi.ismaildrissiexam.services.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/repayments")
public class RepaymentController {

    private final RepaymentService repaymentService;

    @Autowired
    public RepaymentController(RepaymentService repaymentService) {
        this.repaymentService = repaymentService;
    }

    @GetMapping
    public List<RepaymentDTO> getAllRepayments() {
        return repaymentService.findAll();
    }

    @GetMapping("/{id}")
    public RepaymentDTO getRepaymentById(@PathVariable Long id) {
        Optional<RepaymentDTO> repayment = repaymentService.findById(id);
        return repayment.orElse(null);
    }

    @GetMapping("/credit/{creditId}")
    public List<RepaymentDTO> getRepaymentsByCreditId(@PathVariable Long creditId) {
        return repaymentService.findByCreditId(creditId);
    }

    @PostMapping
    public RepaymentDTO createRepayment(@RequestBody RepaymentDTO repaymentDTO) {
        return repaymentService.save(repaymentDTO);
    }

    @PutMapping("/{id}")
    public RepaymentDTO updateRepayment(@PathVariable Long id, @RequestBody RepaymentDTO repaymentDTO) {
        repaymentDTO.setId(id);
        return repaymentService.save(repaymentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRepayment(@PathVariable Long id) {
        Optional<RepaymentDTO> repayment = repaymentService.findById(id);
        if (repayment.isPresent()) {
            repaymentService.delete(id);
        }
    }
}