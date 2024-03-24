package org.fasttrackit.salaryApplication.client.mapper;

import org.fasttrackit.salaryApplication.client.model.PontajDTO;
import org.fasttrackit.salaryApplication.model.Pontaj;
import org.springframework.stereotype.Component;

@Component
public class PontajMapper {

    public static PontajDTO toDtoPontaj(Pontaj pontaj) {
        return PontajDTO.builder()
                .marca(pontaj.getMarca())
                .zileLucratoare(pontaj.getZileLucratoare())
                .zileLucrate(pontaj.getZileLucrate())
                .zileCO(pontaj.getZileCO())
                .zileCFS(pontaj.getZileCFS())
                .build();
    }

    public static PontajDTO toDtoUpdatePontaj(Integer marca, Pontaj pontaj) {
        return PontajDTO.builder()
                .zileLucratoare(pontaj.getZileLucratoare())
                .zileLucrate(pontaj.getZileLucrate())
                .zileCO(pontaj.getZileCO())
                .zileCFS(pontaj.getZileCFS())
                .build();
    }


    public static Pontaj toEntityPontaj(PontajDTO pontajDTO) {
        return Pontaj.builder()
                .marca(pontajDTO.marca())
                .zileLucratoare(pontajDTO.zileLucratoare())
                .zileLucrate(pontajDTO.zileLucrate())
                .zileCO(pontajDTO.zileCO())
                .zileCFS(pontajDTO.zileCFS())
                .build();
    }

}
