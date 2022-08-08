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
public class RegistryOfficesUpdateController {

    @Autowired
    private RegistryOfficeService registryOfficeService;

    @Autowired
    private CertificatesService certificatesService;


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("registryEntity", registryOfficeService.findById(id));
        return "/registry/creation";
    }

    @PostMapping("/update")
    public String update(@Valid RegistryEntity registryEntity, BindingResult result, RedirectAttributes atr) {

        if(result.hasErrors()) {
            return "/registry/creation";
        }

        registryOfficeService.update(registryEntity);
        atr.addFlashAttribute("success", "Registro editado com sucesso.");
        return "redirect:/registry/list";
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
