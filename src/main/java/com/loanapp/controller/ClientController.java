package com.loanapp.controller;



import com.loanapp.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "client-list";
    }

    @PostMapping("/clients/search")
    public String searchClients(@RequestParam("query") String query, Model model) {
        model.addAttribute("clients", clientService.searchClients(query));
        return "client-list";
    }
}
