package br.com.sandes.addapters.in.controller;

import br.com.sandes.addapters.in.controller.mapper.CustomerMapper;
import br.com.sandes.addapters.in.controller.request.CustomerRequest;
import br.com.sandes.addapters.in.controller.response.CustomerResponse;
import br.com.sandes.application.ports.in.FindCustomerByIdInputPort;
import br.com.sandes.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final CustomerMapper mapper;
    private final InsertCustomerInputPort insertCustomerInputPort;

    public CustomerController(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            CustomerMapper mapper,
            InsertCustomerInputPort insertCustomerInputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.mapper = mapper;
        this.insertCustomerInputPort = insertCustomerInputPort;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer =  mapper.toCustomer(customerRequest);

        insertCustomerInputPort.insert(customer, customerRequest.zipcode());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/${id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        var customer =  findCustomerByIdInputPort.find(id);

        var customerResponse = mapper.toCustomerResponse(customer);

        return ResponseEntity.ok().body(customerResponse);
    }
}
