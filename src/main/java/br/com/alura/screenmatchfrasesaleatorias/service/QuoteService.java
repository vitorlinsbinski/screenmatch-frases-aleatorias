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
        Random random = new Random();

        long minId = 1L;
        long maxId = 1L;
        Optional<Quote> lastQuoteInDb =
                this.quoteRepository.findTopByOrderByDesc();

        if(lastQuoteInDb.isPresent()) {
            maxId = lastQuoteInDb.get().getId();
        }

        if (maxId < minId) {
            throw new IllegalStateException("Database has no quotes.");
        }

        long randomId;
        Optional<Quote> randomQuote;

        do {
            randomId = random.nextLong(maxId - minId + 1) + minId;

            randomQuote = this.quoteRepository.findById(randomId);
        } while (randomQuote.isEmpty());

        return converteDado(randomQuote.get());
    }

    private QuoteDTO converteDado(Quote quote) {
        return new QuoteDTO(quote.getTitle(), quote.getPhrase(),
                quote.getCharacter(), quote.getPoster());
    }
}
