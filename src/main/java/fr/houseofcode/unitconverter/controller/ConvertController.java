package fr.houseofcode.unitconverter.controller;

import fr.houseofcode.unitconverter.entity.InputContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.houseofcode.unitconverter.service.UnitConverterService;

import javax.measure.UnitConverter;
import javax.validation.Valid;

@Controller
public class ConvertController {
    private UnitConverterService unitConverterService;

    public ConvertController(@Autowired UnitConverterService unitConverterService){
        this.unitConverterService = unitConverterService;
    }

    @GetMapping("/convert")
    public String unitForm(){
        return "Welcome";
    }

    @PostMapping("/convert")
    public String unitConverter(Model model, @Valid @ModelAttribute("data")InputContent data) {
        if (data.getValue() != null){
            model.addAttribute("result", unitConverterService.meterToHectare(data.getValue()));
        }
        return "Welcome";
    }
}
