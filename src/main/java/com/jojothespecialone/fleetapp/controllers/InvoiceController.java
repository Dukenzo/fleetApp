package com.jojothespecialone.fleetapp.controllers;

import com.jojothespecialone.fleetapp.models.Client;
import com.jojothespecialone.fleetapp.models.Invoice;
import com.jojothespecialone.fleetapp.models.InvoiceStatus;
import com.jojothespecialone.fleetapp.services.ClientService;
import com.jojothespecialone.fleetapp.services.InvoiceService;
import com.jojothespecialone.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {

    @Autowired	private InvoiceService invoiceService;
    @Autowired	private ClientService clientService;
    @Autowired	private InvoiceStatusService  invoiceStatusService;


    @GetMapping("/invoices")
    public String getInvoices(Model model) {
        model.addAttribute("invoices", invoiceService.getInvoices());

        model.addAttribute("clients", clientService.getClients());
        model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatuses());

        return "invoice";
    }

    @PostMapping("/invoices/addNew")
    public String addNew(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping("invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(int id) {
        return invoiceService.findById(id);
    }

    @RequestMapping(value="/invoices/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value="/invoices/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
}
