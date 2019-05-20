package controller;

import entity.ValidClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import repository.MainRepository;

import java.util.List;

@RestController
@RequestMapping("main")
public class ValidClientController {
    private final MainRepository mainRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidClientController.class);

    public ValidClientController(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @GetMapping
    public List<ValidClient> getValidClients() {
        return this.mainRepository.findAll();
    }

    @GetMapping("{uuid}")
    public ValidClient getValidClient(@PathVariable("uuid") ValidClient validClientFromRepo) {
        return validClientFromRepo;
    }

    @PostMapping()
    public ValidClient createValidClient(@RequestBody ValidClient validClient) {
        return mainRepository.save(validClient);
    }

    @PutMapping("{uuid}")
    public ValidClient editValidClient(@PathVariable("uuid") ValidClient validClientFromRepo, @RequestBody ValidClient validClient) {
        BeanUtils.copyProperties(validClient, validClientFromRepo, "uuid", "balance");
        return mainRepository.save(validClientFromRepo);
    }

    @DeleteMapping("{uuid}")
    public void deleteValidClient(@PathVariable("uuid") ValidClient validClientFromRepo) {
        mainRepository.delete(validClientFromRepo);
    }
}
