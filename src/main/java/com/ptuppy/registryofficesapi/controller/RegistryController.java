package com.ptuppy.registryofficesapi.controller;

import com.ptuppy.registryofficesapi.domain.CertificatesEntity;
import com.ptuppy.registryofficesapi.domain.RegistryEntity;
import com.ptuppy.registryofficesapi.domain.UfEnum;
import com.ptuppy.registryofficesapi.service.CertificatesService;
import com.ptuppy.registryofficesapi.service.RegistryOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/registry")
public class RegistryController {

    @Autowired
    private RegistryOfficeService registryOfficeService;

    @Autowired
    private CertificatesService certificatesService;


    @GetMapping
    public String home() {
        return "/home";
    }

    @GetMapping("/create")
    public String create(RegistryEntity registryEntity) {
        return "/registry/creation";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        return "/registry/list";
    }

    @PostMapping("/save")
    public String save(RegistryEntity registryEntity, RedirectAttributes atr){
        registryOfficeService.create(registryEntity);
        atr.addFlashAttribute("success","Cadastro concluído com sucesso.");
        return "redirect:/registry/create";
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
