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
public class RegistryOfficesDeleteController {

    @Autowired
    private RegistryOfficeService registryOfficeService;

    @Autowired
    private CertificatesService certificatesService;

    @GetMapping("/{id}/delete")
    public String edit(@PathVariable("id") Long id, RedirectAttributes atr) {
        registryOfficeService.delete(id);
        atr.addFlashAttribute("success", "Registro excluido com sucesso.");
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
