package com.ptuppy.registryofficesapi.controller;

import com.ptuppy.registryofficesapi.domain.CertificatesEntity;
import com.ptuppy.registryofficesapi.domain.RegistryEntity;
import com.ptuppy.registryofficesapi.domain.UfEnum;
import com.ptuppy.registryofficesapi.service.CertificatesService;
import com.ptuppy.registryofficesapi.service.RegistryOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/registry")
public class RegistryOfficesFetchController {

    @Autowired
    private RegistryOfficeService registryOfficeService;

    @Autowired
    private CertificatesService certificatesService;


    @GetMapping
    public String home() {
        return "/home";
    }

    @GetMapping("/list")
    public String list(ModelMap model,
                       @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                       @RequestParam(name = "page", required = false, defaultValue = "1") Integer page) {
        model.addAttribute("pageRegistry",registryOfficeService.findAllWithPage(page,size));
        return "/registry/list";
    }

    @GetMapping("/find")
    public String findByName(@RequestParam("name") String name, ModelMap model) {
        model.addAttribute("registry", registryOfficeService.findByName(name));
        return "/registry/list";
    }

    @ModelAttribute("certificates")
    public List<CertificatesEntity> getCertificates() {
        return certificatesService.findAll();
    }

    @ModelAttribute("ufs")
    public UfEnum[] getUFs() {

        return UfEnum.values();
    }

}
