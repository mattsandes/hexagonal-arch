package br.com.sandes.addapters.in.controller;

import br.com.sandes.addapters.in.controller.mapper.CustomerMapper;
import br.com.sandes.addapters.in.controller.request.CustomerRequest;
import br.com.sandes.addapters.in.controller.response.CustomerResponse;
import br.com.sandes.application.ports.in.DeleteCustomerByIdInputPort;
import br.com.sandes.application.ports.in.FindCustomerByIdInputPort;
import br.com.sandes.application.ports.in.InsertCustomerInputPort;
import br.com.sandes.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final CustomerMapper mapper;
    private final InsertCustomerInputPort insertCustomerInputPort;

    public CustomerController(
            DeleteCustomerByIdInputPort deleteCustomerByIdInputPort,
            UpdateCustomerInputPort updateCustomerInputPort,
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            CustomerMapper mapper,
            InsertCustomerInputPort insertCustomerInputPort) {
        this.deleteCustomerByIdInputPort = deleteCustomerByIdInputPort;
        this.updateCustomerInputPort = updateCustomerInputPort;
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

    @PutMapping("/${id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = mapper.toCustomer(customerRequest);

        customer.setId(id);

        updateCustomerInputPort.update(customer, customerRequest.zipcode());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/${id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteCustomerByIdInputPort.delete(id);

        return ResponseEntity.noContent().build();
    }
}
