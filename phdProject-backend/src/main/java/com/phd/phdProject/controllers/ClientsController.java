package com.phd.phdProject.controllers;

import com.phd.phdProject.beans.ClientRequest;
import com.phd.phdProject.entities.*;
import com.phd.phdProject.repositories.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("clients")
public class ClientsController {

    private final CityRepository cityRepo;
    private final SexRepository sexRepo;
    private final ClientsRepository clientsRepository;

    ClientsController(CityRepository cityRepo, ClientsRepository clientsRepository, SexRepository sexRepo){
        this.cityRepo = cityRepo;
        this.clientsRepository = clientsRepository;
        this.sexRepo = sexRepo;
    }

    @GetMapping("/all")
    public List<Clients> getClients(){
        return clientsRepository.findAll();
    }


    @GetMapping("search/id")
    public List<Clients> getClientsId(@RequestParam(required = false) Long id) {
        List<Clients> cl = new ArrayList<Clients>();
        cl.add(clientsRepository.findClientsById(id));
        return cl;
        // return clientsRepository.findClientsById(id);
    }

    @GetMapping("search/byId")
    public Clients getClientsById(@RequestParam(required = false) Long id) {
        return clientsRepository.findClientsById(id);
    }

    @GetMapping("search/page")
    public ResponseEntity<?> paginateClient(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                            @RequestParam(value = "perPage", defaultValue = "3") int perPage,
                                            @RequestParam(required = false) String firstName,
                                            @RequestParam(required = false) String secondName,
                                            @RequestParam(required = false) String lastName,
                                            @RequestParam(required = false) String nickName,
                                            @RequestParam(required = false) String sex,
                                            @RequestParam(required = false) Long egn,
                                            @RequestParam(required = false) String city,
                                            @RequestParam(required = false) Double current,
                                            @RequestParam(required = false) Double saving,
                                            @RequestParam(required = false) Double credit
    ) {
        Pageable pageable = PageRequest.of(currentPage - 1, perPage);
        Page<Clients> clients = clientsRepository.findPageClient(pageable,
                firstName.toLowerCase(),
                secondName.toLowerCase(),
                lastName.toLowerCase(),
                nickName.toLowerCase(),
                sex.toLowerCase(),
                egn,
                city.toLowerCase(),
                current,
                saving,
                credit);

        Map<String, Object> response = new HashMap<>();
        response.put("clients", clients.getContent());
        response.put("currentPage", clients.getNumber()+1);
        response.put("totalItems", clients.getTotalElements());
        response.put("totalPages", clients.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveOrUpdate(@RequestBody ClientRequest form) {

        boolean isNew = form.getId() == null;
        City city = cityRepo.findById(form.getCity().getId()==null? 17L: form.getCity().getId())
                .orElse(cityRepo.findById(17L).get());
        Sex sex = sexRepo.findById(form.getSex().getId()==null? 3L: form.getSex().getId())
                .orElse(sexRepo.findById(3L).get());

        Clients client = new Clients(
                form.getId(),
                form.getFirstName(),
                form.getSecondName(),
                form.getLastName(),
                form.getNickName(),
                sex,
                form.getEgn(),
                city,
                form.getCurrent(),
                form.getSaving(),
                form.getCredit()
        );
        client = clientsRepository.save(client);
        Map<String, Object> response = new HashMap<>();
        response.put("clients", client);

        if(isNew) {
            response.put("message", "Успешно записан!");
        }

        else{
            response.put("message", "Успешно редактиран!");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteClients(@RequestParam Long id)
    {  if(!clientsRepository.existsById(id))
    {
        return ResponseEntity.ok("Няма такъв човек!");
    }
        clientsRepository.deleteById(id);
        return ResponseEntity.ok("Изтрит успешно!");
    }

    @GetMapping("search/name")
    public ResponseEntity<?> getClientsName(@RequestParam(required = false) String name) {
        if (name == null || name.isBlank()) return ResponseEntity.ok().body("Не сте задали името като критерий!");

        Optional<Clients> result = clientsRepository.findByFirstName(name.toLowerCase());
        return result.isPresent()? ResponseEntity.ok(result) : ResponseEntity.ok("Не е открит запис по дадените критерии!");
    }

    @GetMapping("/access")
    public ResponseEntity<?> accessClients(@RequestParam(required = false) Long id)
    {
        Map<String, Object> response = new HashMap<>();
        response.put("clients",clientsRepository.findClientsById(id) );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
