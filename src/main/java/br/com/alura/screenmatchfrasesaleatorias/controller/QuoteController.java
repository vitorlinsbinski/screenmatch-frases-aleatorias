package br.com.alura.screenmatchfrasesaleatorias.controller;

import br.com.alura.screenmatchfrasesaleatorias.dto.QuoteDTO;
import br.com.alura.screenmatchfrasesaleatorias.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class QuoteController {
    @Autowired
    private QuoteService quoteService;

    @GetMapping("/frases")
    private QuoteDTO getRandomQuote() {
        return this.quoteService.getRandomQuote();
    }
}
