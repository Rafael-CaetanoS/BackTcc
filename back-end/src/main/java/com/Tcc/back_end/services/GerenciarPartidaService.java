package com.Tcc.back_end.services;
import com.Tcc.back_end.model.JogadorTime;
import com.Tcc.back_end.model.TimePartida;
import com.Tcc.back_end.repository.JogadorTimeRepository;
import com.Tcc.back_end.repository.TimePartidaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GerenciarPartidaService {

    @Autowired
    private TimePartidaRepository timeRepository;

    @Autowired
    private JogadorTimeRepository jogadorRepository;

    private TimePartida findById(Long id){
        return timeRepository.findById(id) .orElseThrow(() -> new EntityNotFoundException("Time não encontrado"));
    }

    public List<TimePartida> findByIdPartida(Long id){
        return this.timeRepository.findByPartidaId(id);
    }

    public List<TimePartida> salvar (List<TimePartida> times){
        List<TimePartida> savedTimes = new ArrayList<>();
        for(TimePartida time : times){
            TimePartida timeResult = null;
            if(time.getIdTimePartida() != null) {
                timeResult = this.findById(time.getIdTimePartida());

                if (timeResult != null) {
                    timeResult.setPartida(time.getPartida());
                    timeResult.setIdTimePartida(time.getIdTimePartida());
                    timeResult.setNomeTime(time.getNomeTime());
                    timeResult.setTotalPontos(time.getTotalPontos());

                    this.timeRepository.save(timeResult);
                }

            }else{
                   timeResult = this.timeRepository.save(time);
                   for(JogadorTime jogadorTime: timeResult.getJogadores()){
                       JogadorTime jogador = new JogadorTime();
                       jogador.setInscricao(jogadorTime.getInscricao());
                       jogador.setTimePartida(timeResult);
                       this.jogadorRepository.save(jogador);
                   }
            }
            savedTimes.add(timeResult);
        }
        return savedTimes;
    }

}
