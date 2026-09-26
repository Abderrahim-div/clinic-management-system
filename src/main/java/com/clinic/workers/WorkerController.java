package com.clinic.workers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {
    
    private WorkerRepository workerRepository;
    public WorkerController(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping
    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Worker getWorkerById(@PathVariable Long id){
        return workerRepository.findById(id).orElseThrow(() -> new RuntimeException("Worker not found"));
    }

    @PostMapping
    public Worker createWorker(@RequestBody Worker worker){
        return workerRepository.save(worker);
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Long id){
        workerRepository.findById(id).orElseThrow(() -> new RuntimeException("Worker not found"));
        workerRepository.deleteById(id);
    }
}
