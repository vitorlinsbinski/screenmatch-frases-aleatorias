package br.com.alura.screenmatchfrasesaleatorias.service;

import br.com.alura.screenmatchfrasesaleatorias.dto.QuoteDTO;
import br.com.alura.screenmatchfrasesaleatorias.model.Quote;
import br.com.alura.screenmatchfrasesaleatorias.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class QuoteService {
    @Autowired
    private QuoteRepository quoteRepository;

    public QuoteDTO getRandomQuote() {
        return converteDado(this.quoteRepository.findRandomQuote());
    }

    private QuoteDTO converteDado(Quote quote) {
        return new QuoteDTO(quote.getTitle(), quote.getPhrase(),
                quote.getCharacter(), quote.getPoster());
    }
}
